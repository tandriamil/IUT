package datastruct;

import java.util.Iterator;
import java.util.AbstractCollection;

/**
 * Class for the Bag Collection
 */
public class Bag<E> extends AbstractCollection<E> {
//Attributes
	private Element sentinel;
	private int size;
	private int modCount;


//Methods
//The most of them are already defined in AbstractCollection so no need to define them
//Like toString(), isEmpty(), contains(Object o), remove(Object o)
	/**
	 * Constructor of the Bag
	 */
	public Bag() {
		//Initializing the size and the modCount
		this.size = 0;
		this.modCount = 0;

		//Initializing the first element
		this.sentinel = new Element(null);
		this.sentinel.next = this.sentinel;
	}


	/**
	* Creation of a new Iterator
	* @return The new Iterator
	*/
	@SuppressWarnings("unchecked")
	public Iterator<E> iterator() {
		return new Itr();
	}


	/**
	* Redefinition of the abstract method in AbstractCollection<E>
	* @return A boolean at false if the size is over Integer.MAX VALUE
	*/
	public boolean add(E data) {
		boolean ret = false;

		//Creation of a new element containing the piece of data
		Element toInsert = new Element(data);

		//If the bag contains nothing but the sentinel
		if (this.size == 0) {
			//The next of the sentinel is the element to insert and its own next is the sentinel
			this.sentinel.next = toInsert;
			toInsert.next = this.sentinel;

			//Incrementing the size, the synchronised attribute and telling that's the size is correct
			this.size++;
			ret = true;
			this.modCount++;
		}

		//If the size is too high (Really really high!)
		else if (this.size >= Integer.MAX_VALUE) {
			ret = false;
		}

		//If the bag isn't empty
		else {
			//Recuperation of the index at which we want to insert the new element created
			//The index will be between 0 and size
			int index = (int)(Math.random()*(size + 1)); //Can be changer to size + 1 if it doesn't work

			//An element for parsing the bag
			Element tmp = this.sentinel;
			Element pastTmp = null;


			//Parsing all the bag
			for (int i = 0; i <= index; i++) {
				pastTmp = tmp;
				tmp = tmp.next;
			}

			//Linking the elements
			pastTmp.next = toInsert;
			toInsert.next = tmp;

			//Incrementing the size, the synchronized attribute and telling that's the size is correct
			this.size++;
			ret = true;
			this.modCount++;
		}

		return ret;
	}


	/**
	* Accesor of the private size attribute
	* @return The size of the list
	*/
	public int size() {
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
	@SuppressWarnings(value={"rawtypes", "unchecked"})
	private class Itr implements Iterator {
	//Attributes
		private Element current;
		private Element pastCurrent;
		private int expectedModCount;

	//Methods
		/**
		 * Constructor
		 */
		private Itr() {
			//Initialise the current and past current to the sentinel
			this.current = Bag.this.sentinel;
			this.pastCurrent = Bag.this.sentinel;
			this.expectedModCount = Bag.this.modCount;
		}


		/**
		 * Method to know if there's a next to the current iterator
		 * @return true if the iterator has a next, false if it's at the end of the list
		 */
		public boolean hasNext() {
			boolean ret = false;

			//If it's not synchronized
			if (this.expectedModCount != Bag.this.modCount) {
				System.out.println("Iterator unsynchronized!");
			}
			else {
				//Just verify the next of the current element
				if (this.current.next == Bag.this.sentinel) {
					ret = false;
				}
				else {
					ret = true;
				}
			}

			return ret;
		}


		/**
		 * Move the current iterator to the next element
		 * @return The data contained in the new current element
		 */
		public E next() {
			E ret = null;

			//If it's not synchronized
			if (this.expectedModCount != Bag.this.modCount) {
				System.out.println("Iterator unsynchronized!");
			}
			else {
				if (hasNext()) {
					//Move the iterator, the past current is the current
					this.pastCurrent = this.current;

					//Then the current became the next of the current
					this.current = this.current.next;

					//In the end, return the data contained in the new current
					ret = this.current.data;
				}
				else {
					System.out.println("Can't go to next");
				}
			}

			return ret;
		}


		/**
		 * Delete the current element, the current became the past current
		 */
		public void remove() {
			//If it's not synchronized
			if (this.expectedModCount != Bag.this.modCount) {
				System.out.println("Iterator unsynchronized!");
			}
			else {
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

					//Synchronizing with ONLY this iterator
					Bag.this.modCount++;
					this.expectedModCount = Bag.this.modCount;
				}
			}
		}
	}
}
