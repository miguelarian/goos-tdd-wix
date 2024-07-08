package greeter;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GreetingServerE2ETest {

    @Test
    public void shouldGreetWithHelloWorld() throws IOException, InterruptedException {
        GreetingServer.main();
        String response = new BufferedReader(new InputStreamReader(new URL("http://localhost:8080/greeting").openStream())).readLine();
        assertThat(response, is("Hello, World!"));
    }
}
