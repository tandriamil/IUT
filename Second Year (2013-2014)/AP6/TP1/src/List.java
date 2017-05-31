package datastruct;

/**
 * Interface pour les listes
 */
public interface List {
//Methodes de l'interface
	
	/**
	 * Methode pour inserer un objet
	 * @param data Objet a inserer
	 */
	public void insert(Object data);


	/**
	 * Methode pour supprimer l'element courant, le current
	 */
	public void delete();


	/**
	 * Methode pour verifier si la chaine contient un objet
	 * @param data L'objet a verifier dans la chaine
	 * @return true si objet present, false sinon
	 */
	public boolean contains(Object data);


	/**
	 * Renvoie la valeur contenue dans l'element current
	 * @return L'information contenue dans l'element current
	 * @param index L'emplacement de l'element
	 */
	public Object getValue();


	/**
	 * Modifie les informations contenues dans l'element courant
	 * @param newData Information a mettre dans le current
	 */
	public void setValue(Object newData);


	/**
	 * Verifie si la chaine est vide ou non
	 * @return true si chaine vide, false sinon
	 */
	public boolean isEmpty();


	/**
	 * Renvoie la taille de la chaine
	 * @return La taille de la chaine
	 */
	public int getSize();
}
