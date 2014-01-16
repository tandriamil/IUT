package test;

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
		//Getting the genre values
		Genre sf = new Genre(SF);
		Genre pop = new Genre(POP);
		Genre drame = new Genre(DRAME);
		Genre rock = new Genre(ROCK);

		//Creates the DB object
		Database db = new Database();

		//Creates the objects to insert
		DVD lotr = new DVD("Lord Of The Ring", "Peter Jackson", 240, this.sf);
		DVD enterTheVoid = new DVD("Enter The Void", "Gaspar Noé", 250, this.drame);
		DVD requiemForADream = new DVD("Requiem For A Dream", "I Dunno", 200, this.drame);

		CD justinBieber = new CD("Best Album Ever", "Justin Bieber", 50, this.pop);
		CD queen = new CD("Best of Queen", "Queen", 60, this.rock);
		CD nightwish = new CD("Sleeping Sun", "Nightwish", 70, this.rock);
		CD riseAgainst = new CD("Savior", "Rise Against", 40, this.rock);
	}
}