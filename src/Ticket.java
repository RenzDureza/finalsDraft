public class Ticket extends Reservation {
    public double ticketPrice;

    public Ticket(String passengerName, int passengerAge, double ticketPrice) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    // functions

    // suggestion ko

    // function for generating ticket file, chill lang muna siguro tayo dito hindi pa naman natuturo.
}
