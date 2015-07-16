/** Homework 6 Q2
 * OperatorFactory class produce a constant or a variable
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Mult.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.util.*;

public class TerminalFactory {

	private static int numIndepVars;

	/**
	 * Sets the range of X-variables that this factory can supply.
	 * 
	 * @param n
	 *            The number of independent variables.
	 */
	public TerminalFactory(int n) {
		numIndepVars = n;
	}

	/**
	 * Returns a randomly selected Variable or Const. The selection is uniform
	 * over the range [X0, X1,...Xn, Const]
	 */
	public Node getTerminal(Random rand) {
		Node n;
		int i = rand.nextInt(numIndepVars + 1);
		if (i < numIndepVars)
			n = new Variable(i);
		else
			n = new Const(rand.nextDouble());
		return n;
	}

	public int getNumIndepVars() {
		return numIndepVars;
	}
}
