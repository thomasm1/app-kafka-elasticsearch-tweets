package xyz.climongoapp.methods.files;

import java.io.*;
import java.util.Arrays;

public class Serialize {
    static String inFileStr = "earthSpaceDefense.jpg";
    static String outFileStr = "earthSpaceDefense-out.jpg";

    // By convention, static nested classes should be placed before static methods
    public static class SerializeNestClass implements Serializable {
        static final long serialVersionUID = 8882416210786165012L;
        private String name;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        private transient int id = 4;
        public int getId() { return id; }

        //private String gender;
    }





    public static void fileMethods() {
        System.out.println("\nInside fileMethodsDemo ...");

        File f = new File("earthSpaceDefense.jpg"); // "movies\\movies.txt" also works
        //File f = new File("earthSpaceDefense.jpg");

        System.out.println("getAbsolutePath(): " + f.getAbsolutePath());
        try {
            System.out.println("getCanonicalPath(): " + f.getCanonicalPath());
            System.out.println("createNewFile(): " + f.createNewFile());
        } catch (IOException e) {}
        System.out.println("separator: " + f.separator);
        System.out.println("separatorChar: " + f.separatorChar);
        System.out.println("getParent(): " + f.getParent());
        System.out.println("lastModified(): " + f.lastModified());
        System.out.println("exists(): " + f.exists());
        System.out.println("isFile(): " + f.isFile());
        System.out.println("isDirectory(): " + f.isDirectory());
        System.out.println("length(): " + f.length());

        System.out.println("My working or user directory: " + System.getProperty("user.dir"));
        System.out.println("new File(\"testdir\").mkdir(): " + new File("testdir").mkdir());
        System.out.println("new File(\"testdir\\test\").mkdir(): " + new File("testdir\\test").mkdir());
        System.out.println("new File(\"testdir\").delete(): " + new File("testdir").delete());
        System.out.println("new File(\"testdir\\test1\\test2\").mkdir(): " + new File("testdir\\test1\\test2").mkdir());
        System.out.println("new File(\"testdir\\test1\\test2\").mkdirs(): " + new File("testdir\\test1\\test2").mkdirs());

        try {
            File f2 = new File("temp.txt");
            System.out.println("f2.createNewFile(): " + f2.createNewFile());
            System.out.println("f2.renameTo(...): " + f2.renameTo(new File("testdir\\temp1.txt"))); // move!!
        } catch (IOException e) {}

    }

    public static void dirFilter(boolean applyFilter) {
        System.out.println("\nInside dirFilter ...");

        File path = new File(".");
        String[] list;

        if(!applyFilter)
            list = path.list();
        else
            list = path.list(new DirFilter());

        //Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }

    /**
     * Internally in memory Java always stores a char as UTF-16.
     */



    public static void applyEncoding() {
        System.out.println("\nInside applyEncoding ...");
        //System.out.println("Default Character Encoding: " + System.getProperty("file.encoding"));

        // Ensure Eclipse property is set as UTF8
        printEncodingDetails("luke");
        printEncodingDetails("€"); // Euro (Reference: http://stackoverflow.com/questions/34922333/how-does-java-fit-a-3-byte-unicode-character-into-a-char-type)
        printEncodingDetails("\u1F602"); // Non-BMP Unicode Code Point ~ Tears of Joy Emoji (one of Smiley graphic symbol)
    }
    private static void printEncodingDetails(String symbol) {
        System.out.println("\nSymbol: " + symbol);
        try {
            System.out.println("ASCII: " + Arrays.toString(symbol.getBytes("US-ASCII")));
            System.out.println("ISO-8859-1: " + Arrays.toString(symbol.getBytes("ISO-8859-1")));
            System.out.println("UTF-8: " + Arrays.toString(symbol.getBytes("UTF-8")));
            System.out.println("UTF-16: " + Arrays.toString(symbol.getBytes("UTF-16")));
            System.out.println("UTF-16 BE: " + Arrays.toString(symbol.getBytes("UTF-16BE")));
            System.out.println("UTF-16 LE: " + Arrays.toString(symbol.getBytes("UTF-16LE")));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
    }

    public void doSerialization() {
        System.out.println("\nInside doSerialization ...");

        SerializeNestClass serializeNestClass = new SerializeNestClass();
        serializeNestClass.setName("Java");
        System.out.println("name (before serialization): " + serializeNestClass.getName());
        System.out.println("id (before serialization): " + serializeNestClass.getId());

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("serial.ser")))) {
            out.writeObject(serializeNestClass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /// GETTING EOF EXCPTION EHRE
    public void doDeserialization() {
        System.out.println("\nInside doDeserialization ...");

        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("serial.ser")))) {
            SerializeNestClass serializedObj = (SerializeNestClass) in.readObject();
            System.out.println("name (after deserialization): " + serializedObj.getName());
            System.out.println("id (after deserialization): " + serializedObj.getId());

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());

        } catch (EOFException e) {
            // TODO Auto-generated catch block
            System.out.println("EOFException "+ e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally to finally");
        }
    }

    public static void main(String[] args) {

        fileMethods();
        dirFilter(true);
        applyEncoding();

        // Serialization
        if (args.length > 0 && args[0].equals("true")) {
            new Serialize().doSerialization();
        }
        new Serialize().doDeserialization();
    }
}

class DirFilter implements FilenameFilter {
    // Holds filtering criteria
    public boolean accept(File file, String name) {
        return name.endsWith(".jpg") || name.endsWith(".JPG");
    }
}