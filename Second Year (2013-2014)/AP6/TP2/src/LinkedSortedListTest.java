package datastruct;

import static org.junit.Assert.*;
import java.util.Iterator;
import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;


/**
 * Test class for the linked sorted list
 */
public class LinkedSortedListTest extends TestCase {
//Attributes
	private LinkedSortedList emptyList;
	private LinkedSortedList normalList;
	private LinkedSortedList anotherList;
	private LinkedSortedList listOfString;
	private LinkedSortedList listNonComparable;
	private Integer un;
	private Integer deux;
	private Integer trois;
	private Integer troisBis;
	private Integer cinq;
	private JButton nonComparable;
	private String comparableString;


//Method ran before each test case
	@Before
	public void setUp() {
		emptyList = new LinkedSortedList(Integer.class);
		normalList = new LinkedSortedList(Integer.class);
		anotherList = new LinkedSortedList(Integer.class);
		listOfString = new LinkedSortedList(String.class); //String etant comparable
		un = new Integer(1);
		deux = new Integer(2);
		trois = new Integer(3);
		troisBis = new Integer(3);
		cinq = new Integer(5);
		nonComparable = new JButton("I'm not comparable!");
		comparableString = "I'm comparable!";

		//The inserts were already tested
		normalList.insert(deux);
		normalList.insert(trois);
		normalList.insert(un);
		normalList.insert(troisBis);
		normalList.insert(un);
		normalList.insert(cinq);
	}


//Test of the constructor()
	//With a list of non comparable, exception must be throwed
	@Test
	public void testCreationOfNonComparableList() {
		System.out.println("\n" + "Test of creating a list of non comparable objects:");
		boolean thrown = false;

		try  {
			listNonComparable = new LinkedSortedList(JButton.class);
		}
		catch (RuntimeException e) {
	    	thrown = true;
	  	}

	  	assertTrue(thrown);
	}


//Test of insert()
	//With an empty list
	@Test
	public void testInsertInEmptyList() {
		System.out.println("\n" + "Test of insert() on an empty list:");
		System.out.println("Before:" + "\n" + emptyList.toString());
		emptyList.insert(trois);
		System.out.println("Then:" + "\n" + emptyList.toString());
	}

	//With a normal list
	@Test
	public void testInsertInNormalListRequiredType() {
		System.out.println("\n" + "Test of insert() an object with the type required in a normal list:");
		System.out.println("Before:" + "\n" + normalList.toString());
		normalList.insert(trois);
		System.out.println("Then:" + "\n" + normalList.toString());
	}

	//With a non Comparable object
	@Test
	public void testInsertInNormalListNonComparableObject() {
		System.out.println("\n" + "Test of insert() a non comparable object in a normal list:");
		/* normalList.insert(nonComparable); */
		System.out.println("The compilator doesn't accept the type. OK");
	}

	//Inserting the wrong type of object but comparable
	@Test
	public void testInsertWrongTypeOfObject() {
		System.out.println("\n" + "Test of insert() a comparable object but with the wrong type:");
		System.out.println("Insertion of a String in a list of Integer:");
		normalList.insert(comparableString);
		System.out.println("Insertion of an Integer in a list of String:");
		listOfString.insert(un);
	}


//Test of hasNext()
	//With an empty list
	@Test
	public void testHasNextOnEmptyList() {
		System.out.println("\n" + "Test of hasNext() on an empty list:");
		assertEquals(false, emptyList.getIterator().hasNext());
		System.out.println("OK");
	}
	
	//With a normal list
	@Test
	public void testHasNextOnNormalList() {
		System.out.println("\n" + "Test of hasNext() on a normal list:");
		assertEquals(true, normalList.getIterator().hasNext());
		System.out.println("OK");
	}

	//With a list that we'll use by different ways
	@Test
	@SuppressWarnings("rawtypes")
	public void testHasNextOnManipulatedList() {
		System.out.println("\n" + "Test of hasNext() on a manipulated list:");
		//When empty
		assertEquals(false, anotherList.getIterator().hasNext());

		//After adding another element
		anotherList.insert(un);
		assertEquals(true, anotherList.getIterator().hasNext());

		//After adding another element
		anotherList.insert(deux);
		assertEquals(true, anotherList.getIterator().hasNext());

		//Then when moving
		Iterator itr = anotherList.getIterator();
		assertEquals(true, itr.hasNext());

		//Moving one time
		itr.next();
		assertEquals(true, itr.hasNext());

		//Moving a second time
		itr.next();
		assertEquals(false, itr.hasNext());
	}


//Test of next()
	//With an empty list
	@Test
	@SuppressWarnings("rawtypes")
	public void testNextOnEmptyList() {
		System.out.println("\n" + "Test of next() on an empty list:");
		Iterator itr = emptyList.getIterator();
		itr.next();
	}

