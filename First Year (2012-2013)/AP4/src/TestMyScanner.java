package ScannerPerso; //Package pour l'exercice
import java.io.*;
import java.util.*;

/**
*Classe de test de MyScanner
*/
public class TestMyScanner {
	public static void main (String [] args) {
//Test du constructeur
		//Test du fichier inexistant
		File f;
		File g;
		File h;
		MyScanner scanf = null;
		MyScanner scang = null;
		MyScanner scanh = null;
		f = new File("nonexistant.txt"); //Ce fichier n'existe pas

		try {
			scanf = new MyScanner(f);
			System.out.print("ECHEC du test ");
		}
		catch (FileNotFoundException fnfe) {
			System.out.print("SUCCES du test ");
		}
		finally {
			System.out.println("du fichier inexistant, renvoie bien l'excpetion.");
		}


		//Test du fichier existant
		g = new File("testrempli.txt"); //Ce fichier existe et n'est pas vide

		try {
			scang = new MyScanner(g);
			System.out.print("SUCCES du test ");
		}
		catch(FileNotFoundException fnfe) {
			System.out.print("ECHEC du test ");
		}
		finally {
			System.out.println("du fichier existant, deroulement normal.");
		}



//Test de nextLine()
		//Test fichier vide
		h = new File("testvide.txt"); //Ce fichier existe mais est vide
		try {
			scanh = new MyScanner(h);
			if (scanh.nextLine() == null) {
				System.out.print("SUCCES du test ");
			}
		}
		catch(NoSuchElementException nsee) {
		}
		catch(FileNotFoundException fnfe) {
			System.out.print("Fichier non trouvable ");
		}
		finally {
			System.out.println("de nextLine() avec fichier vide.");
		}


		//Test fichier non vide
		try {
			if (scang.nextLine() != null) {
				System.out.print("SUCCES du test ");
			}
		}
		catch(NoSuchElementException nsee) {
			System.out.print("ECHEC du test ");
		}
		finally {
			System.out.println("de nextLine() avec fichier rempli.");
		}

//Test de hasNextLine()
		//Test de fichier vide
		try {
			if (scanh.hasNextLine() == false) {
				System.out.print("SUCCES du test ");
			}
			else {
				System.out.print("ECHEC du test ");
			}
		}
		catch(IllegalStateException ise) {
		}
		finally {
			System.out.println("de hasNextLine() avec fichier vide.");
		}


		//Test de fichier rempli
		try {
			if (scang.hasNextLine() == true) {
				System.out.print("SUCCES du test ");
			}
			else {
				System.out.print("ECHEC du test ");
			}
		}
		catch(IllegalStateException ise) {
		}
		finally {
			System.out.println("de hasNextLine() avec fichier rempli.");
		}
	}
}