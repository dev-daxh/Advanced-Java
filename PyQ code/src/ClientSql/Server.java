package ClientSql;

import java.sql.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9898);
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root@123")) {
            
            System.out.println("Server started. Waiting for connections...");
            System.out.println("Connection Established");

            while (true) {
                try (Socket sc = ss.accept();
                     InputStream is = sc.getInputStream();
                     OutputStream os = sc.getOutputStream();
                     Scanner scan = new Scanner(is);
                     PrintWriter pw = new PrintWriter(os, true)) {

                    System.out.println("Client connected: " + sc.getInetAddress().getHostAddress());

                    int enroll = scan.nextInt();
                    System.out.println("Request received from Client");

                    // Use a PreparedStatement to prevent SQL injection
                    String query = "SELECT marks FROM student WHERE enroll = ?";
                    try (PreparedStatement pst = conn.prepareStatement(query)) {
                        pst.setInt(1, enroll);
                        try (ResultSet rs = pst.executeQuery()) {
                            if (rs.next()) {
                                int marks = rs.getInt("marks");
                                pw.println(marks);
                                System.out.println("Reply sent to Client");
                            } else {
                                pw.println("No record found");
                                System.out.println("No record found for enrollment number: " + enroll);
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
