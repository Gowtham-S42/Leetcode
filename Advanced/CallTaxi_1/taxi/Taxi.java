package taxi;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    String taxiId;
    char currentLocation;
    int totalEarnings;
    List<Booking> bookings;

    public Taxi(String taxiId) {
        this.taxiId = taxiId;
        this.currentLocation = 'A'; // All taxis start at point A
        this.totalEarnings = 0;
        this.bookings = new ArrayList<>();
    }

    // Check if the taxi is free at a given time
    public boolean isFree(int pickupTime) {
        if (bookings.isEmpty()) {
            return true;
        }
        Booking lastBooking = bookings.get(bookings.size() - 1);
        return lastBooking.dropTime <= pickupTime;
    }

    // Allocate a booking to this taxi
    public void allocateBooking(Booking booking) {
        bookings.add(booking);
        totalEarnings += booking.amount;
        currentLocation = booking.dropPoint;
    }

    // Display taxi details
    public void displayDetails() {
        System.out.println("Taxi No: " + taxiId);
        System.out.println("Total Earnings: Rs. " + totalEarnings);
        System.out.println("BookingID\tCustomer ID\tFrom\tTo\tPickupTime\tDropTime\tAmount");
        for (Booking booking : bookings) {
            System.out.println(booking.bookingId +  "\t" + booking.customerId + "\t\t"
                    + booking.pickupPoint + "\t" + booking.dropPoint + "\t" + booking.pickupTime + "\t\t" + booking.dropTime+"\t\t" + booking.amount);
        }
        System.out.println();
    }
}
