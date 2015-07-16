/** Homework 6 Q2
 * Generate a variable and select value from an array.
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Plus.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.util.*;
public class Variable extends Node {
	private int index;

	public Variable() {
	}

	public Variable(int i) {
		index = i;
	}

	  /** Returns the value in data indexed by this Variable's index member. */
		public double eval(double[] data) {
	        if (index < data.length)
	        	return data[index];
	        else {
	            System.out.println("Variable index exceeds data array length.");
	            return 0;
	        }
	    }
	
	public int mySize() { return 1; }//mySize = 1 for variable

	public String toString() {
		return new String("X" + index + "");
	}

	public void setChild(int position, Node n) {
	}

	public void addRandomKids(OperatorFactory o,
		    TerminalFactory t, int maxDepth, Random rand) {}

}
