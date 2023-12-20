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
        
        Thread thread3 = new Thread(() -> {
            FileSystem fs = FileSystem.getFileSystem();
            System.out.println("Thread 3: FileSystem instance created");
        });

        Thread thread4 = new Thread(() -> {
            FileSystem fs = FileSystem.getFileSystem();
            System.out.println("Thread 4: FileSystem instance created");
        });

        Thread thread5 = new Thread(() -> {
            FileSystem fs = FileSystem.getFileSystem();
            System.out.println("Thread 5: FileSystem instance created");
        });

        Thread thread6 = new Thread(() -> {
            FileSystem fs = FileSystem.getFileSystem();
            System.out.println("Thread 6: FileSystem instance created");
        });

        Thread thread7 = new Thread(() -> {
            FileSystem fs = FileSystem.getFileSystem();
            System.out.println("Thread 7: FileSystem instance created");
        });

        Thread thread8 = new Thread(() -> {
            FileSystem fs = FileSystem.getFileSystem();
            System.out.println("Thread 8: FileSystem instance created");
        });


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FileSystem fs = FileSystem.getFileSystem();
        System.out.println("Main Thread: FileSystem instance created");
    }

}
