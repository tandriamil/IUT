import media.*;

/**
 * Class for the tests
 */
public class TestDB {

	/**
	 * The main method
	 * @param args The arguments that we can insert
	 */
	public static void main(String[] args) {
		//Creates the DB object
		Database db = new Database();

		//Creates the objects to insert
		DVD lotr = new DVD("Lord Of The Ring", "Peter Jackson", 240, Genre.SF);
		DVD enterTheVoid = new DVD("Enter The Void", "Gaspar Noé", 250, Genre.DRAME);
		DVD requiemForADream = new DVD("Requiem For A Dream", "I Dunno", 200, Genre.DRAME);

		CD justinBieber = new CD("Best Album Ever", "Justin Bieber", 50, Genre.POP);
		CD queen = new CD("Best of Queen", "Queen", 60, Genre.ROCK);
		CD nightwish = new CD("Sleeping Sun", "Nightwish", 70, Genre.ROCK);
		CD riseAgainst = new CD("Savior", "Rise Against", 40, Genre.ROCK);

		//Inserts the objects
		db.addItem(lotr);
		db.addItem(enterTheVoid);
		db.addItem(requiemForADream);

		db.addItem(justinBieber);
		db.addItem(queen);
		db.addItem(nightwish);
		db.addItem(riseAgainst);

		//Then displays the db
		db.list();
	}
}