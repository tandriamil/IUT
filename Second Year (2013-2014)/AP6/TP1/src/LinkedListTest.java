package datastruct;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test de la classe LinkedList
 */
public class LinkedListTest {
//Creation de la liste sur laquelle on va travailler
	private LinkedList listeVide;
	private LinkedList listeNormale;
	private LinkedList listeSolo;
	private String data1;
	private String data2;
	private String data3;
	private String data4;

//Methode executee avant chaque instance de Test
	@Before
	public void setUp() {
		listeVide = new LinkedList();
		listeNormale = new LinkedList();
		listeSolo = new LinkedList();
		data1 = "Une information";
		data2 = "Une deuxieme information";
		data3 = "Une nouvelle information";
		data4 = "Une information non presente";
		listeNormale.insert(data1);
		listeNormale.insert(data2);
		listeNormale.insert(data3);
		listeSolo.insert(data1);
	}


//Test de toString
	@Test
	public void testToStringVide() {
		System.out.println("Test du toString() sur liste vide:");
		System.out.println(listeVide.toString() + "\n");
	}


	@Test
	public void testToString() {
		System.out.println("Test du toString() sur liste non vide:");
		System.out.println(listeNormale.toString() + "\n");
	}


//Test de insert
	@Test
	public void testInsert() {
		System.out.println("Test de insert():");
		System.out.println(listeNormale.toString() + "\n");
	}


	@Test
	public void testInsertVide() {
		System.out.println("Test de insert() sur liste vide:");
		System.out.println("Avant:" + "\n" + listeVide.toString());
		listeVide.insert(data1);
		System.out.println("Apres:" + "\n" + listeVide.toString() + "\n");
	}


//Test de delete
	@Test
	public void testDeleteListeRemplie() {
		System.out.println("Test de delete() sur liste remplie:");
		System.out.println("Avant:" + "\n" + listeNormale.toString());
		listeNormale.delete();
		System.out.println("Apres:" + "\n" + listeNormale.toString());
	}


