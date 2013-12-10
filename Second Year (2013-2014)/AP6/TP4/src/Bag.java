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
	/** 
	 * Constructor of the Bag
	 */
	public Bag() {
		this.size = 0;
		this.sentinel = new Element(null, null);
		this.sentinel.next = this.sentinel;
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
		 * @param val The value contained in it
		 * @param key His key
		 */
		Element(E data, Element next) {
			this.data = data;
			this.next = next;
		}
	}



	/**
	 * Class for the iterator
	 */
	private class Itr {
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