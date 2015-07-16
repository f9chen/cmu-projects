/*This program print line from a file when a substring is found.
 * Author : Fan CHEN (andrew ID: fanc)
 */

import java.util.*;
import java.io.*;

public class PrintSomeLines {

	public static void main(String[] args) {
	
		        Scanner keyboard = new Scanner(System.in);
		        String sub = "string";//define the substring here
		        System.out.println("Enter the name of a file to print some lines:");
		        String fName = keyboard.nextLine();
		        Scanner file = null;
		        String line;
		       
		        try {
		        	file = new Scanner(new File(fName));
		        }
		        catch (FileNotFoundException f) {
		        	System.out.println("Sorry, couldn't find that file.");
		        	System.exit(0);
		        }
		       
		        while(file.hasNextLine() == true) {
		        	line = file.nextLine();
		        	if(line.toUpperCase().indexOf(sub.toUpperCase()) != -1){ //case insensitivity
		        		System.out.println(line);
		        	}
		        }
		        System.out.println("We're done.");

	}

}
