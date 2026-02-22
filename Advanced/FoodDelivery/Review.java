package foodorderingsystem;

public class Review {
    User user;
    int rating;
    String comment;

    Review(User user, int rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }
}