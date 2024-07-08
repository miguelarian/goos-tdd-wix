package greeter;

public class Greeter {

    public String greet(String query) {
        String response = "";

        if(query == null) {
            response = "Hello, World!";
            return response;
        }

        String[] queryParam = query.split("=");
        if(queryParam.length != 2) {
            return response;
        }

        if(queryParam.length == 2 && queryParam[0].toLowerCase().equals("name")) {
            response = "Hello, " + queryParam[1] + "!";
        }

        return response;
    }
}
