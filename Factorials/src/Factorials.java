/* This is my own for loop to calculate factorials up to 50!
 * Author : Fan CHEN 
 * Andrew ID: fanc
 * File Name: Factorials.java
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */

import java.math.BigInteger;
public class Factorials {
	public static void main(String args[]) {
		// Calculate factorials with an int
		// Use BigInterger class to avoid data overflow.
		BigInteger bigFactorial = new BigInteger("1");
		bigFactorial = BigInteger.valueOf(1);
		for (int i = 2; i <= 50; i++) {
			bigFactorial = bigFactorial.multiply(BigInteger.valueOf(i));
			System.out.println(i + "! = " + bigFactorial);
		}
		System.out.println("Above is Factorial from 2 to 50. Enjoy~");

	}
}
