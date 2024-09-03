package ClientSql;

import java.net.*;
import java.util.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try (Socket sc = new Socket("localhost", 9898);
             InputStream is = sc.getInputStream();
             OutputStream os = sc.getOutputStream();
             Scanner scan = new Scanner(System.in);
             PrintWriter pw = new PrintWriter(os, true);
             Scanner serverScanner = new Scanner(is)) {

            System.out.println("Enter enrollment number: ");
            int enroll = scan.nextInt();
            pw.println(enroll);
            System.out.println("Request sent to Server");

            int marks = serverScanner.nextInt();
            System.out.println("Reply received from Server");
            System.out.println("The marks for enrollment number " + enroll + " are " + marks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
