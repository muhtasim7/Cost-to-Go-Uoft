package data_access;

import entities.Flight;

import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class FLIGHT { // Class name changed to Sanyuktatest
    private static final String FILE_PATH =
            "C:\\Users\\Sanyukta\\IdeaProjects\\Cost-to-Go-Uoft\\Data\\fllight_data.txt";
    public static void main(String[] args) throws IOException {
         //Define the API endpoint and parameters
        String apiKey = "04b7d118caa4499d7035c0ac8f127349ffe7726a103e88159c191a8fe3876a39";

        AirportCode airportCodeFetcher = new AirportCode();

        // Fetch airport code for the arrival city (AUS example)
        List<String> airportCodes;
        try {
            airportCodes = airportCodeFetcher.getAirportDetails("Austin");
        } catch (Exception e) {
            System.out.println("Error fetching airport code: " + e.getMessage());
            return;
        }

        String arrivalAirportCode = airportCodes.isEmpty() ? "AUS" : airportCodes.get(0);

        Map<String, String> parameters = Map.of(
                "engine", "google_flights",
                "departure_id", "YYZ",
                "arrival_id", arrivalAirportCode,
                "outbound_date", "2025-01-01",
                "currency", "USD",
                "hl", "en",
                "type", "2",
                "api_key", apiKey // Use the real apiKey here
        );

        // Build the URL with query parameters
        String baseUrl = "https://serpapi.com/search.json";
        String url = baseUrl + "?" + getParamsString(parameters);

        // Create HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Build the GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

         //Send the request and get the response
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // Print the successful response
                System.out.println("Response: " + response.body());
            } else {
                // Print error details if the status code is not 200
                System.out.println("Error: " + response.statusCode());
                System.out.println("Response: " + response.body());
            }
        } catch (Exception e) {
            // Print exception details
            e.printStackTrace();
        }
        String hold = readJsonFromFile();
        List<Flight> hold1 = parseFlights(hold);
        System.out.println(hold1);
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
        JSONObject options = response.getJSONObject("response");


        System.out.println(options);


        return null;
    }

    //Helper method to convert Map<String, String> to a URL query string
    private static String getParamsString(Map<String, String> parameters) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            try {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Remove the trailing '&' character
        String queryString = result.toString();
        if (queryString.length() > 0) {
            queryString = queryString.substring(0, queryString.length() - 1);
        }
        return queryString;
    }

}
