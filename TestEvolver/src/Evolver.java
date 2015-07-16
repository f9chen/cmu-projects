import java.util.Random;

/**  
 * @author Fan CHEN
 */
public class Evolver {
	private static Random ran;
	private DataSet ds;
	/**
	 * @param ds
	 *            pass in the dataset
	 */
	private GPTree[] newPopulation;
	/**
	 * @param newPopulation
	 *            contains new generation of trees
	 */
	private Generation g;

	/**
	 * @param g
	 *            contains old generation
	 */

	/** Construct a better generation of trees and replace the old generation */
	public Evolver(Generation generation, DataSet dataSet, Random r) {
		ran = r;
		g = generation;
		ds = dataSet;
	}

	/** Generate a better generation of trees and replace the old generation */
	public Generation makeNewGeneration() {
		newPopulation = new GPTree[g.getNumTrees()];
		g.evalAll(ds);
		int loopNum;
		if (g.getNumTrees() % 2 == 0)
			loopNum = g.getNumTrees() / 2;
		else
			loopNum = (g.getNumTrees() - 1) / 2;
		//solve the problem of odd number of NumTrees.
		for (int i = 0; i < loopNum; i++) {
			GPTree t1 = g.chooseTreeProportionalToFitness(ran).duplicate();
			GPTree t2 = g.chooseTreeProportionalToFitness(ran).duplicate();
			crossover(t1, t2, ran);
			newPopulation[i] = t1;
			newPopulation[loopNum * 2 - 1 - i] = t2;
		}
		return new Generation(g.getNumTrees(), newPopulation);
	}

	/**
	 * Choose a clip point randomly and switch the children of two trees.
	 * 
	 * @param t1
	 *            first tree to cross over
	 * @param t2
	 *            second tree to cross over
	 * @param rand
	 *            random number help to decide clip point
	 */
	public void crossover(GPTree t1, GPTree t2, Random rand) {
		NodePairPlus pair1 = t1.randomParentAndChild(rand);
		NodePairPlus pair2 = t2.randomParentAndChild(rand);
		pair1.parent.changeChild(pair1.child, pair2.child);
		pair2.parent.changeChild(pair2.child, pair1.child);
	}

}
