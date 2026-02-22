package lift_system;

public class Lift {
    private String id;
    private int currentFloor;
    private int minFloor;
    private int maxFloor;
    private int capacity;
    private boolean underMaintenance;

    public Lift(String id, int minFloor, int maxFloor, int capacity) {
        this.id = id;
        this.currentFloor = 0; // initially all at 0
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.capacity = capacity;
        this.underMaintenance = false;
    }

    public String getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    public void setUnderMaintenance(boolean status) {
        this.underMaintenance = status;
        if (status) {
            this.currentFloor = -1; // mark as unavailable
        }
    }

    public boolean canServe(int source, int destination, int people) {
        if (underMaintenance) return false;
        if (people > capacity) return false;
        return source >= minFloor && destination <= maxFloor;
    }

//	@Override
//	public String toString() {
//		//return ;
//		return String.valueOf(id) +  underMaintenance ? "-1" : String.valueOf(currentFloor);
//	}

    @Override
    public String toString() {
        return id + "@" + currentFloor + (underMaintenance ? "(M)" : "");
    	//return underMaintenance ? "-1" : String.valueOf(LiftSystem.lifts +"\n"+currentFloor);
    }
}
