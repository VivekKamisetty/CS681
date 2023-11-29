package edu.umb.cs681.hw11;
import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {

    LinkedList<File> files = new LinkedList<File>();
    public void visit(Link link) {
        return;
    }

    public void visit(Directory dir) {
        return;
    }

    public void visit(File file) {
        files.add(file);
    }

    public LinkedList<File> getFiles() {
        return files;
    }
}