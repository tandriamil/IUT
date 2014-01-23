package datas;
import java.io.*;
import java.util.*;

/**
*Classe de test de Personne
*/
public class TestPersonne {
	public static void main(String [] args) {
		//Test Constructeur + toString()
		@SuppressWarnings("deprecation")
		Date d1 = new Date(31, 12, 1994);
		Personne p1 = new Personne("Nap", 86, d1);

		System.out.println(d1.toString());
		System.out.println(p1.toString());


		//Test de lireBin()
		System.out.println(p1.lireBin().toString());
	}
}
