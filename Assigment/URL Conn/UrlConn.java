import java.io.InputStream;
import java.net.*;
public class UrlConn {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.gpnagpur.ac.in/gpnagpur_new/");
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        for(int i=1;i<=8;i++){
            System.out.println(huc.getHeaderFieldKey(i)+"= "+huc.getHeaderField(i));

        }
        System.out.println(huc.getResponseCode());
        System.out.println(huc.getResponseMessage());
        huc.disconnect();
        
        URLConnection urlconn = url.openConnection();

        InputStream is = urlconn.getInputStream();
        int i;
        while((i=is.read())!=-1){
            System.out.print((char)i);
        }
        System.out.println("File read sucessfully");

    }
}
