class Point {
    // Attributs
    int x;
    int y;



    // Méthodes
    // Constructeur
    Point (int a, int b) {
	this.x = a;
	this.y = b;
    }


    void setX (int v) {
	this.x = v;
    }


    void setY (int v) {
	this.y = v;
    }


    int getY() {
	return this.y;
    }


    int getX() {
	return this.x;
    }


    // Calcul distance
    double distOrig() {
	double ret;
	ret = (x*x) + (y*y);
	ret = Math.sqrt(ret);
	return ret;
    }

}
