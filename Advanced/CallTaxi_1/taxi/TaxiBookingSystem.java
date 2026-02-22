package taxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiBookingSystem {
    List<Taxi> taxis;
    int bookingIdCounter;

    public TaxiBookingSystem(int numTaxis) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= numTaxis; i++) {
            taxis.add(new Taxi("Taxi-" + i));
        }
        bookingIdCounter = 1;
    }

    // Find the nearest available taxi
    private Taxi findNearestTaxi(char pickupPoint, int pickupTime) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi taxi : taxis) {
            if (taxi.isFree(pickupTime)) {
                freeTaxis.add(taxi);
            }
        }

        if (freeTaxis.isEmpty()) {
            return null; // No free taxis
        }

        // Find the taxi with the nearest location
        Taxi nearestTaxi = freeTaxis.get(0);
        int minDistance = Math.abs(nearestTaxi.currentLocation - pickupPoint);

        for (Taxi taxi : freeTaxis) {
            int distance = Math.abs(taxi.currentLocation - pickupPoint);
            if (distance < minDistance) {
                nearestTaxi = taxi;
                minDistance = distance;
            } else if (distance == minDistance && taxi.totalEarnings < nearestTaxi.totalEarnings) {
                nearestTaxi = taxi; // Prefer taxi with lower earnings
            }
        }

        return nearestTaxi;
    }

    // Book a taxi for a customer
    public void bookTaxi(int customerId, char pickupPoint, char dropPoint, int pickupTime) {
        Taxi taxi = findNearestTaxi(pickupPoint, pickupTime);
        if (taxi == null) {
            System.out.println("Booking rejected. No taxi available.");
            return;
        }

        Booking booking = new Booking(bookingIdCounter++, customerId, pickupPoint, dropPoint, pickupTime);
        taxi.allocateBooking(booking);

        System.out.println("Taxi can be allotted. " + taxi.taxiId + " is allotted.");
    }

    // Display details of a specific taxi
    public void displayTaxiDetails(String taxiId) {
        for (Taxi taxi : taxis) {
            if (taxi.taxiId.equals(taxiId)) {
                taxi.displayDetails();
                return;
            }
        }
        System.out.println("Taxi not found.");
    }
}
