/** Homework 6 Q2
 * Binop class extends Node. Binop is a base class of binary operators.
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Binop.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.util.*;

public abstract class Binop extends Node {

	public Binop() {
	}

	public Binop(Node l, Node r) {
		lChild = l;
		rChild = r;
	}
    
	public int mySize() { return lChild.mySize() + rChild.mySize() + 1; }
	//recursively caculate mySize. 
	//Every binop's mySize equals to the sum of mySize of its 2 children and itself.
	
	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand) {
		int i = rand.nextInt(t.getNumIndepVars() + o.getNumOps() + 1);
		// generate random number from 0 to (numOperators + numIndepVars)
		if (depth == maxDepth) {
			// if depth reach the mx depth, add termial to left and right
			setChild(1, t.getTerminal(rand));
			setChild(2, t.getTerminal(rand));
		} else {
			if (i < o.getNumOps()) {
				setChild(1, o.getOperator(rand));
				// add an operator as left child
			} else {
				setChild(1, t.getTerminal(rand));
				// otherwise add a terminal as the left child
			}
			if (i < o.getNumOps()) {
				setChild(2, o.getOperator(rand));
			} else {
				setChild(2, t.getTerminal(rand));
			}
			lChild.addRandomKids(o, t, maxDepth, rand);
			// call addRandomKid of left child
			rChild.addRandomKids(o, t, maxDepth, rand);
			// call addRandomKid of right child
		}
	}
}