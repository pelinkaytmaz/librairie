package librairie.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import librairie.DatabaseConnection;

/**
 * TEST HANDLER
 */
public class TestController implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "<h1><b>Bonjour sur l'API librairie</b></h1><br/>";

        // Connexion à la base de données
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                response += "<h2>Connexion BDD : </h2><p>Connexion à la base de données réussie.</p><br/>";
                // Link to all the existing API, useful to see the results
                response += "<h3><a href='http://localhost:8000/api/auteurs'>API Auteurs</a></h2><br/>";
            } else {
                response = "Erreur de connexion à la base de données.";
            }
        } catch (Exception e) {
            response = "Erreur lors de l'accès à la base de données: " + e.getMessage();
        }

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
