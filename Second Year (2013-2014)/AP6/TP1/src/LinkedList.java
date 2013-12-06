package datastruct;

/**
 * Classe de la chaine
 */
public class LinkedList implements List {
//Attributs
	private Element sentinel;
	private Element current;
	private int nbElement;

	
//Methodes
	/**
	 * Constructeur
	 */
	public LinkedList() {
		//On insere la sentinelle afin d'evier tout problemes
		this.sentinel = new Element(null, null, null);
		this.sentinel.prev = this.sentinel;
		this.sentinel.next = this.sentinel;
		current = this.sentinel;

		//Initilisation du nombre d'elements a 0
		this.nbElement = 0;
	}
	
	@Override
	public void insert(Object data) {
		//Creation du nouvel element, son prev est le current, son next est le suivant du current
		Element newElt = new Element (this.current, data, this.current.next);

		//Le suivant du courant est donc le nouveau
		this.current.next = newElt;

		//Le precedent de ce qui etait le suivant du courant est donc le nouvel element
		newElt.next.prev = newElt;

		//Finalement, le courant devient ce nouvel element
		this.current = newElt;

		//On incremente le nombre total d'elements
		this.nbElement++;
	}

	
	@Override
	public void delete() {
		this.current.prev.next = this.current.next;
		this.current.next.prev = this.current.prev;
		this.current = this.current.prev;

		//On decremente le nombre total d'elements seulement si le current n'est pas la sentinelle
		if (this.current != this.sentinel) {
			this.nbElement--;
		}
	}

	
	@Override
	public boolean contains(Object data) {
		boolean ret = false;
		Element tmp = sentinel.next;
		int i = 0;
		
		while ((!ret) && (i < nbElement)) {		
			if (tmp.info == data) {
				ret = true;
			}			
			else {
				tmp = tmp.next;
				i++;
			}		
		}		
		return ret;
	}
	
	
	@Override
	public Object getValue() {
		Object ret = current.info; //Acces direct grace a la classe interne
		return ret;
	}

	

	@Override
	public void setValue(Object newData) {
		current.info = newData; //On y a acces directement grace au mecanisme de classe interne
	}

	
	@Override
	public boolean isEmpty() {
		boolean ret = false;
		Element tmpprev = sentinel.prev;
		Element tmpnext = sentinel.next;
		//Si le prev ET le next de la sentinelle pointent sur la sentinelle elle-meme, si c'est le cas alors on a une liste avec seulment une sentinelle et donc vide
		if ((tmpprev == sentinel) && (tmpnext == sentinel)) {
			ret = true;
		}
		return ret;
	}

	
	@Override
	public int getSize() {
		return this.nbElement;
	}


	/**
	* Methode placant le curseur au debut de la liste
	*/
	public void goToHead() {
		//On considere ici que la liste commence a l'element situe juste apres la sentinelle
		this.current = this.sentinel.next;
	}
	
	
	/**
	* Methode placant le curseur a la fin de la liste
	*/
	public void goToEnd() {
		//On considere ici que la liste finit a l'element situe juste avant la sentinelle
		this.current = this.sentinel.prev;
	}
	
	
	/**
	* Methode positionant le curseur sur l'element situe avant le current
	* @return Un booleen indiquant si le positionnement a bien ete effectue
	*/
	public boolean previous() {
		boolean ret = false;
		try {
			//Si liste vide, impossible d'aller au precedent
			if (this.nbElement == 0) {
				ret = false;
			}
			else {
				this.current = this.current.prev;
				ret = true;
			}
		}
		catch (Exception e) {
			e.getMessage();
			System.out.println ("Erreur: Impossible de deplacer le curseur sur l'element precedent");
		}
		return ret;
	}
		
	
	/**
	* Methode positionant le curseur sur l'element situe apres le current
	* @return Un booleen indiquant si le positionnement a bien ete effectue
	*/	
	public boolean next() {
		boolean ret = false;
		try {
			//Si liste vide impossible d'aller au suivant
			if (this.nbElement == 0) {
				ret = false;
			}
			else {
				//Si dernier element, impossible aussi
				if (this.current == this.sentinel.prev) {
					ret = false;
				}
				else {
					this.current = this.current.next;
					ret = true;
				}
			}
		}
		catch (Exception e) {
			e.getMessage();
			System.out.println ("Erreur: Impossible de deplacer le curseur sur l'element suivant");
		}
		return ret;
	}


	/**
	* Methode qui renvoie la donnee a la position index dans la liste
	* @param La position choisie
	* @return L'info de type Object trouvee
	*/
	public Object getValueAt(int index) {
		Object ret = null;
		
		//Verif si l'index est correcte ou non
		if ((index <= this.nbElement) && (index >= 0)) {
			Element tmp = this.sentinel.next;
			for (int i = 0; i < index; i++) {
				ret = tmp.info;
				tmp = tmp.next;
			}
		}
		else {
			ret = null;
		}
		return ret;
	}
	
	
	/**
	 * Methode retournant un affichage de la chaine
	 * @return Une chaine de caractere pour l'affichage
	 */
	public String toString() {
		String ret = "";
		
		//Si liste vide!
		if (this.nbElement == 0) {
			ret = "Liste vide!";
		}
		else {
			Element tmpStart = sentinel; // on commence au debut de la chaine
			for (int i = 1; i <= nbElement; i++) {
				tmpStart = tmpStart.next;
				// quand on atteint le dernier element (int = nbElement)
				ret = ret + i + ": " + tmpStart.info.toString() + "\n";
			}
		}
		return ret;
	}
	
	
	/**
	* Methode verifiant si il y a un element avant le courant
	* @return Un booleen indiquant si il y a un element avant le courant
	*/
	public boolean hasPrevious() {
		boolean ret = false;
		//On verifie que le prev n'est pas la sentinelle
		if (this.current.prev != this.sentinel) {
			ret = true;
		}
		return ret;
	}
	
	
	/**
	* Methode verifiant si il y a un element apres le courant
	* @return Un booleen indiquant si oui ou non un element est present
	*/
	public boolean hasNext() {
		boolean ret = false;
		// on verifie que le next n'est pas la sentinelle
		if (this.current.next != this.sentinel) {
			ret = true;
		}
		return ret;
	}
	
	
	
	
	
	
	/*########################################### Classes internes ###########################################*/
	
	
	/**
	 * La classe pour les elements de la liste chainee
	 */
	private class Element {
	//Attributs
		Element prev;  // L'element precedent
		Element next;  // L'element suivant
		Object info;   // Les informations contenues dans l'element

	//Methodes
		/**
		 * Constructeur vide pour la sentinelle
		 */
		@SuppressWarnings("unused")
		public Element() {}


		/**
		 * Constructeur pour creer un element instancie avec ses attributs
		 */
		public Element(Element p, Object i, Element n) {
			this.prev = p;
			this.info = i;
			this.next = n;
		}

		//Aucun accesseur car attributs visibles depuis sa classe mere
	}
}
