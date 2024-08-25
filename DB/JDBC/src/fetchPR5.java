import java.sql.*;
import java.util.Scanner;

public class fetchPR5 {
    public static void main(String[] args) throws Exception {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "root@123");
            System.out.println("Connection Established Successfully!!");

           Scanner sc = new Scanner(System.in);

             Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from acc;");
            while (rs.next()) {
            String name = rs.getString("name");
            int acc_no = rs.getInt("account_no");
            int bal = rs.getInt("balance");
            int pin = rs.getInt("pin");
            System.out.printf("Name: %s, Account Number: %d, Balance: %d, PIN: %d%n", name, acc_no, bal, pin);
        }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}