package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class Directory extends FSElement {

    private LinkedList<FSElement> children = new LinkedList<FSElement>();
    private LinkedList<Directory> subDirectories = new LinkedList<Directory>();
    private LinkedList <File> files = new LinkedList<File>();
    private ReentrantLock lock = new ReentrantLock();


    Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        // TODO Auto-generated constructor stub
        if (parent != null)
        {
            //System.out.println("Appending....");
            parent.appendChild(this);

        }
        //System.out.println("else Appending....");

    }



    public LinkedList<FSElement> getChildren() {
    	 lock.lock();
         try {
             return this.children;
         } finally {
             lock.unlock();
         }
    }

    public void appendChild(FSElement child) {
        
        lock.lock();
        try {
            this.children.add(child);
            child.setParent(this);
        } finally {
            lock.unlock();
        }
    }

    public int countChildren() {
        
        lock.lock();
        try {
            return getChildren().size();
        } finally {
            lock.unlock();
        }
    }

    public LinkedList<Directory> getSubDirectories() {
         lock.lock();
         try {
             for (FSElement child : this.children) {
                 if (child.isDirectory()) {
                     subDirectories.add((Directory) child);
                 }
             }
         } finally {
             lock.unlock();
         }
         return subDirectories;
    }

    public LinkedList<File> getFiles() {
    	 lock.lock();
         try {
             for (FSElement child : this.children) {
                 if (child.isFile()) {
                     files.add((File) child);
                 }
             }
         } finally {
             lock.unlock();
         }
         return files;
    }

    public int getTotalSize() {
    	int totalSize = this.getSize();
        lock.lock();
        try {
            for (FSElement element : this.children) {
                if (element.isDirectory()) {
                    totalSize += ((Directory) element).getTotalSize();
                } else {
                    totalSize += element.getSize();
                }
            }
        } finally {
            lock.unlock();
        }
        return totalSize;
    }
    @Override
    public boolean isDirectory() {
        // TODO Auto-generated method stub
        return true;
    }



    @Override
    public boolean isFile() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }


}
