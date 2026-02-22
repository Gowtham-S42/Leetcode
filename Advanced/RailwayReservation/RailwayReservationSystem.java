package railway_1;

import java.util.*;

public class RailwayReservationSystem {
    private static final int TOTAL_CONFIRMED_BERTHS = 3;
    private static final int TOTAL_RAC_BERTHS = 2; 
    private static final int TOTAL_WAITING_LIST = 1;

    private List<Passenger> confirmedTickets = new ArrayList<>();
    private List<Passenger> racTickets = new ArrayList<>();
    private List<Passenger> waitingList = new ArrayList<>();
    private List<Integer> availableLowerBerths = new ArrayList<>();
    private List<Integer> availableMiddleBerths = new ArrayList<>();
    private List<Integer> availableUpperBerths = new ArrayList<>();
    private List<Integer> availableSideLowerBerths = new ArrayList<>();
    private List<Integer> availableSideUpperBerths = new ArrayList<>();

    public RailwayReservationSystem() {
        
        for (int i = 1; i <= TOTAL_CONFIRMED_BERTHS; i++) {
            if (i <= 1) availableLowerBerths.add(i);
            else if (i <= 2) availableMiddleBerths.add(i);
            else if (i <= 3) availableUpperBerths.add(i);
        }
        for (int i = 1; i <= TOTAL_RAC_BERTHS; i++) {
            availableSideLowerBerths.add(i);
        }
    }

 
    public void bookTicket(Passenger passenger) {
        if (passenger.getAge() < 5) {
            System.out.println("Ticket not allocated for children below age 5.");
            return;
        }

        if (confirmedTickets.size() < TOTAL_CONFIRMED_BERTHS) {
            assignBerth(passenger, confirmedTickets, availableLowerBerths, availableMiddleBerths, availableUpperBerths);
            System.out.println("Ticket booked successfully. Status: Confirmed");
        } else if (racTickets.size() < TOTAL_RAC_BERTHS) {
            assignBerth(passenger, racTickets, availableSideLowerBerths, availableSideLowerBerths, availableSideLowerBerths);
            System.out.println("Ticket booked successfully. Status: RAC");
        } else if (waitingList.size() < TOTAL_WAITING_LIST) {
            passenger.setStatus("Waiting");
            waitingList.add(passenger);
            System.out.println("Ticket booked successfully. Status: Waiting");
        } else {
            System.out.println("Bus la poda .");
        }
    }

    private void assignBerth(Passenger passenger, List<Passenger> confirmedTickets, List<Integer> availableLowerBerths, List<Integer> availableMiddleBerths, List<Integer> availableUpperBerths) {
        String preference = passenger.getBerthPreference();
        if (passenger.getAge() > 60 || (passenger.getGender().equalsIgnoreCase("F") && passenger.getAge() < 5)) {
            preference = "Lower";
        }

        if (preference.equalsIgnoreCase("Lower") && !availableLowerBerths.isEmpty()) {
            passenger.setSeatNumber(availableLowerBerths.remove(0));
        } else if (preference.equalsIgnoreCase("Middle") && !availableMiddleBerths.isEmpty()) {
            passenger.setSeatNumber(availableMiddleBerths.remove(0));
        } else if (preference.equalsIgnoreCase("Upper") && !availableUpperBerths.isEmpty()) {
            passenger.setSeatNumber(availableUpperBerths.remove(0));
        } else if (!availableLowerBerths.isEmpty()) {
            passenger.setSeatNumber(availableSideLowerBerths.remove(0));
        } else if (!availableMiddleBerths.isEmpty()) {
            passenger.setSeatNumber(availableMiddleBerths.remove(0));
        } else if (!availableUpperBerths.isEmpty()) {
            passenger.setSeatNumber(availableUpperBerths.remove(0));
        }

        passenger.setStatus("Confirmed");
        confirmedTickets.add(passenger);
    }

    
    public void cancelTicket(int seatNumber) {
        Passenger passengerToRemove = null;
        for (Passenger passenger : confirmedTickets) {
            if (passenger.getSeatNumber() == seatNumber) {
                passengerToRemove = passenger;
                break;
            }
        }

        if (passengerToRemove != null) {
            confirmedTickets.remove(passengerToRemove);
            System.out.println("Ticket canceled successfully.");

            if (!racTickets.isEmpty()) {
                Passenger racPassenger = racTickets.remove(0);
                confirmedTickets.add(racPassenger);
                racPassenger.setStatus("Confirmed");
                System.out.println("RAC ticket moved to confirmed.");

                if (!waitingList.isEmpty()) {
                    Passenger waitingPassenger = waitingList.remove(0);
                    racTickets.add(waitingPassenger);
                    waitingPassenger.setStatus("RAC");
                    System.out.println("Waiting list ticket moved to RAC.");
                }
            }
        } else {
            System.out.println("Ticket not found.");
        }
    }

    public void printBookedTickets() {
        System.out.println("Booked Tickets:");
        for (Passenger passenger : confirmedTickets) {
            System.out.println(passenger);
        }
        System.out.println("Total booked tickets: " + confirmedTickets.size());
    }

    
    public void printAvailableTickets() {
        System.out.println("Available Lower Berths: " + availableLowerBerths.size());
        System.out.println("Available Middle Berths: " + availableMiddleBerths.size());
        System.out.println("Available Upper Berths: " + availableUpperBerths.size());
        System.out.println("Available Side Lower Berths: " + availableSideLowerBerths.size());
        System.out.println("Available Side Upper Berths: " + availableSideUpperBerths.size());
        System.out.println("Total available tickets: " + (availableLowerBerths.size() + availableMiddleBerths.size() + availableUpperBerths.size() + availableSideLowerBerths.size() + availableSideUpperBerths.size()));
    }
}
