package edu.umb.cs681.hw11;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class Link extends FSElement {


    private FSElement target;

    Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        // TODO Auto-generated constructor stub
        this.target = target;
    }

    public void setTarget(FSElement target) {
        this.target = target;
    }

    public FSElement getTarget() {
        return target;
    }

    @Override
    public boolean isDirectory() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return true;
    }
    
    @Override
    public void accept(FSVisitor v) {
//        System.out.println("accept from link");
    	lock.lock();
    	try {
        v.visit(this);
    	} finally {
    		lock.unlock();
    	}
    }


}
