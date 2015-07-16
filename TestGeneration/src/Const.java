/** Homework 6 Q2
 * Const class extends Node. Const class produce constant.
 * Author : Fan CHEN
 * Date: Nov 5, 2010
 * Andrew ID: fanc
 * File Name: Const.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.text.NumberFormat;
import java.util.*;

public class Const extends Node {
	private double value;

	public Const() {
	}

	public Const(double d) {
		value = d;

	}

	public double eval(double[] data) {
		return value;
	}

	public int mySize() {
		return 1;
	}// mySize = 1 for constant

	public String toString() {
		NumberFormat f = NumberFormat.getInstance();
		f.setMaximumFractionDigits(3);
		String s = f.format(value);
		return s;
	}

	public void setChild(int position, Node n) {
	}

	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand) {
	}

}
