package datastruct;


/**
 * Interface for the Tables
 */
public interface Table<E extends Comparable<E>, T> {
//Methods

	/**
	 * Permits to obtain the data contained in the node of the key enterred
	 * @param key The key of the node that we want to obtain its data
	 * @return The data contained in the node, null if the key doesn't exist
	 */
	public abstract T select (E key);


	/**
	 * Permits to insert a node in the tree, only if the key isn't already in it
	 * @param key The key of the node to insert
	 * @param data The data of the node to insert
	 * @return true if the insert is successful, false if not
	 */
	public abstract boolean insert (E key, T data);


	/**
	 * Permits to delete a node represented by his key
	 * @param key The key of the node to delete
	 * @return true if the delete is successful, false if not
	 */
	public abstract boolean delete (E key);

	//test


}
