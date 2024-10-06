package ilan.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
@Slf4j
public class ReadFolderService {

    @Value("${root.folder::#{null}}")
    String rootFolder;

    public Map<Path, Set<Path>> getFolderFiles(Boolean removeRoot) {
        Map<Path, Set<Path>> folderAndFiles = new HashMap<>();
        if (Objects.nonNull(rootFolder)) {
            Path directory = Paths.get(rootFolder);
            try (Stream<Path> stream = Files.walk(directory)) {
                folderAndFiles = stream
                        .filter(entry -> !directory.equals(entry))
                        .collect(groupingBy(Path::getParent, TreeMap::new, Collectors.toSet()));
                if(removeRoot) {
                    folderAndFiles.remove(directory);
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        return folderAndFiles;
    }
}
