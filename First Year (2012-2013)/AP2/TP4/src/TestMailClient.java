package mailtab;

//Attention, à refaire car très sale et fonctionnant PAS /!\

public class TestMailClient {
    public static void main() {
	//Test Constructeur
	String user = "Roger";
	MailServer server1 = new MailServer();
	
	MailClient client1 = new MailClient (server1, "Roger");
    }
}