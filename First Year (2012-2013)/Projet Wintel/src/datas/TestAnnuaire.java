package datas;
import java.io.*;
import java.util.*;

/**
*Classe de test d'Annuaire
*/
public class TestAnnuaire {
	public static void main(String[] args) {
//Test du constructeur
		Fiche f1 = new Fiche("Trolol", "Guy", "02 66 65 68 69");
		Fiche f2 = new Fiche("Neige", "Blanche", "7");
		Fiche f3 = new Fiche("Stickey", "Sophie", "666");
		Fiche f4 = new Fiche("Lonjemakeu", "Laura", "69");
		Fiche newFiche = new Fiche("Canno", "Camille", "713705");
		Enumeration<String> enumeration;
		Annuaire pagesJaunes = new Annuaire();

//Test de ajouter()  ==> CHECK
		System.out.println("Test de ajouter():");
		//Test de ajouter(), parametres valides
		try {
			pagesJaunes.ajouter("Guy", f1);
			System.out.print("SUCCES ");
		}
		catch (Exception e) {
			System.out.print("ECHEC ");
		}
		finally {
			System.out.println("du test de ajouter() avec parametres valides.");
		}


		//Test de ajouter(), cle nulle
		try {
			pagesJaunes.ajouter(null, f1);
			System.out.print("ECHEC ");
		}
		catch (Exception e) {
			System.out.print("SUCCES ");
		}
		finally {
			System.out.println("du test de ajouter() avec cle nulle.");
		}


		//Test de ajouter(), Fiche nulle
		try {
			pagesJaunes.ajouter("Une cle", null);
			System.out.print("ECHEC ");
		}
		catch (Exception e) {
			System.out.print("SUCCES ");
		}
		finally {
			System.out.println("du test de ajouter() avec Fiche nulle.");
		}


		//Test de ajouter(), cle deja presente
		try {
			pagesJaunes.ajouter("CleDejaPresente", f2);
			pagesJaunes.ajouter("CleDejaPresente", f3);
			System.out.print("ECHEC ");
		}
		catch (Exception e) {
			System.out.print("SUCCES ");
		}
		finally {
			System.out.println("du test de ajouter() avec une cle deja presente.");
		}

		System.out.println("");


//Test de toString()  ==> CHECK
		System.out.println("Test de toString():");
		
		System.out.println(pagesJaunes.toString());

		System.out.println("SUCCES du test de toString()." + '\n');


//Test de supprimer()  ==> CHECK
		System.out.println("Test de supprimer():");
		//Test de supprimer(), parametres valides
		try {
			pagesJaunes.supprimer("Guy");
			System.out.print("SUCCES ");
		}
		catch (Exception e) {
			System.out.print("ECHEC ");
		}
		finally {
			System.out.println("du test de supprimer() avec parametres valides.");
		}

		//Test de supprimer(), cle nulle
		try {
			pagesJaunes.supprimer(null);
			System.out.print("ECHEC ");
		}
		catch (IllegalArgumentException e) {
			System.out.print("SUCCES ");
		}
		finally {
			System.out.println("du test de supprimer() avec cle nulle.");
		}

		//Test de supprimer(), cle non presente
		try {
			pagesJaunes.supprimer("Cle non presente");
			System.out.print("ECHEC ");
		}
		catch (NoSuchElementException nsee) {
			System.out.print("SUCCES ");
		}
		finally {
			System.out.println("du test de supprimer() avec cle nulle." + '\n');
		}


//Test de existe()  ==> CHECK
		System.out.println("Test de existe():");
		
		try {
			pagesJaunes.ajouter("Laura", f4);
		}
		catch (Exception e) {
			System.out.print("ECHEC ");
		}

		if (pagesJaunes.existe("Laura")) {
			System.out.print("SUCCES ");
		}
		else {
			System.out.print("ECHEC ");
		}

		System.out.println("du test de existe()." + '\n');


//Test de cles()  ==> CHECK
		System.out.println("Test de cles(): (Affiche toutes les cles de l'Annuaire)");
		enumeration = pagesJaunes.cles();

		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}

		System.out.println("SUCCES du test de cles()." + '\n');


//Test de taille()  ==> CHECK
		System.out.println("Test de taille():");

		if (pagesJaunes.taille() == 2) {
			System.out.print("SUCCES ");
		}
		else {
			System.out.print("ECHEC ");
		}

		System.out.println("du test de taille()." + '\n');


//Test de consulter()  ==> CHECK
		System.out.println("Test de consulter():");

		//Fonctionnement normal
		if (pagesJaunes.consulter("Laura") == f4) {
			System.out.print("SUCCES ");
		}
		else {
			System.out.print("ECHEC ");
		}

		System.out.println("du test de consulter(), fonctionnement normal.");

		//Test avec cle nulle
		try {
			pagesJaunes.consulter(null);
			System.out.print("ECHEC ");
		}
		catch (Exception e) {
			System.out.print("SUCCES ");
		}

		System.out.println("du test de consulter() avec cle nulle." + '\n');
	

//Test de modifier()  ==> CHECK
		System.out.println("Test de modifier():");

		//Test avec cle nulle
		try {
			pagesJaunes.modifier(null, newFiche);
			System.out.print("ECHEC ");
		}
		catch (Exception e) {
			System.out.print("SUCCES ");
		}

		System.out.println("du test de modifier() avec cle nulle.");

		//Test avec cle non presente
		try {
			pagesJaunes.modifier("Cle non presente", newFiche);
			System.out.print("ECHEC ");
		}
		catch (Exception e) {
			System.out.print("SUCCES ");
		}

		System.out.println("du test de modifier() avec cle non presente.");

		//Test fonctionnement normal
		try {
			pagesJaunes.modifier("Laura", newFiche);
			System.out.print("SUCCES ");
		}
		catch (Exception e) {
			System.out.print("ECHEC ");
		}

		System.out.println("du test de modifier() avec fonctionnement normal." + '\n');


//Test de sauver()  ==>  CHECK
		System.out.println("Affichage de Pages Jaunes:");
		System.out.println(pagesJaunes.toString() + '\n');
		System.out.println("Test de sauver():");

		//Test fonctionnement normal
		try {
			pagesJaunes.sauver();
			System.out.print("SUCCES ");
		}
		catch (Exception e) {
			System.out.print("ECHEC ");
		}

		System.out.println("du test de sauver() avec fonctionnement normal." + '\n');

		//Ne sachant pas faire les autres tests ...



//Test de charger()  ==>  CHECK
		System.out.println("Test de charger():");
		Annuaire pagesBlanches = new Annuaire();

		//Test fonctionnement normal
		try {
			pagesBlanches = pagesJaunes.charger();
			System.out.print("SUCCES ");
		}
		catch (Exception e) {
			System.out.print("ECHEC ");
		}

		System.out.println("du test de charger() avec fonctionnement normal.");

		System.out.println('\n' + "Affichage de Pages Blanches:");
		System.out.println(pagesBlanches.toString());
	}
}