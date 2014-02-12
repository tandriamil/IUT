package ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import datas.*;

/**
*Classe de l'écouteur de la Jlist
*/
public class EcouteurItemSauver implements ActionListener {
//Attributs
	private Wintel datWin;

//Methodes
	/**
	*Constructeur
	*/
	public EcouteurItemSauver(Wintel monWin) {
		this.datWin = monWin;
	}


	/**
	*Permet de reagir au clic de la souris sur le bouton sauver
	*/
	public void actionPerformed (ActionEvent e) {
		this.datWin.getAnnuaire().sauver();
		this.datWin.setDialogSauvegarderVisible();
	}
}