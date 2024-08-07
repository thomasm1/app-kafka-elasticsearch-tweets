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
        Path outputDir = Paths.get("output-directory");
        Files.createDirectories(inputDir);
        Files.createDirectories(outputDir);

        Path testFile = inputDir.resolve("text-input.txt");
        Files.writeString(testFile, "Text file here...!");

        // Wait for the file to be processed
        Thread.sleep(2000);

        // Verify
        File outputFile = outputDir.resolve("text-input.txt").toFile();
        assertThat(outputFile).exists();
        assertThat(Files.readString(outputFile.toPath())).isEqualTo("Text file here...!");

        // Clean up
        Files.deleteIfExists(testFile);
        Files.deleteIfExists(outputFile.toPath());
        Files.deleteIfExists(inputDir);
        Files.deleteIfExists(outputDir);

        context.close();
    }
}
