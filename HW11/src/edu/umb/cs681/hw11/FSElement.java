package edu.umb.cs681.hw11;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    private Directory parent;
    public static ReentrantLock lock = new ReentrantLock();
    
    FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        this.lock.lock();
        try {
//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	return this.parent;
        }
        finally {
        	lock.unlock();
//        	System.out.println(Thread.currentThread().getName() + " released lock");
        }
    }

    public String getName() {
        this.lock.lock();
        try {
//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	return this.name;
        }
        finally {
        	lock.unlock();
//        	System.out.println(Thread.currentThread().getName() + " released lock");
        }
    }

    public int getSize() {
        this.lock.lock();
        try {
//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	return this.size;
        }
        finally {
        	lock.unlock();
//        	System.out.println(Thread.currentThread().getName() + " released lock");
        }
    }

    public LocalDateTime getCreationTime() {
        this.lock.lock();
        try {
//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	return this.creationTime;
        }
        finally {
        	lock.unlock();
//        	System.out.println(Thread.currentThread().getName() + " released lock");
        }
    }

    public void setParent(Directory parent) {
        this.lock.lock();
        try {
//            System.out.println(Thread.currentThread().getName() + " acquired lock");
        	this.parent = parent;
        }
        finally {
        	lock.unlock();
//        	System.out.println(Thread.currentThread().getName() + " released lock");
        }
    }

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();
    
    public abstract void accept(FSVisitor v);
}
