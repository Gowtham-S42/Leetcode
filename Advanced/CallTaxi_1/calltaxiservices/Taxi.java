package calltaxiservices;

public class Taxi {
    private int id;
    private char currentPoint;
    private int totalEarnings;
    private boolean isFree;
    private int freeTime;

    public Taxi(int id) {
        this.id = id;
        this.currentPoint = 'A';
        this.totalEarnings = 0;
        this.isFree = true;
        this.freeTime = 0;
    }

    public int getId() {
        return id;
    }

    public char getCurrentPoint() {
        return currentPoint;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public boolean isFree() {
        return isFree;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void bookTaxi(char pickupPoint, char dropPoint, int pickupTime) {
        int distance = Math.abs(dropPoint - pickupPoint) * 15;
        int fare = 100 + (distance - 5) * 10;
        this.totalEarnings += fare;
        this.currentPoint = dropPoint;
        this.isFree = false;
        this.freeTime = pickupTime + (Math.abs(dropPoint - pickupPoint));
    }

    public void freeTaxi(int currentTime) {
        if (currentTime >= freeTime) {
            this.isFree = true;
        }
    }
}