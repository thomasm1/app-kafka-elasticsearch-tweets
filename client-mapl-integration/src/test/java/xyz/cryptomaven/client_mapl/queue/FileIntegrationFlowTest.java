package xyz.cryptomaven.client_mapl.queue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.integration.file.FileReadingMessageSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FileIntegrationFlowTest {
 /// TODO: THIS TEST IS FAILING!@!V$%^&*()_!
    @Test
    public void testFileProcessing() throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FileIntegrationFlowTest.class);
        FileReadingMessageSource fileReadingMessageSource = context.getBean(FileReadingMessageSource.class);

        // Setup
        Path inputDir = Paths.get("input-directory");
        Path backupDir = Paths.get("backup-directory");
        Files.createDirectories(inputDir);
        Files.createDirectories(backupDir);

        Path testFile = inputDir.resolve("text2.txt");
        Files.writeString(testFile, "Text file here...!");

        // Wait for the file to be processed
        Thread.sleep(2000);

        // Verify
        File backupFile = backupDir.resolve("text2.txt").toFile();
        assertThat(backupFile).exists();
        assertThat(Files.readString(backupFile.toPath())).isEqualTo("Text file here...!");

        // Clean up
        Files.deleteIfExists(testFile);
        Files.deleteIfExists(backupFile.toPath());
        Files.deleteIfExists(inputDir);
        Files.deleteIfExists(backupDir);

        context.close();
    }
}
