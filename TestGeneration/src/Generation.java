import java.util.Random;

/**
 * Homework 6 Q2 A container of GPTrees. Author : Fan CHEN Date: Nov 16, 2010
 * Andrew ID: fanc File Name: Generation.java; Compiler: Eclipse SDK Version:
 * 3.7.0 Build id: I20110613-1736
 */

public class Generation {
	/**
	 * @param numTrees
	 *            number of trees in the generation
	 * @param population
	 *            an array of GPTree, contains GPTrees in the generation
	 * @param fitness
	 *            an array of double, contains fitness of all trees in the
	 *            generation
	 **/

	private int numTrees;
	private GPTree[] population;
	private double[] fitness;

	/**
	 * Specifies the number of GPTrees in this generation, the factories used to
	 * generate the individual trees, the maximum tree depth, and the Random
	 * object used.
	 */
	Generation(int numTrees, OperatorFactory o, TerminalFactory t, int m,
			Random r) {
		this.numTrees = numTrees;
		population = new GPTree[numTrees];
		fitness = new double[numTrees];
		for (int i = 0; i < numTrees; i++)
			population[i] = new GPTree(o, t, m, r);
	}

	Generation(int n) {
		numTrees = n;
		population = new GPTree[numTrees];
		fitness = new double[numTrees];
	}

	/**
	 * Evaluate each tree in this generation, and set each tree's fitness value.
	 */
	public void evalAll(DataSet theData) {
		for (int i = 0; i < numTrees; i++) {
			fitness[i] = population[i].eval(theData);
		}
	}

	public GPTree getTree(int i) {
		return population[i];
	}

	/** Prints the tree with the lowest fitness value. */
	public void printBestTree() {
		int index = 0;
		double smallestFitness = fitness[0];
		for (int i = 0; i < numTrees; i++) {
			if (fitness[i] < smallestFitness) {
				smallestFitness = fitness[i];
				index = i;
			}
		}
		System.out.println("The best GPTree in this generation is \n"
				+ population[index].toString() + '\n' + "The best fitness = "
				+ fitness[index]);
	}

	public int getNumTrees() {
		return numTrees;
	}

	public void printGeneration() {
		for (int i = 0; i < numTrees; i++) {
			System.out.println(population[i].toString() + '\n' + "fitness = "
					+ fitness[i]);
		}
	}
}
