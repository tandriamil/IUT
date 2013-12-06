class TestPoint {
    public static void main (String [] toto)
    { // Test constructeur + Méthodes getX et getY
	Point p1 = new Point (20,30);
	int var1 = p1.getX();
	int var2 = p1.getY();

	if (var1 == 20) {
	    System.out.println ("Test constructeur réussi!");
	}
	else {
	    System.out.println ("Test constructeur échoué!");
	}


	if (var2 == 30) {
	    System.out.println ("Test constructeur réussi!");
	}
	else {
	    System.out.println ("Test constructeur échoué!");
	}

	// Test des setY et setX
	p1.setX(40);
	p1.setY(50);
	int var3 = p1.getX();
	int var4 = p1.getY();
	
	if (var3 == 40) {
	    System.out.println ("Test setX réussi!");
	}
	else {
	    System.out.println ("Test setX échoué!");
	}

	if (var4 == 50) {
	    System.out.println ("Test setY réussi!");
	}
	else {
	    System.out.println ("Test setY échoué!");
	}
	    
	// Test du calcul de la distance par rapport à l'origine
	Point p2 = new Point(0, 8);
	
	double var5 = p2.distOrig();

	if (var5 == 8) {
	    System.out.println ("Le calcul par rapport à l'origine fonctionne!");
	}
	else {
	    System.out.println ("Le calcul par rapport à l'origine ne fonctionne pas!");
	}

    }

}