	@Test
	public void testDeleteListeVide() {
		System.out.println("Test de delete() sur liste vide:");
		System.out.println("Avant:" + "\n" + listeVide.toString());
		listeVide.delete();
		System.out.println("Apres:" + "\n" + listeVide.toString() + "\n" + "\n");
	}


//Test de contains
	@Test
	public void testContainsTrue() {
		System.out.println("Test du contains() avec data contenu dans liste:");
		assertEquals(true, listeNormale.contains(data1));
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testContainsFalse() {
		System.out.println("Test du contains() avec data non contenu dans liste:");
		assertEquals(false, listeNormale.contains(data4));
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testContainsVide() {
		System.out.println("Test du contains() avec liste vide:");
		assertEquals(false, listeVide.contains(data1));
		System.out.println("Ok" + "\n");
	}


//Test de getValue
	@Test
	public void testGetValueVide() {
		System.out.println("Test du getValue() avec liste vide:");
		assertEquals(null, listeVide.getValue());
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testGetValue() {
		System.out.println("Test du getValue() avec une bonne valeur:");
		assertEquals(data3, listeNormale.getValue());
		System.out.println("Ok" + "\n");
	}


//Test de setValue
	@Test
	public void testSetValueVide() {
		System.out.println("Test du setValue() sur liste Vide:");
		System.out.println("Avant:" + "\n" + listeVide.toString());
		listeVide.setValue(data4);
		System.out.println("Apres:" + "\n" + listeVide.toString() + "\n");
	}


	@Test
	public void testSetValue() {
		System.out.println("Test du setValue() sur liste normale:");
		System.out.println("Avant:" + "\n" + listeNormale.toString());
		listeNormale.setValue(data4);
		System.out.println("Apres:" + "\n" + listeNormale.toString() + "\n");
	}


//Test de isEmpty()
	@Test
	public void testIsEmptyTrue() {
		System.out.println("Test de isEmpty() avec liste vide:");
		assertEquals(true, listeVide.isEmpty());
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testIsEmptyFalse() {
		System.out.println("Test de isEmpty() avec liste non vide:");
		assertEquals(false, listeNormale.isEmpty());
		System.out.println("Ok" + "\n");
	}


//Test de getSize()
	@Test
	public void testGetSizeVideDelete() {
		System.out.println("Test de getSize() avec liste vide et des delete() avant:");
		listeVide.delete();
		listeVide.delete();
		assertEquals(0, listeVide.getSize());
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testGetSize() {
		System.out.println("Test de getSize() avec liste normale:");
		assertEquals(3, listeNormale.getSize());
		System.out.println("Ok" + "\n" + "\n");
	}


//Test de goToHead
	@Test
	public void testGoToHead() {
		System.out.println("Test de goToHead() avec liste normale:");
		System.out.println("Avant d'aller a la tete et de delete le current:" + "\n" + listeNormale.toString());
		listeNormale.goToHead();
		listeNormale.delete();
		System.out.println("Apres:" + "\n" + listeNormale.toString() + "\n");
	}


	@Test
	public void testGoToHeadVide() {
		System.out.println("Test de goToHead() avec liste vide:");
		System.out.println("Avant d'aller a la tete et de delete le current:" + "\n" + listeVide.toString());
		listeVide.goToHead();
		listeVide.delete();
		System.out.println("Apres:" + "\n" + listeVide.toString() + "\n");
	}


//Test de goToEnd
	@Test
	public void testGoToEnd() {
		System.out.println("Test de goToEnd() avec liste normale:");
		System.out.println("Avant d'aller a la fin et de delete le current:" + "\n" + listeNormale.toString());
		listeNormale.goToEnd();
		listeNormale.delete();
		System.out.println("Apres:" + "\n" + listeNormale.toString() + "\n");
	}


	@Test
	public void testGoToEndVide() {
		System.out.println("Test de goToEnd() avec liste vide:");
		System.out.println("Avant d'aller a la fin et de delete le current:" + "\n" + listeVide.toString());
		listeVide.goToEnd();
		listeVide.delete();
		System.out.println("Apres:" + "\n" + listeVide.toString() + "\n");
	}


//Test de previous
	@Test
	public void testPreviousVide() {
		System.out.println("Test de previous() avec liste vide:");
		System.out.println("Avant d'aller au precedent et de delete le current:" + "\n" + listeVide.toString());
		assertEquals(false, listeVide.previous());
		System.out.println("Apres etre aller au precedent:" + "\n" + listeVide.toString());
		listeVide.delete();
		System.out.println("Apres suppression du current:" + "\n" + listeVide.toString() + "\n");
	}


	@Test
	public void testPreviousNormal() {
		System.out.println("Test de previous() avec liste normale:");
		System.out.println("Avant d'aller au precedent et de delete le current:" + "\n" + listeNormale.toString());
		assertEquals(true, listeNormale.previous());
		System.out.println("Apres etre aller au precedent:" + "\n" + listeNormale.toString());
		listeNormale.delete();
		System.out.println("Apres suppression du current:" + "\n" + listeNormale.toString() + "\n");
	}


//Test de next
	@Test
	public void testNextVide() {
		System.out.println("Test de next() avec liste vide:");
		System.out.println("Avant d'aller au suivant et de delete le current:" + "\n" + listeVide.toString());
		assertEquals(false, listeVide.next());
		System.out.println("Apres etre aller au suivant:" + "\n" + listeVide.toString());
		listeVide.delete();
		System.out.println("Apres suppression du current:" + "\n" + listeVide.toString() + "\n");
	}


	@Test
	public void testNextDernier() {
		System.out.println("Test de next() avec liste normale mais current est le dernier element:");
		System.out.println("Avant d'aller au suivant et de delete le current:" + "\n" + listeNormale.toString());
		assertEquals(false, listeNormale.next());
		System.out.println("Apres etre aller au suivant:" + "\n" + listeNormale.toString());
		listeNormale.delete();
		System.out.println("Apres suppression du current:" + "\n" + listeNormale.toString() + "\n");
	}


//Test de hasPrevious
	@Test
	public void testHasPreviousVide() {
		System.out.println("Test de hasPrevious() avec liste vide:");
		assertEquals(false, listeVide.hasPrevious());
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testHasPreviousNormale() {
		System.out.println("Test de hasPrevious() avec liste normale:");
		assertEquals(true, listeNormale.hasPrevious());
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testHasPreviousUnSeulElement() {
		System.out.println("Test de hasPrevious() avec liste normale a un seul element:");
		assertEquals(false, listeSolo.hasPrevious());
		System.out.println("Ok" + "\n");
	}


//Test de hasNext
	@Test
	public void testHasNextVide() {
		System.out.println("Test de hasNext() avec liste vide:");
		assertEquals(false, listeVide.hasNext());
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testHasNextNormale() {
		System.out.println("Test de hasNext() avec liste normale:");
		assertEquals(false, listeNormale.hasNext());
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testHasNextUnSeulElement() {
		System.out.println("Test de hasNext() avec liste normale a un seul element:");
		assertEquals(false, listeSolo.hasNext());
		System.out.println("Ok" + "\n");
	}


//Test de getValueAt
	@Test
	public void testGetValueAtVide() {
		System.out.println("Test de getValueAt() avec liste vide:");
		assertEquals(null, listeVide.getValueAt(1));
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testGetValueAtNormalBon() {
		System.out.println("Test de getValueAt() avec liste normale:");
		assertEquals(data1, listeNormale.getValueAt(1));
		assertEquals(data2, listeNormale.getValueAt(2));
		assertEquals(data3, listeNormale.getValueAt(3));
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testGetValueAtTropGrand() {
		System.out.println("Test de getValueAt() avec liste normale mais index trop grand:");
		assertEquals(null, listeNormale.getValueAt(55));
		System.out.println("Ok" + "\n");
	}


	@Test
	public void testGetValueAtNegatif() {
		System.out.println("Test de getValueAt() avec liste normale mais index negatif:");
		assertEquals(null, listeNormale.getValueAt(-8));
		System.out.println("Ok" + "\n");
	}
}
