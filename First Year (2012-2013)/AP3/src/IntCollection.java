/**
*@author Andriamilanto Tompoariniaina - Groupe C1 - Info 1 (2012-2013)
*@version Bêta 1.0
*Programme permettant de tester différentes méthodes de recherche et de tri, ainsi que de calculer leurs efficacité
*/
public class IntCollection {
    private int flag; //Drapeau pour la case actuelle du tableau
    private int tab[]; //Tableau d'entier sur lequel on va travailler
    
    /**
    *Constructeur de la classe
    *@param maxSize La taille maximale du tableau
	*/
    public IntCollection(int maxSize) { //Attention, la case 0 est compté!
		this.tab = new int[maxSize];
		flag = 0;
    }



    //******************************************************
    //Création et modification du tableau
    /**
    *Permet d'ajouter une valeurs au tableau
    *@param value La valeur à ajouter à la case du tableau
    *@return La valeur de la somme des deux entiers spécifiés.
	*/
    public void add(int value) {
    	if (this.flag < (this.tab.length - 1)) {
			this.tab[this.flag] = value;
			this.flag++;
    	}
    	else {
    		System.out.println("Tableau rempli!");
    	}
    }


    /**
    *Accesseur de l'attribut flag
	*/
    public int getSize() {
		return this.flag;
    }


    /**
    *Accède à la taille du tableau
	*/
    public int getMaxSize() {
		return (this.tab.length - 1);  //Nombre de cases du tableau (La case 0 étant comtpée!)
    }


    /**
    *Mélange le contenu du tableau aléatoirement
	*/
    public void mix() {
	int temp;
	int aleat;

		for (int i = this.flag; i > 0; i--) {
	   		temp = this.tab[i];
	   		aleat = (int)(Math.random()*i);
	   		this.tab[i] = this.tab[aleat];
	   		this.tab[aleat] = temp;
		}
	}


	/**
	*Affiche le contenu du tableau en String
	*@return Un String affichant le contenu du tableau
	*/
	public String toString() {
		String ret = "";
		int count = 0;

		for (int i = 0; i < this.flag; i++) {
			ret = ret + this.tab[i] + " ";
			count++;

			if (count == 10) {
				ret = ret + '\n';
				count = 0;
			}
		}

		return ret;
	}


