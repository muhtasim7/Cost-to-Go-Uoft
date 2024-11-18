package data_access_sim;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AirportCode {

    private static final String API_KEY = "r22OXsyZrlJCVrf8tkzSAA==387SPbE2IE8Suwr6"; // Replace with your actual API key
    private static final OkHttpClient client = new OkHttpClient();

    public List<String> fetchAirportDetails(String city) throws Exception {
        // Build the request
        String API_URL = "https://api.api-ninjas.com/v1/airports?name=" + city;
        Request request = new Request.Builder()
                .url(API_URL)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("X-Api-Key", API_KEY) // Add API key if required
                .build();

        // Execute the request and get the response
        Response response = client.newCall(request).execute();

        // Check if response is successful
        if (!response.isSuccessful() || response.body() == null) {
            throw new Exception("API call failed: " + response.message());
        }

        // Parse the JSON response
        String jsonResponse = response.body().string();
        JSONArray rootArray = new JSONArray(jsonResponse);

        // Extract relevant airport details
        List<String> airportDetails = new ArrayList<>();
        for (int i = 0; i < rootArray.length(); i++) {
            JSONObject airportObject = rootArray.getJSONObject(i);
            String iata = airportObject.optString("iata", "No IATA Code");

            // Concatenate details into a string and add to list
            airportDetails.add(iata);
        }
        return airportDetails;
    }

}
