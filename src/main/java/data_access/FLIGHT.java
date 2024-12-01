package data_access;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

import entities.*;
import usecases.flight.FlightUserDataAccessInterface;

public class FLIGHT implements FlightUserDataAccessInterface {
    private static CommonFlightFactory flightFactory = new CommonFlightFactory();

    public FLIGHT(CommonFlightFactory flightfactory) {
        this.flightFactory = flightfactory;
    }

    public List<Flight> searchFlights(String destination)throws Exception {
        String apiKey = "04b7d118caa4499d7035c0ac8f127349ffe7726a103e88159c191a8fe3876a39";

        AirportCode airportCodeFetcher = new AirportCode();

        List<String> airportDetails = airportCodeFetcher.getAirportDetails("Vancouver");
        String arrivalAirportCode = "";
        for (String airportDetail : airportDetails) {
            arrivalAirportCode = airportDetail;
            if (!Objects.equals(arrivalAirportCode, "")) {
                break;
            }
        }

        Map<String, String> parameters = Map.of(
                "engine", "google_flights",
                "departure_id", "YYZ",
                "arrival_id", arrivalAirportCode,
                "outbound_date", "2025-01-01",
                "currency", "USD",
                "hl", "en",
                "type", "2",
                "api_key", apiKey
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

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // Print the successful response
                List<Flight> flights;
                flights = parseFlights(response.body());
                return flights;
            }
            else {
                // Print error details if the status code is not 200
                System.out.println("Error: " + response.statusCode());
                System.out.println("Response: " + response.body());
            }
        }
        catch (Exception e) {
            // Print exception details
            e.printStackTrace();
        }
        return null;
    }

    private static List<Flight> parseFlights(String jsonResponse) {
        JSONObject response = new JSONObject(jsonResponse);
        List<Flight> flightList = new ArrayList<>();

        JSONArray hold = response.getJSONArray("best_flights");
        for (int i = 0; i < hold.length(); i++) {
            JSONObject first = hold.getJSONObject(i);
            String duration = String.valueOf(first.getInt("total_duration"));

            String price = String.valueOf(first.getInt("price"));

            JSONArray flights = first.getJSONArray("flights");
            for (int j = 0; j < flights.length(); j++) {
                JSONObject index1 = flights.getJSONObject(j);
            }

            JSONObject index = flights.getJSONObject(flights.length() - 1);

            JSONObject departure_airport = flights.getJSONObject(0).getJSONObject("departure_airport");
            String departurename = departure_airport.getString("name");
            String departuretime = departure_airport.getString("time");

            JSONObject arrival_airport = index.getJSONObject("arrival_airport");
            String arrivalname = arrival_airport.getString("name");
            String arrivaltime = arrival_airport.getString("time");

            Flight flight = flightFactory.create(departuretime, arrivaltime, departurename, arrivalname,
                    duration, price);
            flightList.add(flight);

        }

        return flightList;
    }

    // Helper method to convert Map<String, String> to a URL query string
    private static String getParamsString(Map<String, String> parameters) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            try {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }
            catch (Exception e) {
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
