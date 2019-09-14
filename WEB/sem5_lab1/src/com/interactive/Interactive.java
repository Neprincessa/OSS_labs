package com.interactive;

import com.Process;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;
import java.util.Scanner;

public class Interactive extends Process {

    @Override
    public void start() {
        menu();
        int currentMode = checkMode();

        while (currentMode < 0 || currentMode > 3) {
            System.out.println("Invalid number. Print 0,1 or 2");
            currentMode = checkMode();
        }
        
        while (currentMode > 0 && currentMode < 3) {
            System.out.print("Path: ");
            Scanner sc = new Scanner(System.in);
            String fileName = sc.nextLine();
            String tmp = "null";
            String result = null;
           
            if (checkFile(fileName)) {
                try {
                    tmp = readFile(fileName);
                }
                catch (IOException e) {
                    System.out.println("Invalid file name");
                    continue;
                }

                if (currentMode == 1)
                    result = DigestUtils.md5Hex(tmp).toUpperCase();
                else
                    result = DigestUtils.sha256Hex(tmp).toUpperCase();

                System.out.println(result);
            }

            menu();
            currentMode = checkMode();
            while (currentMode < 0 || currentMode > 3) {
                System.out.println("Invalid number. Print 0,1 or 2");
                currentMode = checkMode();
            }
        }

    }


    public void menu () {
        System.out.println("Tap 1, if you want to use MD5");
        System.out.println("Tap 2, if you want to use SHA256");
        System.out.println("Tap 0, if you want to stop work");
    }


    public int checkMode() {
        Scanner sc = new Scanner(System.in);
        int resultInputData;

        if (sc.hasNextInt()) {
            resultInputData = sc.nextInt();
        }
        else {
            resultInputData = -1;
        }

        return resultInputData;
    }

}
