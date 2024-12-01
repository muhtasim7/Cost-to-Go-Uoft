package usecases.property;

/**
 * Class representing the input data for the Property Use Case.
 * Contains all necessary fields to perform the search for properties.
 */
public class PropertyInputData {
    private final String city;

    /**
     * Constructs a new instance of PropertyInputData.
     *
     * @param city the name of the city for which properties are to be searched
     */
    public PropertyInputData(String city) {
        this.city = city;
    }

    /**
     * Retrieves the city for this input data.
     *
     * @return the city name
     */
    public String getCity() {
        return city;
    }
}
