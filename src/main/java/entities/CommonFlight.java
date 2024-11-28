package entities;

public class CommonFlight implements Flight {
    private final String departureTime;
    private final String arrivalTime;
    private final String departureAirport;
    private final String arrivalAirport;
    private final String flightDuration;
    private final String price;

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
    public String getPrice() {return price;}

    @Override
    public String toString() {
        return "Flight{" +
                "Departure Time ='" + departureTime + '\'' +
                ", Arrival Time ='" + arrivalTime + '\'' +
                ", Departure Airport ='" + departureAirport + '\'' +
                ", Arrival Airport ='" + arrivalAirport + '\'' +
                ", Flight Duration ='" + flightDuration + '\'' +
                ", Price ='" + price + '\'' +
                '}';
    }
}
