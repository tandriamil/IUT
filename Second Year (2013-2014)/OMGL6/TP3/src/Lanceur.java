import ihm.*;
import datas.*;

/**
 * The main class to launch the tests
 */
public class Lanceur {

	public static void main(String[] args) {

		//For an Annuaire object
		Annuaire ann = new Annuaire();
		CalculMetrique calc = new CalculMetrique(ann);
		calc.displaysInformations();

		//For a Wintel object
		Wintel win = new Wintel();
		CalculMetrique calc2 = new CalculMetrique(win);
		calc2.displaysInformations();
	}
}