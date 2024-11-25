package entities;

public interface FlightFactory {
    Flight create(String departureTime, String arrivalTime, String departureAirport,
                  String arrivalAirport, String flightDuration, String layovers, String price);
}
