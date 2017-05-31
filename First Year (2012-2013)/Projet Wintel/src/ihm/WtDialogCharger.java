package ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
*Classe de la boite de dialogue de l'accuse de sauvegarde
*/
public class WtDialogCharger extends JDialog {
//Attributs
	//Zone de texte, seul element de la boite de dialogue
	private JPanel boutonConfirmer;
	private JButton confirmer;
	private JLabel zoneTexte;

//Methodes
	/**
	*Constructeur de la classe WtDialogSauvegarder
	*@param parent Fenetre parent
	*/
	public WtDialogCharger(Wintel parent) {
		super(parent, "Chargement", true);
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
		String txt = "Chargement effectue avec succes !";

		//Creation des elements
		zoneTexte = new JLabel(txt);
		zoneTexte.setHorizontalAlignment(JLabel.CENTER);

		confirmer = new JButton("Fermer");
		boutonConfirmer = new JPanel();
		boutonConfirmer.setPreferredSize(new Dimension(75, 40));
		boutonConfirmer.add(confirmer);

		//Creation du panel principal
		this.setLayout(new GridLayout(2, 1));

		//Ajout du JLabel dans le panel
		this.add(zoneTexte);
		this.add(boutonConfirmer);
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
