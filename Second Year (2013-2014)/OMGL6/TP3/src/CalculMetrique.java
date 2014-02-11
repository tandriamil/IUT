import java.lang.reflect.*;

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
	 * @return The number of methods, -1 if error
	 */
	public int getNumberMethods() {
		int ret = -1;

		//Firstly, gets the class of the object
		Class c = o.getClass();

		//Then gets its methods
		Method[] m = c.getMethods();

		//Then gets the number of methods
		ret = m.lenth();

		return ret;
	}


	/**
	 * Method to get the number of classes attributes
	 * @return The number of classes attributes, -1 if error
	 */
	public int getNumberAttributes() {
		int ret = -1;

		return ret;
	}
}