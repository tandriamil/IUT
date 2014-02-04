import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        Socket socketduserveur = null;

        //Gets the port
        int numPort = Integer.parseInt(args[0]);

        //Creates the buffer and the writer to send/receive messages
        BufferedReader in = null;
        PrintWriter out = null;

        //The boolean to continue
        boolean waitNext = true;


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



        //Accepts sockets incomings
        try {
            socketduserveur = socketserver.accept();
        }

        catch (IOException e) {
            System.out.println("IOException catched when the socketduserveur waits some sockets: " + "\n" + e.getMessage());
            e.printStackTrace();
        }



        //Creates the BufferedReader
        try {
            in = new BufferedReader(new InputStreamReader(socketduserveur.getInputStream()));
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the BufferedReader: " + "\n" + e.getMessage());
            e.printStackTrace();
        }



        //Creates the PrintWriter
        try {
            //true for auto_flush so it flushed everytime we do a println
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketduserveur.getOutputStream())), true);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the PrintWriter: " + "\n" + e.getMessage());
            e.printStackTrace();
        }


        //If everything's ok until there
        System.out.println ("Serveur lancé!");



        //Then the boucle to wait
        while (waitNext) {
            String str = "";

            //Read the message
            try {
                str = in.readLine();
            }

            catch (IOException e) {
                System.out.println("IOException catched when trying to read the line: " + "\n" + e.getMessage());
                e.printStackTrace();
            }

            //If it's the exit message
            if (str.equals("exit")) {
                waitNext = false;
            }

            System.out.println("Message: " + str);   // trace locale
            out.println(str);
        }



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