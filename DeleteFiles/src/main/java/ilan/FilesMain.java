package ilan;

import ilan.service.ReadFolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class FilesMain {

    private final ReadFolder readFolder;

    public static void main(String[] args) throws IOException {

        log.info("APPLICATION EXECUTION - INITIATED");
        SpringApplication.run(FilesMain.class, args);
        log.info("APPLICATION EXECUTION - COMPLETED");



        /*Path directory = Paths.get("C:/ILAN/DriveTest/");
        try (Stream<Path> stream = Files.walk(directory)) {


            Map<Path, Set<Path>> tests = stream.filter(entry -> !entry.equals(directory))
                    .collect(groupingBy(e->e.getParent(), Collectors.toSet()));

            tests.entrySet().forEach(e-> System.out.println(e.getKey()+" >> "+e.getValue().size()));

        }*/


       /* Path dir = Paths.get("C:\\ILAN\\Study_Videos\\JAVA\\WebFlux\\Java Brains");

        // Traverse the file tree in depth-first fashion and delete each file/directory.
        Files.walk(dir)
                .sorted(Comparator.reverseOrder())
//                .filter(p->{
//                    System.out.println(p.toAbsolutePath());
//                    return p.getFileName().toString().contains("~$") || p.getFileName().toString().contains(".DS_S");
//                })
                .forEach(path -> {
                    try {
                        String existingFileName = path.getFileName().toString();
                        System.out.println("File name: " + existingFileName);

                        //System.out.println(existingFileName.indexOf(" - "));
                        //System.out.println(existingFileName.indexOf(")-"));

                        if(existingFileName.indexOf(" - ")!=-1 && existingFileName.indexOf(")-")!=-1) {
                            String newFileName = existingFileName.substring(existingFileName.indexOf(" - ")+2, existingFileName.indexOf(")-")+1);
                            System.out.println(newFileName);

                            File sourceFile = new File("C:\\ILAN\\Study_Videos\\JAVA\\WebFlux\\Java Brains\\"+existingFileName);
                            File destFile = new File("C:\\ILAN\\Study_Videos\\JAVA\\WebFlux\\Java Brains\\"+newFileName+".mp4");

                            if (sourceFile.renameTo(destFile)) {
                                System.out.println("File renamed successfully");
                            } else {
                                System.out.println("Failed to rename file");
                            }

                        }
                        //Files.delete(path);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });*/
    }

    @Bean
    public CommandLineRunner startup() {
        return args -> {
            readFolder.getFolderFiles().entrySet()
                    .stream()
                    .forEach(e-> System.out.println(e.getKey()+" >> "+e.getValue().size()));
        };
    }

}
