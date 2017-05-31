package ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import datas.*;

/**
*Classe de l'écouteur de l'item Modifier
*/
public class EcouteurItemModifier implements ActionListener {
//Attributs
	private Wintel datWin;

//Methodes
	/**
	*Constructeur
	*/
	public EcouteurItemModifier(Wintel monWin) {
		this.datWin = monWin;
	}


	/**
	*Permet de reagir au clic de la souris sur l'item Modifer
	*/
	public void actionPerformed(ActionEvent e) {
		this.datWin.setDialogModifierVisible();
	}
}
