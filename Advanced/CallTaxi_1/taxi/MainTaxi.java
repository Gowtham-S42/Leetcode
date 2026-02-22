//package taxi;
//
//import java.util.*;
//
////Taxi class to represent a taxi
//class Taxi {
// String taxiId;
// char currentLocation;
// int totalEarnings;
// List<Booking> bookings;
//
// public Taxi(String taxiId) {
//     this.taxiId = taxiId;
//     this.currentLocation = 'A'; // All taxis start at point A
//     this.totalEarnings = 0;
//     this.bookings = new ArrayList<>();
// }
//
// // Check if the taxi is free at a given time
// public boolean isFree(int pickupTime) {
//     if (bookings.isEmpty()) {
//         return true;
//     }
//     Booking lastBooking = bookings.get(bookings.size() - 1);
//     return lastBooking.dropTime <= pickupTime;
// }
//
// // Allocate a booking to this taxi
// public void allocateBooking(Booking booking) {
//     bookings.add(booking);
//     totalEarnings += booking.amount;
//     currentLocation = booking.dropPoint;
// }
//
// // Display taxi details
// public void displayDetails() {
//     System.out.println("Taxi No: " + taxiId);
//     System.out.println("Total Earnings: Rs. " + totalEarnings);
//     System.out.println("BookingID\tAmount\tCustomer ID\tFrom\tTo\tPickupTime\tDropTime");
//     for (Booking booking : bookings) {
//         System.out.println(booking.bookingId + "\t\t" + booking.amount + "\t" + booking.customerId + "\t\t"
//                 + booking.pickupPoint + "\t" + booking.dropPoint + "\t" + booking.pickupTime + "\t\t" + booking.dropTime);
//     }
//     System.out.println();
// }
//}
//
////Booking class to represent a booking
//class Booking {
// int bookingId;
// int customerId;
// char pickupPoint;
// char dropPoint;
// int pickupTime;
// int dropTime;
// int amount;
//
// public Booking(int bookingId, int customerId, char pickupPoint, char dropPoint, int pickupTime) {
//     this.bookingId = bookingId;
//     this.customerId = customerId;
//     this.pickupPoint = pickupPoint;
//     this.dropPoint = dropPoint;
//     this.pickupTime = pickupTime;
//     this.dropTime = calculateDropTime();
//     this.amount = calculateFare();
// }
//
// // Calculate drop time based on distance
// private int calculateDropTime() {
//     int distance = Math.abs(dropPoint - pickupPoint) * 15; // Each point is 15 km apart
//     int travelTime = (distance / 15) * 60; // 60 minutes per 15 km
//     return pickupTime + (travelTime / 60);
// }
//
// // Calculate fare based on distance
// private int calculateFare() {
//     int distance = Math.abs(dropPoint - pickupPoint) * 15;
//     if (distance <= 5) {
//         return 100;
//     } else {
//         return 100 + (distance - 5) * 10;
//     }
// }
//}
//
////TaxiBookingSystem class to manage taxis and bookings
//class TaxiBookingSystem {
// List<Taxi> taxis;
// int bookingIdCounter;
//
// public TaxiBookingSystem(int numTaxis) {
//     taxis = new ArrayList<>();
//     for (int i = 1; i <= numTaxis; i++) {
//         taxis.add(new Taxi("Taxi-" + i));
//     }
//     bookingIdCounter = 1;
// }
//
// // Find the nearest available taxi
// private Taxi findNearestTaxi(char pickupPoint, int pickupTime) {
//     List<Taxi> freeTaxis = new ArrayList<>();
//     for (Taxi taxi : taxis) {
//         if (taxi.isFree(pickupTime)) {
//             freeTaxis.add(taxi);
//         }
//     }
//
//     if (freeTaxis.isEmpty()) {
//         return null; // No free taxis
//     }
//
//     // Find the taxi with the nearest location
//     Taxi nearestTaxi = freeTaxis.get(0);
//     int minDistance = Math.abs(nearestTaxi.currentLocation - pickupPoint);
//
//     for (Taxi taxi : freeTaxis) {
//         int distance = Math.abs(taxi.currentLocation - pickupPoint);
//         if (distance < minDistance) {
//             nearestTaxi = taxi;
//             minDistance = distance;
//         } else if (distance == minDistance && taxi.totalEarnings < nearestTaxi.totalEarnings) {
//             nearestTaxi = taxi; // Prefer taxi with lower earnings
//         }
//     }
//
//     return nearestTaxi;
// }
//
// // Book a taxi for a customer
// public void bookTaxi(int customerId, char pickupPoint, char dropPoint, int pickupTime) {
//     Taxi taxi = findNearestTaxi(pickupPoint, pickupTime);
//     if (taxi == null) {
//         System.out.println("Booking rejected. No taxi available.");
//         return;
//     }
//
//     Booking booking = new Booking(bookingIdCounter++, customerId, pickupPoint, dropPoint, pickupTime);
//     taxi.allocateBooking(booking);
//
//     System.out.println("Taxi can be allotted. " + taxi.taxiId + " is allotted.");
// }
//
// // Display details of a specific taxi
// public void displayTaxiDetails(String taxiId) {
//     for (Taxi taxi : taxis) {
//         if (taxi.taxiId.equals(taxiId)) {
//             taxi.displayDetails();
//             return;
//         }
//     }
//     System.out.println("Taxi not found.");
// }
//}
//
////Main class to test the application
//public class MainTaxi {
// public static void main(String[] args) {
//     // Initialize the system with 4 taxis
//     TaxiBookingSystem system = new TaxiBookingSystem(4);
//
//     // Bookings
//     system.bookTaxi(1, 'A', 'B', 9);
//     system.bookTaxi(2, 'B', 'D', 9);
//     system.bookTaxi(3, 'B', 'C', 12);
//
//     // Display taxi details
//     system.displayTaxiDetails("Taxi-1");
//     system.displayTaxiDetails("Taxi-2");
// }
//}