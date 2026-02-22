package foodorderingsystem;

public class MenuItem {
    String name;
    double price;
    boolean available;

    MenuItem(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }
}
