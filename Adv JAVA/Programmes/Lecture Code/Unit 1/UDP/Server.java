package UDP;

import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("waiting for connection.....");
        DatagramSocket ds = new DatagramSocket(1607);
        byte[] buff = new byte[64];
        DatagramPacket dp = new DatagramPacket(buff, buff.length);
        ds.receive(dp);
        String msg= new String(dp.getData());
        System.out.println("Msg from Client :"+msg);

        String reply = "Hello from server!";
        
        // Create DatagramPacket for sending reply back to client
        DatagramPacket dpr = new DatagramPacket(reply.getBytes(), reply.length(), dp.getAddress(), dp.getPort());
        ds.send(dpr); // Send reply packet to client
        
        System.out.println("Reply sent to Client");
        ds.close();
    }
}
