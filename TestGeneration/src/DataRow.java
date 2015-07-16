/**
 * Homework 6 Q2
 * DataRow contains y value and x values as an array from a file
 * Author : Fan CHEN
 * Date: Nov 16, 2010
 * Andrew ID: fanc
 * File Name: DataRow.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */

public class DataRow {
	/**
	 * A DataRow object will hold a yvalue and an array of x values
	 * 
	 * @param yValue
	 *            y value of a datarow
	 * @param xValues[]
	 *            an array of x values in a datarow
	 */
	private double yValue;
	private double[] xValues;

	DataRow(double y, double[] x) {
		yValue = y;
		xValues = x;
	}

	public double getYValue() {
		return yValue;
	}

	public double[] getXValues() {
		return xValues;
	}

}
