package apps;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

public class Finalizable {
	 private BufferedReader reader;

	    public Finalizable() {
	        InputStream input = this.getClass()
	          .getClassLoader()
	          .getResourceAsStream("file.txt");
	        this.reader = new BufferedReader(new InputStreamReader(input));
	    }

	    public String readFirstLine() throws IOException { 
	    	String line = new String();
	    	line = "";
	    	while(line!=null) {
	    		line = reader.readLine();  
		        if( line != null) System.out.println(line); 
	       }
//	       this.reader.close();
	       finalize();
	        
	       return line; 
	    }
	    @Override
	    public void finalize() {
	        try {
	            reader.close();
	            System.out.println("Closed BufferedReader in the finalizer");
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	    }
	     
		@Test
	    public void whenGC_thenFinalizerExecuted() throws IOException {
	    	String anotherLine = new Finalizable().readFirstLine();
	    	assertEquals(null, anotherLine); 
//	    	System.gc();
	    	finalize();
	    }
}
