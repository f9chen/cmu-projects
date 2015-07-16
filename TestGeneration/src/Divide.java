/**Homework 6 Q2
 * Extend Binop. Divide two numbers.
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Divide.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
public class Divide extends Binop {
	public Divide() {
	}

	public Divide(Node l, Node r) {
		lChild = l;
		rChild = r;
	}

	 public double eval(double[] data) {
	        if (Math.abs(rChild.eval(data)) < 0.0001)
	            return 1;
	        else
	        	return lChild.eval(data) / rChild.eval(data);
	    }
	// return the division of the two nodes.
		// If the divisor is really close to zero, then return 1.0 as
		// result.--"restricted division"

	public String toString() {
		return new String("(" + lChild + " / " + rChild + ")");
		// overwrite toString function
	}
}
