package ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import datas.*;

/**
*Classe de l'écouteur de la Jlist
*/
public class EcouteurListeGauche extends MouseAdapter {
//Attributs
	private Wintel datWin;

//Methodes
	/**
	*Constructeur
	*/
	public EcouteurListeGauche(Wintel monWin) {
		this.datWin = monWin;
	}


	/**
	*Permet de reagir au clic de la souris sur la JList
	*/
	public void mouseClicked (MouseEvent e) {
		String cle;

		//Acces a la JList
		JList<String> liste = datWin.getListeGauche(); //getListeGauche(): Accesseur de Wintel

		//Recup de l'endroit ou l'utilisateur a clique
		int index = liste.locationToIndex(e.getPoint());

		//Recup du tableau qui memorise les elements de la JList
		DefaultListModel<String> tab = (DefaultListModel<String>)(liste.getModel());

		//Case du tableau ou on a clique
		cle = tab.get(index);

		//La cle (nom) permet de recuperer la fiche correspondante
		Annuaire monAnnuaire = datWin.getAnnuaire();
		Fiche f = monAnnuaire.consulter(cle);

		//Affichage dans les 3 zones de droite
		JTextField afficheNom = datWin.getFieldNom();
		afficheNom.setText(f.getNom());

		JTextField affichePrenom = datWin.getFieldPrenom();
		affichePrenom.setText(f.getPrenom());
		
		JTextField afficheNumero = datWin.getFieldNumero();
		afficheNumero.setText(f.getNumTel());
	}
}