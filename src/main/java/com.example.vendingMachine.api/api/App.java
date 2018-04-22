package api;

import static spark.Spark.*;

import com.google.gson.Gson;

import vendingMachine.DrinkVendingMachine;

import api.db.DBHelper;

import vendingMachine.Objects.Order;
import vendingMachine.Objects.Drink;
import vendingMachine.Objects.Coin;

import vendingMachine.components.Bucket;

import java.util.Map;

import java.lang.ProcessBuilder;

import com.example.vendingMachine.api.VendingMachineImpl;

import api.Tools.CorsFilter;

import api.models.DBItem;
import api.models.DBCoin;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.MultipartConfigElement;
import javax.persistence.Query;
import javax.persistence.EntityManager;


import java.util.List;

public class App {
  public static void main(String[] args) {

    ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

setPort(port);
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    CorsFilter corsFilter = new CorsFilter();
    corsFilter.apply();
    VendingMachineImpl vm = new VendingMachineImpl();

    get("/", (req, res) -> "Hello Heroku World");

    post("/order", (request, response) -> {
      // Create something
      Gson gson = new Gson();
      Order order = (Order) gson.fromJson(request.body(), Order.class);
      Bucket result = (Bucket) vm.vend(order);
      return gson.toJson(result);
    });

    get("/machine/:inventory", (request, response) -> {
      // Get all from chosen inventory
      Gson gson = new Gson();
      DBHelper dbhelper = new DBHelper();
      String inventory = request.params(":inventory");
      if(inventory.equals("coins")) {
        return gson.toJson(dbhelper.getCoins());
      } else if (inventory.equals("items")) {
        return gson.toJson(dbhelper.getItems());
      }
      return gson.toJson("no inventory called " + inventory);
    });

    put("/machine/addcoin/:coin", (request, response) -> {
      // Add one coin :coin
      Gson gson = new Gson();
      String coinName = (String) request.params(":coin") ;
      DBHelper dbhelper = new DBHelper();
      dbhelper.addOneCoin(coinName);
      return gson.toJson("OK");
    });

    put("/machine/additem/:item", (request, response) -> {
      // Add one item :coin
      Gson gson = new Gson();
      String itemName = (String) request.params(":item");
      DBHelper dbhelper = new DBHelper();
      dbhelper.addOneItem(itemName);
      return gson.toJson("OK");
    });

    put("/machine/removecoin/:coin", (request, response) -> {
      Gson gson = new Gson();
      String coinName = (String) request.params(":coin") ;
      DBHelper dbhelper = new DBHelper();
      dbhelper.removeOneCoin(coinName);
      return gson.toJson("OK");
    });

    put("/machine/removeitem/:item", (request, response) -> {
      Gson gson = new Gson();
      String itemName = (String) request.params(":item") ;
      DBHelper dbhelper = new DBHelper();
      dbhelper.removeOneItem(itemName);
      return gson.toJson("OK");
    });


    post("/machine/create/coin", (request, response) -> {
      // Create coin
      Gson gson = new Gson();
      EntityManager session = sf.createEntityManager();
      try {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));
        DBCoin coin = (DBCoin) gson.fromJson(request.body(), DBCoin.class);

        session.getTransaction().begin();
        session.persist(coin);
        session.getTransaction().commit();

        return gson.toJson(coin);
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }

      }
    });

    post("/machine/create/item", (request, response) -> {
      // Create coin
      Gson gson = new Gson();
      EntityManager session = sf.createEntityManager();
      try {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));
        DBItem item = (DBItem) gson.fromJson(request.body(), DBItem.class);

        session.getTransaction().begin();
        session.persist(item);
        session.getTransaction().commit();

        return gson.toJson(item);
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }

      }
    });

    options("/*",
        (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });

// before((response) -> response.header("Access-Control-Allow-Origin"));
  }
}
