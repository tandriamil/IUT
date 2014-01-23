package datastruct;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import javax.swing.JButton;


/**
 * Test class for the BinaryTreeTable class, we'll use Integer as E and String as T
 */
public class BinaryTreeTableTest extends TestCase {
//Attributes
	private BinaryTreeTable<Integer, String> emptyTree;
	private BinaryTreeTable<Integer, String> normalTree;
	private BinaryTreeTable<Integer, String> insertNormalTree;
	private Integer un;
	private Integer deux;
	private Integer trois;
	private Integer quatre;
	private Integer cinq;
	private Integer dix;
	private Integer nonPresent;
	private String dataUn;
	private String dataDeux;
	private String dataTrois;
	private String dataQuatre;
	private String dataCinq;
	private String dataDix;
	private JButton nonComparableObject;


//Method ran before each test case
	@Before
	public void setUp() {
		emptyTree = new BinaryTreeTable<Integer, String>();
		normalTree = new BinaryTreeTable<Integer, String>();
		insertNormalTree = new BinaryTreeTable<Integer, String>();
		un = new Integer(1);
		deux = new Integer(2);
		trois = new Integer(3);
		quatre = new Integer(4);
		cinq = new Integer(5);
		dix = new Integer(10);
		nonPresent = new Integer(42);
		dataUn = "Data de un";
		dataDeux = "Data de deux";
		dataTrois = "Data de trois";
		dataQuatre = "Data de quatre";
		dataCinq = "Data de cinq";
		dataDix = "Data de dix";
		normalTree.insert(un, dataUn);
		normalTree.insert(cinq, dataCinq);
		normalTree.insert(quatre, dataQuatre);
		normalTree.insert(trois, dataTrois);
		normalTree.insert(dix, dataDix);
		normalTree.insert(deux, dataDeux);
	}


//Methods tests
//Test of insert()
	//With a normal list
	@Test
	public void testInsertNormal() {
		System.out.println("\n" + "Test of a normal insert:");
		assertEquals(0, insertNormalTree.getSize());
		assertEquals(true, insertNormalTree.insert(un, dataUn));
		assertEquals(1, insertNormalTree.getSize());
		System.out.println("OK");
	}

	//With a non comparable type for the E
	@Test
	public void testInsertNonComparable() {
		System.out.println("\n" + "Test of an insert with a non comparable object for the E:");
		/*normalTree.insert(nonComparableObject, dataUn);*/
		System.out.println("Doesn't compile, so works. OK");
	}

	//With a non compatible type for the T
	@Test
	public void testInsertNonCompatibleTypeE() {
		System.out.println("\n" + "Test of an insert with a non compatible type for the E:");
		/*normalTree.insert(dataDeux, dataUn);*/
		System.out.println("Doesn't compile, so works. OK");
	}

	//With a non compatible type for the E
	@Test
	public void testInsertNonCompatibleTypeT() {
		System.out.println("\n" + "Test of an insert with a non compatible type for the T:");
		/*normalTree.insert(un, deux);*/
		System.out.println("Doesn't compile, so works. OK");
	}

	//With two times the same key
	@Test
	public void testInsertTheSameKey() {
		System.out.println("\n" + "Test of an insert with two times the same key:");
		assertEquals(0, insertNormalTree.getSize());
		assertEquals(true, insertNormalTree.insert(un, dataUn));
		assertEquals(1, insertNormalTree.getSize());
		assertEquals(false, insertNormalTree.insert(un, dataUn));
		assertEquals(1, insertNormalTree.getSize());
		System.out.println("OK");
	}


//Test of toString()
	//With an empty tree
	@Test
	public void testToStringEmpty() {
		System.out.println("\n" + "Test of toString() with an empty tree:" + "\n" + emptyTree.toString());
		System.out.println("OK");
	}

	//With a normal tree
	@Test
	public void testToStringNormal() {
		System.out.println("\n" + "Test of toString() with a normal tree:" + "\n" + normalTree.toString());
		System.out.println("OK");
	}


//Test of delete()  -- UNSUCCESSFUL
	//With an empty tree
	@Test
	public void testDeleteEmpty() {
		System.out.println("\n" + "Test of delete() with an empty tree:");
		assertEquals(0, emptyTree.getSize());
		assertEquals(false, emptyTree.delete(un));
		assertEquals(0, emptyTree.getSize());
		System.out.println("OK");
	}

