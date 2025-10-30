import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 * Helper utility class to redirect console output (System.out) 
 * to a JTextArea component.
 * It's public so FoodAppGUI.java can create it.
 */
public class TextAreaOutputStream extends OutputStream {
    
    private JTextArea textArea;

    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * This method is called when System.out.print() or println() is used.
     * It writes the character to the JTextArea.
     */
    @Override
    public void write(int b) throws IOException {
        // Appends the character (as a string) to the text area
        textArea.append(String.valueOf((char) b));
        
        // Ensure the text area auto-scrolls to the bottom
        // so the user always sees the latest log message.
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}