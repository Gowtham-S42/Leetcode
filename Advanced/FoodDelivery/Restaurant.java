package foodorderingsystem;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    int id;
    String name, address, gstNumber;
    List<MenuItem> menu = new ArrayList<>();
    List<Review> reviews = new ArrayList<>();

    Restaurant(int id, String name, String address, String gstNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gstNumber = gstNumber;
    }
}