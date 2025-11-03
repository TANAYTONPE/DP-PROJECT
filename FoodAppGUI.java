// import javax.swing.*;       // For GUI components (JFrame, JButton, etc.)
// import java.awt.*;          // For layout (BorderLayout, GridLayout)
// import java.awt.event.*;    // For event handling (ActionListener)
// import java.io.PrintStream; // To redirect output

// /**
//  * This is the GUI class (the "View").
//  * It builds the window and holds an instance of our OrderFacade.
//  * It's public so Main.java can create it.
//  */
// public class FoodAppGUI extends JFrame {

//     // --- GUI Components ---
//     private JTextField itemField;
//     private JTextField locationField;
//     private JTextField quantityField;
//     private JButton orderButton;
//     private JTextArea logArea; // To display output

//     // --- Our Business Logic ---
//     // The GUI ONLY knows about the Facade.
//     private OrderFacade orderFacade;

//     public FoodAppGUI() {
//         // Initialize our Facade. This is the only link to the backend.
//         this.orderFacade = new OrderFacade();

//         // --- Basic Window Setup ---
//         setTitle("Food Delivery App (Design Patterns)");
//         setSize(500, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         // --- 1. Input Panel (at the top) ---
//         JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5)); // 4 rows, 2 cols
//         inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

//         inputPanel.add(new JLabel(" Item (Pizza / Burger):"));
//         itemField = new JTextField("Pizza");
//         inputPanel.add(itemField);

//         inputPanel.add(new JLabel(" Delivery Location:"));
//         locationField = new JTextField("123 Java Lane");
//         inputPanel.add(locationField);

//         inputPanel.add(new JLabel(" Quantity:"));
//         quantityField = new JTextField("1");
//         inputPanel.add(quantityField);

//         // Add a placeholder and the button
//         inputPanel.add(new JLabel()); // Empty cell
//         orderButton = new JButton("Place Order");
//         inputPanel.add(orderButton);

//         add(inputPanel, BorderLayout.NORTH);

//         // --- 2. Log Area (in the center) ---
//         logArea = new JTextArea();
//         logArea.setEditable(false);
//         logArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Set a nice font
//         JScrollPane scrollPane = new JScrollPane(logArea); // Make it scrollable
//         add(scrollPane, BorderLayout.CENTER);

//         // --- 3. Redirect Console Output to the Log Area ---
//         // This helper class will catch all System.out.println() calls
//         // and send them to our logArea JTextArea.
//         PrintStream printStream = new PrintStream(new TextAreaOutputStream(logArea));
//         System.setOut(printStream);
//         System.setErr(printStream);

//         // --- 4. Add the Button's "Click" Action ---
//         orderButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 // This is the "Controller" part of our app.
//                 handlePlaceOrder();
//             }
//         });

//         // Make the window visible
//         setVisible(true);
//         System.out.println("GUI Initialized. Waiting for order...");
//     }

//     /**
//      * This method is called when the "Place Order" button is clicked.
//      */
//     private void handlePlaceOrder() {
//         try {
//             // 1. Get user input from the text fields
//             String itemType = itemField.getText();
//             String location = locationField.getText();
//             int quantity = Integer.parseInt(quantityField.getText());

//             // 2. CALL THE FACADE!
//             // This is the beautiful part. The GUI doesn't know
//             // what happens inside. It just calls one simple method.
//             orderFacade.placeOrder(itemType, location, quantity);

//         } catch (NumberFormatException ex) {
//             // Handle if the user types "two" instead of "2"
//             System.out.println("ERROR: Quantity must be a valid number.");
//         } catch (Exception ex) {
//             // Handle any other errors
//             System.out.println("ERROR: " + ex.getMessage());
//         }
//     }
// }