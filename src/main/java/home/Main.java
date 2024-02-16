package home;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import spark.Spark;

public class Main {
    public static void main(String[] args) {
        // Set the port for your Spark application
        Spark.port(1555);

        // Define the route to serve the contents of index.html
        Spark.get("/", (req, res) -> {
            // Read the contents of index.html from the resources directory
            InputStream inputStream = Main.class.getResourceAsStream("/index.html");
            byte[] bytes = inputStream.readAllBytes();
            String content = new String(bytes, StandardCharsets.UTF_8);

            // Set the response content type to HTML
            res.type("text/html");

            // Return the contents of index.html
            return content;
        });
    }
}
