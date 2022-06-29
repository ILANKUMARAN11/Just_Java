package ilan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class DeleteFilesMain {



    public static void main(String[] args) throws IOException {



        Path dir = Paths.get("C:\\ILAN\\Study_Documents");

        // Traverse the file tree in depth-first fashion and delete each file/directory.
        Files.walk(dir)
                .sorted(Comparator.reverseOrder())
                .filter(p->{
                    System.out.println(p.toAbsolutePath());
                    return p.getFileName().toString().contains("~$") || p.getFileName().toString().contains(".DS_S");
                })
                .forEach(path -> {
                    try {
                        System.out.println("Deleting: " + path.getFileName().toString());
                        Files.delete(path);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

}
