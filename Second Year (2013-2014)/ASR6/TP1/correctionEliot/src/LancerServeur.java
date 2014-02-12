
import connect.Serveur;


public class LancerServeur {
	public static void main(String[] args) {
		if(args.length != 1){
			System.err.println("Usage: Server <port>");
		}
		else {
			new Serveur(Integer.parseInt(args[0]));
		}

	}
}
