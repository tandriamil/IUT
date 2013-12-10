package datastruct;

import java.util.Iterator;
import java.util.AbstractCollection;

/**
 * Class for the Bag Collection
 */
public class Bag<E> {
//Attributes
	private Element sentinel;
	private int size;


//Methods
//The most of them are already defined in AbstractCollection so no need to define them
//Like toString(), isEmpty(), contains(Object o), remove(Object o)
	/** 
	 * Constructor of the Bag
	 */
	public Bag() {
		//Initializing the size
		this.size = 0;

		//Initializing the first element
		this.sentinel = new Element(null, null);
		this.sentinel.next = this.sentinel;
	}

	/**
	* Creation of a new Iterator
	* @return The new Iterator
	*/
	public Iterator getIterator() {
		return new Itr();
	}

	/** 
	* Redefinition of the abstract method in AbstractCollection<E>
	* @return A boolean at false if the size is over Integer.MAX VALUE
	*/
	public boolean add(E data) {
			Element = new Element (data);
			boolean ret = false;

			// Recuperation of the index at which we want to insert
			// the new element created
			int index = (int)(Math.random()*(size+1));

			return ret;
	}

	/**
	* Accesor of the private size attribute
	* @return The size of the list
	*/
	public int getSize() {
		return this.size;
	}


	/*########################################### Inner Classes ###########################################*/

 	/**
 	 * Class for the elements of this Bag Collection
 	 */
 	private class Element {
	//Attributes
		E data;
		Element next;


	//Methods
		/**
		 * Constructor of Element
		 * @param data The data of this Element
		 */
		Element(E data) {
			this.data = data;
		}
	}

		


	/*#####################################################################################################*/


	/**
	 * Class for the iterator
	 */
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
			this.current = Bag.this.sentinel;
			this.pastCurrent = Bag.this.sentinel;
		}


		/**
		 * Method to know if there's a next to the current iterator
		 * @return true if the iterator has a next, false if it's at the end of the list
		 */
		public boolean hasNext() {
			boolean ret = false;

			//Just verify the next of the current element
			if ((this.current.next == Bag.this.sentinel) || (this.current.next == null) || (this.current.next.data == null)) {
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
				Bag.this.size--;
			}
		}
	}
}