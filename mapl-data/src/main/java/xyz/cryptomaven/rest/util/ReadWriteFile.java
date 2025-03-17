package xyz.cryptomaven.rest.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.cryptomaven.rest.models.User;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static xyz.cryptomaven.rest.util.constants.Constants.FILE_IN_USERS;
import static xyz.cryptomaven.rest.util.constants.Constants.FILE_OUT_USERS;
import static xyz.cryptomaven.rest.util.constants.Constants.*;

public class ReadWriteFile {



    public static String readFromJson(String dataPath, String filename) {
        List<User> uList = new ArrayList<>();
        try {
            File jsonFileDir = new File(dataPath);
            if (jsonFileDir != null && jsonFileDir.exists() && jsonFileDir.isDirectory()) {
                for (File file : jsonFileDir.listFiles()) {
                    if (file.isFile() && file.getName().equals(filename)) {
                            System.out.println("file found: "+file.getAbsolutePath()+ file);
                        }
                    }
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    uList =  objectMapper.readValue(new File(jsonFileDir+filename) , objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
                    }  catch (IOException e) {
                    e.printStackTrace();
                    return uList.toString();
                }
                return null;
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }

    public static String readFromFilename(List<String> data, String filename) throws FileNotFoundException, UnsupportedEncodingException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"))) {
            String line;
            System.out.println("filename "+filename);
            while ((line = br.readLine()) != null) {
                data.add(line);
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text.toString();
    }


    public static String readFromStream(InputStream inStream) {
        StringBuilder text = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inStream))) {
            String line;
            while ((line = br.readLine()) !=null) {
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }

    public static void writeUser(User user) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        try {
            Writer output = null;
            File file = new File(FILE_OUT_USERS );
            output = new BufferedWriter(new FileWriter(file));
                output.write(user.toString());
                System.out.println("WRITTEN: "+user);
            output.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Could not create file");
        }
    }

    public static void writeUsers(List<User> users) {
        try {
            Writer output = null;
            File file = new File(FILE_OUT_USERS);
            output = new BufferedWriter(new FileWriter(file));
            for(int i = 0;i < users.size();i++) {
                output.write(users.get(i).toString());
                output.write("\n");
            }
            output.close();
            System.out.println("File has been written");
        } catch (FileNotFoundException e) {
            System.out.println("Could not create file");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Could not create file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Dynamically name webpage based on ID /// HARD-CODED LOCATION!
    public static boolean writeWebpage(String webpage, long id) {
        try(BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_OUT_WEBLINKS+String.valueOf(id)+".html"), "UTF-8"))) {
            wr.write(webpage);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Most common way to read byte streams from a file
    public static void fileCopyWithBufferAndArray() {
        System.out.println("\nInside fileCopyWithBufferAndArray ...");

        long startTime, elapsedTime; // for speed benchmarking
        startTime = System.nanoTime();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(FILE_IN_USERS));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(FILE_OUT_USERS))) {

            byte[] byteBuf = new byte[4000];
            int numBytesRead;
            while ((numBytesRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("fileCopyWithBufferAndArray: " + (elapsedTime / 1000000.0) + " msec");
    }
    public static void urlHeaders(String in_url ) {
        try {
            URL url= new URL(in_url);
            URLConnection urlConnection = url.openConnection();
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
