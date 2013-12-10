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
}

