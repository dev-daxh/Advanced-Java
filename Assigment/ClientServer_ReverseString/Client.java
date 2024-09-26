package ClientServer_ReverseString;

import java.io.*;
import java.util.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException, UnknownHostException {
        Socket sc = new Socket("localhost", 1607);

        InputStream is = sc.getInputStream();
        OutputStream os = sc.getOutputStream();
        Scanner scanner = new Scanner(is);
        PrintWriter pw = new PrintWriter(os, true);

        //System.out.println("Enter a string: ");
        
        String string = "hello";
        pw.println(string);

        String response;
        response = scanner.nextLine();
        System.out.println("respoense from server: " + response);

        is.close();
        os.close();
        scanner.close();
        sc.close();
    }
}
