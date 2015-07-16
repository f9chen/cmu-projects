/** 
 * Homework 6 Q2
 * GPTree class generate a tree with random nodes.
 * Author : Fan CHEN
 * Date: Nov 16, 2010
 * Andrew ID: fanc
 * File Name: GPTree.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.util.*;

public class GPTree {
	/**
	 * @param mySize # of nodes in the tree
	 * @param fitness GPTree eval() returns the fitness of the tree
	 */
	private Node root;
	private int mySize;
	double fitness = 0;

	GPTree() {
		root = null;
	}

	GPTree(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand) {
		root = o.getOperator(rand);
		root.addRandomKids(o, t, maxDepth, rand);
	}

	public String toString() {
		return root.toString();
	}

	public double eval(DataSet data) {
		Iterator<DataRow> i = data.list.iterator();
		while(i.hasNext()){
			DataRow element = i.next();
			fitness += ((element.getYValue()) - root.eval(element.getXValues()))
					* (element.getYValue() - root.eval(element.getXValues()));
		}
		return fitness;
	}

	public int mySize() {
		mySize = root.mySize();
		return mySize;
	}
}
