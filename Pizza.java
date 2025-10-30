// Concrete Product 1
public class Pizza implements FoodItem {
    @Override
    public String getName() {
        return "Margherita Pizza";
    }
    @Override
    public double getPrice() {
        return 12.99;
    }
}