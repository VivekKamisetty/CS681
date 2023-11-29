package edu.umb.cs681.hw10;
import java.time.LocalDateTime;

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

}