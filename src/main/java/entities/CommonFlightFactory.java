package entities;

public class CommonFlightFactory implements FlightFactory {
    @Override
    public Flight create(String departureTime, String arrivalTime, String departureAirport,
                         String arrivalAirport, String flightDuration, String price) {
        return new CommonFlight(departureTime, arrivalTime, departureAirport, arrivalAirport,
                flightDuration, price);
    }
}
