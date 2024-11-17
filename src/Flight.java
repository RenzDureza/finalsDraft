import java.util.*;

public class Flight extends Reservation{
    private String flightCode;
    private String destination;
    private String time;

    public Flight(String flightCode, String destination, String time) {
        this.flightCode = flightCode;
        this.destination = destination;
        this.time = time;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String toString() {
        return "Flight Code: " + flightCode + "  ||  " + "Destination:  " + destination + "  ||  " + " Time: " + time;
    }


}
