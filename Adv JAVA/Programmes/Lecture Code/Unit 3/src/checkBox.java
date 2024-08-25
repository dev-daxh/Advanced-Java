import java.awt.*;
import java.awt.event.*;

public class checkBox extends Frame implements ItemListener {
    private Checkbox java1, python, c, php;
    private Label resLabel;

    public checkBox() {
        // Set layout manager
        setLayout(new FlowLayout());

        // Set frame properties
        setSize(300, 300);
        setVisible(true);

        // Initialize and add components
        add(new Label("Choose Language: ")); // Add the label to the frame

        java1 = new Checkbox("Java");
        add(java1);
        
        python = new Checkbox("Python");
        add(python);
        
        c = new Checkbox("C");
        add(c);
        
        php = new Checkbox("PHP");
        add(php);

        // Initialize result label and add it to the frame
        resLabel = new Label();
        add(resLabel);

        // Add item listeners
        java1.addItemListener(this);
        python.addItemListener(this);
        c.addItemListener(this);
        php.addItemListener(this);

        // Add window listener for closing the frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Determine the state of the checkbox and update the result label accordingly
        Checkbox source = (Checkbox) e.getSource();
        String label = source.getLabel();
        String state = (e.getStateChange() == ItemEvent.SELECTED) ? "checked" : "unchecked";
        resLabel.setText(label + " Checkbox: " + state);
    }

    public static void main(String[] args) {
        new checkBox();
    }
}
