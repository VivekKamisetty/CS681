package edu.umb.cs681.hw08;

public class RunnableFileSystem {
	
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(() -> {
            FileSystem fs = FileSystem.getFileSystem();
            System.out.println("Thread 1: FileSystem instance created");
        });

        Thread thread2 = new Thread(() -> {
            FileSystem fs = FileSystem.getFileSystem();
            System.out.println("Thread 2: FileSystem instance created");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FileSystem fs = FileSystem.getFileSystem();
        System.out.println("Main Thread: FileSystem instance created");
    }

}
