package edu.umb.cs681.hw08;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    private Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

 
	public Directory getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();

}