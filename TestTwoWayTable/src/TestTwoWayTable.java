/*
 * Description:This program reads in an array and display it in a neat format
 * and also calculation sum of rows, columns and total.
 * Author: Fan CHEN
 * Andrew ID: fanc
 * File Name: MonteHallParadox.java; Game.java;
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
public class TestTwoWayTable {
    public static void main(String[] args) {
        int[][] testArray = {
          	{2, 5, 6, 3}, {9, 4, 4, 7}, 
{1, 10, 2, 3}, {8, 4, 5, 3} };

        TwoWayTable t = new TwoWayTable(testArray);
        System.out.println(t);
	}
}

