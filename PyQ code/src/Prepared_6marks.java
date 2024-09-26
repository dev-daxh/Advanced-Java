
import java.sql.*;
import java.util.*;

public class Prepared_6marks {

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root@123");
        System.out.println("Sucess");
        String name, course;
        int marks;
        Scanner sc = new Scanner(System.in);
        // PreparedStatement psmt = conn.prepareStatement("insert student (name,course,marks) values (?,?,?)");
        // System.out.println("Enter Name: ");
        // name = sc.nextLine();
        // System.out.println("Enter Course: ");
        // course = sc.nextLine();
        // System.out.println("Enter marks: ");
        // marks = sc.nextInt();
        // psmt.setString(1, name);
        // psmt.setString(2, course);
        // psmt.setInt(3,marks);
        // int i = psmt.executeUpdate();
        // System.out.println("Record "+i+" inserted Sucessfully");

        // Statement st = conn.createStatement();
        // ResultSet rs = st.executeQuery("Select * from student");
        // while((rs.next())){
        //     String sname = rs.getString("name");
        //     String scourse = rs.getString("course");
        //     int smarks = rs.getInt("marks");
        //     System.out.printf("name: %s \t course: %s \t marks: %d \n",sname,scourse,smarks);
        // }
        //fetching records
        PreparedStatement psmt = conn.prepareStatement("select * from student where marks > ? and course = ?");

        System.out.println("Enter marks: ");
        marks = sc.nextInt();
        System.out.println("Enter course: ");
        course = sc.nextLine();

        psmt.setInt(1, marks);
        psmt.setString(2, course);

        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
               String sname = rs.getString("name");
               String scourse = rs.getString("course");
               int smarks = rs.getInt("marks");
               System.out.printf("name: %s \t course: %s \t marks: %d \n",sname,scourse,smarks);
        }

    }
}
