package ScannerPerso; //Package pour l'exercice
import java.io.*;
import java.util.*;

/**
*Une classe equivalente au Scanner de l'API Java
*/
public class MyScanner {
//Attributs
	private BufferedReader br;
	private boolean isClosed;

//Methodes
	/**
	*Constructeur a partir d'un fichier
	*@param source Fichier en entree
	*@throws FileNotFoundException
	*/
	public MyScanner(File source) throws FileNotFoundException {
		this.isClosed = true; //Fichier ouvert
		FileReader myFR = new FileReader(source); //Lis le fichier
		this.br = new BufferedReader(myFR); //Lis le texte du fichier
		this.isClosed = false; //Fichier ferme
	}

	/**
	*Permet de fermer le BufferedReader
	*/
	public void close() {
		//Test que scanner present
		try {
			this.br.close();
			this.isClosed = true;
		}

		catch (IOException ioe) {
		}
	}

	/**
	*Permet de lire la prochaine ligne
	*@throws IllegalStateException Renvoie si scanner ferme (isClosed == true)
	*@throws NoSuchElementException Renvoie si pas de ligne suivante a lire
	*@return La prochaine ligne
	*/
	public String nextLine() throws IllegalStateException, NoSuchElementException {
		String ret = null;

		//Test que le fichier est bien ouvert, scanner present
		try {
			if (this.isClosed) throw new IllegalStateException("Scanner fermé!");
		}

		catch (IllegalStateException ise) {
			System.out.println(ise.getMessage());
		}

		//Essaie de lire la ligne suivante
		try {
			ret = this.br.readLine();
			if (ret == null) throw new NoSuchElementException("Element non existant!");
		}

		catch (NoSuchElementException nsee) {
			System.out.println(nsee.getMessage());
		}

		catch (IOException ioe) {
			ioe.getMessage();
		}

		//Retour final
		return ret;
	}

	/**
	*Verifie si une ligne suivante existe bien
	*@return true si presente, false sinon
	*@throws IllegalStateException Renvoie si scanner ferme (isClosed == true)
	*/
	public boolean hasNextLine() throws IllegalStateException {
		boolean ret = true;
		int res = 0;

		//Test si scanner ouvert
		try {
			if (this.isClosed) throw new IllegalStateException("Scanner ferme!");
		}

		catch (IllegalStateException ise) {
			System.out.println(ise.getMessage());
		}

		//Voir si prochaine ligne lisible
		try {
			this.br.mark(100);
			res = this.br.read();

			if (res == -1) {
				ret = false;
				this.br.reset(); //Retour position initiale
			}
		}

		catch (IOException ioe) {
			ioe.getMessage();
		}


		//Retour final
		return ret;
	}

}