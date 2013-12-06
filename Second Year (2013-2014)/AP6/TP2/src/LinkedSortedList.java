package datastruct;

import java.lang.Comparable;
import java.util.Iterator;

/**
 * Class for the linked sorted list
 */
public class LinkedSortedList implements SortedList {
//Attributes
	private int size;
	private Element sentinel;
	@SuppressWarnings("rawtypes")
	private Class datType;

	
//Methods

	/**
	 * Constructor
	 * @throws RuntimeException if the class of the objects that we would use isn't comparable
	 */
	@SuppressWarnings(value={"rawtypes", "unchecked"})
	public LinkedSortedList(Class theType) throws RuntimeException {
		//Verification of the type of the objects contained in this list (must be comparable)
		Class comp = Comparable.class;

		//If not, throw an exception
		if (!comp.isAssignableFrom(theType)) {

			throw new RuntimeException ("Pre-condition not respected: " + theType.toString() + " doesn't implements Comparable!");
		}

		//Initialize the type of the elements of the list
		this.datType = theType;

		//Create and insert the sentinel in order to have an empty list
		this.sentinel = new Element(null, null);
		this.sentinel.next = this.sentinel;

		//Initialize the size of the list
		this.size = 0;
	}


	@Override
	@SuppressWarnings(value={"rawtypes", "unchecked"})
	public void insert(Comparable toInsert) {
		//If not the type required, prevents the user
		if (!(this.datType.isAssignableFrom(toInsert.getClass()))) {
			System.out.println("The type doesn't match!");
		}
		else {
			//The current begins to the next of the sentinel and the pastCurrent to the sentinel
			Element current = this.sentinel.next;
			Element pastCurrent = this.sentinel;

			//Parcourt of the list
			while ((current != this.sentinel) && (current.data.compareTo(toInsert) <= 0)) {
				current = current.next;
				pastCurrent = pastCurrent.next;
			}

			//Adding of the element
			Element elToInsert = new Element(current, toInsert);
			pastCurrent.next = elToInsert;

			//Increment the number of elements
			this.size = this.size + 1;
		}
	}


	@Override
	public boolean isEmpty() {
		boolean ret = false;

		//Verify if there's an element in the list
		if (this.sentinel.next == this.sentinel) {
			ret = true;
		}
		else {
			ret = false;
		}

		return ret;
	}
	

	@Override
	public int getSize() {
		return this.size;
	}


	@Override
	public String toString() {
		String ret = "";

		if (this.size <= 0) {
			ret = "Empty list!";
		}
		else {
			//Creation of the current
			Element iterat = this.sentinel.next;

			//Route of the sorted list
			for (int i = 1; i <= this.size; i++) {
				ret = ret + i + ": " + iterat.data.toString() +"\n";
				iterat = iterat.next;
			}
		}

		//Return the String
		return ret;
	}


	@Override
	@SuppressWarnings("rawtypes")
	public Iterator getIterator() {
		return new Itr();
	}


	/*########################################### Inner Classes ###########################################*/

	/**
	 * Class for the elements contained in the list
	 */
	@SuppressWarnings("rawtypes")
	private class Element {
	//Attributes
		Element next;
		Comparable data;

	//Methods
		/**
		 * Constructor
		 * @param data The data contained in the element
		 * @param next The link to the next element
		 */
		Element(Element theNext, Comparable theData) {
			this.next = theNext;
			this.data = theData;
		}
	}


	/*#######################################################################################################*/

	/**
	 * Class for the iterator
	 */
	@SuppressWarnings("rawtypes")
	private class Itr implements Iterator {
	//Attributes
		private Element current;
		private Element pastCurrent;

	//Methods
		/**
		 * Constructor
		 */
		private Itr() {
			//Initialise the current and past current to the sentinel
			this.current = LinkedSortedList.this.sentinel;
			this.pastCurrent = LinkedSortedList.this.sentinel;
		}


		/**
		 * Method to know if there's a next to the current iterator
		 * @return true if the iterator has a next, false if it's at the end of the list
		 */
		public boolean hasNext() {
			boolean ret = false;

			//Just verify the next of the current element
			if ((this.current.next == LinkedSortedList.this.sentinel) || (this.current.next == null) || (this.current.next.data == null)) {
				ret = false;
			}
			else {
				ret = true;
			}

			return ret;
		}


		/**
		 * Move the current iterator to the next element
		 * @return The data contained in the new current element
		 */
		public Element next() {
			Element ret = null;
			
			if (hasNext()) {
				//Move the iterator, the past current is the current
				this.pastCurrent = this.current;

				//Then the current became the next of the current
				this.current = this.current.next;

				//In the end, return the date contained in the new current
				ret = this.current;
			}
			else {
				System.out.println("Can't go to next");
			}
			
			return ret;
		}


		/**
		 * Delete the current element, the current became the past current
		 */
		public void remove() {
			//Verify if the current is the pastCurrent
			if (this.current == this.pastCurrent) {
				System.out.println("Can't remove, the current is the past current!");
			}

			//If not, then remove the current element
			else {
				//We link the past current to the next
				this.pastCurrent.next = this.current.next;

				//Then move the iterator to the past current
				this.current = this.pastCurrent;

				//Decrement the size of the list
				LinkedSortedList.this.size--;
			}
		}
	}
}