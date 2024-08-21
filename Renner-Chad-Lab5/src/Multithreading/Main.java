package Multithreading;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("seperate file names with a space. Total and individual word count will be printed: ");
		String inputFiles = input.nextLine();
		String[] FileNames = inputFiles.split(" ");
		for (String filename : FileNames) {
			File file = new File(filename);
			CountWords thread = new CountWords(file);
			thread.start();
		}
		input.close();
	}
}
