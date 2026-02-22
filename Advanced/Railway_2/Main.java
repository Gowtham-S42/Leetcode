package railwayTicketBokking_2;

public class Main {
    public static void main(String[] args) {
        Train train = new Train("Chennai-Coimbatore Express");

        // Hardcoded bookings
        Ticket ticket1 = train.bookTicket("premium", "Chennai", "Salem", "2023-10-01");
        Ticket ticket2 = train.bookTicket("normal", "Katpadi", "Coimbatore", "2023-10-01");
        Ticket ticket3 = train.bookTicket("premium", "Salem", "Coimbatore", "2023-10-01");

        // Print all tickets for a date
        System.out.println("\nTickets for 2023-10-01:");
        train.listTickets("2023-10-01");

        // Cancel a ticket
        System.out.println("\nCanceling ticket: " + ticket2.getBookingId());
        train.cancelTicket(ticket2.getBookingId(), "2023-10-01");

        // Print tickets after cancellation
        System.out.println("\nTickets for 2023-10-01 after cancellation:");
        train.listTickets("2023-10-01");

        // Display revenue
        System.out.println("\nRevenue by date:");
        train.displayRevenue();
    }
}