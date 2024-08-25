package Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DatabaseUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/adv_java_project"; // Update if necessary
    private static final String USER = "root";
    private static final String PASS = "root@123";

    public static boolean validateCredentials(Frame parentFrame, String enrollmentNo, String password) {
        String sql = "SELECT password FROM std_info WHERE enroll = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(enrollmentNo));

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    if (storedPassword.equals(password)) {
                        showSuccessDialog(parentFrame, "Login Success!!");
                        return true;
                    } else {
                       
                        return false;
                    }
                } else {
                    showErrorDialog(parentFrame, "No data found for the provided enrollment number.");
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showErrorDialog(parentFrame, "Database error occurred.");
        }

        return false;
    }

    public static boolean signupStudent(Frame parentFrame, String enrollmentNo, String name, String branch, String semester, String password) {
        if (isEnrollmentNumberTaken(enrollmentNo)) {
            showErrorDialog(parentFrame, "Enrollment number already exists.");
            return false;
        }

        String sql = "INSERT INTO std_info (enroll, name, branch, semester, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(enrollmentNo));
            pstmt.setString(2, name);
            pstmt.setString(3, branch);
            pstmt.setString(4, semester);
            pstmt.setString(5, password);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            showErrorDialog(parentFrame, "Database error occurred.");
            return false;
        }
    }

    private static boolean isEnrollmentNumberTaken(String enrollmentNo) {
        String sql = "SELECT COUNT(*) FROM std_info WHERE enroll = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(enrollmentNo));

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Returns true if the count is greater than 0
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static void showErrorDialog(Frame parentFrame, String message) {
        Dialog errorDialog = new Dialog(parentFrame, "Error", true);
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
        errorDialog.setSize(300, 150);
        errorDialog.setVisible(true);
    }

    private static void showSuccessDialog(Frame parentFrame, String message) {
        Dialog successDialog = new Dialog(parentFrame, "Success", true);
        successDialog.setLayout(new FlowLayout());
        successDialog.add(new Label(message));
        Button okButton = new Button("OK");
        successDialog.add(okButton);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successDialog.setVisible(false);
            }
        });
        successDialog.setSize(300, 150);
        successDialog.setVisible(true);
    }
}
