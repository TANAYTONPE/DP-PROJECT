// Concrete Product 2
public class Burger implements FoodItem {
    @Override
    public String getName() {
        return "Classic Cheeseburger";
    }
    @Override
    public double getPrice() {
        return 8.99;
    }
}