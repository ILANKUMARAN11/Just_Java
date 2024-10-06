package ilan.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
@Slf4j
public class ReadFolder {

    @Value("${root.folder::#{null}}")
    String rootFolder;

    public Map<Path, Set<Path>> getFolderFiles() {
        Map<Path, Set<Path>> folderAndFiles = new HashMap<>();
        if (Objects.nonNull(rootFolder)) {
            Path directory = Paths.get(rootFolder);
            System.out.println("++++"+directory);
            try (Stream<Path> stream = Files.walk(directory)) {
                folderAndFiles = stream
                        .filter(entry ->!entry.equals(directory))
                        .collect(Collectors.groupingBy(Path::getParent, TreeMap::new, Collectors.toSet()));
                folderAndFiles.remove(directory);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        return folderAndFiles;
    }
}
