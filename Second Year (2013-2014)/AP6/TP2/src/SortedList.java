package datastruct;

import java.lang.Comparable;
import java.util.Iterator;

/**
 * Interface for sorted lists
 */
public interface SortedList {
//Methods

	/**
	 * Insert an object
	 * @param comp A comparable object to insert
	 */
	@SuppressWarnings("rawtypes")
	public void insert(Comparable comp);


	/**
	 * Verify if the list is empty or not
	 * @return true if the list is empty, false if not
	 */
	public boolean isEmpty();


	/**
	 * Permits to know the size of the list
	 * @return Size of the list
	 */
	public int getSize();


	/**
	 * Permits to display correctly the list
	 * @return A string of the list
	 */
	public String toString();


	/**
	 * Method to get the current iterator of the list
	 * @return The current iterator of the list
	 */
	@SuppressWarnings("rawtypes")
	public Iterator getIterator();
}
