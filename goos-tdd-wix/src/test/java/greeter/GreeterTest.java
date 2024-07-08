package greeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

    @Test
    void shouldGreetByName() {
        Greeter greeter = new Greeter();
        String response = greeter.greet("Miguel");
        assertEquals("Hello, Miguel!", response);
    }

    @Test
    void shouldGreetsWithHelloWorld() {
        Greeter greeter = new Greeter();
        String response = greeter.greet(null);
        assertEquals("Hello, World!", response);
    }
}