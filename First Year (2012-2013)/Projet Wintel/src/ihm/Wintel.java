package ihm;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;
import java.util.*;
import datas.*;

/**
*Classe pour l'interface graphique
*/
public class Wintel extends JFrame {
//Attributs
	//Afin d'eviter le Warning du serialVersionUID
	private static final long serialVersionUID = 42L;

	//Une instance d'Annuaire pour les donnees
	private Annuaire monAnnuaire;

	//Les attributs WtDialog permettent les interactions
	private WtDialogAjouter dialogAdd;
	private WtDialogSupprimer dialogSuppr;
	private WtDialogModifier dialogModif;
	private WtDialogAide dialogAide;
	private WtDialogQuitter dialogQuitter;
	private WtDialogComposer dialogComposer;
	private WtDialogSauvegarder dialogSauvegarder;
	private WtDialogCharger dialogCharger;

	//Les composants graphiques
	private JMenuBar barreMenu;
	private JPanel titres;
	private JPanel affichageDonnees;
	private JPanel affichageCaracteristiques;
	private JPanel butComposer;
	private JList<String> listeContacts;
	private JMenu menuFichier;
	private JMenu menuContact;
	private JMenu menuAide;
	private JMenuItem sauvegarder;
	private JMenuItem charger;
	private JMenuItem quitter;
	private JMenuItem ajouterContact;
	private JMenuItem modifierContact;
	private JMenuItem supprimerContact;
	private JMenuItem aide;
	private JLabel contacts;
	private JLabel caracteristiques;
	private JLabel nom;
	private JLabel prenom;
	private JLabel numero;
	private JTextField afficheNom;
	private JTextField affichePrenom;
	private JTextField afficheNumero;
	private JButton composer;

