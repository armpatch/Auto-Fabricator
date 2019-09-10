package io;

import java.io.File;

public class FilepathChecker {
    public static boolean isDirectory(String directoryPath) {
        System.out.println("directory path: " + directoryPath);
        File sourceFile = new File(directoryPath);

        if (sourceFile.isDirectory()) {
            return true;
        } else {
            System.out.println("Directory Path is not valid");
            return false;
        }
    }

    public static boolean isFile(String filePath) {
        System.out.println("file path: " + filePath);
        File sourceFile = new File(filePath);

        if (sourceFile.isFile()) {
            return true;
        } else {
            System.out.println("File Path is not valid");
            return false;
        }
    }
}
