package Student;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.OutputStream;
import java.net.*;
import java.util.*;
import java.io.*;


public class AWTFrame extends Frame {

    private TextField enrollmentField;
    private TextField passwordField;

    public AWTFrame() {
        setTitle("Student Login");
        setLayout(new BorderLayout(10, 10));

        // Create login panel
        Panel loginPanel = new Panel(new GridLayout(4, 2, 20, 20));
        loginPanel.setBackground(Color.LIGHT_GRAY);

        // Add components to the login panel
        loginPanel.add(new Label("Enrollment No.:"));
        enrollmentField = new TextField();
        loginPanel.add(enrollmentField);

        loginPanel.add(new Label("Password:"));
        passwordField = new TextField();
        passwordField.setEchoChar('*');
        loginPanel.add(passwordField);

        Button loginButton = new Button("Login");
        loginPanel.add(loginButton);

        Button signupButton = new Button("Signup");
        loginPanel.add(signupButton);

        // Add login panel to frame
        add(loginPanel, BorderLayout.CENTER);

        // Set frame properties
        setSize(550, 220);
        setVisible(true);

        // Handle login button click
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enrollmentNo = enrollmentField.getText().trim();
                String password = passwordField.getText().trim();

                if (enrollmentNo.isEmpty() || password.isEmpty()) {
                    // If either field is empty, show an error dialog
                    showErrorDialog("Please enter both enrollment number and password.");
                } else {
                    // Check credentials and handle success or failure
                    boolean isValid = DatabaseUtils.validateCredentials(AWTFrame.this, enrollmentNo, password);
                    if (isValid) {
                        // Hide login frame and open main frame
                        setVisible(false);
                        new MarksheetFrame();
                    } else {
                        // Display error message for invalid credentials
                        showErrorDialog("Invalid enrollment number or password.");
                    }
                }
            }
        });

        // Handle signup button click
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open signup frame
                new SignupFrame(AWTFrame.this);
            }
        });

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void showErrorDialog(String message) {
        Dialog errorDialog = new Dialog(this, "Login Failed", true);
        errorDialog.setLayout(new FlowLayout());
        errorDialog.add(new Label(message));
        Button okButton = new Button("OK");
        errorDialog.add(okButton);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorDialog.setVisible(false);
            }
        });
        errorDialog.setSize(400, 150);
        errorDialog.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Socket sc = new Socket("localhost",8888);
        InputStream in = sc.getInputStream();
        OutputStream os  = sc.getOutputStream();

        PrintWriter pw = new PrintWriter(os,true);
        Scanner scan = new Scanner(in);


        new AWTFrame(); // Create and show the login frame
    }
}