	/**
	*Vérifie que le tableau est trié
	*@return True si tableau trié, sinon false
	*/
	private boolean sortCheck() {
		int counter = 0;

		for (int i = 0; i < this.flag; i++) {
			if (this.tab[i] < this.tab[i+1]) {
				counter++;
			}
		}

		if (counter == (this.flag - 1)) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	*Affiche si le tableau est trié ou non
	*/
	public void sortTest() {
		if (this.sortCheck() == true) {
			System.out.println("Le tableau est correctement trié!");
		}
		
		else {
			System.out.println("Le tableau est mal trié! ERREUR!");
		}
	}


	/**
	*Rempli le tableau avec des valeurs comprises entre min et max
	*@param min Valeur minimale
	*@param max Valeur maximale
	*/
	public void fill(int min, int max) {
		for (int i = 0; i < this.tab.length; i++) {
			this.tab[i] = (int)(Math.random() * (max - min)) + min;
		}
		this.flag = (this.tab.length - 1);
	}



	//****************************************************************
    //Recherches sur le tableau

	/**
	*Effectue une recherche dichotomique
	*@param value Valeur à recherchée
	*@return True si la valeur est trouvée, sinon false
	*/
	public boolean dicotomicResearch(int value) {
		int inf = 0;
		int sup = this.flag;
		int med;

		while (inf != sup) {
			med = (int)((inf + sup) / 2);

			if (value > tab[med]) {
				inf = med + 1;
			}
			else {
				sup = med;
			}
		}

		if (value == tab[inf]) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	*Effectue une recherche séquentielle
	*@param value Valeur recherchée
	*@return True si la valeur est trouvée, sinon false
	*/
	public boolean sequentialResearch(int value) {
		boolean ret = false;

		for (int i = 0; i <= this.flag; i++) {
			if (this.tab[i] == value) {
				ret = true;
				i = this.flag;
			}
		}

		return ret;
	}


	/**
	*Supprime la première récurrence d'une valeur du tableau
	*@param value Valeur à supprimée
	*@return True si la valeur est trouvée et supprimée, sinon false
	*/
	public boolean delete(int value) {
		boolean ret = false;
		int i = 0;

		while (i <= this.flag && ret == false) {

			if (this.tab[i] == value) {

				//Décalage des valeurs du tableau
				 for (int j = i; j < this.flag; j++) {
				 	tab[j] = tab[j + 1];
				 }
				 this.flag = this.flag - 1;
				 ret = true;
			}

			i++;
		}

		return ret;
	}


	/**
	*Supprime toutes les valeurs value du tableau
	*@param value Valeur recherchée
	*@return Le nombre de valeurs supprimées
	*/
	public int deleteAll(int value) {
		int ret = 0;

		for (int i = 0; i <= this.flag; i++) {

			if (this.tab[i] == value) {
				
				//Décalage des valeurs du tableau
				 for (int j = i; j < this.flag; j++) {
				 	tab[j] = tab[j + 1];
				 }
				 this.flag--;
				 ret++;
			}
		}

		return ret;
	}


	/**
	*Donne le nombre d'occurence d'une valeur donnée
	*@param value Valeur recherchée
	*@return Le nombre d'occurence d'une valeur donnée
	*/
	public int getNumberOf(int value) {
		int ret = 0;

		for (int i = 0; i <= this.flag; i++) {
			if (this.tab[i] == value) {
				ret = ret + 1;
			}
		}

		return ret;
	}


	/**
	*Effectue une recherche séquentielle
	*@param valur Valeur recherchée
	*@return True si la valeur est trouvée, sinon false
	*/
	public void automaticSearch(int value) {
		if (this.sortCheck() == true) {
			if (this.dicotomicResearch(value) == true) {
				System.out.println("D'après une recherche dichotomique, il y a bien la valeur " + value + " dans le tableau.");
			}
			else {
				System.out.println("D'après une recherche dichotomique il n'y pas la valeur " + value + " dans le tableau.");
			}
		}

		else {
			if (this.sequentialResearch(value) == true) {
				System.out.println("D'après une recherche séquentielle, il y a bien la valeur " + value + " dans le tableau.");
			}
			else {
				System.out.println("D'après une recherche séquentielle, il n'y pas la valeur " + value + " dans le tableau.");
			}
		}
	}


	/**
	*Réinitialise le tableau
	*/
	public void resetTab() {
		this.flag = 0;
	}


	/**
	*Rempli le tableau avec des valeurs croissantes
	*/
	public void fill2() {
		for (int i = 1; i < this.tab.length; i++) {
			add(i);
		}
	}


	//#############################################################################
	//Algorithmes de tri

	/**
	*Effectue un tri par sélection
	*/
	public void sortBySelection() {
		int temp, indexMin;

		for (int i = 0; i < this.tab.length; i++) {
			indexMin = i;
			for (int j = 0; j < this.tab.length; j++) {
				if (this.tab[j] > this.tab[indexMin]) {
					indexMin = j;
				}
				temp = this.tab[indexMin];
				this.tab[indexMin] = this.tab[i];
				this.tab[i] = temp;
			}
		}
	}


	/**
	*Effectue une séparation monodirectionnelle
	*@param start Valeur de début
	*@param stop Valeur de stop ou de fin
	*@return ???
	*/
	public int monoSeparation(int start, int stop) {
		int pivot = this.tab[start];
		int count = start;
		int temp;

		for (int i = (start + 1); i <= stop; i++) {
			if (this.tab[i] < pivot) {
				count++;
				temp = this.tab[i];
				this.tab[i] = this.tab[count];
				this.tab[count] = temp;
			}
		}
		this.tab[start] = this.tab[count];
		this.tab[count] = pivot;
		return count;
	}

	
	/**
	*Effectue un tri par séparation monodirectionnelle
	*@param start Valeur de début
	*@param stop Valeur de stop ou de fin
	*/ //Tri à un seul sens, de gauche à droite
	public void monoDirectionSort(int start, int stop) {
		int pivotPosition = monoSeparation(start, stop);

		if (start < stop) { //Condition d'arrêt
			monoDirectionSort(start, pivotPosition);
			monoDirectionSort((pivotPosition + 1), stop);
		}
	}


	/**
	*Effectue une séparation bidirectionnelle
	*@param start Valeur de début
	*@param stop Valeur de stop ou de fin
	*/
	public int biDirectionSeparation(int start, int stop) {
		int pivot = this.tab[start];
		int left = start;
		int right = stop;

		while(left < right) {

			while(this.tab[right] > pivot)
				right--;

			this.tab[left] = this.tab[right];
			this.tab[right] = pivot;
			if (left != right)
				left++;


			while(this.tab[left] < pivot)
				left++;

			this.tab[right] = this.tab[left];
			this.tab[left] = pivot;
			if (left != right)
				right--;
		}

		return right;
	}


	/**
	*Effectue un tri par séparation bidirectionnelle
	*Plus rapide que le monoDirectionSort!
	*@param start Valeur de début
	*@param stop Valeur de stop ou de fin
	*/
	public void biDirectionSort(int start, int stop) {
		if (start < stop) {
			int pivotPosition = this.biDirectionSeparation(start, stop);
			this.biDirectionSort(start, (pivotPosition - 1));
			this.biDirectionSort((pivotPosition + 1), stop);
		}
	}
}