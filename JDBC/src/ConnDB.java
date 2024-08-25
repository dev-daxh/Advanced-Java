import java.sql.*;
public class ConnDB {
    public static void main(String[] args) throws SQLException {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daksh","root","root@123");
            System.out.println("Connection Established Successfully!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
