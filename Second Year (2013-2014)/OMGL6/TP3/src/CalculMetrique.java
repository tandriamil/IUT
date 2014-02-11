import java.reflect.*;

/**
 * Class to count a lot of things in a class
 */
public class CalculMetrique {

//Attributes
	Object theObject;


//Methods
	/**
	 * Constructor
	 * @param o The object to analyse
	 */
	public CalculMetrique(Object o) {
		this.theObject = o;

		//Displays the name of the class
		Class oClass = o.getClass();
		String name = oClass.getName();
		System.out.println("L'objet est instance de " + name + ".");
	}


	/**
	 * Method to get the number of methods
	 * @return The number of methods
	 */
	public int getNumberMethods() {
		int ret;

		return ret;
	}


	/**
	 * Method to get the number of classes attributes
	 * @return The number of classes attributes
	 */
	public int getNumberAttributes() {
		int ret;

		return ret;
	}


	/**
	 * Method to get the number of classes attributes
	 * @return The number of classes attributes
	 */
	public int getNumberAttributes() {
		int ret;

		return ret;
	}
}