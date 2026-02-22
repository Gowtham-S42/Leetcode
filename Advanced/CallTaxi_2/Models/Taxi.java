package Models;

public class Taxi {
	private String taxiName;
	
	public String getTaxiName() {
		return taxiName;
	}

	public char getCurrentLocation() {
		return currentLocation;
	}

	public Time getAvailableTime() {
		return availableTime;
	}

	public int getEarning() {
		return earning;
	}

	private char currentLocation;
	
	private Time availableTime;
	
	private int earning;
	
	public Taxi(String taxiName, char currentLocation, Time availableTime) {
		this.taxiName = taxiName;
		this.currentLocation = currentLocation;
		this.availableTime = availableTime;
		this.earning = 0;
	}
}
