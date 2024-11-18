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
        this.row = 6; //see line 54
        this.col = 7; //see line 56
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

        System.out.print(" Col  "); //for clarity
        for (int colNum = 1; colNum < col; colNum++) {
            System.out.print(" " + colNum + " ");
        }

        System.out.println();
        for (int i = 1; i < row; i++) { // ginawa ko 1 para di siya 0 index
            System.out.print("Row " + i + " "); //for clarity
            for (int j = 1; j < col; j++) { // ginawa ko 1 para di siya 0 index
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
