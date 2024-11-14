package API;

import entities.Flight;

import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FLIGHT { // Class name changed to Sanyuktatest
    private static final String FILE_PATH = "C:\\Users\\Sanyukta\\IdeaProjects\\san\\src\\flight data";
    public static void main(String[] args) throws IOException {
        // Define the API endpoint and parameters
//        String apiKey = "2f36e678c8f6e1f24cfd4da0fa90b9ca613e96b7e2cd039c2becad7aebcf0309"; // Replace with your actual API key (better to get it from environment variables or a config file)
//        Map<String, String> parameters = Map.of(
//                "engine", "google_flights",
//                "departure_id", "YYZ",
//                "arrival_id", "AUS",
//                "outbound_date", "2024-12-01",
//                "currency", "USD",
//                "hl", "en",
//                "type", "2",
//                "api_key", apiKey // Use the real apiKey here
//        );
//
//        // Build the URL with query parameters
//        String baseUrl = "https://serpapi.com/search.json";
//        String url = baseUrl + "?" + getParamsString(parameters);
//
//        // Create HttpClient instance
//        HttpClient client = HttpClient.newHttpClient();
//
//        // Build the GET request
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET()
//                .build();

        // Send the request and get the response
//        try {
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            if (response.statusCode() == 200) {
//                // Print the successful response
//                System.out.println("Response: " + response.body());
//            } else {
//                // Print error details if the status code is not 200
//                System.out.println("Error: " + response.statusCode());
//                System.out.println("Response: " + response.body());
//            }
//        } catch (Exception e) {
//            // Print exception details
//            e.printStackTrace();
//        }
        String hold = readJsonFromFile();
        List<Flight> hold1 = parseFlights(hold);
        //System.out.println(hold1);
    }

    private static String readJsonFromFile() throws IOException {
        // Read the contents of the JSON file and return it as a string
        FileReader fileReader = new FileReader(FILE_PATH);
        StringBuilder jsonData = new StringBuilder();
        int i;
        while ((i = fileReader.read()) != -1) {
            jsonData.append((char) i);
        }
        fileReader.close();
        return jsonData.toString();
    }

    private static List<Flight> parseFlights(String jsonResponse) {
        JSONObject response = new JSONObject(jsonResponse);
        JSONObject options = JSONObject.getJSONObject("response");


        System.out.println(response);


        return null;
    }

}
