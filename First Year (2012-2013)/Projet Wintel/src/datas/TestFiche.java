package datas;

/**
*Classe de test de Fiche
*/
public class TestFiche {
	public static void main(String[] args) {
		//Test du Constructeur + toString()
		Fiche f1 = new Fiche("Trolol", "Guy", "02 66 65 68 69");
		System.out.println(f1.toString());

		//Test des accesseurs
		System.out.println("Test du nom: " + f1.getNom());
		System.out.println("Test du prenom: " + f1.getPrenom());
		System.out.println("Test du numero: " + f1.getNumTel());
	}
}