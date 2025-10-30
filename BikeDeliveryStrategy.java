// Concrete Strategy 1
public class BikeDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void deliver(String location) {
        System.out.println("Delivering to " + location + " by Bike.");
        // Add logic for bike tracking, time estimation, etc.
    }
}