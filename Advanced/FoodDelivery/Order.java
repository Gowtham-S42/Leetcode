package foodorderingsystem;

import java.util.List;

public class Order {
    int id;
    User user;
    Restaurant restaurant;
    List<MenuItem> items;
    String status;

    Order(int id, User user, Restaurant restaurant, List<MenuItem> items) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.status = "PLACED";
    }
}
