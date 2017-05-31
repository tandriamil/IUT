package mailtab;

public class MailClient {
//Attributs
    private String user;
    private MailServer server;

//Constructeur
    public MailClient (MailServer server, String user) {
	this.user = user;
	this.server = server;
    }

//Accesseurs
    //Permet de prendre un MailItem sur le serveur
    private MailItem getNextMailItem() {
	MailItem ret;
	ret = this.server.getNextMailItem(this.user);
	return ret;
    }


    //Permet d'afficher le MailItem récupéré sur le serveur
    public void printNextMailItem() {
	MailItem mailtemp;
	mailtemp = this.server.getNextMailItem(this.user);
	System.out.println (mailtemp.enChaine());
    }


    //Envoie un message
    public void sendMailItem (String to, String message) {
	MailItem mailtemp = new MailItem (this.user, to, message);
	this.server.post(mailtemp);
    }
}
