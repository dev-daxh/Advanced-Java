package PTodd_23;
import java.sql.*;
import java.net.*;
public class Client {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "root@123");
        System.out.println("Sucess");

    }
}
