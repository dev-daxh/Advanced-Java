package UDP;

import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String request = "Hello Server!";
        DatagramPacket dp = new DatagramPacket(request.getBytes(), request.length(), InetAddress.getLocalHost(), 1607);
        ds.send(dp);
        System.out.println("Msg send to server");

        byte[] buff = new byte[64];
        DatagramPacket dpr = new DatagramPacket(buff, buff.length);
        ds.receive(dpr);
        String reply = new String(dpr.getData());
        System.out.println("Reply from Server: " + reply);
        ds.close();
    }
}
