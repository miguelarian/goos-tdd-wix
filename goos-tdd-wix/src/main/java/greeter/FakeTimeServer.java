package greeter;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class FakeTimeServer implements TimeServer{
    final HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
    private static String hourOfDay = "9";

    public FakeTimeServer() throws IOException {
        server.createContext("/hourOfDay", handler -> {
            String response = hourOfDay;
            handler.sendResponseHeaders(200, response.length());
            OutputStream os = handler.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.start();
    }

    public static void assumingHourOfDay(int assumedHourOfDay) {
        hourOfDay = "" + assumedHourOfDay;
    }
}
