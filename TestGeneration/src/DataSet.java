import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Homework 6 Q2
 * DataSet is a container of DataRow
 * Author : Fan CHEN
 * Date: Nov 16, 2010
 * Andrew ID: fanc
 * File Name: DataRow.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
public class DataSet {
	private Scanner file = null;

	/**
	 * the DataSet constructor takes an String as argument, open the file, and
	 * add all dataRow into itself
	 */
	DataSet(String fName) {
		try {
			file = new Scanner(new File(fName));
		} catch (FileNotFoundException f) {
			System.out.println("Sorry, couldn't find that file.");
			System.exit(0);
		}
		fillDataSet();
	}

	/**
	 * @param list
	 *            hold an ArrayList of DataRow objects
	 * */
	ArrayList<DataRow> list = new ArrayList<DataRow>();

	/**
	 * return the size of list
	 * */
	public int size() {
		return list.size();
	}

	/**
	 * fill the DataSet with each row
	 * 
	 * @param arrSize
	 *            how many variables, also is the size of the array Variable()
	 *            takes in
	 * @param arrListSize
	 *            how many rows of DataRow
	 */
	public void fillDataSet() {
		int arrSize = file.nextInt();
		int arrListSize = file.nextInt();
		for (int i = 0; i < arrListSize; i++) {
			double yValue = file.nextDouble();
			double[] xValues = new double[arrSize];
			for (int count = 0; count < arrSize; count++) {
				xValues[count] = file.nextDouble();
			}
			list.add(i, new DataRow(yValue, xValues));
		}
	}

}
