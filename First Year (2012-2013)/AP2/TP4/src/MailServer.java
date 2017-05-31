package mailtab;

public class MailServer {
//Attributs
    private int mailNb;
    private final int SIZEMAX = 10;
    private MailItem [] items;

//Constructeur
    public MailServer() {
	mailNb = 0;
	items = new MailItem [SIZEMAX];
    }

//Accesseurs
    //Accès au nombre de messages d'un client
    public int howManyMailItems (String who) {
	int ret;
	String aqui;

	ret = 0;
	for (int i = 0; i < this.mailNb; i++) {
	    aqui = items[i].getTo();
	    if (aqui.equals(who)) {
		ret = ret + 1;
	    }
	}

	return ret;
    }


    //Accès au dernier message
    public MailItem getNextMailItem (String who) {
	MailItem ret;
	int i;
	boolean atteint = false;

	ret = new MailItem ("le serveur",who,"Pas de message pour vous.");
	for (i = (mailNb-1); i >= 0; i--) {
	    if (atteint == false) {
		if (this.items[i].getTo().equals(who)) {
		    ret = this.items[i];
		    atteint = true;
		    this.removeMail(i);
		}
	    }
	}

	return ret;
    }


    //Permet l'envoie de message
    public void post (MailItem item) {
	if (this.mailNb < this.SIZEMAX) {
	    this.items[mailNb] = item;
	    this.mailNb = this.mailNb + 1;
	}
	else {
	    System.out.println ("Il n'y a plus de place!");
	}
    }


    //Permet de supprimer un MailItem
    private void removeMail (int indice) {
	    for (int i = indice; i < (this.mailNb-1); i++) {
		    this.items[i] = this.items[i+1];
	    }
	    this.mailNb--;
    }
}
