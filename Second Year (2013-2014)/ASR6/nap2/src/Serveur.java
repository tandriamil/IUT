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
//Attributes
    private ServerSocket socketserver = null;
    private Socket socketduserveur = null;
    private int numPort;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private boolean waitNext;
    private Client[] listClient;
    private int nbClient;


//Methods
    /** 
     * The constructor
     * @param port The number of the port to use
     */
    public Serveur(int port) {
        //Initializes the port, the boolean and the list of client
        this.numPort = port;
        this.listClient = new Client[10];
        this.waitNext = true;
        this.nbClient = 0;



        //Creates the ServerSocket and catches errors if there are some
        try {
            this.socketserver = new ServerSocket(this.numPort);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the ServerSocket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        catch (SecurityException e) {
            System.out.println("SecurityException catched when initializing the ServerSocket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("ServerSocket correctly created on the port number " + this.numPort + ".");



        //Creates the Socket of the server and catches errors if there are some
        try {
            this.socketduserveur = new Socket(InetAddress.getLocalHost(), this.numPort);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the socketduserveur: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        catch (SecurityException e) {
            System.out.println("SecurityException catched when initializing the socketduserveur: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Server's socket created on localhost:" + this.numPort + ".");



        //Creates the BufferedReader
        try {
            in = new BufferedReader(new InputStreamReader(socketduserveur.getInputStream()));
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the BufferedReader: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println ("BufferedReader correctly created!");



        //Creates the PrintWriter
        try {
            //true for auto_flush so it flushed everytime we do a println
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketduserveur.getOutputStream())), true);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the PrintWriter: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println ("PrintWriter correctly created!");



        //Accepts sockets incomings
        try {
            socketduserveur = socketserver.accept();
        }

        catch (IOException e) {
            System.out.println("IOException catched when the socketduserveur waits some sockets: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println ("The server accepts sockets now.");
    }


    /**
     * Permits to close the server
     */
    public void closeServer() {
        //Closes the reader/writer
        try {
            in.close();
            out.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing in and out: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Reader/Writer correctly closed.");



        //Then finish by closing the two sockets
        try {
            this.socketserver.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing the ServerSocket: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("ServerSocket is correctly closed.");


        try {
            this.socketduserveur.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing the socketduserveur: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Server's socket is correctly closed.");
    }


    /**
     * Waits a connection and messages
     */
    public void waitConnection() {
        //Then the boucle to wait
        while (this.waitNext) {
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

            System.out.println("Message: " + str);
            out.println(str);
        }
    }
}