package Models;

public class Time {
	private int Hours;

	private int Minutes;
	
	public Time(int hours,int minutes) {
		this.Hours=hours;
		this.Minutes=minutes;
	}
	
	public Time(String pickupTime) {
		String[] arr=pickupTime.split(":");
		this.Hours = Integer.parseInt(arr[0]);
		this.Minutes = Integer.parseInt(arr[1]);
	}

	

	public int getHours() {
		return Hours;
	}

	public int getMinutes() {
		return Minutes;
	}
	
	public String toString() {
		return this.Hours+":"+this.Minutes;
	}
}
