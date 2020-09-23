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
        File dir = new File("./");
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
        directoryTraversal(dir, "");
    }

    private static void directoryTraversal(File dir, String space) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(space + "File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(space + "Directory: " + file.getName());
                    directoryTraversal(file, space + "\t");
                }
            }
        }
    }
}