package util;

import java.io.*;

public class InputOutput {
    //    each line data chunk
    public static  void read(String[] data, String filename) throws FileNotFoundException, UnsupportedEncodingException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8" ))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null )     {
                data[count] = line;
                count++;
            }
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}