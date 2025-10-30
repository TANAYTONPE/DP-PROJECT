// Concrete Strategy 2
public class CarDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void deliver(String location) {
        System.out.println("Delivering to " + location + " by Car.");
        // Add logic for car tracking, handling larger orders, etc.
    }
}