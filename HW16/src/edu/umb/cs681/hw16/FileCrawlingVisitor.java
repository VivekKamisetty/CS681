package edu.umb.cs681.hw16;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FileCrawlingVisitor implements FSVisitor {

	ConcurrentLinkedQueue<File> files = new ConcurrentLinkedQueue<File>();
    public void visit(Link link) {
        return;
    }

    public void visit(Directory dir) {
        return;
    }

    public void visit(File file) {
        files.add(file);
    }

    public ConcurrentLinkedQueue<File> getFiles() {
        return files;
    }
}