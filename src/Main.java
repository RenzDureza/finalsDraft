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
            input.nextLine();
            System.out.println("======================================================");

            switch (choice) {
                case 1:
                    clearScreen();
                    System.out.println("============  --- AVAILABLE  FLIGHTS ---  ============");
                    Iterator<Flight> itr = flightList.iterator(); // iniba ko lng para mabasa nung iterator
                    while (itr.hasNext()){
                        // System.out.println(itr.next()); ibahihin ko to para madisplay din yung seatplan
                        Flight flight = itr.next();
                        System.out.println(flight);
                        flight.displaySeats();
                        System.out.println();
                    }
                    consolePause();
                    clearScreen();
                    break;
                case 2:
                    clearScreen();
                    System.out.println("--- AVAILABLE FLIGHTS ---");
                    for (Flight flight : flightList) {
                        System.out.println(flight);
                    }

                    System.out.println("--- BOOK A TICKET ---");
                    System.out.print("Enter your Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter your Age: ");
                    int age = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Flight Code: ");
                    String flightCode = input.nextLine();

                    Flight myFlight = null;
                    for (Flight flight : flightList) {
                        if (flight.getFlightCode().equals(flightCode)) {
                            myFlight = flight;
                            break;
                        }
                    }


                    if (myFlight != null) {
                        System.out.print("[1] Business Class [2] Economy Class: ");
                        String seatClass = input.nextLine();

                        myFlight.displaySeats();
                        System.out.print("Enter your Row: ");
                        int row = input.nextInt();
                        System.out.print("Enter your Column: ");
                        int column = input.nextInt();

                        myFlight.markSeat(row, column);

                        double ticketPrice = myFlight.getFlightPrice();
                        if (seatClass.equals("1")) {
                            ticketPrice += 1500;
                            seatClass = "Business Class";
                        } else if (seatClass.equals("2")) {
                            ticketPrice += 300;
                            seatClass = "Economy Class";
                        } else {
                            System.out.println("Invalid choice.");
                            break;
                        }

                        Ticket myTicket = new Ticket(name, age, flightCode, seatClass, ticketPrice, row, column);
                        ticketList.add(myTicket);

                        System.out.println("Seat successfully booked! Updated seat map:");
                        myFlight.displaySeats();
                    } else {
                        System.out.println("Flight not found.");
                    }
                    consolePause();
                    clearScreen();
                    break;

                case 3:
                    clearScreen();
                    System.out.println("=============   --- TICKET  DETAILS ---  ==============");
                    System.out.print("Enter your Name: ");
                    String nameSearch = input.nextLine();

                    for (Ticket ticket : ticketList) {
                        if (ticket.getName().equals(nameSearch)) {
                            ticket.viewTicket();
                        } else {
                            System.out.println("Ticket not found.");
                            break;
                        }
                    }
                    consolePause();
                    clearScreen();
                    break;
                case 4:
                    clearScreen();
                    System.out.println("============   --- CANCEL  BOOKING ---  =============");

                    consolePause();
                    clearScreen();
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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void consolePause() {
        Scanner input = new Scanner(System.in);
        System.out.print("Press Enter to continue...");
        input.nextLine();
    }
}