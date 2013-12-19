package tr.edu.metu.ii.sm.oosd;


public class FarmGame {

	private static final int STARTING_XP = 0;
	private static final int STARTING_COIN = 0;

	private static FarmGame instance;

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

	public boolean buySection(Player player, String coordinate) {
		Section selectedSession = this.farmArea.selectSection(coordinate);
		return selectedSession.buySection(player);
	}
	
	public boolean sellSection(Player player, String coordinate) {
		Section selectedSession = this.farmArea.selectSection(coordinate);
		return selectedSession.sellSection(player);
	}
	
	public boolean recruitEmployee(Player player, Employee employee) {
		return employee.recruit(player);
	}

}
