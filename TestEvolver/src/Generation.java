/*
 * Generated by Together A container of GPTrees.
 * 
 * Date: Dec 5, 2011 / 
 */

import java.util.*;
import java.text.*;

/** @author Fan CHEN */
public class Generation {
	private int numTrees;
	private GPTree[] population;
	private double[] fitness;

	/**
	 * 
	 * @return number of trees
	 */
	public int getNumTrees() {
		return numTrees;
	}

	/**
	 * 
	 * @return the new population array
	 */
	public GPTree[] getPopultation() {
		return population;
	}

	/**
	 * 
	 * @param index index of tree in the population
	 * @param gpt gptree to pass in
	 */
	public void setPolulation(int index, GPTree gpt) {
		population[index] = gpt;
	}

	/**
	 * * Specifies the number of GPTrees in this generation, the factories used
	 * to generate the individual trees, the maximum tree depth, and the Random
	 * object used.
	 * 
	 * @param numTrees
	 *            number of Trees in the generation
	 * @param o
	 *            a random operator
	 * @param t
	 *            a random terminal
	 * @param m
	 *            maximum depth
	 * @param r
	 *            random number
	 */
	Generation(int numTrees, OperatorFactory o, TerminalFactory t, int m,
			Random r) {
		this.numTrees = numTrees;
		population = new GPTree[numTrees];
		for (int i = 0; i < numTrees; i++)
			population[i] = new GPTree(o, t, m, r);
	}

	/**
	 * 
	 * @param numTrees
	 *            number of trees in the generation
	 * @param newPopulation
	 *            a array to contain new generation of trees
	 */
	Generation(int numTrees, GPTree[] newPopulation) {
		this.numTrees = numTrees;
		population = new GPTree[numTrees];
		for (int i = 0; i < numTrees; i++)
			population[i] = newPopulation[i];
	}

	/**
	 * Evaluate each tree in this generation, and set each tree's fitness value.
	 */
	/**
	 * Evaluate each tree in this generation, and set each tree's fitness value.
	 */
	public void evalAll(DataSet d) {
		fitness = new double[numTrees];
		for (int i = 0; i < numTrees; i++)
			fitness[i] = 1.0 / population[i].eval(d);
	}

	/**
	 * Print the symbolicEval of each tree, and its fitness value. Very lengthy!
	 */
	public void printAll() {
		for (int i = 0; i < numTrees; i++) {
			System.out.println(population[i]);
			System.out.println("This tree's fitness is "
					+ NumberFormat.getInstance().format(
							population[i].getFitness()));
		}
	}

	/** Prints the tree with the lowest fitness value. */
	public void printBestTree() {
		Arrays.sort(population);
		// printAll();
		// System.out.println(population[0]);
		System.out.println("Its fitness is " + population[0].getFitness());
	}

	/**
	 * Randomly choose a tree in Generation so that more fit trees are more
	 * likely to be choosen
	 */
	public GPTree chooseTreeProportionalToFitness(Random ran) {
		double totalValue = 0.00;
		double currentValue = 0.00;
		for (int i = 0; i < numTrees; i++) {
			totalValue += fitness[i];
		}
		double theLuckyNumber = ran.nextDouble() * totalValue;
		for (int j = 0; j < numTrees; j++) {
			currentValue += fitness[j];
			if (currentValue > theLuckyNumber) {
				return population[j];
			}
		}
		return null;
	}
}
