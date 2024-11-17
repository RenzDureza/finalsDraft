public class Flight extends Reservation{
    public String flightCode;
    public String destination;
    public String time;

    public Flight(String flightCode, String destination, String time) {
        this.flightCode = flightCode;
        this.destination = destination;
        this.time = time;
        // not sure pa kung pano gagawin yung sa seats eh mb  mb, pero baka yung sa "tictactoe"
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String getDestination() {
        return destination;
    }

    public String getTime() {
        return time;
    }

    // Functions

    // Suggestions ko
    // Dito ilagay yung function for diplaying the flight details like: flight code, time, destination, ticket price,
    // ex:
        // EBX123
        // 9:00 - 10:00
        // MNL - CN
        // 850php

    // need din ng function for displaying seat map, pwede gumamit ng nested for loop dito, like sa tictactoe program, madali lang yon kopya nalang kayo sa google HAHAHAH

}
