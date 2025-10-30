// The Factory class
public class FoodFactory {
    // The "Factory Method"
    public FoodItem createFoodItem(String itemType) {
        if ("Pizza".equalsIgnoreCase(itemType)) {
            return new Pizza();
        } else if ("Burger".equalsIgnoreCase(itemType)) {
            return new Burger();
        }
        // Return a default or throw an exception
        return null; 
    }
}