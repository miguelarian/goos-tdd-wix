package greeter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GreeterTest {

    final String NO_NAME_GREET = "Hello, World!";
    final String hourOfDay = "9";

    @Test
    void shouldGreetByName() {
        Greeter greeter = new Greeter();

        String response = greeter.greet("name=Miguel", hourOfDay);

        assertThat(response, is("Hello, Miguel!"));
    }

    @Test
    void shouldGreetsWithHelloWorld() {
        Greeter greeter = new Greeter();

        String response = greeter.greet(null, hourOfDay);

        assertThat(response, is(NO_NAME_GREET));
    }

    @Test
    void shouldNotGreetWithInvalidQuery() {
        Greeter greeter = new Greeter();

        String response = greeter.greet("invalidQuery", hourOfDay);

        assertThat(response, is(NO_NAME_GREET));
    }
}