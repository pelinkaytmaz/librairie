package librairie;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import librairie.controllers.AuteursController;
import librairie.controllers.TestController;

public class App {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/api", new TestController());
        server.createContext("/api/auteurs", new AuteursController());
        server.start();
        System.out.println("Server started on port 8000");
    }
}