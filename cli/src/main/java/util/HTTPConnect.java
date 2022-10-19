package util;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class HTTPConnect {

    public static String download(String sourceURL) throws IOException, URISyntaxException {
        System.out.println("Downloading from "+ sourceURL);
        URL url = new URI(sourceURL).toURL();

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int responseCode = conn.getResponseCode();

            if(responseCode >=200 && responseCode < 300) {
                return InputOutput.read(conn.getInputStream()); // returns html text
            }
        } catch (MalformedURLException e) {
          e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } catch (RuntimeException e) {
         e.printStackTrace();
        }
        return null;
    }

    public static String download(InputStream in) throws MalformedURLException, URISyntaxException {
        return InputOutput.read(in);
    }
    public InputStream getInputStream(String sourceUrl) throws MalformedURLException, URISyntaxException {
        System.out.println("Downloading: " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();
        InputStream in = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int responseCode = conn.getResponseCode();
            if(responseCode >= 200 && responseCode  < 300) {
                in = conn.getInputStream();
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
        return in;
    }
}
