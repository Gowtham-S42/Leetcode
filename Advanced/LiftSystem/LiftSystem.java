package lift_system;

import java.util.*;

public class LiftSystem {
    private List<Lift> lifts;

    public LiftSystem() {
        lifts = new ArrayList<>();
        // L1 & L2 for 0–5
        lifts.add(new Lift("L1", 0, 5, 5));
        lifts.add(new Lift("L2", 0, 5, 5));
        // L3 & L4 for 6–10
        lifts.add(new Lift("L3", 6, 10, 8));
        lifts.add(new Lift("L4", 6, 10, 8));
        // L5 for 0–10
        lifts.add(new Lift("L5", 0, 10, 10));
    }

    public void displayLiftPositions() {
        for (Lift lift : lifts) {
            System.out.print(lift + "  ");
        }
        System.out.println();
    }

    public void assignLift(int source, int destination, int people) {
        Lift best = null;
        int bestDistance = Integer.MAX_VALUE;
        int bestStops = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            if (!lift.canServe(source, destination, people)) continue;

            int distance = Math.abs(lift.getCurrentFloor() - source);
            int stops = Math.abs(lift.getCurrentFloor() - source) + Math.abs(source - destination);

            // Rule 4: direction preference if tie
            boolean directionMatch = 
                (destination > source && lift.getCurrentFloor() <= source) || 
                (destination < source && lift.getCurrentFloor() >= source);

            if (distance < bestDistance ||
                (distance == bestDistance && directionMatch) ||
                (distance == bestDistance && stops < bestStops)) {
                best = lift;
                bestDistance = distance;
                bestStops = stops;
            }
        }

        if (best != null) {
            System.out.println(best.getId() + " is assigned");
            best.setCurrentFloor(destination);
        } else {
            System.out.println("No lift available for this request.");
        }
    }

    public void setLiftUnderMaintenance(String liftId) {
        for (Lift lift : lifts) {
            if (lift.getId().equalsIgnoreCase(liftId)) {
                lift.setUnderMaintenance(true);
                System.out.println(liftId + " is now under maintenance.");
                return;
            }
        }
        System.out.println("Lift ID not found.");
    }
}
