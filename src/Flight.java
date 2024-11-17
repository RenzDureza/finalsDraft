import java.util.*;

public class Flight{
    private String flightCode;
    private String destination;
    private String time;
    private double flightPrice;
    private  int row;
    private  int col;
    public char[][] seat;

    public Flight(String flightCode, String destination, String time, double flightPrice) {
        this.flightCode = flightCode;
        this.destination = destination;
        this.time = time;
        this.flightPrice = flightPrice;
        this.row = 5;
        this.col = 6;
        this.seat = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                seat[i][j] = ' ';
            }
        }
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

    public double getFlightPrice() {
        return flightPrice;
    }

    public void displaySeats() {
        System.out.println("+---------------------------+");
        System.out.println("|          Cockpit          |");
        System.out.println("+---------------------------+     Business Class");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + seat[i][j] + "]");
            }
            System.out.println();
        }
    }

    public boolean markSeat(int row, int col) {
        if (seat[row][col] == ' ') {
            seat[row][col] = 'X';
            return true;
        } else {
            System.out.println("Seat already occupied. Choose another one.");
            return false;
        }
    }

    public String toString() {
        return "Flight Code: " + flightCode + "  ||  " + "Destination:  " + destination + "  ||  " + " Time: " + time;
    }

}
