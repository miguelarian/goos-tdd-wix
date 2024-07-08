package greeter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GreetingServerE2ETest {

    @BeforeAll
    public static void setUp() throws IOException {
        GreetingServer.main();
    }

    @Test
    public void shouldGreetWithHelloWorld() throws InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/greeting"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        assertThat(responseBody, is("Hello, World!"));
        assertThat(response.statusCode(), is(200));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Miguel"})
    public void shouldGreetByName(String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/greeting?name=" + name))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        assertThat(responseBody, is("Hello, " + name + "!"));
        assertThat(response.statusCode(), is(200));
    }
}
