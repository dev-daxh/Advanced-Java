import java.awt.*;
import java.awt.event.*;

public class CalAwt extends Frame implements ActionListener {

    // Declare variables outside the constructor
    private TextField tfFirst;
    private TextField tfSecond;
    private TextField tfResult;
    private Button add;
    private Button sub;
    private Button mul;
    private Button resButton;

    public CalAwt() {
        setTitle("My Calculator");
        setSize(1000, 500);
        setLayout(new GridLayout(2, 1));

        // Create and configure panels
        Panel ippanel = new Panel();
        ippanel.setLayout(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns

        // Initialize and add components to the input panel
        Label fNumber = new Label("First Number:");
        tfFirst = new TextField("0");
        tfFirst.setEditable(true);
        ippanel.add(fNumber);
        ippanel.add(tfFirst);

        Label sNumber = new Label("Second Number:");
        tfSecond = new TextField("0");
        tfSecond.setEditable(true);
        ippanel.add(sNumber);
        ippanel.add(tfSecond);

        Label result = new Label("Result:");
        tfResult = new TextField("0");
        tfResult.setEditable(false);
        ippanel.add(result);
        ippanel.add(tfResult);

        Panel btnpanel = new Panel();
        btnpanel.setLayout(new GridLayout(1, 4, 10, 10));

        // Initialize and add buttons to the button panel
        add = new Button("Add");
        btnpanel.add(add);

        sub = new Button("Sub");
        btnpanel.add(sub);

        mul = new Button("Mul");
        btnpanel.add(mul);

        resButton = new Button("Reset");
        btnpanel.add(resButton);

        // Add panels to the frame
        add(ippanel);
        add(btnpanel);

        // Add action listeners to buttons
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        resButton.addActionListener(this);

        // Make the frame visible
        setVisible(true);
    }

    // Implement the actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source of the event
        Object source = e.getSource();

        try {
            // Parse input values
            double num1 = Double.parseDouble(tfFirst.getText());
            double num2 = Double.parseDouble(tfSecond.getText());

            // Perform actions based on which button was clicked
            if (source == add) {
                double result = num1 + num2;
                tfResult.setText(result+"");
            } else if (source == sub) {
                double result = num1 - num2;
                tfResult.setText(String.valueOf(result));
            } else if (source == mul) {
                double result = num1 * num2;
                tfResult.setText(String.valueOf(result));
            } else if (source == resButton) {
                // Reset the fields
                tfFirst.setText("0");
                tfSecond.setText("0");
                tfResult.setText("0");
            }
        } catch (NumberFormatException ex) {
            tfResult.setText("Error");
        }
    }

    public static void main(String[] args) {
        new CalAwt();
    }
}

