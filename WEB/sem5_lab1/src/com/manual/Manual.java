package com.manual;

import com.Process;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.codec.digest.DigestUtils;

public class Manual implements Process {

    String[] fileNames;
    String currentMode;

    public Manual(String[] names ) {
        this.fileNames = Arrays.copyOfRange(names, 2, names.length);
        this.currentMode = names[0]; //question
    }


    @Override
    public void start() {
        for (String file:
             this.fileNames) {
            String tmp = "null";
            String result = null;
            if (checkFile(file)) {
                try {
                    tmp = readFile(file);
                } catch (IOException e) {
                    System.out.println("Invalid file name");
                    continue;
                }

                if (this.currentMode.equals("-md5"))
                    result = DigestUtils.md5Hex(tmp).toUpperCase();
                else
                    result = DigestUtils.sha256Hex(tmp).toUpperCase();
                System.out.println(result);
            }
        }
    }

}
