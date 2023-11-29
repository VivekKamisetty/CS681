package edu.umb.cs681.hw10;

import java.time.LocalDateTime;

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


}