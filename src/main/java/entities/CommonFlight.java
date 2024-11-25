package entities;

public class CommonFlight implements Flight {
    private final String departureTime;
    private final String arrivalTime;
    private final String departureAirport;
    private final String arrivalAirport;
    private final String flightDuration;
    private final String layovers;
    private final String price;

    public CommonFlight(String departureTime, String arrivalTime, String departureAirport,
                        String arrivalAirport, String flightDuration, String layovers, String price) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightDuration = flightDuration;
        this.layovers = layovers;
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
    public String getLayovers() {
        return layovers;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", flightDuration='" + flightDuration + '\'' +
                ", layovers='" + layovers + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
