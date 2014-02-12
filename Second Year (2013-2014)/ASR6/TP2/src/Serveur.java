import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * The server class
 */
public class Serveur {
//Attributes
    private ServerSocket socketserver = null;
    private int numPort;
    private BufferedReader in;
    private PrintStream out = null;
    private boolean waitNext;
    private Socket socketTravail = null;


//Methods
    /** 
     * The constructor
     * @param port The number of the port to use
     */
    public Serveur(int port) {
        //Initializes the port, the boolean and the list of client
        this.numPort = port;
        this.waitNext = true;


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



        //Creates the BufferedReader
        try {
            this.in = new BufferedReader(new InputStreamReader(socketTravail.getInputStream()));
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the BufferedReader: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println ("BufferedReader correctly created!");



        //Creates the PrintWriter
        try {
            //true for auto_flush so it flushed everytime we do a println
            this.out = new PrintStream(socketTravail.getOutputStream(), true);
        }

        catch (IOException e) {
            System.out.println("IOException catched when initializing the PrintWriter: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println ("PrintWriter correctly created!");
    }


    /**
     * Permits to close the server
     */
    public void closeServer() {
        //Closes the reader/writer
        try {
            this.in.close();
            this.out.close();
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
    }


    /**
     * Waits a connection and messages
     */
    public void waitConnection() {
        //Then the boucle to wait
        while (this.waitNext) {
            //Accepts sockets incomings
            try {
                this.socketTravail = socketserver.accept();
            }

            catch (IOException e) {
                System.out.println("IOException catched when the socketduserveur waits some sockets: " + "\n" + e.getMessage());
                e.printStackTrace();
            }

            System.out.println ("The server accepts now clients!");


            //Creates a client
            Client cli = new Client(socketTravail);

            //Read the message
            cli.start();
        }

        //Then closes it
        try {
            socketTravail.close();
        }

        catch (IOException e) {
            System.out.println("IOException catched when closing the socketduserveur: " + "\n" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Server's socket is correctly closed.");
    }
}