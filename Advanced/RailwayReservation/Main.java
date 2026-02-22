package railway_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RailwayReservationSystem reservationSystem = new RailwayReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Book Ticket\n2. Cancel Ticket\n3. Print Booked Tickets\n4. Print Available Tickets\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Gender (M/F): ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Berth Preference (Lower/Middle/Upper): ");
                    String berthPreference = scanner.nextLine();

                    Passenger passenger = new Passenger(name, age, gender, berthPreference);
                    reservationSystem.bookTicket(passenger);
                    break;

                case 2:
                    System.out.print("Enter Seat Number to Cancel: ");
                    int seatNumber = scanner.nextInt();
                    reservationSystem.cancelTicket(seatNumber);
                    break;

                case 3:
                    reservationSystem.printBookedTickets();
                    break;

                case 4:
                    reservationSystem.printAvailableTickets();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}