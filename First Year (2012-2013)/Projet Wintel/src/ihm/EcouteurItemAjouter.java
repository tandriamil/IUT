package ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import datas.*;

/**
*Classe de l'écouteur de l'item Ajouter
*/
public class EcouteurItemAjouter implements ActionListener {
//Attributs
	private Wintel datWin;

//Methodes
	/**
	*Constructeur
	*/
	public EcouteurItemAjouter(Wintel monWin) {
		this.datWin = monWin;
	}


	/**
	*Permet de reagir au clic de la souris sur la JList
	*/
	public void actionPerformed(ActionEvent e) {
		this.datWin.setDialogAjouterVisible();
	}
}
