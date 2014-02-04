import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;

public class Serveur {

	public static void main(String[] zero) {
        
        ServerSocket socketserver;
        Socket socketduserveur;
        BufferedReader in; // buffer in pour récupérer des messages
        PrintWriter out; // printer-out pour envoyer des messages

        try {
        
            // création d'un servercosket à l'écoute sur le port 1234
            socketserver = new ServerSocket(1234);
            System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
            
            // attente d'une demande de connexion provenant du client
            socketduserveur = socketserver.accept(); 

            // création d'un printer-out pour transmettre un message au client
            out = new PrintWriter(socketduserveur.getOutputStream());
            out.println("message du serveur : connexion établie !");
            out.flush();

            // création du lecteur pour récupérer un éventuel message venant du client
            in = new BufferedReader (new InputStreamReader (socketduserveur.getInputStream()));
            String message_distant = in.readLine();
            System.out.println(message_distant);
                       
            // fermeture du socket puis du serversocket           
            socketduserveur.close();
            socketserver.close();
                
        }

        catch (IOException e) {
           e.printStackTrace();
        }
    }

}