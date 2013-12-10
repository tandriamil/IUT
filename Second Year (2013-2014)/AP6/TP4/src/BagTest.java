package datastruct;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Class test for the Bag Collection
 */
public class BagTest extends TestCase {
//Attributes
	private Bag<Integer> emptyBag;
	private Bag<Integer> normalBag;
	private Bag<Integer> testInsertBag;
	private Bag<String> stringBag;
	private Integer un;
	private Integer deux;
	private Integer trois;
	private Integer quatre;
	private Integer cinq;
	private Integer six;
	private Integer sept;
	private Integer huit;
	private Integer neuf;
	private Integer dix;



//Method ran before each test case
	@Before
	public void setUp() {
		emptyBag = new Bag<Integer>();
		normalBag = new Bag<Integer>();
		testInsertBag = new Bag<Integer>();
		stringBag = new Bag<String>();
		un = new Integer(1);
		deux = new Integer(2);
		trois = new Integer(3);
		quatre = new Integer(4);
		cinq = new Integer(5);
		six = new Integer(6);
		sept = new Integer(7);
		huit = new Integer(8);
		neuf = new Integer(9);
		dix = new Integer(10);
	}


//Methods tests
//Test of add()
	//With a normal bag
	@Test
	public void testAddBag() {
		System.out.println("\n" + "Test of a normal add:");
		assertEquals(true, testInsertBag.add(un));
	}

	//With an empty bag
	@Test
	public void testAddEmptyBag() {
		System.out.println("\n" + "Test of an add in an empty bag:");
		assertEquals(true, emptyBag.add(un));
	}
}