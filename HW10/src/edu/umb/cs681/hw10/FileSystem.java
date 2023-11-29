package edu.umb.cs681.hw10;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FileSystem {

    private final LinkedList<Directory> rootDirs;

    private static final AtomicReference<FileSystem> atomicRef = new AtomicReference<>();
    
    private FileSystem() {
        rootDirs = new LinkedList<Directory>();
    }

    //private static FileSystem fileSystem;

    public static FileSystem getFileSystem() {
    	
    	FileSystem  currentInstance = atomicRef.get();
    	
        if(currentInstance == null) {
        	
            FileSystem  newFileSystem = new FileSystem();
            
            if (atomicRef.compareAndSet(null, newFileSystem)) {
            	
            	currentInstance = newFileSystem;
            	
            } else {
            				
            	currentInstance = atomicRef.get();
            	
            }
            
        }
        return currentInstance;
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }
    
}