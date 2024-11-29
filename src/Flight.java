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

    public double getFlightPrice() {
        return flightPrice;
    }

    public void displaySeats(String seatClass) {

        System.out.print("         ");
        for (int colNum = 1; colNum <= col - 1; colNum++) {
            System.out.print(" " + colNum + "   ");
        }
        System.out.println();


        if (seatClass.equals("Business")) {
            System.out.println("      +---------------------------------+");
            System.out.println("      |             Cockpit             |");
            System.out.println("      +---------------------------------+      Business Class");

            for (int i = 1; i < 3; i++) {
                System.out.print("Row " + i + " | ");
                for (int j = 1; j < col; j++) {
                    System.out.print(" [" + (seat[i][j]) + "] ");
                }
                System.out.println("  |");
            }
        } else if (seatClass.equals("Economy")) {
            System.out.println("      +---------------------------------+      Economy Class");
            for (int i = 3; i < 6; i++) {
                System.out.print("Row " + i + " | ");
                for (int j = 1; j < col; j++) {
                    System.out.print(" [" + (seat[i][j]) + "] ");
                }
                System.out.println("  |");
            }
        }
    }

    public boolean markSeat(int row, int col, String seatClass) {
        int totalCol = 7;
        int businessRows = 3;
        int economyRows= 6;

        if (seatClass.equals("Business")) {
            if (row < 0 || row >= businessRows) {
                System.out.println("Invalid row");
                return false;
            }
        } else if (seatClass.equals("Economy")) {
            if (row < businessRows || row >= economyRows) {
                System.out.println("Invalid row");
                return false;
            }
        } else {
            System.out.println("Invalid seat class");
            return false;
        }

        if (col < 0 || col >= totalCol) {
            System.out.println("Invalid column");
            return false;
        }

        if (seat[row][col] == ' ') {
            seat[row][col] = 'X';
            System.out.println("Seat successfully booked! Updated seat map:");
            displaySeats(seatClass);
            return true;
        } else {
            System.out.println("Seat already occupied. Choose another one.");
            return false;
        }
    }

    public boolean removeSeat(int rowSeat, int colSeat){
        if (seat[rowSeat][colSeat] == 'X'){
            seat[rowSeat][colSeat] = ' ';
            System.out.println("Seat successfully cleared.");
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Flight Code: " + flightCode + "  ||  " + "Destination:  " + destination + "  ||  " + " Time: " + time;
    }
}
