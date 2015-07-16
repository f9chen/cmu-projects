/** 
 * HW6 Q1
 * CharFrequencies implements a HashMap.
 * Then print out each letter in the file and the number of occurrances.
 * Author : Fan CHEN 
 * Date : Nov. 18, 2011
 * Andrew ID: fanc
 * File Name: CharFrequencies.java
 * Compiler: Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */

import java.util.*;

public class CharFrequencies {

	public HashMap<Character, CharCount> hm = new HashMap<Character, CharCount>();

	// Generic version of HashMap.

	public void put(Character c) {
		if (hm.containsKey(c))
			((CharCount) hm.get(c)).i++;
		// Character already occurred.
		else
			hm.put(c, new CharCount());
		// First occurrance
		hm.re
	}
	
	

	public String toString() {
		String result = "";
		for (Character key = 'a'; key <= 'z'; key++) {
			if (hm.containsKey(key))
				result += "In this file " + key + " occurs "
						+ hm.get(key).toString() + " times!" + '\n';
		}
		return result;
	}
}
