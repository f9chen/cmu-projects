/** 
 * HW 6 Q1
 * This program asks user for a file name. 
 * Then print out each letter in the file and the number of occurrances.
 * Author : Fan CHEN 
 * Date: Nov 18, 2011
 * Andrew ID: fanc
 * File Name: TestFrequencies.java
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */

import java.util.Scanner;

public class TestFrequencies {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of a file:");
		String fName = keyboard.nextLine();
		FindCharFrequencies findFrequencies = new FindCharFrequencies(fName);
		findFrequencies.buildCharFrequencyMap();
		System.out.println(findFrequencies.toString());
	}

}
