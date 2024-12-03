package entities;

/**
 * Shows flight with time of departure and arrival, the arrival and departure airports and duration and price of flight.
 * Implementation of Flight interface
 */
public class CommonFlight implements Flight {
    private final String departureTime;
    private final String arrivalTime;
    private final String departureAirport;
    private final String arrivalAirport;
    private final String flightDuration;
    private final String price;

    /**
     * Makes a new CommonFlight object with the specified details.
     * @param departureTime is the time of departure of the flight
     * @param arrivalTime is the time the flight arrives at destination
     * @param departureAirport is the airport from which the plane departs
     * @param arrivalAirport is the airport at which the airport arrives
     * @param flightDuration is the total duration of the flight
     * @param price is the price of the flight
     */
    public CommonFlight(String departureTime, String arrivalTime, String departureAirport,
                        String arrivalAirport, String flightDuration, String price) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightDuration = flightDuration;
        this.price = price;
    }

    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public String getFlightDuration() {
        return flightDuration;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight{"
                + "Departure Time ='" + departureTime + '\''
                + ", Arrival Time ='" + arrivalTime + '\''
                + ", Departure Airport ='" + departureAirport + '\''
                + ", Arrival Airport ='" + arrivalAirport + '\''
                + ", Flight Duration ='" + flightDuration + '\''
                + ", Price ='" + price + '\''
                + '}';
    }
}
