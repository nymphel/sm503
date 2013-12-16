package tr.edu.metu.ii.sm.oosd;

public class UI {

	public static void main(String[] args) {
		FarmGame farmGame = FarmGame.getInstance();
		farmGame.prepareGame();
		farmGame.startGame();
	}

}
