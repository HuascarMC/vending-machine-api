import static spark.Spark.*;

import com.google.gson.Gson;

import vendingMachine.DrinkVendingMachine;
import vendingMachine.Objects.Order;
import vendingMachine.components.Bucket;

public class App {
  public static void main(String[] args) {
    get("/", (request, response) -> {
      // Show something
      return "get";
    });

    post("/", (request, response) -> {
      // Create something
      // could be static to prevent multiple instances.
      DrinkVendingMachine vm = new DrinkVendingMachine();
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
