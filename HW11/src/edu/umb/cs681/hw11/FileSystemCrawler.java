package edu.umb.cs681.hw11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileSystemCrawler {
	private static List<File> sharedList = new ArrayList<>();
	private static AtomicBoolean terminateFlag = new AtomicBoolean(false);
    private static ThreadLocal<FileCrawlingVisitor> threadLocalFileCrawler = ThreadLocal.withInitial(() -> new FileCrawlingVisitor());
	
	public static void main(String [] args) {
		TestFixatureInitializer fixatureInitializer = new TestFixatureInitializer();
		
		fixatureInitializer.FileSystem1();
        fixatureInitializer.FileSystem2();
        fixatureInitializer.FileSystem3();
		
		Thread thread1 = new Thread(() -> {
			FileCrawlingVisitor fileCrawler1 = threadLocalFileCrawler.get();
			fixatureInitializer.DriveC.accept(fileCrawler1);
			sharedList.addAll(fileCrawler1.getFiles());
			terminateFlag.set(true);
		});
		
		Thread thread2 = new Thread(() -> {
			FileCrawlingVisitor fileCrawler2 = threadLocalFileCrawler.get();
			fixatureInitializer.DriveD.accept(fileCrawler2);
			sharedList.addAll(fileCrawler2.getFiles());
			terminateFlag.set(true);
		});
		
		Thread thread3 = new Thread(() -> {
			FileCrawlingVisitor fileCrawler3 = threadLocalFileCrawler.get();
			fixatureInitializer.DriveE.accept(fileCrawler3);
			sharedList.addAll(fileCrawler3.getFiles());
			terminateFlag.set(true);
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			while(!terminateFlag.get()) {
				Thread.sleep(100);
			}
			
			thread1.interrupt();
			thread2.interrupt();
			thread3.interrupt();
			
			List<File> allFiles = new ArrayList<>(sharedList);
			System.out.println("Identified Files: ");
			for (File file: allFiles) {
				System.out.println(file.getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
