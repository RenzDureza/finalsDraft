import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner choiceInput = new Scanner(System.in);
        int choice;

        // Im thinking of using a java collection para sa pag add ng flight like yung <List>
        // ex
            // List<Flight> flights = new ArrayList<>();
            // flights.add(new Flight("EBX123", "MNL - CN", "9:00 - 10:00", blah blah));
            // flights.add(new Flight("EBX123", "MNL - CN", "9:00 - 10:00", blah blah));
            // flights.add(new Flight("EBX123", "MNL - CN", "9:00 - 10:00", blah blah));

        do {
            System.out.println("=========== EBX Airline Reservation System ===========");
            System.out.println("[1] View Flights");
            System.out.println("[2] Book Ticket");
            System.out.println("[3] View Ticket Details");
            System.out.println("[4] Cancel Flight");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice: ");
            choice = choiceInput.nextInt();
            System.out.println("======================================================");

            switch (choice) {
                case 1:
                    // code
                    break;
                case 2:
                    // code
                    break;
                case 3:
                    // code
                    break;
                case 4:
                    // code
                    break;
                case 5:
                    // code
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while  (choice != 5);
    }
}