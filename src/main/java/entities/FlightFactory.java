package entities;

public interface FlightFactory {
    /**
     * Creates a new flight object with the parameters below.
     * @param departureTime the departure time of the flight
     * @param arrivalTime the arrival time of the flight
     * @param departureAirport the airport from which the plane departs
     * @param arrivalAirport the airport at which the plane arrives
     * @param flightDuration the duration of the flight
     * @param price the price of the flight
     * @return a new flight object with the parameters mentioned
     */
    Flight create(String departureTime, String arrivalTime, String departureAirport,
                  String arrivalAirport, String flightDuration, String price);
}
