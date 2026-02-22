package lift_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LiftSystem liftSystem = new LiftSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Lift System Menu ---");
            System.out.println("1. Display Lift Positions");
            System.out.println("2. Assign Lift to User");
            System.out.println("3. Set Lift Under Maintenance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    liftSystem.displayLiftPositions();
                    break;

                case 2:
                    System.out.print("Enter source floor: ");
                    int sourceFloor = scanner.nextInt();
                    System.out.print("Enter destination floor: ");
                    int destinationFloor = scanner.nextInt();
                    System.out.print("Enter number of people: ");
                    int people = scanner.nextInt();

                    liftSystem.assignLift(sourceFloor, destinationFloor, people);
                    liftSystem.displayLiftPositions();
                    break;

                case 3:
                    System.out.print("Enter lift ID to set under maintenance (e.g., L1, L2): ");
                    String liftId = scanner.next();
                    liftSystem.setLiftUnderMaintenance(liftId);
                    liftSystem.displayLiftPositions();
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
