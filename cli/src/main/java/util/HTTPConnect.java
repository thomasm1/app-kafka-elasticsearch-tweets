package util;

import java.io.IOException;
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
            throw new IOException(e);
        } catch (IOException e) {
            throw new IOException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
