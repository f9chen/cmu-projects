/* This program ask user for an interger and test wheather it's a prime or not.
 * Author : Fan CHEN 
 * Andrew ID: fanc
 * File Name: TestForPrime.java
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */


import java.util.Scanner;

public class TestForPrime {

	/**
	 * @param devisor the devisor being used to test prime
	 * @param testNumber the user's input of number
	 */
	public static void main(String[] args) {
		int devisor = 0;
		int testNumber = 0;
		while(testNumber < 1){
 	        System.out.println("Please input a interger that is positive and less than 2147483647!!");
 	        //prompt user the instructions
 	        Scanner keyboard = new Scanner(System.in);//set up var keyboard as scanner
 	        String input = keyboard.nextLine();
 	        try {
 	        	testNumber = Integer.parseInt(input);
 	        }
 	        catch(NumberFormatException nFE) {
 	        	System.out.println("Invalid Input!!");
 	        }
 	        if(testNumber < 1){
 	        	System.out.println("Invalid Input!!");
 	        }
 	        //if user's input is not valid, promt for new input
		}
		
		for(devisor = 2; devisor < 2147483647; devisor++){
			if(devisor % testNumber == 0)break;
		}
		
		if(devisor != testNumber || testNumber == 1){
			//if testNumber is 1, it is not a Prime!!!
			//if testNumber is not 1, and can be devided by other number other than 1 and itself
			//it is a prime.
			System.out.println("Not a Prime!! devisor="+ devisor);
		}
		else{
			System.out.println("Is a Prime!!");
		}

	}

}
