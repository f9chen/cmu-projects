/** 
 * HW 6 Q 1
 * FindCharFrequencies can built a HashMap to store the characters and their occcurrance.
 * Author : Fan CHEN 
 * Date: Nov. 18, 2011
 * Andrew ID: fanc
 * File Name: 
 * FindCharFrequencies.java
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindCharFrequencies {
	Scanner file = null;
	CharFrequencies cf = new CharFrequencies();

	FindCharFrequencies(String fileName) {
		try {
			file = new Scanner(new File(fileName));
		} catch (FileNotFoundException f) {
			System.out.println("Sorry, couldn't find that file.");
			System.exit(0);
		}
	}

	// read in a file

	void buildCharFrequencyMap() {
		while (file.hasNextLine() == true) {
			// not the EOF
			String line = file.nextLine();
			// read in next line of the file as string
			for (int i = 0; i < line.length(); i++) {
				Character ch = line.toLowerCase().charAt(i);
				// boxing the character. case insensitive.
				if (Character.isLetter(ch)) {
					cf.put(ch);
					// use hashmap to store
				}
			}
		}
	}

	public String toString() {
		return cf.toString();
	}
}