	//With a normal list
	@SuppressWarnings("rawtypes")
	public void testNextOnNormalList() {
		System.out.println("\n" + "Test of next() on a normal list:");
		Iterator itr = normalList.getIterator();

		//Normally, we can do it 6 times
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		itr.next();

		//Then we can't move anymore
		itr.next();
		itr.next();
	}


//Test of toString()
	//With an empty list
	@Test
	public void testToStringEmpty() {
		System.out.println("\n" + "Test of toString() on an empty list:");
		System.out.println(emptyList.toString());
	}

	//With a normal list
	@Test
	public void testToStringNormal() {
		System.out.println("\n" + "Test of toString() on a normal list:");
		System.out.println(normalList.toString());
	}


//Test of isEmpty()
	//With an empty list
	@Test
	public void testIsEmptyOnEmptyList() {
		System.out.println("\n" + "Test of isEmpty() on an empty list:");
		assertEquals(true, emptyList.isEmpty());
		System.out.println("OK");
	}

	//With a normal list
	@Test
	public void testIsEmptyOnNormalList() {
		System.out.println("\n" + "Test of isEmpty() on a normal list:");
		assertEquals(false, normalList.isEmpty());
		System.out.println("OK");
	}


//Test of getSize()
	//With an empty list
	@Test
	public void testGetSizeOnEmptyList() {
		System.out.println("\n" + "Test of getSize() on an empty list:");
		assertEquals(0, emptyList.getSize());
		System.out.println("OK");
	}
	
	//With a normal list
	@Test
	public void testGetSizeOnNormalList() {
		System.out.println("\n" + "Test of getSize() on a normal list:");
		assertEquals(6, normalList.getSize());
		System.out.println("OK");
	}


//Test of remove()
	//With an empty list
	@Test
	@SuppressWarnings("rawtypes")
	public void testRemoveOnEmptyList() {
		System.out.println("\n" + "Test of remove() on an empty list:");
		Iterator itr = emptyList.getIterator();
		System.out.println("Before:" + "\n" + emptyList.toString());
		itr.remove();
		System.out.println("Then:" + "\n" + emptyList.toString());
		assertEquals(true, emptyList.isEmpty());
		assertEquals(0, emptyList.getSize());
	}

	//With a normal list
	@Test
	@SuppressWarnings("rawtypes")
	public void testRemoveOnNormalList() {
		//Without moving
		System.out.println("\n" + "Test of remove() on a normal list without moving (the iterator is on the sentinel):");
		Iterator itr = normalList.getIterator();
		System.out.println("Before:" + "\n" + normalList.toString());
		itr.remove();
		System.out.println("Then:" + "\n" + normalList.toString());
		assertEquals(false, normalList.isEmpty());
		assertEquals(6, normalList.getSize());

		//After moving 2 times
		System.out.println("\n" + "After moving 2 times:");
		itr.next();
		itr.next();
		System.out.println("Before:" + "\n" + normalList.toString());
		itr.remove();
		System.out.println("Then:" + "\n" + normalList.toString());
		assertEquals(false, normalList.isEmpty());
		assertEquals(5, normalList.getSize());

		//Then moving one time
		System.out.println("\n" + "Then moving one time:");
		itr.next();
		System.out.println("Before:" + "\n" + normalList.toString());
		itr.remove();
		System.out.println("Then:" + "\n" + normalList.toString());
		assertEquals(false, normalList.isEmpty());
		assertEquals(4, normalList.getSize());

		//And trying to remove a second time without moving
		System.out.println("\n" + "Finally, try to remove without moving:");
		System.out.println("Before:" + "\n" + normalList.toString());
		itr.remove();
		System.out.println("Then:" + "\n" + normalList.toString());
		assertEquals(false, normalList.isEmpty());
		assertEquals(4, normalList.getSize());
	}
}