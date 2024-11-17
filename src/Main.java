import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        List<Flight> flightList = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();
        flightList.add(new Flight("EBX123", "PH - CN", "09:00 - 14:00",300));
        flightList.add(new Flight("EBX142", "PH - KR", "04:00 - 08:00",500));
        flightList.add(new Flight("EBX369", "PH - JP", "08:00 - 12:30",600));

        do {
            System.out.println("=========== EBX Airline Reservation System ===========");
            System.out.println("[1] View Flights");
            System.out.println("[2] Book Ticket");
            System.out.println("[3] View Ticket Details");
            System.out.println("[4] Cancel Flight");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            System.out.println("======================================================");

            switch (choice) {
                case 1:
                    System.out.println("============  --- AVAILABLE  FLIGHTS ---  ============");
                    Iterator itr = flightList.iterator();
                    while (itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    break;
                case 2:
                    System.out.println("--- BOOK A TICKET ---");
                    System.out.print("Enter your Name: ");
                    input.nextLine();
                    String name = input.nextLine();

                    System.out.print("Enter your Age: ");
                    int age = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Flight Code: ");
                    String flightCode = input.next();

                    Flight myFlight = null;
                    for (Flight flight : flightList) {
                        if (flight.getFlightCode().equals(flightCode)) {
                            myFlight = flight;
                            break;
                        }
                    }

                    if (myFlight != null) {
                        System.out.println("[1] Business or [2] Economy?: ");
                        int seatClass = input.nextInt();
                        input.nextLine();

                        myFlight.displaySeats();
                        System.out.print("Enter your Row: ");
                        int row = input.nextInt();
                        System.out.print("Enter your Column: ");
                        int column = input.nextInt();

                        myFlight.markSeat(row, column);

                        double ticketPrice = myFlight.getFlightPrice();
//                        if (seatClass == 1) {
//                            ticketPrice -= 300;
//                        } else if (seatClass == 2) {
//                            ticketPrice += 300;
//                        }

                        Ticket myTicket = new Ticket(name, age, flightCode, seatClass, ticketPrice, row, column);
                        ticketList.add(myTicket);
                    }
                    break;

                case 3:
                    System.out.println("=============   --- TICKET  DETAILS ---  ==============");
                    System.out.println("Enter your Name: ");
                    String nameSearch = input.next();

                    for (Ticket ticket : ticketList) {
                        if (ticket.getName().equals(nameSearch)) {
                            ticket.viewTicket();
                        }
                    }
                    break;
                case 4:
                    System.out.println("============   --- CANCEL  BOOKING ---  =============");

                    break;
                case 5:
                    System.out.println("Thank you for using EBX Airline System! Goodbye and have a safe flight!");
                    break;
                default:
                    System.out.println("Invalid Choice.");
                    break;
            }
        } while (choice != 5);
    }
}