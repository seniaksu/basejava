package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        String filepath = ".\\.gitignore";

        File file = new File(filepath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : dir.list()) {
                System.out.println(name);
            }
        }
        try (FileInputStream fis = new FileInputStream(filepath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void directoryTraversal(File dir) {
        File[] folder = dir.listFiles();
        if (folder != null) {
            for (File file : folder) {
                if (file.isFile()) {
                    System.out.println("File:" + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("File:" + file.getName());
                    directoryTraversal(file);
                }
            }
        }
    }
}
