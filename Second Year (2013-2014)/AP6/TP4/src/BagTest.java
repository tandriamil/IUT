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


//Method ran before each test case
	@Before
	public void setUp() {
		emptyBag = new Bag<Integer>();
		normalBag = new Bag<Integer>();
		testInsertBag = new Bag<Integer>();
		stringBag = new Bag<String>();
	}


//Methods tests
//Test of add()
}