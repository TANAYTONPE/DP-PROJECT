public class Main {
    public static void main(String[] args) {
        // The client (your app's UI layer) only interacts with the Facade.
        OrderFacade orderFacade = new OrderFacade();

        // --- Scenario 1: A simple order ---
        // User orders 1 Burger to "123 Java Lane"
        orderFacade.placeOrder("Burger", "123 Java Lane", 1);

        System.out.println("\n"); // Add a space

        // --- Scenario 2: A large pizza order ---
        // User orders 6 Pizzas to "404 Design Pattern St"
        orderFacade.placeOrder("Pizza", "404 Design Pattern St", 6);
    }
}