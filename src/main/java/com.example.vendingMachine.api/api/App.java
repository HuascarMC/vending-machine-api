import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
    get("/", (request, response) -> {
      // Show something
      return "";
    });

    post("/", (request, response) -> {
      // Create something
      return "";
    });

    put("/", (request, response) -> {
      // Update something
      return "";
    });

    delete("/", (request, response) -> {
    // Annihilate something
    return "";
    });

    options("/", (request, response) -> {
    // Appease something
    return "";
    });
  }
}
