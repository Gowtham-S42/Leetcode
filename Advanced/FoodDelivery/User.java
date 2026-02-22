package foodorderingsystem;

public class User {
    String phoneNumber, userName, emailAddress, address;
    boolean verified;

    User(String phoneNumber, String userName, String emailAddress, String address) {
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.verified = false;
    }
}
