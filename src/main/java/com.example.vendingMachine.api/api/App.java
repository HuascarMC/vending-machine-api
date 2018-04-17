package api;

import static spark.Spark.*;

import com.google.gson.Gson;

import vendingMachine.DrinkVendingMachine;
import vendingMachine.Objects.Order;
import vendingMachine.Objects.Drink;
import vendingMachine.Objects.Coin;
import vendingMachine.components.Bucket;
import java.util.Map;

import api.models.Item;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.servlet.MultipartConfigElement;

import java.util.List;

public class App {
  public static void main(String[] args) {
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    staticFiles.location("/public");
    DrinkVendingMachine vm = new DrinkVendingMachine();


    vm.stockInventory.put(Drink.SODA, 10);
    vm.coinInventory.put(Coin.QUARTER, 10);

    get("/", (request, response) -> {
      // Show something
      Gson gson = new Gson();
      // Map stock = vm.stockInventory.getInventory();
      // return gson.toJson(stock);
      EntityManager session = sf.createEntityManager();
            try {
                List<Item> items = session.createQuery("FROM Item").getResultList();
                return gson.toJson(items);

            } catch (Exception e) {
                return "Error: " + e.getMessage();
            } finally {
                if (session.isOpen()) {
                    session.close();
                }
            }

    });

    post("/", (request, response) -> {
      // Create something
      Gson gson = new Gson();
      Order order = (Order) gson.fromJson(request.body(), Order.class);
      Bucket result = vm.vend(order);
      return gson.toJson(result);

    });

    put("/", (request, response) -> {
      // Update something
      return "put";
    });

    delete("/", (request, response) -> {
      // Annihilate something
      return "delete";
    });

    options("/", (request, response) -> {
      // Appease something
      return "options";
    });
  }
}
