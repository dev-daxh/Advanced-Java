package ClientServer_ReverseString;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException {
        boolean working = true; 
        System.out.println("Server started. Waiting for connections...");
        ServerSocket ss = new ServerSocket(1607);

        while (working) {
            try {
               
                Socket sc = ss.accept();
                System.out.println("Client connected: " + sc.getInetAddress().getHostAddress());

                
                InputStream is = sc.getInputStream();
                OutputStream os = sc.getOutputStream();
                Scanner scanner = new Scanner(is);
                PrintWriter pw = new PrintWriter(os, true);

                
                String request = scanner.nextLine();
                System.out.println("Received: " + request);

                
                StringBuilder stringBuilder = new StringBuilder(request);
                String reply = stringBuilder.reverse().toString();

                
                pw.println(reply);
                System.out.println("Sent: " + reply);

                
                scanner.close();
                pw.close();
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       
        ss.close();
    }
}
