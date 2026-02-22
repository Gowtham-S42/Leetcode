package service;

import java.util.HashMap;

import Models.Taxi;
import Models.Time;
import Models.Travel;
import database.Database;

public class TaxiService {
	Database db = new Database();
	HashMap<String , Taxi> drivers = db.getDrivers();
	private static int taxiId = 0;
	
	public void addTaxi(char currentLocation, Time time) {
		Taxi taxi = new Taxi(NewTaxiName(),currentLocation,time);
		drivers.put(taxi.getTaxiName(), taxi);
	}
	
	private String NewTaxiName() {
		taxiId+=1;
		return "Taxi-"+taxiId;
	}
	
	public void displayTaxi() {
	  	for(Taxi t : drivers.values()) {
			System.out.println(t.getTaxiName()+" "+t.getCurrentLocation()+" "+t.getEarning()+" "+t.getAvailableTime());
		}
	}
	public boolean verifyTime(Time time, Time currentTime) {
		if(currentTime.getHours()<=time.getHours()) {
			if (currentTime.getMinutes()<=time.getMinutes()) {
				return true;
			}
		}
		return false;
	}
	public Taxi gettaxi(char pickup, char drop, String pickupTime) {
		// TODO Auto-generated method stub
		return null;
	}
}
