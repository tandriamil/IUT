package datastruct;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import java.util.ArrayList;

/**
 * Class test for the Bag Collection
 */
public class BagTest extends TestCase {
//Attributes
	private Bag<Integer> emptyBag;
	private Bag<Integer> normalBag;
	private Bag<Integer> testInsertBag;
	private Bag<Integer> cloneNormalBag;
	private Bag<Integer> partNormalBag;
	private Bag<Integer> cloneEmptyBag;
	private Bag<Integer> nonPresentBag;



//Method ran before each test case
	@Before
	public void setUp() {
		emptyBag = new Bag<Integer>();
		normalBag = new Bag<Integer>();
		testInsertBag = new Bag<Integer>();
		cloneNormalBag = new Bag<Integer>();
		partNormalBag = new Bag<Integer>();
		cloneEmptyBag = new Bag<Integer>();
		nonPresentBag = new Bag<Integer>();

		//Addings
		normalBag.add(1);
		normalBag.add(2);
		normalBag.add(3);
		normalBag.add(4);
		normalBag.add(5);
		normalBag.add(6);
		normalBag.add(7);
		normalBag.add(8);
		normalBag.add(9);
		normalBag.add(10);

		cloneNormalBag.add(1);
		cloneNormalBag.add(2);
		cloneNormalBag.add(3);
		cloneNormalBag.add(4);
		cloneNormalBag.add(5);
		cloneNormalBag.add(6);
		cloneNormalBag.add(7);
		cloneNormalBag.add(8);
		cloneNormalBag.add(9);
		cloneNormalBag.add(10);

		partNormalBag.add(1);
		partNormalBag.add(3);
		partNormalBag.add(4);
		partNormalBag.add(6);
		partNormalBag.add(7);
		partNormalBag.add(9);

		nonPresentBag.add(42);
		nonPresentBag.add(55);
		nonPresentBag.add(99);
	}


//Methods tests
//getSize() will be tested in parallel of add() and remove()

//Test of add()
	@Test
	public void testAddBag() {
		System.out.println("Test of a normal add:");
		assertEquals(0, testInsertBag.size());
		assertEquals(true, testInsertBag.add(1));
		assertEquals(1, testInsertBag.size());
		assertEquals(true, testInsertBag.add(2));
		assertEquals(2, testInsertBag.size());
		assertEquals(true, testInsertBag.add(3));
		assertEquals(3, testInsertBag.size());
		System.out.println("OK \n");
	}

