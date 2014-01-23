package ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import datas.*;

/**
*Classe de l'écouteur de la Jlist
*/
public class EcouteurItemCharger implements ActionListener {
//Attributs
	private Wintel datWin;

//Methodes
	/**
	*Constructeur
	*/
	public EcouteurItemCharger(Wintel monWin) {
		this.datWin = monWin;
	}


	/**
	*Permet de reagir au clic de la souris sur le bouton charger
	*/
	public void actionPerformed(ActionEvent e) {
		this.datWin.chargerEtAfficherAnnuaire();
		this.datWin.setDialogChargerVisible();
	}
}