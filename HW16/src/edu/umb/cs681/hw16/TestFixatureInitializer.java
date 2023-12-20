package edu.umb.cs681.hw16;

import java.time.LocalDateTime;

public class TestFixatureInitializer {
	
	 protected Directory DriveC;
	    protected Directory src;
	    protected Directory lib;
	    protected Directory test;
	    protected Directory testSrc;

	    protected File a;
	    protected File b;
	    protected File c;
	    protected File d;
	    protected File x;
	    protected Link y;

	    protected Directory DriveD;
	    protected Directory programs;
	    protected Directory documents;
	    protected Directory pictures;

	    protected File program1;
	    protected File program2;
	    protected File report;
	    protected File presentation;
	    protected File nature;
	    protected File events;
	    protected File backup;

	    protected Directory DriveE;
	    protected Directory projects;
	    protected Directory music;

	    protected File notes;
	    protected File projectA;
	    protected File script;
	    protected File main;
	    protected File UI;
	    protected File UX;
	    protected File playlist1;
	    protected File playlist2;

	    public void FileSystem1() {
	        LocalDateTime localDateTime = LocalDateTime.now();

	        DriveC = new Directory(null, "DriveC", 100, localDateTime);
	        src = new Directory(DriveC, "src", 100, localDateTime);
	        lib = new Directory(DriveC, "lib", 100, localDateTime);
	        test = new Directory(DriveC, "test", 100, localDateTime);
	        testSrc = new Directory(test, "src", 100, localDateTime);

	        a = new File(src, "a", 25, localDateTime);
	        b = new File(src, "b", 25, localDateTime);
	        c = new File(lib, "c", 25, localDateTime);
	        d = new File(testSrc, "d", 25, localDateTime);
	        x = new File(DriveC, "x", 25, localDateTime);
	        y = new Link(DriveC, "y", 0, localDateTime, d);
	    }

	    public void FileSystem2() {
	        LocalDateTime localDateTime = LocalDateTime.now();

	        DriveD = new Directory(null, "DriveD", 100, localDateTime);
	        programs = new Directory(DriveD, "Programs", 100, localDateTime);
	        documents = new Directory(DriveD, "Documents", 100, localDateTime);
	        pictures = new Directory(DriveD, "Pictures", 100, localDateTime);

	        program1 = new File(programs, "Program1.exe", 25, localDateTime);
	        program2 = new File(programs, "Program2.exe", 25, localDateTime);
	        report = new File(documents, "Report.docx", 25, localDateTime);
	        presentation = new File(documents, "Presentation.pptx", 25, localDateTime);
	        nature = new File(pictures, "Nature.jpg", 25, localDateTime);
	        events = new File(pictures, "Events.png", 25, localDateTime);
	        backup = new File(DriveD, "Backup.zip", 25, localDateTime);
	    }

	    public void FileSystem3() {
	        LocalDateTime localDateTime = LocalDateTime.now();

	        DriveE = new Directory(null, "DriveE", 100, localDateTime);
	        projects = new Directory(DriveE, "Projects", 100, localDateTime);
	        music = new Directory(DriveE, "Music", 100, localDateTime);

	        notes = new File(DriveE, "Notes.txt", 25, localDateTime);
	        projectA = new File(projects, "ProjectA.docx", 25, localDateTime);
	        script = new File(projects, "script.py", 25, localDateTime);
	        main = new File(projects, "main.java", 25, localDateTime);
	        UI = new File(projects, "UI.jpg", 25, localDateTime);
	        UX = new File(projects, "UX.png", 25, localDateTime);
	        playlist1 = new File(music, "Playlist1.mp3", 25, localDateTime);
	        playlist2 = new File(music, "Playlist2.mp3", 25, localDateTime);
	    }

}
