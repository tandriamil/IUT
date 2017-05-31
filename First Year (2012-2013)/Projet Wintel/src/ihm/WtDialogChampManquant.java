package ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
*Classe de la boite de dialogue de la notification de champ manquant
*/
public class WtDialogChampManquant extends JDialog {
//Attributs
	//Zone de texte, seul element de la boite de dialogue
	private JButton confirmer;
	private JLabel zoneTexte;

//Methodes
	/**
	*Constructeur de la classe WtDialogChampManquant
	*@param parent Fenetre parent
	*/
	public WtDialogChampManquant(WtDialog parent) {
		super(parent, "ERREUR", true);
		creerInterface();
        this.setSize(190, 100);
		attacherComportements();
    	setResizable(false);
    	setVisible(false);
	}


	/**
	*Methode a appeler avant chaque (re)affichage qui permet de
	*placer la fenetre relativement a la fenetre principale
	*/
	public void init() {
		WtDialog parent = (WtDialog)this.getOwner();
		Dimension dim = parent.getSize();
		Point p = parent.getLocation();
		this.setLocation(p.x+(dim.width-getSize().width)/2, p.y+(dim.height-getSize().height)/2);
	}


	/**
	*Creation de l'interface
	*/
	private void creerInterface() {
		//Creation du texte
		String text = "Champ \"Nom\" manquant !";

		//Creation des elements
		zoneTexte = new JLabel(text);
		zoneTexte.setHorizontalAlignment(JLabel.CENTER);
		confirmer = new JButton("Fermer");

		//Creation du panel principal
		this.setLayout(new GridLayout(2, 1));

		//Ajout du JLabel dans le panel
		this.add(zoneTexte);
		this.add(confirmer);
	}


	/**
	*Classe qui permet d'y attacher les comportements
	*/
	private void attacherComportements() {
		confirmer.addActionListener(new AuditeurConfirmer());
	}


	/**
	*Permet de faire la reaction au clic de confirmer
	*/
	private void confirmer() {
		this.setVisible(false);
	}


	/**
	*Auditeur du bouton confirmer qui quitte en fait
	*/
	public class AuditeurConfirmer implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			confirmer();
		}
	}
}
