package librairie.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import librairie.models.Auteurs;
import librairie.services.AuteursService;

public class AuteursController implements HttpHandler {

    private AuteursService auteursService = new AuteursService();
    private ObjectMapper objectMapper = new ObjectMapper();

    public AuteursController() {
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "";
        // If the request is a GET
        if ("GET".equals(exchange.getRequestMethod())) {
            List<Auteurs> auteurs = auteursService.getAllAuteurs();
            response = objectMapper.writeValueAsString(auteurs);
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        }
        // Remarque : On peut gérer d'autres types de requetes (POST, PUT, DELETE) sur
        // le même controller en
        // ajoutant un else if
        // EX : else if ("POST".equals(exchange.getRequestMethod())) {
        // Handle POST request to create a new author
        // }

        // MEMO : response 200 = successful response
        exchange.sendResponseHeaders(200, response.getBytes("UTF-8").length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes("UTF-8"));
        os.close();
    }
}
