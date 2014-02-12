package ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import datas.*;

/**
*La classe de fenetre de dialogue "Modifier"
*/
public class WtDialogModifier extends WtDialog {
//Attributs
    WtDialogChampManquant wtDialogChampManquant;
    WtDialogNomNonExistant wtDialogNomNonExistant;

//Methodes
    /**
    *Constructeur de WtDialogModifier
    */
    public WtDialogModifier(Wintel parent) {
        super(parent, "Modifier un Contact", "Veuillez entrer les nouvelles informations du Contact déjà existant:");
        wtDialogChampManquant = new WtDialogChampManquant(this);
        wtDialogNomNonExistant = new WtDialogNomNonExistant(this);
    }


    /**
     * Methode a appeler avant chaque (re-)affichage (on place la 
     * fenetre relativement a la fenetre principale).
     */    
    public void init() {
        //Recup du contact cible + ajout dans le champ nom
        Wintel parent = (Wintel)this.getOwner();
        this.tfNom.setText(parent.getFieldNom().getText());
        this.tfPrenom.setText(parent.getFieldPrenom().getText());
        this.tfNumero.setText(parent.getFieldNumero().getText());
        Dimension d = parent.getSize();
        Point p = parent.getLocation();
        this.setLocation(p.x+(d.width-getSize().width)/2, p.y+(d.height-getSize().height)/2);
    }


    /**
    *Reaction au clic de confirmer
    */
    public void confirmer() {
        //Test si le champ est vide ou non
        if (! tfNom.getText().equals("")) {
            //Recuperation des infos de l'Annuaire
            Wintel parent = (Wintel)this.getOwner();

            //Test si le nom est present dans l'annuaire
            if (parent.verifyCle(tfNom.getText())) {
                //Recuperation des informations
                String cle = tfNom.getText();
                String prenom = tfPrenom.getText();
                String numero = tfNumero.getText();

                //Modification dans l'annuaire
                parent.supprimerContact(cle);
                parent.ajouterAbonne(cle, prenom, numero);

                //Ferme la fenetre
                this.setVisible(false);
            }

            //Si nom non present dans l'Annuaire
            else {
                this.wtDialogNomNonExistant.init();
                this.wtDialogNomNonExistant.setVisible(true);
            }
        }

        else {
            this.wtDialogChampManquant.init();
            this.wtDialogChampManquant.setVisible(true);
            tfNom.setText("ERREUR: Champ manquant!!!");
        }
    }
}