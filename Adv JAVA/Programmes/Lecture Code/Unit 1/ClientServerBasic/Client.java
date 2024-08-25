package ClientServerBasic;
import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
    public static void main(String[] args) throws IOException, UnknownHostException {
        Socket sc = new Socket("localhost", 1607); 
        InputStream is = sc.getInputStream();
        OutputStream os = sc.getOutputStream();
        Scanner scan = new Scanner(is);
        PrintWriter pw = new PrintWriter(os, true);

        String msg = "hello Server!";
        pw.println(msg);

        
        String response = scan.nextLine();
        System.out.println("response from server : " + response);

        pw.close();
        scan.close();
        sc.close();
    }
}
