import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] zero) {
        
        ServerSocket socketserver;
        Socket socketduserveur;

        try {
            // création d'un objet serveur à l'écoute du port 80
            socketserver = new ServerSocket(80);
            System.out.println ("socketserver lancé !");

            socketduserveur = socketserver.accept(); 
            System.out.println("connexion réussie et établissement d'un socket entre le serveur et le client !");
            socketserver.close();
            socketduserveur.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}