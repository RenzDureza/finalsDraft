public class Ticket extends Reservation {
    public String flightCode;
    public String seatClass;
    public double ticketPrice;
    public int rowSeat;
    public int colSeat;

    public Ticket(String name, int age, String flightCode, String seatClass, double ticketPrice, int rowSeat, int colSeat) {
        super(name, age);
        this.flightCode = flightCode;
        this.seatClass = seatClass;
        this.rowSeat = rowSeat;
        this.colSeat = colSeat;
        this.ticketPrice = ticketPrice;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String viewTicket() {
        return "Ticket Name: " + getName() + "\nTicket Age: " + getAge() + "\nFlight Code: " + flightCode + "\nSeat Class: " + seatClass + "\nRow Seat: " + rowSeat + "\nCol Seat: " + colSeat + "\nTicket Price: P" + ticketPrice;
    }
}
