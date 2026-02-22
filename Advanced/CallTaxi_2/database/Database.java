package database;

import java.util.HashMap;

import Models.Taxi;
import Models.Travel;

public class Database {
	
	private static HashMap<String , Travel> taxiRecords = new HashMap<String , Travel>(); 
	private static HashMap<String , Taxi> drivers = new HashMap<String , Taxi>();
	
	public static HashMap<String, Travel> getTaxiRecords() {
		return taxiRecords;
	}
	public static HashMap<String, Taxi> getDrivers() {
		return drivers;
	}
}
