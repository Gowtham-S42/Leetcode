package foodorderingsystem;
import java.util.*;

public class FoodOrderingSystem {
    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static List<Restaurant> restaurants = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static int orderCounter = 1, restaurantCounter = 1;

    public static void main(String[] args) {
        System.out.println("=== Welcome to Food Ordering System ===");
        while (true) {
            System.out.println("\n1. Register User\n2. Register Restaurant\n3. Add Menu Item\n4. Place Order\n5. Track Order\n6. Add Review\n7. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: registerUser(); break;
                case 2: registerRestaurant(); break;
                case 3: addMenuItem(); break;
                case 4: placeOrder(); break;
                case 5: trackOrder(); break;
                case 6: addReview(); break;
                case 7: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void registerUser() {
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Address: ");
        String addr = sc.nextLine();

        User u = new User(phone, name, email, addr);
        u.verified = true; // simulate OTP verification
        users.add(u);
        System.out.println("User registered successfully!");
    }

    static void registerRestaurant() {
        System.out.print("Enter Restaurant Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Address: ");
        String addr = sc.nextLine();
        System.out.print("Enter GST Number: ");
        String gst = sc.nextLine();

        Restaurant r = new Restaurant(restaurantCounter++, name, addr, gst);
        restaurants.add(r);
        System.out.println("Restaurant registered successfully!");
    }

    static void addMenuItem() {
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants registered!");
            return;
        }
        System.out.println("Select Restaurant ID:");
        for (Restaurant r : restaurants) {
            System.out.println(r.id + ". " + r.name);
        }
        int rid = sc.nextInt(); sc.nextLine();

        Restaurant selected = null;
        for (Restaurant r : restaurants) {
            if (r.id == rid) {
                selected = r;
                break;
            }
        }
        if (selected == null) {
            System.out.println("Invalid restaurant!");
            return;
        }

        System.out.print("Enter Item Name: ");
        String itemName = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble(); sc.nextLine();

        selected.menu.add(new MenuItem(itemName, price, true));
        System.out.println("Menu item added successfully!");
    }

    static void placeOrder() {
        if (users.isEmpty() || restaurants.isEmpty()) {
            System.out.println("Register user and restaurant first!");
            return;
        }
        User u = users.get(0); // simple: first user
        System.out.println("Select Restaurant ID:");
        for (Restaurant r : restaurants) {
            System.out.println(r.id + ". " + r.name);
        }
        int rid = sc.nextInt(); sc.nextLine();

        Restaurant selected = null;
        for (Restaurant r : restaurants) {
            if (r.id == rid) {
                selected = r;
                break;
            }
        }
        if (selected == null || selected.menu.isEmpty()) {
            System.out.println("Invalid restaurant or empty menu!");
            return;
        }

        System.out.println("Menu:");
        for (int i = 0; i < selected.menu.size(); i++) {
            MenuItem item = selected.menu.get(i);
            System.out.println((i+1) + ". " + item.name + " - Rs." + item.price);
        }

        System.out.print("Select item number: ");
        int itemChoice = sc.nextInt(); sc.nextLine();
        List<MenuItem> selectedItems = new ArrayList<>();
        selectedItems.add(selected.menu.get(itemChoice-1));

        Order o = new Order(orderCounter++, u, selected, selectedItems);
        orders.add(o);
        System.out.println("Order placed successfully! Order ID: " + o.id);
    }

    static void trackOrder() {
        System.out.print("Enter Order ID: ");
        int id = sc.nextInt(); sc.nextLine();
        for (Order o : orders) {
            if (o.id == id) {
                System.out.println("Order Status: " + o.status);
                return;
            }
        }
        System.out.println("Order not found!");
    }

    static void addReview() {
        if (users.isEmpty() || restaurants.isEmpty()) {
            System.out.println("Register user and restaurant first!");
            return;
        }
        User u = users.get(0);
        System.out.println("Select Restaurant ID:");
        for (Restaurant r : restaurants) {
            System.out.println(r.id + ". " + r.name);
        }
        int rid = sc.nextInt(); sc.nextLine();

        Restaurant selected = null;
        for (Restaurant r : restaurants) {
            if (r.id == rid) {
                selected = r;
                break;
            }
        }
        if (selected == null) {
            System.out.println("Invalid restaurant!");
            return;
        }

        System.out.print("Enter rating (1-5): ");
        int rating = sc.nextInt(); sc.nextLine();
        System.out.print("Enter comment: ");
        String comment = sc.nextLine();

        Review rev = new Review(u, rating, comment);
        selected.reviews.add(rev);
        System.out.println("Review added successfully!");
    }
}