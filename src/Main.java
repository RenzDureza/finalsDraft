import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight("EBX123", "PH - CN", "09:00 - 14:00"));
        flightList.add(new Flight("EBX142", "PH - KR", "04:00 - 08:00"));
        flightList.add(new Flight("EBX369", "PH - JP", "08:00 - 12:30"));

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
//                    Reservation reservation = new Reservation();
//                    System.out.println("--- BOOK A TICKET ---");
//                    System.out.println("Enter your Name: ");
//                    reservation.setName(input.nextLine());
//                    System.out.println("[1] Business or [2] Economy?: ");
//                    reservation.setFlightClass(input.nextInt());
//                    System.out.println("Enter Flight Code: ");

                    break;
                case 3:
                    System.out.println("=============   --- TICKET  DETAILS ---  ==============");

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