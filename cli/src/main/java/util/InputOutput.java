package util;

import models.User;

import java.io.*;
import java.util.List;

public class InputOutput {
    //    each line data chunk
    static String inFileStr = "src/fileInUsers.txt";
    static String outFileStr = "src/fileOutUser.txt";
    static String outFileArr = "src/outFileArr.txt";

    public static void read(List<String> data, String filename) throws FileNotFoundException, UnsupportedEncodingException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            System.out.println("filename");
            System.out.println(filename);
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void writeUser(User user) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            Writer output = null;
            File file = new File(outFileStr);
            output = new BufferedWriter(new FileWriter(file));
                output.write(user.toString());
                System.out.println("WRITTEN: "+user);
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

    // Most common way to read byte streams from a file
    public static void fileCopyWithBufferAndArray() {
        System.out.println("\nInside fileCopyWithBufferAndArray ...");

        long startTime, elapsedTime; // for speed benchmarking
        startTime = System.nanoTime();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {

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
            File file = new File(outFileArr);
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
}