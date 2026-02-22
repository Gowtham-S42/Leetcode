package calltaxiservices;

import java.util.ArrayList;
import java.util.List;

public class TaxiBookingSystem {
    private List<Taxi> taxis;
    private List<Booking> bookings;
    private int bookingIdCounter;

    public TaxiBookingSystem(int numberOfTaxis) {
        taxis = new ArrayList<>();
        bookings = new ArrayList<>();
        bookingIdCounter = 1;
        for (int i = 1; i <= numberOfTaxis; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(int customerId, char pickupPoint, char dropPoint, int pickupTime) {
        Taxi allocatedTaxi = null;
        for (Taxi taxi : taxis) {
            taxi.freeTaxi(pickupTime);
            if (taxi.isFree() && taxi.getCurrentPoint() == pickupPoint) {
                if (allocatedTaxi == null || taxi.getTotalEarnings() < allocatedTaxi.getTotalEarnings()) {
                    allocatedTaxi = taxi;
                }
            }
        }

        if (allocatedTaxi == null) {
            for (Taxi taxi : taxis) {
                taxi.freeTaxi(pickupTime);
                if (taxi.isFree()) {
                    if (allocatedTaxi == null || Math.abs(taxi.getCurrentPoint() - pickupPoint) < Math.abs(allocatedTaxi.getCurrentPoint() - pickupPoint)) {
                        allocatedTaxi = taxi;
                    }
                }
            }
        }

        if (allocatedTaxi != null) {
            int distance = Math.abs(dropPoint - pickupPoint) * 15;
            int fare = 100 + (distance - 5) * 10;
            allocatedTaxi.bookTaxi(pickupPoint, dropPoint, pickupTime);
            bookings.add(new Booking(bookingIdCounter++, customerId, pickupPoint, dropPoint, pickupTime, fare));
            System.out.println("Taxi can be allotted.");
            System.out.println("Taxi-" + allocatedTaxi.getId() + " is allotted.");
        } else {
            System.out.println("taxi Illa po da.");
        }
    }

    public void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi-" + taxi.getId() + " Total Earnings: Rs. " + taxi.getTotalEarnings());
            for (Booking booking : bookings) {
                if (booking.getCustomerId() == taxi.getId()) {
                    System.out.println(booking.getBookingId() + " " + booking.getCustomerId() + " " + booking.getPickupPoint() + " " + booking.getDropPoint() + " " + booking.getPickupTime() + " " + (booking.getPickupTime() + (Math.abs(booking.getDropPoint() - booking.getPickupPoint()))) + " " + booking.getFare());
                }
            }
        }
    }
}
