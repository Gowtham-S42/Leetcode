package railway_1;

public class Passenger {
    private String name;
    private int age;
    private String gender;
    private String berthPreference;
    private String status; // Confirmed, RAC, Waiting, or Not Booked
    private int seatNumber;

    public Passenger(String name, int age, String gender, String berthPreference) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.status = "Not Booked";
        this.seatNumber = -1;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Berth Preference: " + berthPreference +
                ", Status: " + status + ", Seat Number: " + seatNumber;
    }
}