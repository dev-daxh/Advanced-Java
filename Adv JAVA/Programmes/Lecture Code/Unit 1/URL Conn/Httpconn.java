import java.io.IOException;
import java.net.*;
import java.net.URL;


public class Httpconn {
    public static void main(String[] args) throws IOException{
        URL url = new URL("https://www.gpnagpur.ac.in/gpnagpur_new/");
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        for(int i=1;i<=8;i++){
            System.out.println(huc.getHeaderFieldKey(i)+"= "+huc.getHeaderField(i));

        }
        System.out.println(huc.getResponseCode());
        System.out.println(huc.getResponseMessage());
        huc.disconnect();
    }
}
