package taxi;

public class Booking{
    int bookingId;
    int customerId;
    char pickupPoint;
    char dropPoint;
    int pickupTime;
    int dropTime;
    int amount;

    public Booking(int bookingId, int customerId, char pickupPoint, char dropPoint, int pickupTime) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.dropTime = calculateDropTime();
        this.amount = calculateFare();
    }

    // Calculate drop time based on distance
    private int calculateDropTime() {
        int distance = Math.abs(dropPoint - pickupPoint) * 15; // Each point is 15 km apart
        int travelTime = (distance / 15) * 60; // 60 minutes per 15 km
        return pickupTime + (travelTime / 60);
    }

    // Calculate fare based on distance
    private int calculateFare() {
        int distance = Math.abs(dropPoint - pickupPoint) * 15;
        if (distance <= 5) {
            return 100;
        } else {
            return 100 + (distance - 5) * 10;
        }
    }
}
