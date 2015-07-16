/** Homework 6 Q2
 * Node class is a base class for all binops, constants, and variables.
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Node.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.util.*;

public abstract class Node implements Cloneable {
	protected Node lChild, rChild;
	protected int depth = 0;

	public void setChild(int position, Node n) {
		if (position == 1) {
			lChild = n;
			lChild.depth = this.depth + 1;
		}// add a left child
		else {
			rChild = n;
			rChild.depth = this.depth + 1;
		}// add a right child
	}

	double eval(double[] data) {
		System.out.println("Error: eval Node");
		return 0;
	}
	
	public abstract int mySize();

	public String toString() {
		return "Error: eval Node";
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Node cannot clone!!");
		}
		return o;
	}

	public abstract void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand);
}
