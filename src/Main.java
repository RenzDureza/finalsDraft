import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;
        List<Flight> flightList = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();
        flightList.add(new Flight("EBX123", "PH - CN", "09:00 - 14:00", 3440));
        flightList.add(new Flight("EBX142", "PH - KR", "04:00 - 08:00", 9645));
        flightList.add(new Flight("EBX369", "PH - JP", "08:00 - 12:30", 13510));
        int ticketCount = 0;
        do {
            System.out.println("=========== EBX Airline Reservation System ===========");
            System.out.println("[1] View Flights");
            System.out.println("[2] Book Ticket");
            System.out.println("[3] View Ticket Details");
            System.out.println("[4] Cancel Flight");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextLine();
            System.out.println("======================================================");

            switch (choice) {
                case "1":
                    clearScreen();
                    System.out.println("============  --- AVAILABLE  FLIGHTS ---  ============");
                    Iterator<Flight> itr = flightList.iterator();
                    while (itr.hasNext()) {
                        Flight flight = itr.next();
                        System.out.println(flight);
                        flight.displaySeats("Business");
                        flight.displaySeats("Economy");
                        System.out.println();
                    }
                    consolePause();
                    clearScreen();
                    break;

                case "2":
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

                    
                    if (myFlight != null) {
                        System.out.print("Enter your Name: ");
                        String name = input.nextLine();
                        System.out.print("Enter your Age: ");
                        int age = input.nextInt(); input.nextLine();

                        System.out.print("Business Class [1] || Economy Class [2]: ");
                        int seatClassChoice = input.nextInt(); input.nextLine();

                        String seatClass;
                        double ticketPrice = myFlight.getFlightPrice();
                        if (seatClassChoice == 1) {
                            seatClass = "Business";
                            ticketPrice += 4500;
                        } else if (seatClassChoice == 2) {
                            seatClass = "Economy";
                        } else {
                            System.out.println("Invalid choice.");
                            break;
                        }

                        myFlight.displaySeats(seatClass);
                        System.out.print("Enter your Row: ");
                        int row = input.nextInt(); input.nextLine();
                        System.out.print("Enter your Column: ");
                        int column = input.nextInt(); input.nextLine();
                        
                        if (myFlight.markSeat(row, column, seatClass)){
                            Ticket myTicket = new Ticket(name, age, flightCode, seatClass, ticketPrice, row, column);
                            ticketList.add(myTicket);
                            ticketCount++;

                            printTicket(myTicket, ticketCount);
                        }
                    } else {
                        System.out.println("Flight not found.");
                    }
                    consolePause();
                    clearScreen();
                    break;

                case "3":
                    clearScreen();
                    System.out.println("=============   --- TICKET  DETAILS ---  ==============");
                    System.out.print("Enter your Name: ");
                    String ticketName = input.nextLine();

                    List<Ticket> ticketEntry = new ArrayList<>();

                    for (Ticket ticket : ticketList) {
                        if (ticket.getName().equalsIgnoreCase(ticketName)) {
                            ticketEntry.add(ticket); // LISTS ALL SAME NAMES INTO ARRAY LIST
                        }
                    }
                    if (ticketEntry.isEmpty()) {
                        System.out.println("No ticket found for the name: " + ticketName);
                    } else {
                        System.out.println("Found " + ticketEntry.size() + " ticket(s) for the name: " + ticketName);
                        System.out.println("-----------------------");
                        for (Ticket ticket : ticketEntry) { // DISPLAYS ALL FOUND NAMES
                                System.out.println(ticket.viewTicket());
                                System.out.println("-----------------------");
                        }
                    }
                    consolePause();
                    clearScreen();
                    break;

                case "4":
                    clearScreen();
                    System.out.println("============   --- CANCEL  BOOKING ---  =============");
                    for (Flight flight : flightList) { // DISPLAY LIST OF AVAILABLE FLIGHTS
                        System.out.println(flight);
                    }
                    System.out.print("Enter Flight Code: ");
                    String searchFlightCode = input.nextLine();

                    Flight searchFlight = null;
                    for (Flight flight : flightList) { // CHECKS IF INPUTTED FLIGHT CODE IS AN EXISTING FLIGHT
                        if (flight.getFlightCode().equals(searchFlightCode)) {
                            searchFlight = flight;
                            break;
                        }
                    }
                    if (searchFlight == null) {
                        System.out.println("Flight not found.");
                    } else { // NEXT STEP - CHECK IF THE PERSON'S NAME HAS A TICKET
                        System.out.print("Enter your Name: ");
                        String searchName = input.nextLine();

                        List<Ticket> searchTicket = new ArrayList<>();
                        for (Ticket ticket : ticketList) { // LISTS ALL SAME NAMES OF DIFFERENT TICKETS
                            if (ticket.getFlightCode().equals(searchFlightCode) && ticket.getName().equalsIgnoreCase(searchName)) {
                                searchTicket.add(ticket);
                            }
                        }

                        Ticket ticketToCancel = null;
                        if (searchTicket.isEmpty()) {
                            System.out.println("Ticket not found in flight for the provided name: " + searchName);

                        } else if (searchTicket.size() == 1) { // IF NAME IS THE ONLY ONE EXISTING IN FLIGHT
                            ticketToCancel = searchTicket.getFirst();
                            System.out.println("-----------------------");
                            System.out.println(ticketToCancel.viewTicket());
                            System.out.println("-----------------------");

                        } else { // IF MULTIPLE NAMES EXIST IN FLIGHT
                            System.out.println("Found " + searchTicket.size() + " ticket(s) for the name: " + searchName);
                            System.out.println("-----------------------");
                            for (int i=0; i<searchTicket.size(); i++){ // DISPLAY ALL FOUND NAMES
                                System.out.println("Ticket " + (i+1) + ": ");
                                System.out.println(searchTicket.get(i).viewTicket());
                                System.out.println("-----------------------");
                            }

                            System.out.print("Enter ticket # to be cancelled: ");
                            int ticketNo = input.nextInt(); input.nextLine();

                            if (ticketNo > 0 && ticketNo <= searchTicket.size()) {
                                ticketToCancel = searchTicket.get(ticketNo - 1);
                            } else {
                                System.out.println("Invalid input.");
                            }
                        }

                        if (ticketToCancel != null) {
                            String cancelConfirm;
                            while(true) {
                                System.out.print("Confirm Cancellation of Ticket? [Y/N]: ");
                                cancelConfirm = input.nextLine();
                                if (cancelConfirm.equalsIgnoreCase("Y")) {
                                    searchFlight.removeSeat(ticketToCancel.rowSeat, ticketToCancel.colSeat); // CLEARS SEAT IN FLIGHT
                                    System.out.println("Ticket for " + ticketToCancel.getName() + " has been successfully cancelled.");
                                    ticketList.remove(ticketToCancel);
                                    break;

                                } else if (cancelConfirm.equalsIgnoreCase("N")) {
                                    System.out.println("Ticket cancellation process has been cancelled.");
                                    break;

                                } else {
                                    System.out.println("Invalid input.");
                                }
                            }
                        }
                    }
                    consolePause();
                    clearScreen();
                    break;

                case "5":
                    System.out.println("Thank you for using our EBX Airline System! Have a safe flight!");
                    break;

                default:
                    clearScreen();
                    System.out.println("Invalid Choice.");
                    consolePause();
                    clearScreen();
                    break;
            }
        } while (!choice.equalsIgnoreCase("5"));
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

    public static void printTicket(Ticket ticket, int ticketCount) {
        try {
            String pathforEveryone = System.getProperty("user.home") + "\\Documents\\Ticket"+ ticketCount + ".txt";

            FileOutputStream fout = new FileOutputStream(pathforEveryone);
            String ticketContent = ticket.viewTicket();
            byte[] b = ticketContent.getBytes();
            fout.write(b);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}