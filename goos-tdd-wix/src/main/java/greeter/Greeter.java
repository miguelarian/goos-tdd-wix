package greeter;

public class Greeter {

    private final String NO_NAME_GREET = "Hello, World!";

    public String greet(String query) {

        if(query == null) {
            return NO_NAME_GREET;
        }

        String[] queryParam = query.split("=");
        if(queryParam.length != 2) {
            return NO_NAME_GREET;
        }

        if(queryParam.length == 2 && queryParam[0].toLowerCase().equals("name")) {
            return "Hello, " + queryParam[1] + "!";
        }

        return null;
    }
}
