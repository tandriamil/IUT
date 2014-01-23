package ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Gautier Koscielny MAJ par J-F. Kamp
 * @version 1.0
 *
 * <BR>Enseignement : AP5, 1ere annee
 * <BR>Annee Universitaire : 2012/2013
 * <BR>IUT d'informatique, Vannes
 *
 * <BR>Sujet : Correction du TD intitule travail de synthese.
 * <BR>Creation d'une boite de dialogue generique a l'application
 * Wintel. Le constructeur de cette boite ne fait que placer les 
 * differents composants dans la boite. On y definit un comportement
 * par defaut (la fenetre est cachee quand on clique sur l'un ou l'autre
 * des boutons). Il suffit de redefinir les methodes confirmer() et annuler()
 * dans une sous-classe pour modifier le comportement associe au clic sur les boutons.
 * 
 * <BR>Cette classe est abstraite car la methode "confirmer()" est abstraite.
 * Elle doit etre redefinie dans les sous-classes.
 */

abstract class WtDialog extends JDialog {

//Attributs --
	/**
	 * Etiquette du nom
	 */
    protected JLabel lNom;

	/**
	 * Etiquette du prenom
	 */
    protected JLabel lPrenom;

	/**
	 * Etiquette du numero
	 */
    protected JLabel lNumero;

	/**
	 * Etiquette du message a l'utilisateur
	 */
    protected JLabel lEtat;

	/**
	 * Champ textuel pour le nom
	 */
    protected JTextField tfNom;

	/**
	 * Champ textuel pour le prenom
	 */
    protected JTextField tfPrenom ;

	/**
	 * Champ textuel pour le numero
	 */
    protected JTextField tfNumero ;

	/**
	 * Bouton pour confirmer
	 */
    protected JButton bConfirmer;

	/**
	 * Bouton pour annuler
	 */
    protected JButton bAnnuler;
   
    private JPanel pBoutons;
    private JPanel boutonConfirmer;
    private JPanel boutonAnnuler;

//Methodes
    /**
     * Construction de la boite de dialogue generique pour l'application Wintel.
     * @param parent La fenetre "parent" a laquelle est rattache la boite de dialogue
     * @param titre Le titre de la boite de dialogue
     * @param info Texte affiche à l'utilisateur
     */
    public WtDialog(Wintel parent, String titre, String info) {
    	super(parent, titre, true);
    	this.creerInterface(info);
    	this.attacherComportements();
        this.setSize(400, 500);
    	this.setResizable(false);
    	this.setVisible(false);
    }


    /**
     * Methode a appeler avant chaque (re-)affichage (on place la 
     * fenetre relativement a la fenetre principale).
     */    
    public void init() {
    	Wintel parent = (Wintel)this.getOwner();
    	Dimension d = parent.getSize();
    	Point p = parent.getLocation();
    	this.setLocation(p.x+(d.width-getSize().width)/2, p.y+(d.height-getSize().height)/2);
    }


    /**
     * Creation de l'interface (partie presentation).
     *@param info Informations afficher a l'utilisateur
     */
    private void creerInterface(String info) {
    //Le panel du haut qui contient le texte afficher aux utilisateurs
        //Creation de l'element (Pas besoin de le mettre dans un Panel puisqu'il est tout seul)
        lEtat = new JLabel(info);

    //Le panel du centre qui contient les caracteristiques du contact
        //Creation des elements
        lNom = new JLabel("Nom");
        tfNom = new JTextField(20);
        lPrenom = new JLabel("Prenom");
        tfPrenom = new JTextField(20);
        lNumero = new JLabel("Numero");
        tfNumero = new JTextField(20);

        bAnnuler = new JButton("Annuler");
        boutonAnnuler = new JPanel();
        boutonAnnuler.add(bAnnuler);
        boutonAnnuler.setPreferredSize(new Dimension(90, 70));

        bConfirmer = new JButton("Confirmer");
        boutonConfirmer = new JPanel();
        boutonConfirmer.add(bConfirmer);
        boutonConfirmer.setPreferredSize(new Dimension(90, 70));

        //Creation du panel principal des boutons
        pBoutons = new JPanel(new GridLayout(1, 2));

        //Ajout des boutons au panel des boutons
        pBoutons.add(boutonConfirmer);
        pBoutons.add(boutonAnnuler);

        //Creation du panel principal
        this.setLayout(new GridLayout(8, 1));

        //Ajout des elements au panel principal
        this.add(lEtat);
        this.add(lNom);
        this.add(tfNom);
        this.add(lPrenom);
        this.add(tfPrenom);
        this.add(lNumero);
        this.add(tfNumero);
        this.add(pBoutons);
    }
    

    /**
     * Des auditeurs d'evenements sont lies aux boutons confirmer et
     * annuler.
     * <BR>Le clic sur le bouton confirmer entraine
     * l'appel a la methode confirmer() de WtDialog (ou celle
     * de sa sous-classe si elle est surchargee).
     * <BR>De la meme maniere, le clic sur le bouton annuler 
     * entraine un appel a la methode annuler().
     */
    private void attacherComportements () {
    	// pour le bouton Confirmer (comportement par defaut)
    	bConfirmer.addActionListener(new AuditeurConfirmer());

    	// pour le bouton Annuler (comportement par defaut)
    	bAnnuler.addActionListener(new AuditeurAnnuler());
    }


    /**
     * A redefinir dans la sous-classe.
     */
    abstract protected void confirmer();


    /**
     * Consiste simplement a cacher la fenetre.
     */
    protected void annuler() {
    	this.setVisible(false);
        this.initChamps();
    }


    /**
     * Auditeur du bouton confirmer. 
     */
    public class AuditeurConfirmer implements  ActionListener {
    	public void actionPerformed(ActionEvent evt) {
    		confirmer();
    	}
    }
    

    /**
     * Auditeur du bouton annuler.
     */
    public class AuditeurAnnuler implements ActionListener {
    	public void actionPerformed(ActionEvent evt) {
    		annuler();
    	}
    }


    /**
    *Permet de reinitialiser le JTextField du Nom
    */
    public void initChamps() {
        this.tfNom.setText("");
        this.tfNumero.setText("");
        this.tfPrenom.setText("");
    }
}