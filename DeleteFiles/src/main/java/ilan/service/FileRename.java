package ilan.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileRename {

    private final ReadFolder readFolder;

    public void renameFile(String sourceDestination, String targetDestination, String fileName, String fileExtension){

        if (!new File(sourceDestination).renameTo(new File(targetDestination+"\\"+String.valueOf(fileName)+fileExtension))) {
            log.info("Failed to rename file");
        }
    }
}
