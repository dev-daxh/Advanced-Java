import java.sql.*;

class basic{
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/atm";
        String username = "root";
        String password = "root@123";

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Drivers loaded");

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("connection established");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * form acc;");
        while(rs.next()){
            String name = rs.getString("name");
            int acc = rs.getInt("account_no");
            int bal = rs.getInt("balance");
            int pin = rs.getInt("pin");

            // Format the output
String formattedOutput = String.format("| %-15s | %-10d | %-8d | %-4d |", name, acc, bal, pin);

// Print the formatted output
System.out.println("+-----------------+------------+---------+------+");
System.out.println("| Name            | Account No | Balance | PIN  |");
System.out.println("+-----------------+------------+---------+------+");
System.out.println(formattedOutput);
System.out.println("+-----------------+------------+---------+------+");
        }

    }
}