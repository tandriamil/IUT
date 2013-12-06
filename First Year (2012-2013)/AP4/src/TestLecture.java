package ScannerPerso; //Package pour l'exercice
import java.io.*;
import java.util.*;

/**
*Classe de test de Lecture
*/
public class TestLecture {
	public static void main (String [] args) {
//Test du constructeur
		//Test normal
		try {
			Lecture lect1 = new Lecture("testrempli.txt");
			System.out.print("SUCCES ");
		}
		catch (FileNotFoundException fnfe) {
			System.out.print("ECHEC ");
		}
		finally {
			System.out.println("du test du constructeur avec fichier existant.");
		}


		//Test fichier inexistant
		try {
			Lecture lect1 = new Lecture("fichierNonExistant.txt");
			System.out.print("ECHEC ");
		}
		catch (FileNotFoundException fnfe) {
			System.out.print("SUCCES ");
		}
		finally {
			System.out.println("du test du constructeur avec fichier inexistant.");
		}
	}
}