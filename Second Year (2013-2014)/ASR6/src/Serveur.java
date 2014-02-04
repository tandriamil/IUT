import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The server class
 */
public class Serveur {

    /** 
     * The main method to be thrown
     */
	public static void main(String[] args) {
        
        //Creates the sockets
        ServerSocket socketserver;
        Socket socketduserveur;

        //Gets the port
        int numPort = Integer.parseInt(args[0]);

        try {
            //Creates the server's socket
            socketserver = new ServerSocket(numPort);
            System.out.println ("Socketserver lancé!");

            socketduserveur = socketserver.accept(); 
            System.out.println("Connexion réussie et établissement d'un socket entre le serveur et le client!");
            socketserver.close();
            socketduserveur.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}