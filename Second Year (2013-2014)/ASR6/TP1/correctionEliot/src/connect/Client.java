package connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;


public class Client implements Runnable{

	private Vector <Client> clients;
	private BufferedReader in;
	private PrintStream out;
	private String nom;
	
	public Client(BufferedReader in, PrintStream out, Vector <Client> clients) {
		this.in = in;
		this.out = out;
		this.clients = clients;
	}
	
	public void run() {
		try {
			// On demande le nom au client
			out.println("Quel est votre nom?");
			nom = in.readLine();
			System.out.println(nom + " s'est connecté.");
			out.println("Welcome " + nom);
			
			// On envoi le message de connection du nouveau client aux autres clients
			synchronized(clients) {
				for(int i = 0; i < clients.size(); i++) {
					if(clients.get(i) != this) {
						clients.get(i).getPrintStream().println(nom + " s'est connecté.");
						clients.get(i).getPrintStream().flush();
					}
				}
			}

			while(true) {
				String lineIn = in.readLine();
				
				// Déconnection d'un client
				if(lineIn == null) {
					synchronized(clients){
						clients.remove(this);
						
						for(int i = 0; i < clients.size(); i++) {
							clients.get(i).getPrintStream().println(nom + " s'est déconnecté.");
							clients.get(i).getPrintStream().flush();		
						}	
					}
					
					System.out.println(nom + " s'est déconnecté.");
					System.out.flush();
					break;
				}
				
				// Affichage du message dans la console du serveur
				System.out.println(nom + ": " + lineIn);
				System.out.flush();
				
				// Envoi du message aux autres clients
				synchronized(clients) {
					for(int i = 0; i < clients.size(); i++) {
						if(clients.get(i) != this) {
							clients.get(i).getPrintStream().println(nom + ": " + lineIn);
							clients.get(i).getPrintStream().flush();
						}
					}
				}
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public PrintStream getPrintStream() {
		return out;
	}
}