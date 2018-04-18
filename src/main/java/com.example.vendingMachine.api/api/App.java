package api;

import static spark.Spark.*;

import com.google.gson.Gson;

import vendingMachine.DrinkVendingMachine;
import vendingMachine.Objects.Order;
import vendingMachine.Objects.Drink;
import vendingMachine.Objects.Coin;
import vendingMachine.components.Bucket;
import java.util.Map;

import api.Tools.CorsFilter;

import api.models.DBItem;
import api.models.DBCoin;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.servlet.MultipartConfigElement;
import javax.persistence.Query;


import java.util.List;

public class App {
  public static void main(String[] args) {
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    DrinkVendingMachine vm = new DrinkVendingMachine();
    vm.initialize();
    CorsFilter corsFilter = new CorsFilter();
    corsFilter.apply();
    get("/cointemp", (request, response) -> {
      // Show something
      Gson gson = new Gson();
      // Map stock = vm.stockInventory.getInventory();
      // return gson.toJson(stock);
      EntityManager session = sf.createEntityManager();
      try {
        Map<Coin, Integer> coins = vm.coinInventory.getInventory();
        return gson.toJson(coins);
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }
      }

    });

    get("/itemtemp", (request, response) -> {
      // Show something
      Gson gson = new Gson();
      // Map stock = vm.stockInventory.getInventory();
      // return gson.toJson(stock);
      EntityManager session = sf.createEntityManager();
      try {
        Map<Drink, Integer> items = vm.stockInventory.getInventory();
        return gson.toJson(items);
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }
      }

    });



    post("/order", (request, response) -> {
      // Create something
      Gson gson = new Gson();

      EntityManager session = sf.createEntityManager();
      try {
        System.out.print("hi");
        Order order = (Order) gson.fromJson(request.body(), Order.class);
        Bucket result = vm.vend(order);
        return gson.toJson(result);
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }

      }
    });


    get("/coins", (request, response) -> {
      // Show something
      Gson gson = new Gson();
      // Map stock = vm.stockInventory.getInventory();
      // return gson.toJson(stock);
      EntityManager session = sf.createEntityManager();
      try {
        List<Coin> items = session.createQuery("FROM DBCoin").getResultList();
        return gson.toJson(items);
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }
      }

    });

    post("/coins", (request, response) -> {
      // Create something
      Gson gson = new Gson();
      // Order order = (Order) gson.fromJson(request.body(), Order.class);
      // Bucket result = vm.vend(order);
      // return gson.toJson(result);
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

    put("/coins", (request, response) -> {
      // Update something
      EntityManager session = sf.createEntityManager();
      try{
        Gson gson = new Gson();

        String query = String.format("FROM DBCoin WHERE name = '%s'", request.queryParams("name"));
        DBCoin coin = (DBCoin) session.createQuery(query).getSingleResult();
        coin.setQuantity(Integer.parseInt(request.queryParams("quantity")));
        session.getTransaction().begin();
        session.merge(coin);
        session.getTransaction().commit();
        return gson.toJson(coin);
      } catch(Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if(session.isOpen()) {
          session.close();
        }
      }
    });

    delete("/coins", (request, response) -> {
      // Annihilate something
      // Create something
      Gson gson = new Gson();
      // Order order = (Order) gson.fromJson(request.body(), Order.class);
      // Bucket result = vm.vend(order);
      // return gson.toJson(result);
      EntityManager session = sf.createEntityManager();
      try {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));
        session.getTransaction().begin();
        session.createQuery("DELETE FROM DBCoin").executeUpdate();
        session.getTransaction().commit();
        return "OK";
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }
      }
    });



    get("/items", (request, response) -> {
      // Show something
      Gson gson = new Gson();
      // Map stock = vm.stockInventory.getInventory();
      // return gson.toJson(stock);
      EntityManager session = sf.createEntityManager();
      try {
        List<DBItem> items = session.createQuery("FROM Item").getResultList();
        return gson.toJson(items);
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }
      }

    });

    post("/items", (request, response) -> {
      // Create something
      Gson gson = new Gson();

      // Order order = (Order) gson.fromJson(request.body(), Order.class);
      // Bucket result = vm.vend(order);
      // return gson.toJson(result);
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

    put("/items", (request, response) -> {
      // Update something
      EntityManager session = sf.createEntityManager();
      try{
        Gson gson = new Gson();

        String query = String.format("FROM Item WHERE name = '%s'", request.queryParams("name"));
        DBItem item = (DBItem) session.createQuery(query).getSingleResult();
        item.setQuantity(Integer.parseInt(request.queryParams("quantity")));
        session.getTransaction().begin();
        session.merge(item);
        session.getTransaction().commit();
        return gson.toJson(item);
      } catch(Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if(session.isOpen()) {
          session.close();
        }
      }
    });

    delete("/items", (request, response) -> {
      // Annihilate something
      // Create something
      Gson gson = new Gson();
      // Order order = (Order) gson.fromJson(request.body(), Order.class);
      // Bucket result = vm.vend(order);
      // return gson.toJson(result);
      EntityManager session = sf.createEntityManager();
      try {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));
        session.getTransaction().begin();
        session.createQuery("DELETE FROM Item").executeUpdate();
        session.getTransaction().commit();
        return "OK";
      } catch (Exception e) {
        return "Error: " + e.getMessage();
      } finally {
        if (session.isOpen()) {
          session.close();
        }
      }
    });

    options("/options", (request, response) -> {
      // Appease something
      return "options";
    });
  }
}
