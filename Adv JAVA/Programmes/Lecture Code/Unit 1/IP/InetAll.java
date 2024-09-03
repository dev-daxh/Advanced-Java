// InetAddress all instance and factory methods
import java.net.*;

public class InetAll{
    public static void main(String[] args) throws Exception{

         
        InetAddress getLocalHost = InetAddress.getLocalHost();
        System.out.println(getLocalHost);

        InetAddress getbyname = InetAddress.getByName("www.google.com");
        InetAddress getbyname2 = InetAddress.getByName("www.google.com");

        System.out.println(getbyname);

        InetAddress [] getall = InetAddress.getAllByName("www.google.com");
        for(InetAddress add : getall){
            System.out.println(add);
        }

        System.out.println(getbyname.getHostAddress());
        System.out.println(getbyname.getHostName());
        System.out.println(getbyname.isReachable(200));
        System.out.println(getbyname.equals(getbyname2));

        
    }
}