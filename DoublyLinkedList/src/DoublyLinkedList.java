/**
 * @FileName testDoublyLinkedList.java
 * @Description Test a simple doubly linked list
 * @author Fan Chen
 * @Date Jan 21, 2012
 * @Compiler Eclipse SDK  Version: 3.7.0  Build id: I20110613-1736
 *
 * This class implements a doubly linked list of characters in Java. -- The
 * instance variables head and tail are initially null. -- As elements are added
 * head points to the first element on the list-- and tail points to the last
 * element. -- Each node on the list is of type DoubleNode. -- Each DoubleNode
 * holds a pointer to the previous node and a -- pointer to the next node in the
 * list.
 * 
 * @author Fan Chen
 * 
 */
public class DoublyLinkedList extends java.lang.Object {
	DoubleNode head;
	DoubleNode tail;

	/**
	 * Constructs a new DoublyLinkedList object with head and tail as null.
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * returns true if this container is empty.
	 * 
	 * @return true if the list empty false otherwise
	 */
	public boolean isEmpty() {
		return (head == tail && head == null);
	}

	/**
	 * Add a character node containing the character c to the end of the linked
	 * list.-- This routine does not require a search.
	 * runtime analysis: Theta(1)
	 * @param c
	 *            a single character
	 */
	public void addCharAtEnd(char c) {
		if (isEmpty()) {
			DoubleNode newNode = new DoubleNode(null, c, null);
			head = tail = newNode;
		} else {
			DoubleNode cursor = tail;
			DoubleNode newNode = new DoubleNode(cursor, c, null);
			cursor.setNext(newNode);
			tail = newNode;
		}
	}

	/**
	 * Add a character node containing the character c to the front of the
	 * linked list. -- No search is required.
	 * runtime analysis: Theta(1)
	 * @param c
	 *            a single character
	 */
	public void addCharAtFront(char c) {
		if (isEmpty()) {
			DoubleNode newNode = new DoubleNode(null, c, null);
			head = tail = newNode;
		} else {
			DoubleNode cursor = head;
			DoubleNode newNode = new DoubleNode(null, c, cursor);
			cursor.setPrev(newNode);
			head = newNode;
		}
	}

	/**
	 * Remove and return the character at the front of the doubly linked list.
	 * runtime anlysis: Theata(1)
	 * @return the character at the front
	 * @precondition the list is not empty
	 */

	public char removeCharFromFront() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty list.");
		} else {
			char ch = head.getC();
			if (head.getNext() == null) {
				head = tail = null;
			} else {
				head.getNext().setPrev(null);
				head = head.getNext();
			}
			return ch;
		}
	}

	/**
	 * Remove and return the character at the end of the doubly linked list. No
	 * searching is required.
	 * runtime analysis: Theta(1)
	 * @return the character at the end of the doubly linked list
	 */
	public char removeCharAtEnd() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty list.");
		} else {
			char ch = tail.getC();
			if (tail.getPrev() == null) {
				head = tail = null;
			} else {
				tail.getPrev().setNext(null);
				tail = tail.getPrev();
			}
			return ch;
		}
	}

	/**
	 * Counts the number of nodes in the list. We are not maintaining a counter
	 * so a search is required.
	 * runtime analysis: theta(n)
	 * @return the number of nodes in the doubly linked list between head and
	 *         tail inclusive
	 */
	public int countNodes() {
		if (isEmpty()) {
			return 0;
		} else {
			int count = 0;
			DoubleNode cursor = head;
			while (cursor != null) {// not eol
				count++;
				cursor = cursor.getNext();
			}
			return count;
		}
	}

	/**
	 * Deletes the first occurence of the character c from the list.-- If the
	 * character c is not in the list then no modifications are made.-- This
	 * method needs to search the list.
	 * best case runtime analysis: theta(1)
	 * worst case runtime analysis: theta(n)
	 * @param c
	 *            the character to be searched for.
	 * @return true if a deletion occurred and false otherwise
	 */
	public boolean deleteChar(char c) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty list.");
		} else {
			DoubleNode cursor = head;
			while (cursor != null) {
				if (cursor.getC() == c) {
					if (cursor == head) {
						removeCharFromFront();
					} else if (cursor == tail) {
						removeCharAtEnd();
					} else {
						cursor.getPrev().setNext(cursor.getNext());
						cursor.getNext().setPrev(cursor.getPrev());
					}
					return true;
				}
				cursor = cursor.getNext();
			}
			return false;
		}
	}

	/**
	 * runtime cannot be decided because hard to decide what is going on inside toString()
	 * Returns the list as a String. -- The class DoubleNode has a toString that
	 * will be called from this toString. -- The String returned must be
	 * presented clearly. -- Null pointers must be represented differently than
	 * non-null pointers.
	 * 
	 * @return a String containing the characters in the list
	 */
	@Override
	public java.lang.String toString() {
		if (isEmpty()) {
			return "";
		} else {
			String result = "";
			DoubleNode cursor = head;
			while (cursor != null) {// not eol
				result += cursor;
				cursor = cursor.getNext();
			}
			return result;
		}
	}

	/**
	 * Reverse the list. a -> b -> c becomes c -> b -> a
	 * runtime complexity: Theta(n)
	 */
	public void reverse() {
		{
			if (isEmpty())
				return;
			DoubleNode previous = head;
			DoubleNode current = head.getNext();
			head.setNext(null);
			while (current != null) {
				DoubleNode next = current.getNext();
				current.setNext(previous);
				previous = current;
				current = next;
			}
			head = previous;
		}
	}
	
	public static void main(String a[]) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addCharAtEnd('H');
		list.addCharAtEnd('e');
		list.addCharAtEnd('l');
		list.addCharAtEnd('l');
		list.addCharAtEnd('o');
		System.out.println(list);
		System.out.println("Deleting l");
		list.deleteChar('l');
		System.out.println(list);
		System.out.println("Deleting H");
		list.deleteChar('H');
		System.out.println(list);
		System.out.println("Deleting o");
		list.deleteChar('o');
		System.out.println(list);
		System.out.println("Deleting e");
		list.deleteChar('e');
		System.out.println(list);
		System.out.println("Deleting l");
		list.deleteChar('l');
		System.out.println(list);
		list.addCharAtFront('o');
		list.addCharAtFront('l');
		list.addCharAtFront('l');
		list.addCharAtFront('e');
		list.addCharAtFront('H');
		System.out.println(list);

		System.out.println(list.countNodes());

		System.out.println("Popping everything");
		while (!list.isEmpty()) {
			System.out.println(list.removeCharFromFront());
		}

		list.addCharAtFront('o');
		list.addCharAtFront('l');
		list.addCharAtFront('l');
		list.addCharAtFront('e');
		list.addCharAtFront('H');

		System.out.println("Popping everything from the end");
		while (!list.isEmpty()) {
			System.out.println(list.removeCharAtEnd());
		}
		System.out.println(list.countNodes());

		list.addCharAtEnd('o');
		list.addCharAtEnd('l');
		list.addCharAtEnd('l');
		list.addCharAtEnd('e');
		list.addCharAtEnd('H');

		list.reverse();
		System.out.println(list);

		list.reverse();
		System.out.println(list);
	}
}
