package greeter;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class GreetingServer {
    public static void main(String... args) throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/greeting", handler -> {
            String query = handler.getRequestURI().getQuery();
            String response = new Greeter().greet(query);
            handler.sendResponseHeaders(200, response.length());
            OutputStream os = handler.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
    }


}
