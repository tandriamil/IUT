package ScannerPerso; //Package pour l'exercice
import java.io.*;
import java.util.*;

/**
*Une classe utilisant MyScanner.java permettant de faire la lecture
*/
public class Lecture {
//Methodes
	/**
	*Constructeur a partir d'un fichier
	*@param nomFichier Fichier en entree a lire
	*@throws FileNotFoundException
	*/
	public Lecture(String nomFichier) throws FileNotFoundException {
		File monFichier = new File(nomFichier);
		FileReader myFR = new FileReader(monFichier);
		BufferedReader myBR = new BufferedReader(myFR);
	}

	/**
	*Permet de lire un fichier
	*@throws FileNotFoundException
	*/
	public void lire() throws NoSuchElementException {
		boolean eof = false;
		String tmp1, tmp2, ligne;
		File f = new File("./rempli.txt");

		try {
			MyScanner scan = new MyScanner(f);
			tmp1 = scan.nextLine();
			tmp2 = scan.nextLine();
			ligne = tmp1 + '\n' + tmp2;
			System.out.println(ligne);
			scan.close();
		}
		catch (FileNotFoundException fnfe) {
		    System.out.println("File not found!");
		}
		catch(NoSuchElementException nsee) {
		}
	}
}
