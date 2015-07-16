/**
 * @FileName list.java
 * @Description container of node
 * @author Fan Chen
 * @Date Jan 28, 2012
 * @Compiler Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.math.BigInteger;

public class list {
	private Node head;
	private Node tail;
	
	/**
	 * constructor
	 * 
	 */
	public list() {
		head = null;
		tail = null;
	}

	/**
	 * returns true if this container is empty.
	 * runtime complexity: Theta(1)
	 * @return true if the list empty false otherwise
	 */
	public boolean isEmpty() {
		return (head == tail && head == null);
	}

	/**
	 * runtime complexity: Theta(1)
	 * Add a character node containing the character c to the end of the linked
	 * list.-- This routine does not require a search.
	 * @param c
	 *            an integer
	 */
	public void addIntAtEnd(BigInteger num) {
		if (isEmpty()) {
			Node newNode = new Node(num, null);
			head = tail = newNode;
		} else {
			Node cursor = tail;
			Node newNode = new Node(num, null);
			cursor.setNext(newNode);
			tail = newNode;
		}
	}
	
	/**
	 * runtime complexity: Theta(n)
	 * @param index
	 * @return
	 */
	public BigInteger getInt(int index){
		Node cursor = head;
		for(int i = 0; i < index; i++)
			cursor = cursor.getNext();
		return cursor.getInt();
	}
	
	/**
	 * runtime complexity: Theta(n)
	 * @param index
	 * @param value
	 */
	public void setInt(int index, BigInteger num){
		Node cursor = head;
		for(int i = 0; i < index; i++)
			cursor = cursor.getNext();
		cursor.setInt(num);
	}
}
