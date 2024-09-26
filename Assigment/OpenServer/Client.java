package Assigment.OpenServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException, UnknownHostException {
        Socket sc = new Socket("localhost", 1607);

        InputStream is = sc.getInputStream();
        OutputStream os = sc.getOutputStream();
        Scanner scanner = new Scanner(is);
        PrintWriter pw = new PrintWriter(os, true);
        System.out.print("Enter a message to send to the server: ");
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        pw.println(input);
        String response;
        response = scanner.nextLine();
        System.out.println("respoense from server: " + response);

        is.close();
        os.close();
        scanner.close();
        userInput.close();
        sc.close();
    }
}
