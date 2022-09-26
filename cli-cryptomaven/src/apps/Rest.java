package apps;

import java.io.*;
import java.math.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Rest { 
	    /*
	     * Complete the 'getDiscountedPrice' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts INTEGER barcode as parameter.
	     * API URL: https://jsonmock.hackerrank.com/api/inventory?barcode=<barcode>
	     */ 
public static void main(String[] args) throws IOException, Throwable {
	getDiscountedPrice(74002314);
}
public static int getDiscountedPrice(int code) throws IOException, ParseException {
//	{"page":1,"per_page":500,"total":1,"total_pages":1,"data":[{"barcode":"74002314","item":"Nightgown","category":"Underwear","price":3705,"discount":20,"available":1}]}

	URL url = new URL("https://api.covid19api.com/summary"); 
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	conn.connect();
	int responsecode = conn.getResponseCode();
	
    URL u = new URL("https://jsonmock.hackerrank.com/api/inventory?barcode="+Integer.toString(code));
    URLConnection conn1 = u.openConnection(); 
    String inputLine; 
    
try (BufferedReader in = new BufferedReader( new InputStreamReader(conn1.getInputStream() ))) {

  while((inputLine = in.readLine()) != null) {
      System.out.println(inputLine);  
      JSONParser parse = new JSONParser();
      JSONObject data_obj = (JSONObject) parse.parse(inputLine);

      //Get the required object from tche above created object
      JSONArray objArray = (JSONArray) data_obj.get("data");
      List arr = new ArrayList();
      arr = Arrays.asList(objArray); 
     
//      System.out.println(obj.get("price"));
      //Get the required data using its key 
  }
   
} catch(IOException e) {
    e.printStackTrace();
}; 
return 1;
}
}
