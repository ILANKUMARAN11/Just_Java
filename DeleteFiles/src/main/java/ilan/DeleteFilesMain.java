package ilan;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteFilesMain {



    public static void main(String[] args) throws IOException {


        String s = "abcdefgh";

        StringBuffer stringBuffer = new StringBuffer(s);
        Map<String, String> hm = new HashMap<>();
        hm.put("a", "1");
        hm.put("b", "1");
        hm.put("c", "1");
        hm.put("d", "1");

        String[] json = { s };

        hm.forEach((key, val) -> json[0] = json[0].replaceAll(key, String.valueOf(val)));
        System.out.println(json[0]);

        String result = hm.entrySet().stream()
                .map(e -> s.replace("$name$", e.getKey())
                        .replace("$age$",  e.getValue().toString()))
                .collect(Collectors.joining());




//        Path dir = Paths.get("C:\\ILAN\\Study_Videos\\JAVA\\WebFlux\\Java Brains");
//
//        // Traverse the file tree in depth-first fashion and delete each file/directory.
//        Files.walk(dir)
//                .sorted(Comparator.reverseOrder())
////                .filter(p->{
////                    System.out.println(p.toAbsolutePath());
////                    return p.getFileName().toString().contains("~$") || p.getFileName().toString().contains(".DS_S");
////                })
//                .forEach(path -> {
//                    try {
//                        String existingFileName = path.getFileName().toString();
//                        System.out.println("File name: " + existingFileName);
//
//                        //System.out.println(existingFileName.indexOf(" - "));
//                        //System.out.println(existingFileName.indexOf(")-"));
//
//                        if(existingFileName.indexOf(" - ")!=-1 && existingFileName.indexOf(")-")!=-1) {
//                            String newFileName = existingFileName.substring(existingFileName.indexOf(" - ")+2, existingFileName.indexOf(")-")+1);
//                            System.out.println(newFileName);
//
//                            File sourceFile = new File("C:\\ILAN\\Study_Videos\\JAVA\\WebFlux\\Java Brains\\"+existingFileName);
//                            File destFile = new File("C:\\ILAN\\Study_Videos\\JAVA\\WebFlux\\Java Brains\\"+newFileName+".mp4");
//
//                            if (sourceFile.renameTo(destFile)) {
//                                System.out.println("File renamed successfully");
//                            } else {
//                                System.out.println("Failed to rename file");
//                            }
//
//                        }
//                        //Files.delete(path);
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                });
    }

}
