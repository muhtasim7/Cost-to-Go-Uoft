package entities;

public interface Flight {
    /**
     * Gets the departure time of the flight.
     * @return the departure time
     */
    String getDepartureTime();

    /**
     * Gets the time the flight lands.
     * @return the arrival time
     */
    String getArrivalTime();

    /**
     * Gets the departure airport.
     * @return the departure airport
     */
    String getDepartureAirport();

    /**
     * Gets the arrival airport.
     * @return the arrival airport
     */
    String getArrivalAirport();

    /**
     * Gets the flight duration.
     * @return the flight duration
     */
    String getFlightDuration();

    /**
     * Gets the price of the flight.
     * @return flight price
     */
    String getPrice();
}
