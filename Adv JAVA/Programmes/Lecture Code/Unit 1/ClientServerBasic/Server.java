package ClientServerBasic;
import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
    public static void main(String[] args) throws IOException,UnknownHostException {
        System.out.println("Waiting for connection.....");
        ServerSocket ss = new ServerSocket(1607);
        Socket sc = ss.accept();
        
        InputStream is = sc.getInputStream();
        OutputStream os = sc.getOutputStream();
        Scanner scan = new Scanner(is);
        PrintWriter pw = new PrintWriter(os,true);
        String request = scan.nextLine();
        System.out.println("request from client : "+request);
        String response ="hello Client!";
        pw.println(response);
        
        is.close();
        os.close();
        scan.close();
        sc.close();
        ss.close();
        
    }
}
