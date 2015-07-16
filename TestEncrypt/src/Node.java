/**
 * @FileName Node.java
 * @Description serve as a simple node class, contain a biginteger object
 * @author Fan Chen
 * @Date Jan 28, 2012
 * @Compiler Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 */
import java.math.*;

public class Node {
	private BigInteger content;
	private Node next;
	/**
	 * Constructor with no argument
	 */
	public Node(){
		content = null;
		next = null;
	}
	/**
	 * Constructor with arguments
	 * @param num the number stored in the node
	 * @param n next node
	 */
	public Node(BigInteger num, Node n){
		content = num;
		next = n;
	}	
	/**
	 * runtime complexity: Theta(1)
	 * Set the integer value
	 * @param i interger
	 */
	public void setInt(BigInteger num){
		content = num;
	}	
	/**
	 * runtime complexity: Theta(1)
	 * @return the BigInter format content of the node
	 */
	public BigInteger getInt(){
		return content;
	}	
	/**
	 * runtime complexity: Theta(1)
	 * @param n the next Node
	 */
	public void setNext(Node n){
		next = n;	
	}
	/**
	 * runtime complexity: Theta(1)
	 * @return the next Node
	 */
	public Node getNext(){
		return next;
	}
}
