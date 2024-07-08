package greeter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

    @Test
    void shouldGreetByName() {
        Greeter greeter = new Greeter();

        String response = greeter.greet("name=Miguel");

        assertThat(response, is("Hello, Miguel!"));
    }

    @Test
    void shouldGreetsWithHelloWorld() {
        Greeter greeter = new Greeter();

        String response = greeter.greet(null);

        assertThat(response, is("Hello, World!"));
    }
}