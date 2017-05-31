package Parking;

/**
*Classe gerant les exceptions de Parking et Voiture
*/
public class ExceptionParking extends Throwable {
	//Attributs
	private static final long serialVersionUID = 1;


	//Methodes
	/**
	*Constructeur
	*@param messageErreur Message d'erreur a signaler
	*/
	public ExceptionParking(String messageErreur) {
		super(messageErreur);
	}
}
