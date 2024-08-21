package Multithreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountWords extends Thread {
	
	private File inputFile;
	private int wordCount;
	private static int totalWordCount;
	private static int activeThreads;
	
	public CountWords(File inputFile) {
		this.inputFile = inputFile;
	}
	public int getWordCount() {
		return wordCount;
	}
	private synchronized void addToTotal(int wordCount) {
		totalWordCount += wordCount;
	}
	private synchronized void registerThread () {
		activeThreads++;
	}
	private synchronized void unregisterThread() {
		activeThreads--;
	}
	public void run() {
		registerThread();
		try {
			Scanner file = new Scanner(inputFile);
			while (file.hasNext()) {
				wordCount++;
				file.next();
			}
			file.close();
			System.out.println(inputFile.getName() + ": " + wordCount);
			addToTotal(wordCount);
			unregisterThread();
			if (activeThreads == 0) {
				System.out.println("Total word count: " + totalWordCount);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
