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
    private MailItem getNextMailItem() {
	MailItem ret;
	
        ret = getNextMailItems (this.user);
	return ret;
    }

    
    public void printnextMailitem() {
    }

    
    public void sendmailItem (String to, String message) {
    }
}