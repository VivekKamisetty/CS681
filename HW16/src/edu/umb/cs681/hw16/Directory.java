package edu.umb.cs681.hw16;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Directory extends FSElement {

    private ConcurrentLinkedQueue<FSElement> children = new ConcurrentLinkedQueue<FSElement>();
    private ConcurrentLinkedQueue<Directory> subDirectories = new ConcurrentLinkedQueue<Directory>();
    private ConcurrentLinkedQueue <File> files = new ConcurrentLinkedQueue<File>();
    

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



    public ConcurrentLinkedQueue<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return getChildren().size();
    }

    public ConcurrentLinkedQueue<Directory> getSubDirectories() {
        for( FSElement child : getChildren()) {
            if (child.isDirectory()) {
                subDirectories.add((Directory) child);
            }
        }
        return subDirectories;
    }

    public ConcurrentLinkedQueue<File> getFiles() {
        for( FSElement child : getChildren()) {
            if (child.isFile()) {
                files.add((File) child);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = this.getSize();
        for (FSElement element : this.getChildren()) {
            if (element.isDirectory()) {
                totalSize += ((Directory) element).getTotalSize();
            } else {
                totalSize += element.getSize();
            }
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
    
    @Override
    public void accept(FSVisitor v) {
        

    		v.visit(this);
//        System.out.println("accept from dir");
//        System.out.println(children);
    		for (FSElement e : children) {
    			e.accept(v);
        }
    } 
    }


