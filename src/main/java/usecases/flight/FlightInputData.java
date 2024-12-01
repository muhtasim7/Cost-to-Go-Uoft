package usecases.flight;

public class FlightInputData {
    private final String destination;

    public FlightInputData(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }
}

