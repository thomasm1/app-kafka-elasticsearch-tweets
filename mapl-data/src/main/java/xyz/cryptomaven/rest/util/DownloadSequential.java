package xyz.cryptomaven.rest.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class DownloadSequential {

    public static String downloadFromUrl(String sourceURL) throws IOException, URISyntaxException {
        System.out.println("Downloading from "+ sourceURL);
        URL url = new URI(sourceURL).toURL();

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int responseCode = conn.getResponseCode();

            if(responseCode >=200 && responseCode < 300) {
                return ReadWriteFile.readFromStream(conn.getInputStream()); // returns html text
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

    public static String downloadFromStream(InputStream in) throws MalformedURLException, URISyntaxException {
        return ReadWriteFile.readFromStream(in);
    }

    public InputStream getStreamFromUrl(String sourceUrl) throws MalformedURLException, URISyntaxException {
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
