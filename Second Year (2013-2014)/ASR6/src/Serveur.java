import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Serveur {

	public static void main(String[] args) {
        try {    
            int port = Integer.parseInt (args [0]);
            ServerSocket serversocket = new ServerSocket (port);
            System.err.println ("Start server on port : " +port);

            for (;;) {
                Socket socket = serversocket.accept();
                //BufferedReader in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
                PrintStream out = new PrintStream (socket.getOutputStream (), true);
                //BufferedReader sysin = new BufferedReader (new InputStreamReader (System.in));
                //for (;;) {
                   // String line1 = in.readLine();
                   // if (line1 == null) {
                   //     break;
                   // }
                   // System.err.println(line1);
                   // System.err.flush();
                   // String line2 = sysin.readLine();
                    //out.println(line2);
                    //out.flush();
                //}
                //System.err.println("socket closed");
                for (;;) {
                    
                


                    BufferedReader in = new BufferedReader (new InputStreamReader (socket.getInputStream ()));
                
                    String line = in.readLine();
                    if (line == null) {
                        break;
                    }
                    System.err.println(line);
                    System.err.flush();

<<<<<<< HEAD
        catch (IOException e) {
           e.printStackTrace();
=======
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Veuillez saisir un mot :");
                    String str = sc.nextLine();
                    System.out.println("Vous avez saisi : " + str);
                    out.println (str);
                    out.flush();
                    socket.shutdownOutput();
                    
                    out.close();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
>>>>>>> 0099d99bd16a4aea87a30885ab60fb2e943851d1
        }
    }

}