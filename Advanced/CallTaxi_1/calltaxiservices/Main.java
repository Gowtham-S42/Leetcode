package calltaxiservices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your List of Taxis:");
        int n=scanner.nextInt();
        TaxiBookingSystem system = new TaxiBookingSystem(n);

        while (true) {
            System.out.println("Enter Customer ID:");
            int customerId = scanner.nextInt();
            System.out.println("Enter Pickup Point (A-F):");
            char pickupPoint = scanner.next().charAt(0);
            System.out.println("Enter Drop Point (A-F):");
            char dropPoint = scanner.next().charAt(0);
            System.out.println("Enter Pickup Time (in hours):");
            int pickupTime = scanner.nextInt();

            system.bookTaxi(customerId, pickupPoint, dropPoint, pickupTime);

            System.out.println("Do you want to book another taxi? (yes/no)");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        system.displayTaxiDetails();
        scanner.close();
    }
}