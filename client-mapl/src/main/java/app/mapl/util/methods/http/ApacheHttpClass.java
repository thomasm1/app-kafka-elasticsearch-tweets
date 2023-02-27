package app.mapl.util.methods.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApacheHttpClass {

    public static void main(String[] args) throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet request = new HttpGet("http://example.org");
//        request.addHeader("User-Agent","Chrome");
//
//        CloseableHttpResponse response = httpClient.execute(request);
//
//        try {
//            System.out.println("response code = " + response.getStatusLine().getStatusCode());
//            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//            String line;
//            while((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//            br.close();
//        } catch(IOException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            response.close();
//        }
    }
}
