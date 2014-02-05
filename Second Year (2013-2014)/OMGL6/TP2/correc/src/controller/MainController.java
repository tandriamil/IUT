package controller;

import engine.AbstractModel;
import engine.Command;
import engine.Game;
import view.MainView;

public class MainController extends AbstractController{
	
	private AbstractModel mGame;
	private MainView mView;
	
	public MainController() {
		
		mView = new MainView(this);
		mGame = new Game();
		mGame.addObserver(mView);
		mGame.play();
	}

	@Override
	public void move(String direction) {
		System.out.println(direction);
		mGame.proceedAction(new Command("go", direction));
	}
	
	@Override
	public String getText() {
		return mGame.getText();
	}
	
	
	public static void main(String[] args) {
		
		new MainController();
	}

}
