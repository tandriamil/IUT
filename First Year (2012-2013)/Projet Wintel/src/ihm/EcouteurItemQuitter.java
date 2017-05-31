package ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import datas.*;

/**
*Classe de l'écouteur de l'item Quitter
*/
public class EcouteurItemQuitter implements ActionListener {
//Attributs
	private Wintel datWin;

//Methodes
	/**
	*Constructeur
	*/
	public EcouteurItemQuitter(Wintel monWin) {
		this.datWin = monWin;
	}


	/**
	*Permet de reagir au clic de la souris sur Quitter
	*/
	public void actionPerformed(ActionEvent e) {
		this.datWin.setDialogQuitterVisible();
	}
}
