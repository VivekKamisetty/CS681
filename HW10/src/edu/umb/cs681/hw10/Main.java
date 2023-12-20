package edu.umb.cs681.hw10;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static AtomicBoolean running = new AtomicBoolean(true);

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystem.getFileSystem();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                while (running.get()) {
                    fileSystem.getRootDirs();
                    System.out.println(Thread.currentThread().getName() + " accessing FS data");

                    if (!running.get()) {
                        break; 
                    }

                    try {
                        Thread.sleep(10); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            threads[i] = thread;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running.set(false);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " terminating...");
    }
}
