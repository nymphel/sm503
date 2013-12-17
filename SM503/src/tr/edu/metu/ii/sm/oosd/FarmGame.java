package tr.edu.metu.ii.sm.oosd;

import tr.edu.metu.ii.sm.oosd.persistance.DataStore;

public class FarmGame {

	private static final int STARTING_XP = 0;
	private static final int STARTING_COIN = 0;

	private static FarmGame instance;
	
	private DataStore dataStore;

	private FarmGame() {
		
	}

	private Player player1;
	private Player player2;
	
	private FarmArea farmArea;

	public static synchronized FarmGame getInstance() {
		if (instance == null) {
			instance = new FarmGame();
		}

		return instance;
	}

	public void prepareGame() {

		player1 = new Player();
		player1.setName("player-1");
		player1.setCoin(STARTING_COIN);
		player1.setXp(STARTING_XP);

		player2 = new Player();
		player2.setName("player-2");
		player2.setCoin(STARTING_COIN);
		player2.setXp(STARTING_XP);

		farmArea = new FarmArea();
		farmArea.prepareFarmArea();
		farmArea.placePlayers(player1, player2);

	}

	public void startGame() {
		while (true) {
			player1.takeTurn();
			if (this.farmArea.allSectionsOccupied()) {
				break;
			}

			player2.takeTurn();
			if (this.farmArea.allSectionsOccupied()) {
				break;
			}
		}
	}

	public DataStore getDataStore() {
		return dataStore;
	}

	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
	}

	

}
