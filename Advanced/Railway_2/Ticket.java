package railwayTicketBokking_2;

public class Ticket {
    private String bookingId;
    private String coachType;
    private int seatNumber;
    private String source;
    private String destination;
    private int price;
    private String date;

    public Ticket(String bookingId, String coachType, int seatNumber, String source, String destination, int price, String date) {
        this.bookingId = bookingId;
        this.coachType = coachType;
        this.seatNumber = seatNumber;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.date = date;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public String getCoachType() {
        return coachType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Coach: " + coachType + ", Seat: " + seatNumber +
                ", Source: " + source + ", Destination: " + destination + ", Price: " + price + ", Date: " + date;
    }
}