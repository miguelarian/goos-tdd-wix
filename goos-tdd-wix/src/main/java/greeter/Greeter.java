package greeter;

public class Greeter {

    public String greet(String query) {
        String response;
        if(query == null) {
            response = "Hello, World!";
        } else {
            response = "Hello, Miguel!";
        }
        return response;
    }
}
