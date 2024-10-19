package librairie;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * TEST HANDLER
 */
public class CustomHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "<b>Bonjour sur l'API librairie</b>";

        // Connexion à la base de données
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");

                // Traiter les résultats de la requête
                while (resultSet.next()) {
                    response += "<br>" + resultSet.getString("nom");
                }
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
