package main.apps.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class MainNIO {

    public static void main(String[] args) {

        try {
//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();
            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(dataPath);
            for(String line : lines) {
                System.out.println(line);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
///////
        DirectoryStream.Filter<Path> filter =  new DirectoryStream.Filter<Path>() {  // Predicate
              public boolean accept(Path path) throws IOException {
                   return (Files.isRegularFile(path));
              }
        };

        DirectoryStream.Filter<Path> filter1 = p -> Files.isRegularFile(p);
///////
        Path directory = FileSystems.getDefault().getPath("Filetree"+ File.separator + "Dir2");
        Path directory1 = FileSystems.getDefault().getPath("FileTree\\Dir2");// FileTree\\Dir2

        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getName(0));
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
/////////
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
/////////
        System.out.println("*******************");
        try {
            Path tempFile = Files.createTempFile("myTemp", ".appext"); //
            // C:\\users\thoma\appData\Local\Temp\myapp0234870327403274.appext
            System.out.println("Temp file path = "+ tempFile.toAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
/////////
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store: stores) {
            System.out.println("Volume Name/Drive letter = "+store);
            System.out.println("file Store: " + store.name());
        }
////////
        System.out.println("*******************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths) {
            System.out.println(path);
        }
//////
        System.out.println("************ Walking Tree for Dir2 *******");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintPaths());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        //    FileTree/Dir4/Dir2Copy
        try {
            Files.walkFileTree(dir2Path, new FileNIO(dir2Path, copyPath));//src,target

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

/////////
        System.out.println("************ Path convertedPath = file.toPath(); *******");

        File file = new File("/Examples/file.txt");   // C:\\Examples\file.txt
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("/Examples");  // C:\\Examples
        File resolvedFile = new File(parent, "dir/file.txt");  // dir\\file.txt
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("/Examples", "dir/file.txt");  // C:\\Examples   dir\\file.txt
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("/Examples");  // C:\\Examples
        Path childRelativePath = Paths.get("dir/file.txt");  // dir\\file.txt
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("--- print Dir2 contents using list() ---");
        File dir2File = new File(workingDirectory, "/FileTree/Dir2");   // \\FileTree\Dir2
        String[] dir2Contents = dir2File.list();
        for(int i=0; i< dir2Contents.length; i++) {
            System.out.println("i= " + i + ": " + dir2Contents[i]);
        }

        System.out.println("--- print Dir2 contents using listFiles() ---");
        File[] dir2Files = dir2File.listFiles();
        for(int i=0; i< dir2Files.length; i++) {
            System.out.println("i= " + i + ": " + dir2Files[i].getName());
        }








    } // END main method
}