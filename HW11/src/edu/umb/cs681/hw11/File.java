package edu.umb.cs681.hw11;
import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class File extends FSElement {

    File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        // TODO Auto-generated constructor stub
        if (parent != null)
        {
            //System.out.println("File Appending....");
            parent.appendChild(this);

        }
    }

    @Override
    public boolean isDirectory() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFile() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isLink() {
        return false;
    }
    
    @Override
    public void accept(FSVisitor v) {
    	lock.lock();
//        System.out.println("accept from file");
    	try {
        v.visit(this);
    	} finally {
    		lock.unlock();
    	}

}
}
