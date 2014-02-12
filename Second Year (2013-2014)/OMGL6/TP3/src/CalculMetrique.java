import java.lang.reflect.*;

/**
 * Class to count a lot of things in a class
 */
public class CalculMetrique {

//Attributes
	Object o;
	Class c;


//Methods
	/**
	 * Constructor
	 * @param o The object to analyse
	 */
	public CalculMetrique(Object o) {
		this.o = o;
		this.c = this.o.getClass();
	}


	/**
	 * Constructor
	 * @param c The class of the object
	 */
	public CalculMetrique(Class c) {
		this.c = c;
		this.o = null;
	}


	/**
	 * Method to get the number of methods
	 * @return The number of methods
	 */
	public int getNumberMethods() {
		int ret;

		//Then gets its methods
		Method[] m = this.c.getMethods();

		//Then gets the number of methods
		ret = m.length;

		//And returns it
		return ret;
	}


	/**
	 * Method to get the number of classes attributes
	 * @return The number of classes attributes
	 */
	public int getNumberAttributes() {
		int ret;

		//Gets all the fields (= attributes)
		Field[] f = this.c.getDeclaredFields();

		//Then gets the number of fields
		ret = f.length;

		return ret;
	}


	/**
	 * Method to get the number of classes instances attributes
	 * @return The number of classes instances attributes
	 */
	public int getNumberInstancesAttributes() {
		int ret = 0;

		//Gets all the fields (= attributes)
		Field[] f = this.c.getDeclaredFields();

		//Then gets the number of instances fields
		for (int i = 0; i < f.length; i++) {

			//If it contains "static"
			if (f[i].getName().matches("(?i).*static.*")) {
				ret++;
			}
		}

		return ret;
	}


	/**
	 * Method to get the number of classes instances attributes
	 * @return The number of classes instances attributes
	 */
	public int getNumberSuperClasses() {
		int ret = 0;

		//Gets the first super class, if it's null, don't enter in the boucle
		Class superClass = this.c.getSuperclass();
		Class current;

		//While there is a super class of this current one
      	while (superClass != null) {
      		ret++;
	        current = superClass;
	        superClass = current.getSuperclass();
     	}

		return ret;
	}


	/**
	 * Displays all the informations
	 */
	public void displaysInformations() {
		System.out.println("\n" + "Début des mesures de la classe " + this.c.getName() + ":");
		System.out.println("Nombre de méthodes: " + this.getNumberMethods());
		System.out.println("Nombre d'attributs de classe: " + this.getNumberAttributes());
		System.out.println("Nombre d'attributs d'instances: " + this.getNumberInstancesAttributes());
		System.out.println("Nombre de super classes: " + this.getNumberSuperClasses());
	}

}