	//Delete the first element of a normal tree
	@Test
	public void testDeleteFirstNormal() {
		System.out.println("\n" + "Test of deleting the first element (the root):");
		System.out.println("\nBefore:" + normalTree.toString());
		assertEquals(6, normalTree.getSize());
		assertEquals(true, normalTree.delete(un));
		System.out.println("\nAfter:" + normalTree.toString());
		assertEquals(5, normalTree.getSize());
		System.out.println("OK");
	}

	//Delete a middle element of a normal tree
	@Test
	public void testDeleteMiddleNormal() {
		System.out.println("\n" + "Test of deleting a middle element:");
		System.out.println("\nBefore:" + normalTree.toString());
		assertEquals(6, normalTree.getSize());
		assertEquals(true, normalTree.delete(cinq));
		System.out.println("\nAfter:" + normalTree.toString());
		assertEquals(5, normalTree.getSize());
		System.out.println("OK");
	}

	//With a key which doesn't exist
	@Test
	public void testDeleteInexistentKey() {
		System.out.println("\n" + "Test of deleting with a key that doesn't exist:");
		System.out.println("\nBefore:" + normalTree.toString());
		assertEquals(6, normalTree.getSize());
		assertEquals(false, normalTree.delete(nonPresent));
		System.out.println("\nAfter:" + normalTree.toString());
		assertEquals(6, normalTree.getSize());
		System.out.println("OK");

	}


//Test of select()
	//With an empty tree
	@Test
	public void testSelectEmptyTree() {
		System.out.println("\n" + "Test of select() with an empty tree:");
		assertEquals(null, emptyTree.select(un));
		System.out.println("OK");
	}

	//With a normal tree with an existent key
	@Test
	public void testSelectNormalTree() {
		System.out.println("\n" + "Test of select() with an existent key of a normal tree:");
		
		assertEquals(dataUn, normalTree.select(un));
		System.out.println(normalTree.select(un).toString());

		assertEquals(dataCinq, normalTree.select(cinq));
		System.out.println(normalTree.select(cinq).toString());
		
		assertEquals(dataDix, normalTree.select(dix));
		System.out.println(normalTree.select(dix).toString());

		assertEquals(dataQuatre, normalTree.select(quatre));
		System.out.println(normalTree.select(quatre).toString());

		assertEquals(dataTrois, normalTree.select(trois));
		System.out.println(normalTree.select(trois).toString());

		assertEquals(dataDeux, normalTree.select(deux));
		System.out.println(normalTree.select(deux).toString());
	}


//Test of balanceLevel()
	//With an empty tree
	@Test
	public void testBalanceEmptyTree() {
		System.out.println("\n" + "Test of balanceLevel() with an empty tree:" + "\n" + emptyTree.balanceLevel());
		System.out.println("OK");
	}

	//With only the root
	@Test
	public void testBalanceOneElement() {
		insertNormalTree.insert(un, dataUn);
		System.out.println("\n" + "Test of balanceLevel() with only one element (the root):" + "\n" + insertNormalTree.balanceLevel());
		System.out.println("OK");
	}

	//With a normal tree
	@Test
	public void testBalanceNormalTree() {
		System.out.println("\n" + "Test of balanceLevel() with a normal tree:" + "\n" + normalTree.balanceLevel());
		System.out.println("OK");
	}

	//With another normal tree
	@Test
	public void testBalanceAnotherNormalTree() {
		System.out.println("\n" + "Test of balanceLevel() with another normal tree:");
		insertNormalTree.insert(quatre, dataQuatre);
		insertNormalTree.insert(un, dataUn);
		insertNormalTree.insert(cinq, dataCinq);
		insertNormalTree.insert(trois, dataTrois);
		insertNormalTree.insert(dix, dataDix);
		insertNormalTree.insert(deux, dataDeux);
		System.out.println(insertNormalTree.balanceLevel());
		System.out.println("OK");
	}
}