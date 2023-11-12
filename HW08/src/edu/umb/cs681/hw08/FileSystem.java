package edu.umb.cs681.hw08;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystem {

    private final LinkedList<Directory> rootDirs;
    public static ReentrantLock lock = new ReentrantLock();

    private FileSystem() {
        rootDirs = new LinkedList<Directory>();
    }

    private static FileSystem fileSystem;

//    public static FileSystem getFileSystem() {
//        lock.lock();
//        try {
//        	if(fileSystem == null) {
//        		fileSystem = new FileSystem();
//        	}
//        } finally {
//        	lock.unlock();
//        }
//        return fileSystem;
//    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }

	public static FileSystem getFileSystem() {
		lock.lock();
        try {
        	if(fileSystem == null) {
        		fileSystem = new FileSystem();
        	}
        } finally {
        	lock.unlock();
        }
        return fileSystem;
    }
	}