	//Attribut pour se rappeler s'il y a eu une modification ou pas
	private boolean modification;

//Methodes
	/**
	*Constructeur
	*/
	public Wintel() {
		super("Wintel");
		this.monAnnuaire = new Annuaire();
		this.dialogAdd = new WtDialogAjouter(this);
		this.dialogModif = new WtDialogModifier(this);
		this.dialogSuppr = new WtDialogSupprimer(this);
		this.dialogAide = new WtDialogAide(this);
		this.dialogQuitter = new WtDialogQuitter(this);
		this.dialogComposer = new WtDialogComposer(this);
		this.dialogSauvegarder = new WtDialogSauvegarder(this);
		this.dialogCharger = new WtDialogCharger(this);
		this.modification = false;

		this.creerInterface();
		this.attacherReactions();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(700, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	/**
	*Permet de creer l'interface en creant et placant tout les elements graphiques
	*/
	private void creerInterface() {
	//La Barre de Menu
		//Creation des elements
		menuFichier = new JMenu("Fichier");
		menuContact = new JMenu("Contact");
		menuAide = new JMenu("Aide");
		sauvegarder = new JMenuItem("Sauvegarder");
		charger = new JMenuItem("Charger");
		quitter = new JMenuItem("Quitter");
		ajouterContact = new JMenuItem("Ajouter");
		modifierContact = new JMenuItem("Modifier");
		supprimerContact = new JMenuItem("Supprimer");
		aide = new JMenuItem("Aide");

		//Creation du menu
		barreMenu = new JMenuBar();

		//Ajout des elements dans le menu
		menuFichier.add(sauvegarder);
		menuFichier.add(charger);
		menuFichier.add(quitter);
		menuContact.add(ajouterContact);
		menuContact.add(modifierContact);
		menuContact.add(supprimerContact);
		menuAide.add(aide);
		barreMenu.add(menuFichier);
		barreMenu.add(menuContact);
		barreMenu.add(menuAide);

	//La barre des titres
		//Creation des elements
		contacts = new JLabel("Contacts");
		contacts.setForeground(Color.white);
		caracteristiques = new JLabel("Caractéristiques");
		caracteristiques.setForeground(Color.white);

		//Creation du panel
		titres = new JPanel(new GridLayout(1, 2));

		//Ajout des elements dans le panel
		titres.add(contacts);
		titres.add(caracteristiques);
		titres.setBackground(Color.gray);
		titres.setPreferredSize(new Dimension(700, 30));

	//Panel de gauche contenant la liste des contacts
		//Creation de l'element JList
		listeContacts = new JList<String>();
		listeContacts.setModel(new DefaultListModel<String>());

	//Panel de droite contenant les informations
		//Creation des elements


		nom = new JLabel("Nom : ");
		afficheNom = new JTextField(20);
		afficheNom.setEditable(false);
		afficheNom.setBackground(Color.cyan);


		prenom = new JLabel("Prénom : ");
		affichePrenom = new JTextField(20);
		affichePrenom.setEditable(false);
		affichePrenom.setBackground(Color.cyan);


		numero = new JLabel("Numéro : ");
		afficheNumero = new JTextField(20);
		afficheNumero.setEditable(false);
		afficheNumero.setBackground(Color.cyan);


		butComposer = new JPanel();
		composer = new JButton("Composer");
		composer.setPreferredSize(new Dimension (175, 60));
		butComposer.add(composer);

		//Creation du panel
		affichageCaracteristiques = new JPanel(new GridLayout(0, 1));

		//Ajout des elements dans le panel
		affichageCaracteristiques.add(nom);
		affichageCaracteristiques.add(afficheNom);
		affichageCaracteristiques.add(prenom);
		affichageCaracteristiques.add(affichePrenom);
		affichageCaracteristiques.add(numero);
		affichageCaracteristiques.add(afficheNumero);
		affichageCaracteristiques.add(butComposer);

	//Fenetre centrale
		//Creation de la fenetre centrale
		affichageDonnees = new JPanel(new GridLayout(1, 2, 40, 40));

		//Ajout des elements
		affichageDonnees.add(listeContacts);
		affichageDonnees.add(affichageCaracteristiques);

	//Fenetre principale
		//Creation de la fenetre principale
		this.setLayout(new BorderLayout());

		//Ajout des elements
		setJMenuBar(barreMenu);
		this.add(titres, BorderLayout.NORTH);
		this.add(affichageDonnees, BorderLayout.CENTER);
	}


	/**
	*Permet d'attacher aux composants graphiques adequats des ecouteurs d'evenements utilisateurs
	*/
	private void attacherReactions() {
		//Creation d'un ecouteur
		this.listeContacts.addMouseListener(new EcouteurListeGauche(this));
		this.sauvegarder.addActionListener(new EcouteurItemSauver(this));
		this.charger.addActionListener(new EcouteurItemCharger(this));
		this.ajouterContact.addActionListener(new EcouteurItemAjouter(this));
		this.aide.addActionListener(new EcouteurItemAide(this));
		this.supprimerContact.addActionListener(new EcouteurItemSupprimer(this));
		this.quitter.addActionListener(new EcouteurItemQuitter(this));
		this.modifierContact.addActionListener(new EcouteurItemModifier(this));
		this.composer.addActionListener(new EcouteurItemComposer(this));
	}


	/**
	*Permet d'ajouter un nouveau Contact dans l'Annuaire
	*@param nom Nom du contact a ajouter
	*@param prenom Prenom du contact a ajouter
	*@param numTel Numero du contact a ajouter
	*/
	public void ajouterAbonne(String nom, String prenom, String numTel) {
		Fiche f = new Fiche(nom, prenom, numTel);

		try {
			this.monAnnuaire.ajouter(f.getNom(), f);
			DefaultListModel<String> liste = (DefaultListModel<String>)this.listeContacts.getModel();
			liste.addElement(nom);
			this.modification = true;
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	/**
	*Accesseur de la liste de gauche
	*@return La JList du panel de gauche contenant les Contacts
	*/
	public JList<String> getListeGauche() {
		return this.listeContacts;
	}


	/**
	*Accesseur de l'annuaire
	*@return L'annuaire de l'objet Wintel
	*/
	public Annuaire getAnnuaire() {
		return this.monAnnuaire;
	}


	/**
	*Accesseur de la zone d'affichage du nom
	*@return La zone d'affichage du nom
	*/
	public JTextField getFieldNom() {
		return this.afficheNom;
	}


	/**
	*Accesseur de la zone d'affichage du prenom
	*@return La zone d'affichage du prenom
	*/
	public JTextField getFieldPrenom() {
		return this.affichePrenom;
	}


	/**
	*Accesseur de la zone d'affichage du numero
	*@return La zone d'affichage du numero
	*/
	public JTextField getFieldNumero() {
		return this.afficheNumero;
	}


	/**
	*Permet de charger et de mettre a jour l'annuaire
	*/
	public void chargerEtAfficherAnnuaire() {
		Annuaire temp;
		temp = this.monAnnuaire.charger();
		this.monAnnuaire = temp;
		this.modification = true;


		DefaultListModel<String> liste = (DefaultListModel<String>)this.listeContacts.getModel();
		liste.clear();
		Enumeration<String> e = this.monAnnuaire.cles();
		while (e.hasMoreElements()) {
			liste.addElement(e.nextElement());
		}
	}


	/**
	*Permet de supprimer un Contact de l'annuaire
	*@param cle Nom du contact a supprimer comme cle
	*/
	public void supprimerContact(String cle) {
		this.monAnnuaire.supprimer(cle);
		DefaultListModel<String> liste = (DefaultListModel<String>)this.listeContacts.getModel();
		liste.removeElement(cle);

		//Efface les champs ou etait affiche les infos du contact
		this.afficheNumero.setText("");
		this.affichePrenom.setText("");
		this.afficheNom.setText("");

		//Annuaire modifie!
		this.modification = true;
	}


	/**
	*Permet d'afficher la fenetre d'ajout d'abonne
	*/
	public void setDialogAjouterVisible() {
		this.dialogAdd.init();
		this.dialogAdd.setVisible(true);
	}


	/**
	*Permet d'afficher la fenetre d'aide
	*/
	public void setDialogAideVisible() {
		this.dialogAide.init();
		this.dialogAide.setVisible(true);
	}


	/**
	*Permet d'afficher la fenetre de modification de contact
	*/
	public void setDialogModifVisible() {
		this.dialogModif.init();
		this.dialogModif.setVisible(true);
	}


	/**
	*Permet d'afficher la fenetre de suppression de contact
	*/
	public void setDialogSupprVisible() {
		this.dialogSuppr.init();
		this.dialogSuppr.setVisible(true);
	}


	/**
	*Permet d'afficher la fenetre d'exit
	*/
	public void setDialogQuitterVisible() {
		this.dialogQuitter.attacherComportements();
		this.dialogQuitter.init();
		this.dialogQuitter.setVisible(true);
	}


	/**
	*Permet d'afficher la fenetre de modification
	*/
	public void setDialogModifierVisible() {
		this.dialogModif.init();
		this.dialogModif.setVisible(true);
	}


	/**
	*Permet d'afficher la fenetre de composition
	*/
	public void setDialogComposerVisible() {
		this.dialogComposer.init();
		this.dialogComposer.setVisible(true);
	}


	/**
	*Permet d'afficher la fenetre de sauvegarde effectuee
	*/
	public void setDialogSauvegarderVisible() {
		this.dialogSauvegarder.init();
		this.dialogSauvegarder.setVisible(true);
	}


	/**
	*Permet d'afficher la fenetre de chargement effectuee
	*/
	public void setDialogChargerVisible() {
		this.dialogCharger.init();
		this.dialogCharger.setVisible(true);
	}


	/**
	*Permet de verifier si la cle est presente
	*/
	public boolean verifyCle(String cle) {
		DefaultListModel<String> liste = (DefaultListModel<String>)this.listeContacts.getModel();
		return liste.contains(cle);
	}


	/**
	*Permet de verifier si l'Annuaire a ete modifie ou pas
	*/
	public boolean verifyModif() {
		return this.modification;
	}


	/**
	*Permet de creer une instance de Wintel, ce qui affiche une fenetre
	*/
	public static void main(String [] args) {
		Wintel wintel = new Wintel();
		wintel.ajouterAbonne("Test", "Test", "0621640");
	}
}
