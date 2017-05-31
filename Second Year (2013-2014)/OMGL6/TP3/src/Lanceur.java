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

		//For all the infos of Wintel
		getInfos(win);
	}


	/**
	 * Displays packages informations
	 */
	private static void getInfos(Object o) {
		//Gets the class of the object
		Class c = o.getClass();

		//Displays the beginning
		System.out.println("\n" + "Début des mesures du package de la classe " + c.getName() + ":");

		//For all the packages of Wintel
		int meth = 0;
		int attr = 0;
		int inst = 0;

		//Gets all its superclasses
		Class superClass = c.getSuperclass();
		Class current;
		CalculMetrique tmp;

		//While there is a super class of this current one
      	while (superClass != null) {
      		//Gets all the infos of the superclasses
      		tmp = new CalculMetrique(superClass);

      		//Gets all the values
      		meth = meth + tmp.getNumberMethods();
      		attr = attr + tmp.getNumberAttributes();
      		inst = inst + tmp.getNumberInstancesAttributes();

      		//Increments
	        current = superClass;
	        superClass = current.getSuperclass();
     	}

     	tmp = new CalculMetrique(c);
     	int nbSup = tmp.getNumberSuperClasses();

     	System.out.println("Nombre total de méthodes: " + meth);
		System.out.println("Nombre total d'attributs de classe: " + attr);
		System.out.println("Nombre total d'attributs d'instances: " + inst);
		System.out.println("Nombre total de super classes: " + nbSup);

		System.out.println("\n" + "Nombre moyen de méthodes: " + (meth / nbSup));
		System.out.println("Nombre moyen d'attributs de classe: " + (attr / nbSup));
		System.out.println("Nombre moyen d'attributs d'instances: " + (inst / nbSup));
	}
}
