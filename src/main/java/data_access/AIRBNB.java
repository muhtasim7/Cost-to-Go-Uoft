package data_access;

import entities.Property;
import entities.CommonPropertyFactory;
import usecases.property.PropertyUserDataAccessInterface;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Uncomment the necessary imports for API calls
// import okhttp3.OkHttpClient;
// import okhttp3.Request;
// import okhttp3.Response;

public class AIRBNB implements PropertyUserDataAccessInterface {
    private static final String FILE_PATH = "C:\\Users\\Sanyukta\\IdeaProjects\\Cost-to-Go-Uoft\\Data\\jsonformatter.txt";

    private final CommonPropertyFactory propertyFactory;

    // Uncomment and replace with your actual API key
    // private static final String API_KEY = "f980612bd5msh4536668cad5f89bp1c7ddejsn36d7c9d6b0be";

    public AIRBNB(CommonPropertyFactory propertyFactory) {
        this.propertyFactory = propertyFactory;
    }

    @Override
    public List<Property> searchProperties(String city) throws Exception {
        // Uncomment this block to use the API call
        /*

        //This part of the call to the RAPIDAPI was given to us thanks to RAPID API as they have implemented the API
        OkHttpClient client = new OkHttpClient();

        String url = "https://airbnb19.p.rapidapi.com/api/v1/searchPropertyByLocationV2"
                + "?location=" + city
                + "&totalRecords=40&currency=USD&adults=1&checkin=2025-01-01&checkout=2025-04-30";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("x-rapidapi-key", API_KEY)
                .addHeader("x-rapidapi-host", "airbnb19.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful() || response.body() == null) {
            throw new Exception("API call failed: " + response.message());
        }

        String jsonResponse = response.body().string();
        return parseProperties(jsonResponse);
        */

        // Use local JSON file for now
        String jsonResponse = readJsonFromFile();
        return parseProperties(jsonResponse);
    }

    //This part of the code was thanks to ChatGPT as I was not sure how to call the local file
    private String readJsonFromFile() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH);
        StringBuilder jsonData = new StringBuilder();
        int i;
        while ((i = fileReader.read()) != -1) {
            jsonData.append((char) i);
        }
        fileReader.close();
        return jsonData.toString();
    }

    private List<Property> parseProperties(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONObject hold = jsonObject.getJSONObject("data");
        JSONArray list = hold.getJSONArray("list");
        List<Property> properties = new ArrayList<>();

        for (int i = 0; i < list.length(); i++) {
            JSONObject listing = list.getJSONObject(i);
            JSONObject core = listing.getJSONObject("listing");

            String discount = listing.getJSONObject("pricingQuote")
                    .getJSONObject("structuredStayDisplayPrice")
                    .getJSONObject("primaryLine")
                    .optString("discountedPrice", "N/A");

            String price = listing.getJSONObject("pricingQuote")
                    .getJSONObject("structuredStayDisplayPrice")
                    .getJSONObject("primaryLine")
                    .optString("originalPrice", "N/A");

            String name = core.optString("name", "Unknown Name");
            String rating = core.optString("avgRatingA11yLabel", "No Rating");
            String roomType = core.optString("roomTypeCategory", "Unknown Room Type");

            // Use propertyFactory to create a Property object
            Property property = propertyFactory.create(name, rating, discount, price, roomType);
            properties.add(property);
        }
        return properties;
    }
}
