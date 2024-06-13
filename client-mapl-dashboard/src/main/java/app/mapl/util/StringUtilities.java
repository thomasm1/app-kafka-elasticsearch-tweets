package app.mapl.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import static app.mapl.CliApplication.log;

public class StringUtilities {
    public static void main(String[] args) {
        StringUtilities stringUtilities = new StringUtilities();
        System.out.println(stringUtilities.upperAndPrefix("test"));
        System.out.println(stringUtilities.addSuffix("test"));
        System.out.println(stringUtilities.walkThroughCheck("./src/main/resources/"));

        Path path = Path.of("files/testing.txt");
        printPathInfo(path);
    }
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c) {
        sBuilder.append(c);
        charsAdded++;
    }

    public String upperAndPrefix(String str) {
        String upper = str.toUpperCase();
        return "Prefix_" + upper;
    }

    public String addSuffix(String str) {
        return str + "__Suffix";
    }

    public Boolean walkThroughCheck(String pathString) {
        try (Stream<Path> paths = Files.walk(Paths.get(pathString), 2)) {
            paths.filter(Files::isRegularFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void printPathInfo(Path path) {
        log.info("Path: " + path);
        log.info("Absolute Path: " + path.toAbsolutePath());
        log.info("File Name: " + path.getFileName());
        log.info("Parent: " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        log.info("absolutePath: " + absolutePath);
        log.info("Root: " + path.getRoot());
        log.info("Name Count: " + path.getNameCount());
        log.info("Subpath: " + path.subpath(0, 2));
        log.info("Is Absolute: " + path.isAbsolute());


        log.info(String.valueOf(absolutePath.getRoot()));
        int i = 1;
        Iterator it = path.toAbsolutePath().iterator();
        while (it.hasNext()) {
            log.info(".".repeat(i++) + " " + it.next());
        }
        log.info("-----------  - - ");


        int  pathParts = absolutePath.getNameCount();
        for ( i = 0; i < pathParts; i++) {
            log.info("Name element ".repeat(i+ 1) + i + " is: " + absolutePath.getName(i));
        }
        log.info("-----------  - - ");

    }
    public static void readFiles (String fileNameStr) {
        try (FileReader reader = new FileReader("file.txt")) {
            char[] block = new char[1000];
            int data;
            while ((data = reader.read(block)) != -1) {
                String content = new String(block, 0, data);
                System.out.printf("---> [%d chars] %s%n", data, content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------------");
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("file.txt"))) {

            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
