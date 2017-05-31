import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {


        if (args.length != 2) {
            System.err.println ("nombre d'arguments incorrect");
        }

        else {
            try {
                Socket clientsocket = new Socket (args[0], Integer.parseInt(args [1]));
                PrintStream out = new PrintStream (clientsocket.getOutputStream (), true);
                for (;;) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Veuillez saisir un mot :");
                    String str = sc.nextLine();
                    System.out.println("Vous avez saisi : " + str);
                    out.println (str);
                    out.flush();
                    clientsocket.shutdownOutput();



                    BufferedReader in = new BufferedReader (new InputStreamReader (clientsocket.getInputStream ()));

                    String line = in.readLine();
                    if (line == null) {
                        break;
                    }
                    System.err.println(line);
                    System.err.flush();
                    out.close();
                }
            }

            catch (IOException e){
                System.err.println("socket closed");
                System.err.flush();
            }

            catch (Exception e) {
                e.printStackTrace ();
            }


        }

    }

}
