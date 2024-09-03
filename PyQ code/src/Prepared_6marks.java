import java.sql.*;
public class Prepared_6marks {
    public static void main(String [] args) throws Exception{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root@123");
        System.out.println("Sucess");
    }
}
