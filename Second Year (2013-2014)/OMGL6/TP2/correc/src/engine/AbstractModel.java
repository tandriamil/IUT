package engine;

import java.util.Observable;

public abstract class AbstractModel extends Observable{
	
	public abstract void proceedAction(Command action);
	
	public abstract String getText();

	public abstract void play();

}
