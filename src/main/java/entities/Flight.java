package entities;

public class Flight {
    private final String departureTime;
    private final String arrivalTime;
    private final String arrivalAirport;
    private final String flightDuration;
    private final String layovers;
    private final String price;

    public Flight(String departureTime, String arrivalTime, String arrivalAirport, String flightDuration,
                  String layovers, String price) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.arrivalAirport = arrivalAirport;
        this.flightDuration = flightDuration;
        this.layovers = layovers;
        this.price = price;
    }
    public String getDepartureTime() {return departureTime;}
    public String getArrivalTime() {return arrivalTime;}
    public String getArrivalAirport() {return arrivalAirport;}
    public String getFlightDuration() {return flightDuration;}
    public String getLayovers() {return layovers;}
    public String getPrice() {return price;}
}
