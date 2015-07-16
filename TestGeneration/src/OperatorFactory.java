/** Homework 6 Q2
 * OperatorFactory class produce a random operator.
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Mult.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.util.*;
    
public class OperatorFactory {
	private Node[] currentOps;
	private int numOps;//length of the array
	public OperatorFactory(Node[] n) {
		currentOps = n;
		numOps = n.length;
	}

	public Node getOperator(Random rand) {
		return (Node)currentOps[rand.nextInt(currentOps.length)].clone();
	}

	public int getNumOps() {
		return numOps;
	}

}
