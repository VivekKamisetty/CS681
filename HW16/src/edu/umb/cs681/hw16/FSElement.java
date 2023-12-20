package edu.umb.cs681.hw16;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    private Directory parent;
    
    FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent() {

//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	return this.parent;
        }

    

    public String getName() {

//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	return this.name;

    }

    public int getSize() {

//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	return this.size;

    }

    public LocalDateTime getCreationTime() {

//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	return this.creationTime;

    }

    public void setParent(Directory parent) {

//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	this.parent = parent;

    }

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();
    
    public abstract void accept(FSVisitor v);
}