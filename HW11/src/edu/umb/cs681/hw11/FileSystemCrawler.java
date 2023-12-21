package edu.umb.cs681.hw11;

import java.util.ArrayList;
import java.util.List;

public class FileSystemCrawler {
    
    private static List<File> sharedList = new ArrayList<>();
    private static volatile boolean terminateFlag = false;
    private static ThreadLocal<FileCrawlingVisitor> threadLocalFileCrawler = ThreadLocal.withInitial(() -> new FileCrawlingVisitor());

    public static void main(String[] args) {
        TestFixatureInitializer fixatureInitializer = new TestFixatureInitializer();
        fixatureInitializer.FileSystem1();
        fixatureInitializer.FileSystem2();
        fixatureInitializer.FileSystem3();

        Thread thread1 = startCrawlingThread(fixatureInitializer.DriveC);
        Thread thread2 = startCrawlingThread(fixatureInitializer.DriveD);
        Thread thread3 = startCrawlingThread(fixatureInitializer.DriveE);


        try {
            
            while (!terminateFlag) {
                Thread.sleep(100);
            }

            terminateCrawlingThreads(new Thread[]{thread1, thread2, thread3});

            List<File> allFiles;
            allFiles = new ArrayList<>(sharedList);

            System.out.println("Identified Files:");
            for (File file : allFiles) {
                System.out.println(file.getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Thread startCrawlingThread(Directory drive) {
        Thread thread = new Thread(() -> {
            FileCrawlingVisitor fileCrawler = threadLocalFileCrawler.get();
            drive.accept(fileCrawler);
            List<File> identifiedFiles = fileCrawler.getFiles(); 
                sharedList.addAll(identifiedFiles);
            terminateFlag = true;
        });
        thread.start();
        return thread;
    }

    private static void terminateCrawlingThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