	@Test
	public void testAddEmptyBag() {
		System.out.println("Test of an add in an empty bag:");
		assertEquals(0, emptyBag.size());
		assertEquals(true, emptyBag.add(1));
		assertEquals(1, emptyBag.size());
		System.out.println("OK \n");
	}


//Test of toString()
	@Test
	public void testToStringEmptyBag() {
		System.out.println("Test of displaying an empty bag:");
		System.out.println(emptyBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testToStringNormalBag() {
		System.out.println("Test of displaying a normal bag:");
		System.out.println(normalBag.toString());
		System.out.println("OK \n");
	}


//Test of isEmpty()
	@Test
	public void testIsEmptyWithEmptyBag() {
		System.out.println("Test of isEmpty() with an empty bag:");
		assertEquals(true, emptyBag.isEmpty());
		System.out.println("OK \n");
	}

	@Test
	public void testIsEmptyWithNormalBag() {
		System.out.println("Test of isEmpty() with a normal bag:");
		assertEquals(false, normalBag.isEmpty());
		System.out.println("OK \n");
	}


//Test of contains()
	@Test
	public void testContainsWithEmptyBag() {
		System.out.println("Test of contains() with an empty bag:");
		assertEquals(false, emptyBag.contains(1));
		System.out.println("OK \n");
	}

	@Test
	public void testContainsWithNormalBag() {
		System.out.println("Test of contains() with a normal bag and an element contained in it:");
		assertEquals(true, normalBag.contains(1));
		System.out.println("OK \n");
	}

	@Test
	public void testContainsWithNormalBagNotContaining() {
		System.out.println("Test of contains() with a normal bag and an element non present in it:");
		assertEquals(false, normalBag.contains(42));
		System.out.println("OK \n");
	}


//Test of toArray() number one
	@Test
	public void testToArrayNumberOneNormal() {
		System.out.println("Test of the first toArray() with a normal bag:");
		Object[] array = normalBag.toArray();

		//Parsing the array obtained
		for (int i = 0; i < array.length; i++) {
			assertEquals(true, normalBag.contains(array[i]));
		}

		System.out.println("OK \n");
	}

	@Test
	public void testToArrayNumberOneEmpty() {
		System.out.println("Test of the first toArray() with an empty bag:");
		Object[] array = emptyBag.toArray();
		assertEquals(0, array.length);
		System.out.println("OK \n");
	}


//Test of toArray() number two
	@Test
	public void testToArrayNumberTwoNormal() {
		System.out.println("Test of the second toArray() with a normal bag:");
		Integer[] array = new Integer[10];
		normalBag.toArray(array);

		//For displaying it
		String ret = "";

		for (int i = 0; i < array.length; i++) {
			ret = ret + array[i] + " | ";
		}

		System.out.println("Displaying the table obtained:" + "\n" + ret);
		System.out.println("OK \n");
	}

	@Test
	public void testToArrayNumberTwoEmpty() {
		System.out.println("Test of the second toArray() with an empty bag:");
		Integer[] array = new Integer[10];
		emptyBag.toArray(array);

		//For displaying it
		String ret = "";

		for (int i = 0; i < array.length; i++) {
			ret = ret + array[i] + " | ";
		}

		System.out.println("Displaying the table obtained:" + "\n" + ret);
		System.out.println("OK \n");
	}


//Test of remove()
	@Test
	public void testRemoveEmpty() {
		System.out.println("Test of remove() with an empty bag:");
		System.out.println("Before:" + "\n" + emptyBag.toString());
		assertEquals(0, emptyBag.size());
		assertEquals(false, emptyBag.remove(1));
		assertEquals(0, emptyBag.size());
		System.out.println("After:" + "\n" + emptyBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testRemoveNormal() {
		System.out.println("Test of remove() with a normal bag:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(true, normalBag.remove(5));
		assertEquals(9, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testRemoveInexistant() {
		System.out.println("Test of remove() with a non existant element in a normal bag:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(false, normalBag.remove(42));
		assertEquals(10, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}

	@Test
	//We can't really test this because the iterator used isn't the same!
	public void testRemoveTwoTimes() {
		System.out.println("Test of remove() two times in a row:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(true, normalBag.remove(5));
		assertEquals(9, normalBag.size());
		assertEquals(true, normalBag.remove(1));
		assertEquals(8, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}


//Test of containsAll()
	@Test
	public void testContainsAllEmpty() {
		System.out.println("Test of containsAll() with an empty bag:");
		assertEquals(true, emptyBag.containsAll(cloneEmptyBag));
		System.out.println("OK \n");
	}

	@Test
	public void testContainsAllNormal() {
		System.out.println("Test of containsAll() with a normal bag:");
		assertEquals(true, normalBag.containsAll(cloneNormalBag));
		System.out.println("OK \n");
	}

	@Test
	public void testContainsAllOnlyAPart() {
		System.out.println("Test of containsAll() with only a part of the bag:");
		assertEquals(true, normalBag.containsAll(partNormalBag));
		System.out.println("OK \n");
	}

	@Test
	public void testContainsAllNonTrue() {
		System.out.println("Test of containsAll() with an empty bag compared to a non empty one:");
		assertEquals(true, normalBag.containsAll(emptyBag)); //true because normalBag contains the empty one ...
		assertEquals(false, emptyBag.containsAll(normalBag));
		System.out.println("OK \n");
	}


//Test of addAll()
	@Test
	public void testAddAllOnEmptyBag() {
		System.out.println("Test of addAll() with an empty bag:" + "\n" + "Before:");
		System.out.println(emptyBag.toString() + "\n");
		assertEquals(0, emptyBag.size());
		emptyBag.addAll(normalBag);
		assertEquals(10, emptyBag.size());
		System.out.println("After:" + "\n" + emptyBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testAddAllOnNormalBag() {
		System.out.println("Test of addAll() with a normal bag:" + "\n" + "Before:");
		System.out.println(normalBag.toString() + "\n");
		assertEquals(10, normalBag.size());
		normalBag.addAll(partNormalBag);
		assertEquals(16, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testAddAllOnNormalBagAddingAnEmptyBag() {
		System.out.println("Test of addAll() with a normal bag adding an empty bag:" + "\n" + "Before:");
		System.out.println(normalBag.toString() + "\n");
		assertEquals(10, normalBag.size());
		normalBag.addAll(emptyBag);
		assertEquals(10, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}


//Test of removeAll()
	@Test
	public void testRemoveAllEmpty() {
		System.out.println("Test of removeAll() with an empty bag:");
		System.out.println("Before:" + "\n" + emptyBag.toString());
		assertEquals(0, emptyBag.size());
		assertEquals(false, emptyBag.removeAll(partNormalBag));
		assertEquals(0, emptyBag.size());
		System.out.println("After:" + "\n" + emptyBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testRemoveAllNormal() {
		System.out.println("Test of removeAll() with a normal bag:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(true, normalBag.removeAll(partNormalBag));
		assertEquals(4, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testRemoveAllClone() {
		System.out.println("Test of removeAll() with a clone of a normal bag:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(true, normalBag.removeAll(cloneNormalBag));
		assertEquals(0, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}


//Test of retainAll()
	//A verifier la signification de retainAll!!!
	@Test
	public void testRetainAllEmpty() {
		System.out.println("Test of retainAll() with an empty bag:");
		System.out.println("Before:" + "\n" + emptyBag.toString());
		assertEquals(0, emptyBag.size());
		assertEquals(false, emptyBag.retainAll(partNormalBag));
		assertEquals(0, emptyBag.size());
		System.out.println("After:" + "\n" + emptyBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testRetainAllNormal() {
		System.out.println("Test of retainAll() with a normal bag and a part of it:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(true, normalBag.retainAll(partNormalBag));
		assertEquals(6, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testRetainAllNormalClone() {
		System.out.println("Test of retainAll() with a normal bag and a clone of it:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(false, normalBag.retainAll(cloneNormalBag)); //false cause it didn't change
		assertEquals(10, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testRetainAllNormalEmpty() {
		System.out.println("Test of retainAll() with a normal bag and an empty one:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(true, normalBag.retainAll(emptyBag));
		assertEquals(0, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testRetainAllNormalNonExistant() {
		System.out.println("Test of retainAll() with a normal bag and another which have no data that both have:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		assertEquals(true, normalBag.retainAll(nonPresentBag));
		assertEquals(0, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}


//Test of clear()
	@Test
	public void testClearEmpty() {
		System.out.println("Test of clear() with an empty bag:");
		System.out.println("Before:" + "\n" + emptyBag.toString());
		assertEquals(0, emptyBag.size());
		emptyBag.clear();
		assertEquals(0, emptyBag.size());
		System.out.println("After:" + "\n" + emptyBag.toString());
		System.out.println("OK \n");
	}

	@Test
	public void testClearNormal() {
		System.out.println("Test of clear() with a normal bag:");
		System.out.println("Before:" + "\n" + normalBag.toString());
		assertEquals(10, normalBag.size());
		normalBag.clear();
		assertEquals(0, normalBag.size());
		System.out.println("After:" + "\n" + normalBag.toString());
		System.out.println("OK \n");
	}


//Here, we'll have the tests which aren't really unitary and which are more complex
	@Test
	public void testReallyRandom() {
		System.out.println("Test if the placment of those numbers is really random:");

		//Firstly, we'll see that for the number one
		int[] caseOfNumberOne = new int[10];
		int[] caseOfNumberTwo = new int[10];
		int[] caseOfNumberThree = new int[10];
		int[] caseOfNumberFour = new int[10];
		int[] caseOfNumberFive = new int[10];
		int[] caseOfNumberSix = new int[10];
		int[] caseOfNumberSeven = new int[10];
		int[] caseOfNumberEight = new int[10];
		int[] caseOfNumberNine = new int[10];
		int[] caseOfNumberTen = new int[10];

		for (int x = 0; x < 10; x++) {
			caseOfNumberOne[x] = 0;
			caseOfNumberTwo[x] = 0;
			caseOfNumberThree[x] = 0;
			caseOfNumberFour[x] = 0;
			caseOfNumberFive[x] = 0;
			caseOfNumberSix[x] = 0;
			caseOfNumberSeven[x] = 0;
			caseOfNumberEight[x] = 0;
			caseOfNumberNine[x] = 0;
			caseOfNumberTen[x] = 0;
		}

		//The table where we'll save the array
		Integer[] array = new Integer[10];
		
		//Repetition of the placement about 1000 times
		for (int i = 1; i <= 1000; i++) {
			/*System.out.println(i + " " + normalBag.toString());*/

			//Saving the current array to a table
			normalBag.toArray(array);

			//We'll watch where is the number 1
			for (int j = 0; j < 10; j++) {
				if (array[j] == 1) {
					caseOfNumberOne[j] = caseOfNumberOne[j] + 1;
				}

				if (array[j] == 2) {
					caseOfNumberTwo[j] = caseOfNumberTwo[j] + 1;
				}

				if (array[j] == 3) {
					caseOfNumberThree[j] = caseOfNumberThree[j] + 1;
				}

				if (array[j] == 4) {
					caseOfNumberFour[j] = caseOfNumberFour[j] + 1;
				}

				if (array[j] == 5) {
					caseOfNumberFive[j] = caseOfNumberFive[j] + 1;
				}

				if (array[j] == 6) {
					caseOfNumberSix[j] = caseOfNumberSix[j] + 1;
				}

				if (array[j] == 7) {
					caseOfNumberSeven[j] = caseOfNumberSeven[j] + 1;
				}

				if (array[j] == 8) {
					caseOfNumberEight[j] = caseOfNumberEight[j] + 1;
				}

				if (array[j] == 9) {
					caseOfNumberNine[j] = caseOfNumberNine[j] + 1;
				}

				if (array[j] == 10) {
					caseOfNumberTen[j] = caseOfNumberTen[j] + 1;
				}
			}

			normalBag.clear();
			normalBag.addAll(cloneNormalBag);
		}

		//Counting the numbers of times where the numbers were in a case
		System.out.println("For the number 1:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number one was " + caseOfNumberOne[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 2:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number two was " + caseOfNumberTwo[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 3:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number three was " + caseOfNumberThree[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 4:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number four was " + caseOfNumberFour[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 5:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number five was " + caseOfNumberFive[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 6:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number six was " + caseOfNumberSix[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 7:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number seven was " + caseOfNumberSeven[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 8:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number eight was " + caseOfNumberEight[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 9:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number nine was " + caseOfNumberNine[i] + " times in the case " + i + ".");
		}

		System.out.println("\nFor the number 10:");

		for (int i = 0; i < 10; i++) {
			System.out.println("The number ten was " + caseOfNumberTen[i] + " times in the case " + i + ".");
		}

		System.out.println("\n");
	}
}