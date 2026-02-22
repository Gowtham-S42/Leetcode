package calltaxi;

import java.util.Scanner;

import Models.Taxi;
import Models.Time;
import service.TaxiService;

public class main {
	public static void main(String[]args) {
		TaxiService taxiservice = new TaxiService();
		Time time = new Time(9,0);
		Scanner get = new Scanner(System.in);
		
		for(int i=0;i<5;i++)
		taxiservice.addTaxi('A',time);
		
		taxiservice.displayTaxi();
		char choice;
		while(true) {
			System.out.println("is there any customer?(y or n)");
			choice = get.nextLine().charAt(0);
			if(choice == 'y') {
				System.out.println("Enter pickup location:");
				char pickup = get.nextLine().charAt(0);
				System.out.println("Enter destination location:");
				char drop = get.nextLine().charAt(0);
				System.out.println("Enter pickup time: ");
				String pickupTime = get.nextLine();
				if(taxiservice.verifyTime(new Time(pickupTime),time)) {
				}
				Taxi taxi = taxiservice.gettaxi(pickup,drop,pickupTime);
				if(taxi !=null) {
					taxiservice.gettaxi(pickup,drop,pickupTime);
				}
				else {
					System.out.println("taxi ila po da");
				}
			}
			else if (choice == 'n'){
				break;
			}
			else {
				System.out.println("dont type un necessary");
			}
		}
	}
}
// TAxi table
//CREATE TABLE Taxis (
//	    taxi_id INT PRIMARY KEY,
//	    status VARCHAR(10) DEFAULT 'free',  -- 'free' or 'busy'
//	    current_location CHAR(1) DEFAULT 'A',  -- Location (A, B, C, D, E, F)
//	    total_earnings INT DEFAULT 0
//	);


// Bookings table
//CREATE TABLE Bookings (
//	    booking_id INT PRIMARY KEY AUTO_INCREMENT,
//	    customer_id INT,
//	    pickup_point CHAR(1),
//	    drop_point CHAR(1),
//	    pickup_time INT,
//	    drop_time INT,
//	    taxi_id INT,
//	    amount INT,
//	    FOREIGN KEY (taxi_id) REFERENCES Taxis(taxi_id)
//	);


//Booking history table
//CREATE TABLE BookingHistory (
//	    booking_id INT PRIMARY KEY,
//	    customer_id INT,
//	    taxi_id INT,
//	    pickup_point CHAR(1),
//	    drop_point CHAR(1),
//	    pickup_time INT,
//	    drop_time INT,
//	    amount INT,
//	    FOREIGN KEY (taxi_id) REFERENCES Taxis(taxi_id)
//	);

//1. Database Design
//We'll have three primary tables to manage the data:
//
//Taxis: This table will hold information about the taxis, their status (free/busy), and their total earnings.
//Bookings: This table will store the booking details, including the customer, pickup/drop points, taxi allocated, and the cost of the trip.
//BookingHistory: This table stores historical records of completed trips with detailed information on the time of trip, and earnings.
//
