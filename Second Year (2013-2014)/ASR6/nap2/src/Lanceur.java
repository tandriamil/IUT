/**
 * The class to launch the application
 */
public class Lanceur {

	/**
	 * The main method to run the application
	 */
	public static void main(String[] args) {
		//Gets the port
		int port = Integer.parseInt(args[0]);
		System.out.println("Lancement de l'application sur le port " + port + ".");

		//Creates the server
		Serveur serv = new Serveur(port);

		//Then waits some connection
		serv.waitConnection();

		//When finished, close it
		serv.closeServer();
	}

}