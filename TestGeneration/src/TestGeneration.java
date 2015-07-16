import java.util.*;
/** Homework 6 Q2
 * Generate one Generation of trees and print out the best one. (with smallest fitness
 * Author : Fan CHEN
 * Date: Nov 16, 2010
 * Andrew ID: fanc
 * File Name: TestGeneration.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
public class TestGeneration {
	/**
	 * @param rand a random number used to generate random operators and terminals
	 * @param numIndepVars 
	 */

	public static void main(String[] args) {
		static Random rand = new Random();
		static int numIndepVars = 1;
		static int maxDepth = 3;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of a file:");
		String fName = keyboard.nextLine();
		Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
		OperatorFactory o = new OperatorFactory(ops);
        TerminalFactory t = new TerminalFactory(numIndepVars);
		Generation g = new Generation(500, o, t, maxDepth,
				rand);
		DataSet ds = new DataSet(fName);
		g.evalAll(ds);
		g.printBestTree();	
	}
}
