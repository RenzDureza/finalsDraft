public class Ticket extends Reservation {
    public String flightCode;
    public int seatClass;
    public double ticketPrice;
    public int rowSeat;
    public int colSeat;

    public Ticket(String name, int age, String flightCode, int seatClass, double ticketPrice, int rowSeat, int colSeat) {
        super(name, age);
        this.flightCode = flightCode;
        this.seatClass = seatClass;
        this.rowSeat = rowSeat;
        this.colSeat = colSeat;
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void viewTicket() {
        System.out.println("Ticket Name: " + getName());
        System.out.println("Ticket Age: " + getAge());
        System.out.println("Flight Code: " + flightCode);
        System.out.println("Seat Class: " + seatClass);
        System.out.println("Row Seat: " + rowSeat);
        System.out.println("Col Seat: " + colSeat);
        System.out.println("Ticket Price: P" + ticketPrice);
    }

}
