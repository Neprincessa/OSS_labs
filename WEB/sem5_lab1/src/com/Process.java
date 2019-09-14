package com;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public abstract class Process {
    public void start() {
        System.out.println("No correct arguments");
    }

    public boolean checkFile(String path) {
        File currentFile = new File(path);
        if (currentFile.isFile()) {
            return true;
        }
        System.out.println("Invalid file name");
        return false;
    }

    public  String readFile(String path) throws IOException {
        File currentFile = new File(path);
        String result = FileUtils.readFileToString(currentFile, "utf-8");

        return result;
    }
}
