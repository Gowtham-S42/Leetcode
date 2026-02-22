package Models;

public class Travel {
	private final int customerId;
	
	private final char startingPoint;
	
	private final char destinationPoint;
	
	private final String startTime;
	
	private final String endTime;
	
	private final int wages;
	
	public Travel(int customerId,char startingPoint,char destinationPoint,String startTime,String endTime,int wages) {
		this.customerId = customerId;
		this.startingPoint = startingPoint;
		this.destinationPoint = destinationPoint;
		this.startTime = startTime;
		this.endTime = endTime;
		this.wages = wages;
	}
	public String toString() {
		return customerId+" "+startingPoint+" "+destinationPoint+" "+startingPoint+" "+endTime+" "+wages;
	}
}
