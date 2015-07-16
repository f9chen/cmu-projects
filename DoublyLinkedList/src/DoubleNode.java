/**
 * The class DoubleNode holds two pointers and a character. It is used to --
 * represent a single node on a double linked list.
 * 
 * @author Fan Chen
 * @Date Jan 21, 2012
 */

public class DoubleNode extends java.lang.Object {
	private static Character character;
	private DoubleNode previous, next;

	/**
	 * Constructor with no arguments. Assign null values to previous, next and
	 * the null character to c.
	 */
	public DoubleNode() {
		previous = null;
		character = '\u0000';
		next = null;
	}

	/**
	 * Assign node to previous, next node. Assign character to c.
	 * 
	 * @param p
	 *            is a pointer to a previous node.
	 * @param ch
	 *            is a character for this node.
	 * @param n
	 *            is a pointer to a next node.
	 */
	public DoubleNode(DoubleNode p, char ch, DoubleNode n) {
		previous = p;
		character = new Character(ch);
		next = n;
	}

	/**
	 * runtime complexity: Theta(1)
	 * get the character of Node
	 * @return the character
	 */
	public char getC() {
		return character.charValue();
	}

	/**
	 * runtime complexity: Theta(1)
	 * get the next node
	 * @return the next node
	 */
	public DoubleNode getNext() {
		return next;
	}

	/**
	 * runtime complexity: Theta(1)
	 * get the previous
	 * @return previous node
	 */
	public DoubleNode getPrev() {
		return previous;
	}

	/**
	 * runtime complexity: Theta(1)
	 * set the character to the current node
	 * @param c character that you want to set into the function
	 */
	public void setC(char c) {
		character = new Character(c);
	}

	/**
	 * runtime complexity: Theta(1)
	 * set the next character
	 * @param next next Node
	 */
	public void setNext(DoubleNode next) {
		this.next = next;
	}

	/**
	 * runtime complexity: Theta(1)
	 * set the previous node
	 * @param prev previous node
	 */
	public void setPrev(DoubleNode prev) {
		this.previous = prev;
	}

	/**
	 * runtime cannot be decided because hard to decide what is going on inside toString()
	 */
	@Override
	public String toString() {
		//if(character == '\u0000')
			//return "||";
		//else
			return character.toString();
		
	}
	
	/**
	 * runtime complexity: Theta(1)
	 * Test driver for DoubleNode
	 */
	public static void main(String a[]) {
		DoubleNode node = new DoubleNode();
		System.out.println(node);
	}

}
