// Subsystem 1: Handles payments
class PaymentSystem {
    public boolean processPayment(double amount) {
        // Logic to process payment via a gateway
        System.out.println("Processing payment of $" + amount);
        return true; // Assume payment is always successful
    }
}

// Subsystem 2: Handles kitchen/restaurant comms
class RestaurantSystem {
    public void prepareOrder(FoodItem item) {
        // Logic to send order to the restaurant's kitchen
        System.out.println("Kitchen is preparing: " + item.getName());
    }
}

// Subsystem 3: Handles delivery assignment (using our Strategy)
class DeliverySystem {
    public void assignDelivery(String location, DeliveryStrategy strategy) {
        // Logic to find a delivery partner and assign the task
        System.out.println("Assigning delivery partner...");
        strategy.deliver(location); // Execute the chosen strategy
    }
}
// The Facade class
public class OrderFacade {
    // The Facade holds references to all complex subsystems
    private FoodFactory factory;
    private PaymentSystem paymentSystem;
    private RestaurantSystem restaurantSystem;
    private DeliverySystem deliverySystem;

    public OrderFacade() {
        // Initialize all subsystems
        this.factory = new FoodFactory();
        this.paymentSystem = new PaymentSystem();
        this.restaurantSystem = new RestaurantSystem();
        this.deliverySystem = new DeliverySystem();
    }

    /**
     * The simplified method for the client (the user) to call.
     * This method hides all the complex interactions between subsystems.
     */
    public void placeOrder(String itemType, String deliveryLocation, int quantity) {
        System.out.println("--- New Order Received ---");

        // 1. Factory: Create the food item
        FoodItem item = factory.createFoodItem(itemType);
        if (item == null) {
            System.out.println("Sorry, we don't serve that item.");
            return;
        }
        System.out.println("Item created: " + item.getName());

        // 2. Facade Logic: Handle payment
        double totalAmount = item.getPrice() * quantity;
        boolean paymentSuccessful = paymentSystem.processPayment(totalAmount);
        
        if (!paymentSuccessful) {
            System.out.println("Payment Failed. Order cancelled.");
            return;
        }

        // 3. Facade Logic: Send to kitchen
        restaurantSystem.prepareOrder(item);

        // 4. Strategy: Choose a delivery method
        DeliveryStrategy strategy;
        if (quantity > 5 || totalAmount > 50) {
            // Use a car for large/expensive orders
            strategy = new CarDeliveryStrategy();
        } else {
            // Use a bike for small orders
            strategy = new BikeDeliveryStrategy();
        }
        
        // 5. Facade Logic: Assign delivery
        deliverySystem.assignDelivery(deliveryLocation, strategy);

        System.out.println("--- Order Completed Successfully ---");
    }
}