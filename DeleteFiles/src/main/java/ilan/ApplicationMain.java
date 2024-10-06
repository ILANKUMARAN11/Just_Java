package ilan;

import ilan.service.FileRename;
import ilan.service.ReadFolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ApplicationMain {

    private final ReadFolder readFolder;
    private final FileRename fileRename;

    public static void main(String[] args) throws IOException {

        log.info("APPLICATION EXECUTION - INITIATED");
        SpringApplication.run(ApplicationMain.class, args);
        log.info("APPLICATION EXECUTION - COMPLETED");
    }

    @Bean
    public CommandLineRunner startup() {
        return args -> {
            readFolder.getFolderFiles(Boolean.TRUE)
                    .entrySet()
                    .stream()
                    .forEach(e -> {
                        List<Path> files = new ArrayList<>(e.getValue());

                        for (int i = 0; i < files.size(); i++) {
                            File sourceFile = files.get(i).toFile();
                            String targetDestination = sourceFile.getParent();

                            fileRename.renameFile(sourceFile.getAbsolutePath(), targetDestination, String.valueOf(i + 1), ".PNG");
                        }
                    });
        };
    }

}
