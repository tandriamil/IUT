/**
 * An abstract class that is common to several games in
 * which players play against the others, but only one is
 * playing at a given time.
 */
 
public abstract class Game {
 
    protected int playersCount;

    public abstract void initializeGame();

    public abstract void makePlay(int player);

    public abstract boolean endOfGame();

    public abstract void printWinner();
 
 
    public final void playOneGame(int playersCount) {
        this.playersCount = playersCount;
        initializeGame();
        int j = 0;
        while (!endOfGame()) {
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }
}
