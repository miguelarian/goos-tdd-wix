package greeter;

public class Greeter {

    private final String NO_NAME_GREET = "Hello, World!";
    private final String NAME_PARAM = "name";

    public String greet(String query) {

        if(query == null) {
            return NO_NAME_GREET;
        }

        String[] queryParam = query.split("=");
        if(queryParam.length != 2) {
            return NO_NAME_GREET;
        }

        if(!queryParam[0].toLowerCase().equals(NAME_PARAM)) {
            return NO_NAME_GREET;
        }

        return "Hello, " + queryParam[1] + "!";
    }
}
