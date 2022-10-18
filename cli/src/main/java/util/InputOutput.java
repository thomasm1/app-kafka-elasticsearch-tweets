package util;

import constants.Datum;
import models.User;

import java.io.*;
import java.util.List;

import static constants.Datum.FILE_OUT_WEBLINKS;

public class InputOutput {
    //    each line data chunk


    public static String read(List<String> data, String filename) throws FileNotFoundException, UnsupportedEncodingException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"))) {
            String line;
            System.out.println("filename");
            System.out.println(filename);
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


    public static String read(InputStream inStream) {
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
            File file = new File(Datum.FILE_OUT_USERS);
            output = new BufferedWriter(new FileWriter(file));
                output.write(user.toString());
                System.out.println("WRITTEN: "+user);
            output.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Could not create file");
        }
    }

    // Most common way to read byte streams from a file
    public static void fileCopyWithBufferAndArray() {
        System.out.println("\nInside fileCopyWithBufferAndArray ...");

        long startTime, elapsedTime; // for speed benchmarking
        startTime = System.nanoTime();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(Datum.FILE_IN_USERS));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(Datum.FILE_OUT_USERS))) {

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

    public static void writeUsers(List<User> users) {
        try {
            Writer output = null;
            File file = new File(Datum.FILE_OUT_USERS);
            output = new BufferedWriter(new FileWriter(file));
           for(int i = 0;i < users.size();i++) {
               output.write(users.get(i).toString());
               output.write("\n");
               System.out.println("ARRAY[i]: "+ users.get(i));
               System.out.println("\n");
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

    public static boolean write(String webpage, long id) {
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
}