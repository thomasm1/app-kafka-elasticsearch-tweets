package app.mapl.util.methods.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetHeaders {
    public static void main(String[] args) throws IOException {

        // URL READER
        URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=dogs");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Chrome");
        connection.setReadTimeout(30000);

        int responseCode = connection.getResponseCode();
        System.out.println("Response code: " + responseCode);

        if(responseCode != 200) {
            System.out.println("Error reading web page");
            System.out.println(connection.getResponseMessage());
            return;
        }

        BufferedReader inputReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String line;
        while((line = inputReader.readLine()) != null) {
            System.out.println(line);
        }

        inputReader.close();
/// GET HEADERS
        try {
    URL url_example = new URL("http://example.org");
    URLConnection urlConnection = url_example.openConnection();
    urlConnection.setDoOutput(true);
    urlConnection.connect();
    BufferedReader br = new BufferedReader(
            new InputStreamReader(urlConnection.getInputStream()));

    Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
    for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
        String key = entry.getKey();
        List<String> value = entry.getValue();
        System.out.println("key: "+key+"========= ");
            for(String v: value) {
                System.out.println("Values: " +value);
            }
    }

        } catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}

