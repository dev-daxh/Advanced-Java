package Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SignupFrame extends Frame {

    private TextField signupEnrollmentField;
    private TextField signupNameField;
    private Choice branchChoice;
    private Choice semesterChoice;
    private TextField passwordField;

    private Frame parentFrame;

    public SignupFrame(Frame parent) {
        this.parentFrame = parent; // Store the parent frame
        setTitle("Student Signup");
        setLayout(new BorderLayout(10, 10));

        // Create signup panel
        Panel signupPanel = new Panel(new GridLayout(6, 2, 10, 10));
        signupPanel.setBackground(Color.LIGHT_GRAY);

        signupPanel.add(new Label("Enrollment No.:"));
        signupEnrollmentField = new TextField();
        signupPanel.add(signupEnrollmentField);

        signupPanel.add(new Label("Name:"));
        signupNameField = new TextField();
        signupPanel.add(signupNameField);

        signupPanel.add(new Label("Branch:"));
        branchChoice = new Choice();
        branchChoice.add("CM");
        branchChoice.add("IT");
        branchChoice.add("AIML");
        branchChoice.add("EE");
        branchChoice.add("ETX");
        branchChoice.add("ME");
        branchChoice.add("CE");
        signupPanel.add(branchChoice);

        signupPanel.add(new Label("Semester:"));
        semesterChoice = new Choice();
        semesterChoice.add("Odd 24");
        semesterChoice.add("Even 24");
        signupPanel.add(semesterChoice);

        signupPanel.add(new Label("Password:"));
        passwordField = new TextField();
        passwordField.setEchoChar('*'); // Mask password input
        signupPanel.add(passwordField);

        Button submitButton = new Button("Submit");
        signupPanel.add(submitButton);

        // Add signup panel to frame
        add(signupPanel, BorderLayout.CENTER);

        // Set frame properties
        setSize(300, 250);
        setVisible(true);

        // Handle submit button click
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enrollmentNo = signupEnrollmentField.getText().trim();
                String name = signupNameField.getText().trim();
                String branch = branchChoice.getSelectedItem();
                String semester = semesterChoice.getSelectedItem();
                String password = passwordField.getText().trim();

                if (enrollmentNo.isEmpty() || name.isEmpty() || password.isEmpty()) {
                    showErrorDialog("All fields are required.");
                } else {
                    boolean success = DatabaseUtils.signupStudent(SignupFrame.this, enrollmentNo, name, branch, semester, password);
                    if (success) {
                        // Close signup frame after success dialog
                        setVisible(false);
                        parentFrame.setVisible(true);
                    }
                }
            }
        });

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                setVisible(false);
                parentFrame.setVisible(true);
            }
        });
    }

    private void showErrorDialog(String message) {
        Dialog errorDialog = new Dialog(this, "Signup Failed", true);
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
        errorDialog.setSize(200, 100);
        errorDialog.setVisible(true);
    }

    // private static void showSuccessDialog(Frame parentFrame, String message) {
    //     // Create and configure the dialog
    //     Dialog successDialog = new Dialog(parentFrame, "Signup Success", true);
    //     successDialog.setLayout(new FlowLayout());
    //     successDialog.add(new Label(message));
    //     Button okButton = new Button("OK");
    //     successDialog.add(okButton);
    //     okButton.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             successDialog.setVisible(false);
    //         }
    //     });
    //     successDialog.setSize(300, 150);
    //     successDialog.setVisible(true);
    // }
}
