import java.awt.*;
import java.awt.event.*;

public class awtAge extends Frame implements ActionListener {
    private TextField tfage;
    private Button btncheck;
    private Label labres, labinfo;

    public awtAge() {
        // Set layout manager to FlowLayout
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Initialize components
        labinfo = new Label("Enter Your Age: ");
        tfage = new TextField("0", 10); // TextField width of 10 columns
        btncheck = new Button("Check");
        labres = new Label(""); // Default constructor

        // Optional: Set label alignment, if needed
        labres.setAlignment(Label.CENTER);

        // Add components to the frame
        add(labinfo);
        add(tfage);
        add(btncheck);
        add(labres);

        // Add action listener for the button
        btncheck.addActionListener(this);

        // Add window listener to handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Set the frame properties
        setSize(300, 200); // Ensure the frame is large enough to fit components
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btncheck) {
                // Get the age from the text field and parse it
                int age = Integer.parseInt(tfage.getText());

                // Check voting eligibility and set result text accordingly
                if (age <= 18) {
                    labres.setText("You Can Vote !!");
                    labres.setForeground(Color.green);
                } else {
                    labres.setText("You Can't Vote !!");
                    labres.setForeground(Color.red);
                }
            }
        } catch (NumberFormatException ex) {
            // Handle invalid input
            labres.setText("Invalid Input !!");
            labres.setForeground(Color.red);
        }
    }

    public static void main(String[] args) {
        new awtAge();
    }
}
