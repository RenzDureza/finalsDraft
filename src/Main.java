import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        List<Flight> flightList = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();
        flightList.add(new Flight("EBX123", "PH - CN", "09:00 - 14:00",3440));
        flightList.add(new Flight("EBX142", "PH - KR", "04:00 - 08:00",9645));
        flightList.add(new Flight("EBX369", "PH - JP", "08:00 - 12:30",13510));

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
                    System.out.print("Enter Flight Code: ");
                    String flightCode = input.nextLine();

                    Flight myFlight = null;
                    for (Flight flight : flightList) {
                        if (flight.getFlightCode().equals(flightCode)) {
                            myFlight = flight;
                            break;
                        }
                    }

                    System.out.print("Enter your Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter your Age: ");
                    int age = input.nextInt();
                    input.nextLine();


                    if (myFlight != null) {
                        System.out.print("Business Class [1] || Economy Class [2]: ");
                        String seatClass = input.nextLine();

                        double ticketPrice = myFlight.getFlightPrice();
                        if (seatClass.equals("1")) {
                            ticketPrice += 4500;
                            seatClass = "Business Class";
                        } else if (seatClass.equals("2")) {
                            ticketPrice = myFlight.getFlightPrice();
                            seatClass = "Economy Class";
                        } else {
                            System.out.println("Invalid choice.");
                            break;
                        }

                        myFlight.displaySeats();
                        System.out.print("Enter your Row: ");
                        int row = input.nextInt();
                        System.out.print("Enter your Column: ");
                        int column = input.nextInt();

                        myFlight.markSeat(row, column);

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
                    String ticketName = input.nextLine();

                    for (Ticket ticket : ticketList) {
                        if (ticket.getName().equals(ticketName)) {
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
                    for (Flight flight : flightList) {
                        System.out.println(flight);
                    }
                    System.out.print("Enter Flight Code: ");
                    String searchFlightCode = input.nextLine();

                    Ticket searchTicket = null;
                    for (Ticket ticket : ticketList) {
                        if (ticket.getFlightCode().equals(searchFlightCode)) {
                            searchTicket = ticket;
                            break;
                        }
                    }

                    if (searchTicket != null){
                        System.out.print("Enter your Name: ");
                        String searchName = input.nextLine();

                        if (searchTicket.getName().equals(searchName)){
                            searchTicket.viewTicket();
                            String cancelConfirm;
                            do{
                                System.out.print("Confirm Cancellation of Ticket? [Y/N]: ");
                                cancelConfirm = input.nextLine();
                                if (cancelConfirm.equals("Y")){
                                    ticketList.remove(searchTicket);
                                    System.out.println("Your ticket has been successfully cancelled.");
                                } else if (cancelConfirm.equals("N")){
                                    System.out.println("Ticket cancellation process has been cancelled.");
                                } else {
                                    System.out.println("Invalid input.");
                                }
                            }while(!cancelConfirm.equals("Y") && !cancelConfirm.equals("N"));
                        } else {
                            System.out.println("Name not found.");
                        }

                    } else {
                        System.out.println("Flight not found.");
                        consolePause();
                        clearScreen();
                        break;
                    }

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

/* TODO:
    - Storing new ticket
    - Test delete function
    - Seat map
    -
*/