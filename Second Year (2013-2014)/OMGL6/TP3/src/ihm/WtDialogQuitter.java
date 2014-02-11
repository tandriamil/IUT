package ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
*Classe de la boite de dialogue de l'exit
*/
public class WtDialogQuitter extends JDialog {
//Attributs
	//Zone de texte, seul element de la boite de dialogue
	private JPanel boutons;
	private JPanel boutonOui;
	private JPanel boutonNon;
	private JButton oui;
	private JButton non;
	private JLabel zoneTexte;
	private WtDialogQuitterSauvegarder wtDialogQuitterSauvegarder;

//Methodes
	/**
	*Constructeur de la classe WtDialogQuitter
	*@param parent Fenetre parent
	*/
	public WtDialogQuitter(Wintel parent) {
		super(parent, "Quitter", true);
		wtDialogQuitterSauvegarder = new WtDialogQuitterSauvegarder(this);
		creerInterface();
        this.setSize(250, 100);
		attacherComportements();
    	setResizable(false);
    	setVisible(false);
	}


	/**
	*Methode a appeler avant chaque (re)affichage qui permet de 
	*placer la fenetre relativement a la fenetre principale
	*/
	public void init() {
		Wintel parent = (Wintel)this.getOwner();
		Dimension dim = parent.getSize();
		Point p = parent.getLocation();
		this.setLocation(p.x+(dim.width-getSize().width)/2, p.y+(dim.height-getSize().height)/2);
	}


	/**
	*Creation de l'interface
	*/
	private void creerInterface() {
		//Creation des elements
		zoneTexte = new JLabel("Souhaitez vous vraiment quitter ?");
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
	public void attacherComportements() {
		Wintel parent = (Wintel)this.getOwner();

		if (parent.verifyModif()) {
			oui.addActionListener(new AuditeurConfirmerSauvegarde());
		}
		else {
			oui.addActionListener(new AuditeurConfirmer());
		}

		non.addActionListener(new AuditeurAnnuler());
	}


	/**
	*Permet de faire la reaction au clic de confirmer
	*/
	private void confirmer() {
		Wintel parent = (Wintel)this.getOwner();
		parent.dispose();
	}


	/**
	*Permet de faire la reaction au clic de confirmer si Annuaire modifie
	*/
	private void confirmerSauvegarder() {
		this.setVisible(false);
		this.wtDialogQuitterSauvegarder.init();
		this.wtDialogQuitterSauvegarder.setVisible(true);
	}


	/**
	*Permet de sauvegarder l'Annuaire avant de quitter
	*/
	public void sauvegarderAvantQuitter() {
		Wintel parent = (Wintel)this.getOwner();
		parent.getAnnuaire().sauver();
	}


	/**
	*Permet de fermer la fenetre principale
	*/
	public void setParentDispose() {
		Wintel parent = (Wintel)this.getOwner();
		parent.dispose();
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
	*Auditeur du bouton confirmer si Annuaire modifiee
	*/
	public class AuditeurConfirmerSauvegarde implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			confirmerSauvegarder();
		}
	}


	/**
	*Permet de faire la reaction au clic de annuler
	*/
	private void annuler() {
		this.setVisible(false);
	}
}