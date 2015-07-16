/** Homework 6 Q2
 * Extend Binop. Add two numbers up.
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Plus.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
public class Plus extends Binop {
	public Plus() {
	}

	public Plus(Node l, Node r) {
		super(l, r);
	}

	public double eval(double[] data) {
        return lChild.eval(data) + rChild.eval(data);
    }

	public String toString() {
		return new String("(" + lChild + " + " + rChild + ")");
	}
}
