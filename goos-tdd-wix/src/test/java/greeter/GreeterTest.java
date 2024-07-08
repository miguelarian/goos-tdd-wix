package greeter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GreeterTest {

    final String NO_NAME_GREET = "Hello, World!";

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

        assertThat(response, is(NO_NAME_GREET));
    }

    @Test
    void shouldNotGreetWithInvalidQuery() {
        Greeter greeter = new Greeter();

        String response = greeter.greet("invalidQuery");

        assertThat(response, is(NO_NAME_GREET));
    }
}