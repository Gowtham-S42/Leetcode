package railwayTicketBokking_2;

import java.util.*;

public class Train {
    private String name;
    private Set<Integer> premiumSeats;
    private Set<Integer> normalSeats;
    private Map<String, List<Ticket>> bookingsByDate;
    private int premiumSurgeCounter;

    public Train(String name) {
        this.name = name;
        this.premiumSeats = new HashSet<>();
        this.normalSeats = new HashSet<>();
        this.bookingsByDate = new HashMap<>();
        this.premiumSurgeCounter = 0;

        // Initialize seats
        for (int i = 1; i <= Constants.PREMIUM_SEATS; i++) {
            premiumSeats.add(i);
        }
        for (int i = 1; i <= Constants.NORMAL_SEATS; i++) {
            normalSeats.add(i);
        }
    }

    // Book a ticket
    public Ticket bookTicket(String coachType, String source, String destination, String date) {
        if (!isValidStation(source) || !isValidStation(destination)) {
            System.out.println("Invalid source or destination.");
            return null;
        }

        int distance = Math.abs(Arrays.asList(Constants.STATIONS).indexOf(destination) - Arrays.asList(Constants.STATIONS).indexOf(source));
        if (distance == 0) {
            System.out.println("Source and destination cannot be the same.");
            return null;
        }

        if (coachType.equalsIgnoreCase("premium")) {
            if (premiumSeats.isEmpty()) {
                System.out.println("No premium seats available.");
                return null;
            }
            int seatNumber = premiumSeats.iterator().next();
            premiumSeats.remove(seatNumber);
            int price = (Constants.PREMIUM_BASE_PRICE + premiumSurgeCounter * Constants.PREMIUM_SURGE_PRICE) * distance;
            premiumSurgeCounter++;
            String bookingId = UUID.randomUUID().toString();
            Ticket ticket = new Ticket(bookingId, "Premium", seatNumber, source, destination, price, date);
            addBooking(date, ticket);
            return ticket;
        } else if (coachType.equalsIgnoreCase("normal")) {
            if (normalSeats.isEmpty()) {
                System.out.println("No normal seats available.");
                return null;
            }
            int seatNumber = normalSeats.iterator().next();
            normalSeats.remove(seatNumber);
            int price = Constants.NORMAL_PRICE * distance;
            String bookingId = UUID.randomUUID().toString();
            Ticket ticket = new Ticket(bookingId, "Normal", seatNumber, source, destination, price, date);
            addBooking(date, ticket);
            return ticket;
        } else {
            System.out.println("Invalid coach type.");
            return null;
        }
    }

    // Cancel a ticket
    public boolean cancelTicket(String bookingId, String date) {
        List<Ticket> tickets = bookingsByDate.get(date);
        if (tickets == null) {
            System.out.println("No bookings found for the given date.");
            return false;
        }

        for (Ticket ticket : tickets) {
            if (ticket.getBookingId().equals(bookingId)) {
                tickets.remove(ticket);
                if (ticket.getCoachType().equalsIgnoreCase("premium")) {
                    premiumSeats.add(ticket.getSeatNumber());
                } else {
                    normalSeats.add(ticket.getSeatNumber());
                }
                System.out.println("Ticket canceled. Refund amount: " + (ticket.getCoachType().equalsIgnoreCase("premium") ? Constants.PREMIUM_BASE_PRICE : ticket.getPrice()));
                return true;
            }
        }
        System.out.println("Booking ID not found.");
        return false;
    }

    // List all tickets for a given date
    public void listTickets(String date) {
        List<Ticket> tickets = bookingsByDate.get(date);
        if (tickets == null || tickets.isEmpty()) {
            System.out.println("No tickets found for the given date.");
            return;
        }
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    // Display total revenue grouped by date
    public void displayRevenue() {
        for (Map.Entry<String, List<Ticket>> entry : bookingsByDate.entrySet()) {
            int revenue = 0;
            for (Ticket ticket : entry.getValue()) {
                revenue += ticket.getPrice();
            }
            System.out.println("Date: " + entry.getKey() + ", Revenue: " + revenue);
        }
    }

    // Helper methods
    private boolean isValidStation(String station) {
        return Arrays.asList(Constants.STATIONS).contains(station);
    }

    private void addBooking(String date, Ticket ticket) {
        bookingsByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(ticket);
    }
}