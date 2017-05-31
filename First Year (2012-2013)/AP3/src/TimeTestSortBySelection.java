import java.lang.Math.*;
import java.util.*;
import java.io.*;

public class TimeTestSortBySelection {
	public static void main (String [] args) {
		//Attributs
		final int NBTEST = 20;
		final int MULTIPLE = 1000;
		int nbdata;
		long time, startTime, stopTime;

		//Méthodes pour mesure de la recherche dichotomique
		for (int index = 1; index <= NBTEST; index++) {

			//De 1000 à 20 000
			System.gc();	//Appel du garbage collector à chaque fois
			nbdata = MULTIPLE * index;
			IntCollection collection = new IntCollection (nbdata);
			collection.fill(0, nbdata);

			//Début mesure
			startTime = System.currentTimeMillis();

			//Algo recherche
			collection.sortBySelection();

			//Fin mesure
			stopTime = System.currentTimeMillis();

			//Calcul du temps mis
			time = stopTime - startTime;

			System.out.println("Nombre de valeurs: " + nbdata + " | Durée: " + time + " ms.");

			//Création du fichier de sortie .csv pour chaque plage
			try {
				FileWriter file = new FileWriter ("resultat_sortbyselection.csv", true);
				BufferedWriter tampon = new BufferedWriter (file);
				PrintWriter out = new PrintWriter(tampon);
				out.println(nbdata + " " + time);
				out.close();
			}

			catch(IOException e) {}

		}
	}
}
