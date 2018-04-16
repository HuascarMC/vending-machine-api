import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
    get("/", (request, response) -> {
      // Show something
      return "get";
    });

    post("/", (request, response) -> {
      // Create something
      return "post";
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
