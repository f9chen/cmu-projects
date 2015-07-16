/** Homework 6 Q2
 * Extend Binop. Multiply two numbers.
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Mult.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
public class Mult extends Binop {
	public Mult() {
	}

	public Mult(Node l, Node r) {
		super(l, r);
	}

	public double eval(double[] data) {
		return lChild.eval(data) * rChild.eval(data);
	}

	public String toString() {
		return new String("(" + lChild + " * " + rChild + ")");
		// overwrite toString function
	}
}
