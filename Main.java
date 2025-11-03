// // public class Main {
// //     public static void main(String[] args) {
// //         // The client (your app's UI layer) only interacts with the Facade.
// //         OrderFacade orderFacade = new OrderFacade();

// //         // --- Scenario 1: A simple order ---
// //         // User orders 1 Burger to "123 Java Lane"
// //         orderFacade.placeOrder("Burger", "123 Java Lane", 1);

// //         System.out.println("\n"); // Add a space

// //         // --- Scenario 2: A large pizza order ---
// //         // User orders 6 Pizzas to "404 Design Pattern St"
// //         orderFacade.placeOrder("Pizza", "404 Design Pattern St", 6);
// //     }
// // }
// import java.util.Scanner;

// /**
//  * 4. Main class to run the project.
//  * Now updated to take user input from the console.
//  */
// public class Main {
//     public static void main(String[] args) {
//         // We only create our Facade and a Scanner
//         OrderFacade orderFacade = new OrderFacade();
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("Welcome to the Food Delivery App!");
        
//         while (true) {
//             System.out.println("\n--- Place a New Order ---");

//             // 1. Get food item
//             System.out.print("What would you like to order? (Pizza / Burger): ");
//             String itemType = scanner.nextLine();

//             // 2. Get location
//             System.out.print("Enter delivery location: ");
//             String location = scanner.nextLine();

//             // 3. Get quantity
//             int quantity = 1; // Default
//             try {
//                 System.out.print("Enter quantity: ");
//                 quantity = Integer.parseInt(scanner.nextLine());
//             } catch (NumberFormatException e) {
//                 System.out.println("Invalid number, defaulting to 1.");
//             }

//             // 4. Place the order
//             // We still call the same, simple Facade method!
//             orderFacade.placeOrder(itemType, location, quantity);

//             // 5. Ask to continue
//             System.out.print("\nPlace another order? (yes/no): ");
//             String continueChoice = scanner.nextLine();
//             if (!continueChoice.equalsIgnoreCase("yes")) {
//                 break; // Exit the loop
//             }
//         }

//         System.out.println("\nThank you for using the Food Delivery App!");
//         scanner.close();
//     }
// }

// // ------------------------------------------------------------------
// // (Paste all the other classes from the previous file below here)
// // e.g., interface DeliveryStrategy, class BikeDeliveryStrategy, etc.
// // ------------------------------------------------------------------
// import javax.swing.SwingUtilities;

// /**
//  * This is the new Main class.
//  * Its ONLY job is to launch the GUI application safely.
//  */
// public class Main {
//     public static void main(String[] args) {
//         // Run the GUI creation on the Event Dispatch Thread (EDT)
//         // This is the standard, safe way to start a Swing application.
//         SwingUtilities.invokeLater(new Runnable() {
//             @Override
//             public void run() {
//                 // This creates an instance of our GUI class
//                 new FoodAppGUI();
//             }
//         });
//     }
// }
/**
 * Main class to run a simple, hard-coded demo.
 * This is perfect for the presentation to show the patterns clearly.
 */
public class Main {
    public static void main(String[] args) {
        // The client (your presentation) only interacts with the Facade.
        OrderFacade orderFacade = new OrderFacade();

        // --- Scenario 1: A simple order ---
        System.out.println("=== DEMO SCENARIO 1: SMALL ORDER ===");
        // User orders 1 Burger to "123 Java Lane"
        orderFacade.placeOrder("Burger", "123 Java Lane", 1);

        System.out.println("\n"); // Add a space

        // --- Scenario 2: A large pizza order ---
        System.out.println("=== DEMO SCENARIO 2: LARGE ORDER ===");
        // User orders 6 Pizzas to "404 Design Pattern St"
        orderFacade.placeOrder("Pizza", "404 Design Pattern St", 6);
    }
}