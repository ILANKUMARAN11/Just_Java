package ilan.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileRenameService {

    private final ReadFolderService readFolderService;

    public void renameFile(File sourceFile, String targetDestination, String fileName, String fileExtension) {

        if (!sourceFile.renameTo(new File(targetDestination + "\\" + String.valueOf(fileName) + fileExtension))) {
            log.info("Failed to rename file");
        }
    }
}
