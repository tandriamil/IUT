package ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
*Classe de la boite de dialogue de l'aide
*/
public class WtDialogAide extends JDialog {
//Attributs
	//Zone de texte, seul element de la boite de dialogue
	private JPanel boutonConfirmer;
	private JPanel zoneAide;
	private JButton confirmer;
	private JTextArea zoneTexte;

//Methodes
	/**
	*Constructeur de la classe WtDialogAide
	*@param parent Fenetre parent
	*/
	public WtDialogAide(Wintel parent) {
		super(parent, "Aide", true);
		creerInterface();
        this.setSize(800, 500);
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
		//Creation du texte
		String aide = "Ceci est l'aide de l'application Wintel.";
		aide = aide + '\n' + "L'application consiste à gérer une liste de personnes enregistrées dans un annuaire téléphonique.";
		aide = aide + '\n' + "Le premier menu, nommé \"Fichier\", permet de :";
		aide = aide + '\n' + "- Charger l'annuaire des personnes;";
		aide = aide + '\n' + "- Sauvegarder sur disque l'annuaire, une fois qu'il est modifié";
		aide = aide + '\n' + "- Quitter l'application avec une demande de confirmation";
		aide = aide + '\n' + '\n' + "La clé de recherche dans l'annuaire est le nom de la personne et on n'autorise pas l'ajout d'une personne de même nom.";
		aide = aide + '\n' + '\n' + "Le second menu, nommé \"Abonnés\", permet:";
		aide = aide + '\n' + "- D'ajouter une nouvelle personne à l'annuaire, en rentrant au moins son nom;";
		aide = aide + '\n' + "- De modifier les données d'une personne existante;";
		aide = aide + '\n' + "- De supprimer une personne de l'annuaire.";
		aide = aide + '\n' + '\n' + "Enfin, en cliquant sur la liste des personnes, on peut obtenir des informations détaillées sur la personne sélectionnée.";

		//Creation de l'organisation du panel principal

		this.setLayout(new BorderLayout());

		//Creation des elements

		zoneAide = new JPanel();
		boutonConfirmer = new JPanel();
		confirmer = new JButton("Fermer");
		zoneTexte = new JTextArea(aide, 24, 1);

		// spécifications de taille et de couleur des éléments

		zoneAide.setPreferredSize(new Dimension(780, 400));
		zoneAide.setBackground(Color.cyan);
		zoneTexte.setEditable(false);
		zoneTexte.setBackground(Color.cyan);
		boutonConfirmer.setPreferredSize(new Dimension(80, 65));

		// insertion des différents éléments

		boutonConfirmer.add(confirmer);
		zoneAide.add(zoneTexte);
		this.add(zoneAide, BorderLayout.NORTH);
		this.add(boutonConfirmer, BorderLayout.SOUTH);


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
