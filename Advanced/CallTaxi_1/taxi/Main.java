 package taxi;

 public class Main {
	    public static void main(String[] args) {
	        // Initialize the system with 4 taxis
	        TaxiBookingSystem system = new TaxiBookingSystem(4);

	        // Bookings
	        system.bookTaxi(1, 'A', 'B', 25);
	        system.bookTaxi(2, 'B', 'D', 9);
	        system.bookTaxi(3, 'B', 'C', 12);
	        system.bookTaxi(4, 'B', 'A', 11);
	       

	        // Display taxi details
	        system.displayTaxiDetails("Taxi-1");
	        system.displayTaxiDetails("Taxi-2");
	        
	    }
	}                                 