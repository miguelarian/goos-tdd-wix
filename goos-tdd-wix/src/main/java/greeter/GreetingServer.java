package greeter;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GreetingServer {
    public static void main(String... args) throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        TimeServer timeServer = new FakeTimeServer();
        server.createContext("/greeting", handler -> {

            String hourOfDay = "";
            try {
                hourOfDay = getHourOfDay();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String query = handler.getRequestURI().getQuery();
            String response = new Greeter().greet(query, hourOfDay);
            handler.sendResponseHeaders(200, response.length());
            OutputStream os = handler.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
    }

    private static String getHourOfDay() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/hourOfDay"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String hourOfDay = response.body();
        return hourOfDay;
    }


}
