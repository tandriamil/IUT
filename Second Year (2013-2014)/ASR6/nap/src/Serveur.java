import java.io.IOException;
import java.net.InetAddress;
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
        ServerSocket socketserver = null;
        Socket socketduserveur = new Socket();

        //Gets the port
        int numPort = Integer.parseInt(args[0]);


        //Creates the ServerSocket and catches errors if there are some
        try {
            socketserver = new ServerSocket(numPort);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the ServerSocket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        catch (SecurityException e) {
            System.out.println("SecurityException catched when initializing the ServerSocket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Le ServerSocket est correctement créer sur le port " + numPort + ".");



        //Creates the Socket of the server and catches errors if there are some
        try {
            socketduserveur = new Socket(InetAddress.getLocalHost(), numPort);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the socketduserveur: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        catch (SecurityException e) {
            System.out.println("SecurityException catched when initializing the socketduserveur: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Le socketduserveur est correctement créer en localhost sur le port " + numPort + ".");



        //Waits if some sockets come
        try {
            while (true) {
                socketduserveur = socketserver.accept();
            }
        }

        catch (IOException e) {
            System.out.println("IOException catched when the socketduserveur waits some sockets: " + "\n" + e.getMessage());
            e.printStackTrace();
        }


        //If everything's ok until there
        System.out.println ("Socketserver lancé!");
        System.out.println("Connexion réussie et établissement d'un socket entre le serveur et le client!");



        //Then finish by closing the two sockets
        try {
            socketserver.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing the ServerSocket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Le ServerSocket est correctement fermé.");


        try {
            socketduserveur.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing the socketduserveur: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Le socketduserveur est correctement fermé.");
    }

}