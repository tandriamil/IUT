package ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
*Classe de la boite de dialogue de l'exit
*/
public class WtDialogQuitterSauvegarder extends JDialog {
//Attributs
	//Zone de texte, seul element de la boite de dialogue
	private JPanel boutons;
	private JPanel boutonOui;
	private JPanel boutonNon;
	private JButton oui;
	private JButton non;
	private JLabel zoneTexte;

//Methodes
	/**
	*Constructeur de la classe WtDialogQuitter
	*@param parent Fenetre parent
	*/
	public WtDialogQuitterSauvegarder(WtDialogQuitter parent) {
		super(parent, "Sauvegarder?", true);
		creerInterface();
        this.setSize(350, 100);
		attacherComportements();
    	setResizable(false);
    	setVisible(false);
	}


	/**
	*Methode a appeler avant chaque (re)affichage qui permet de
	*placer la fenetre relativement a la fenetre principale
	*/
	public void init() {
		WtDialogQuitter parent = (WtDialogQuitter)this.getOwner();
		Dimension dim = parent.getSize();
		Point p = parent.getLocation();
		this.setLocation(p.x+(dim.width-getSize().width)/2, p.y+(dim.height-getSize().height)/2);
	}


	/**
	*Creation de l'interface
	*/
	private void creerInterface() {
		//Creation des elements
		zoneTexte = new JLabel("Souhaitez vous sauvegarder avant de quitter ?");
		zoneTexte.setHorizontalAlignment(JLabel.CENTER);

		oui = new JButton("Oui");
		boutonOui = new JPanel();
		boutonOui.setPreferredSize(new Dimension(75, 40));
		boutonOui.add(oui);

		non = new JButton("Non");
		boutonNon = new JPanel();
		boutonNon.setPreferredSize(new Dimension(75, 40));
		boutonNon.add(non);

		//Creation des panels
		boutons = new JPanel(new GridLayout(1, 2));
		this.setLayout(new GridLayout(2, 1));

		//Ajout du JLabel dans le panel
		boutons.add(boutonOui);
		boutons.add(boutonNon);
		this.add(zoneTexte);
		this.add(boutons);
	}


	/**
	*Classe qui permet d'y attacher les comportements
	*/
	private void attacherComportements() {
		oui.addActionListener(new AuditeurConfirmer());
		non.addActionListener(new AuditeurAnnuler());
	}


	/**
	*Permet de faire la reaction au clic de confirmer
	*/
	private void confirmer() {
		WtDialogQuitter parent = (WtDialogQuitter)this.getOwner();
		parent.sauvegarderAvantQuitter();

		this.setVisible(false);
		parent.setParentDispose();
	}


	/**
	*Auditeur du bouton confirmer qui quitte en fait
	*/
	public class AuditeurConfirmer implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			confirmer();
		}
	}


	/**
	*Auditeur du bouton annuler qui retourne a la fentre principale
	*/
	public class AuditeurAnnuler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			annuler();
		}
	}


	/**
	*Permet de faire la reaction au clic de annuler
	*/
	private void annuler() {
		WtDialogQuitter parent = (WtDialogQuitter)this.getOwner();
		this.setVisible(false);
		parent.setParentDispose();
	}
}
