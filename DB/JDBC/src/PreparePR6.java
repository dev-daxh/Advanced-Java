import java.sql.*;
import java.util.Scanner;

public class PreparePR6 {
    public static void main(String[] args) throws Exception {
        try{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "root@123");
        System.out.println("Connection Established Successfully!!");

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO acc (name, account_no, balance, pin) VALUES (?, ?, ?, ?)");

        boolean moreRecords = true;
        Scanner sc = new Scanner(System.in);
        do {
            String name;
            int acc_no, pin, bal;

            System.out.println("Enter information of new Account Holder: ");
            System.out.print("Name: ");
            name = sc.nextLine();

            System.out.print("Account No.: ");
            acc_no = sc.nextInt();

            System.out.print("Balance: ");
            bal = sc.nextInt();

            System.out.print("PIN: ");
            pin = sc.nextInt();
            sc.nextLine();

            // Set the parameters for the PreparedStatement
            stmt.setString(1, name);
            stmt.setInt(2, acc_no);
            stmt.setInt(3, bal);
            stmt.setInt(4, pin);

            // Execute the update
            int i = stmt.executeUpdate();
            System.out.println(i + " record(s) inserted");

            // Ask user if they want to continue
            System.out.print("Do you want to insert another record? (yes/no): ");
            String response = sc.nextLine();
            moreRecords = response.equalsIgnoreCase("yes");

        } while (moreRecords);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from acc;");
        while (rs.next()) {
            String name = rs.getString("name");
            int acc_no = rs.getInt("account_no");
            int bal = rs.getInt("balance");
            int pin = rs.getInt("pin");
            System.out.printf("Name: %s, Account Number: %d, Balance: %d, PIN: %d%n", name, acc_no, bal, pin);
        }
    }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
