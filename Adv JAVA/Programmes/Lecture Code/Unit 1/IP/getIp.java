import java.net.*;

public class getIp{
    public static void main(String[] args) throws UnknownHostException {
        
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip);
        
        InetAddress getName = InetAddress.getByName("www.gpnagpur.ac.in");
        System.out.println(getName);

        InetAddress [] getAllName = InetAddress.getAllByName("www.google.com");
        for(InetAddress address:getAllName){
            System.out.println(address);
            
        }
        
    }
}