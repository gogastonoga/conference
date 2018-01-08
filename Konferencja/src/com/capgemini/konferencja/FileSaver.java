package com.capgemini.konferencja;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileSaver {
	     
	    private String path;
	    private boolean addToFile = false;
	     
	    public FileSaver(String pathToFile){
	        path = pathToFile;
	    }
	     
	    public FileSaver(String pathToFile, boolean addValue){
	        path = pathToFile;
	        addToFile = addValue;
	    }
	     
	public void saveToFile(String textLine) throws IOException {
		FileWriter write = new FileWriter(path, addToFile);
		PrintWriter printLine = new PrintWriter(write);

		printLine.printf("%s" + "%n", textLine);
		printLine.close();
	}
	     
	}
