package ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import datas.*;

/**
*La classe de fenetre de dialogue "Ajouter"
*/
public class WtDialogAjouter extends WtDialog {
//Attributs
    WtDialogChampManquant wtDialogChampManquant;

//Methodes
    /**
    *Constructeur de WtDialogAjouter
    *@param parent Fenetre parent
    */
    public WtDialogAjouter(Wintel parent)  {
        super(parent, "Ajouter un nouveau contact", "Veuillez saisir les coordonnees du nouveau contact :");
        wtDialogChampManquant = new WtDialogChampManquant(this);
    }


    /**
    *Reaction au clic de confirmer
    */
    public void confirmer() {
        //Test si le champ est vide ou non
        if (! tfNom.getText().equals("")) {
            //Recuperation des infos de l'Annuaire
            Wintel parent = (Wintel)this.getOwner();

            //Recuperation des informations
            String nom = tfNom.getText();
            String prenom = tfPrenom.getText();
            String numero = tfNumero.getText();


            //Ajout dans l'annuaire
            parent.ajouterAbonne(nom, prenom, numero);

            //Ferme la fenetre
            this.setVisible(false);
            this.tfNom.setText("");
        }

        else {
            this.wtDialogChampManquant.init();
            this.wtDialogChampManquant.setVisible(true);
            tfNom.setText("");
        }
    }
}
