package com.fesva;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public static final boolean ENRU = true;
    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "data/src";
        String dstFolder = "data/dst";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int countOfCores = Runtime.getRuntime().availableProcessors();
        if (ENRU) {
            System.out.println("Processors in System:  " + countOfCores);
        } else {
            System.out.println("Процессоров в системе:  " + countOfCores);
        }

        try {
            ExecutorService service = Executors.newFixedThreadPool(countOfCores);
            for (int i = 0; i < files.length; i++) {
                service.submit(new ImageResizer(files[i], newWidth, dstFolder));
            }

            service.shutdown();
        } catch (Exception e) {
            System.out.println("Check files. Exception " + e);
        }
    }
}
