package tr.edu.metu.ii.sm.oosd;


public class FarmGame {

	private static final int STARTING_XP = 0;
	private static final int STARTING_COIN = 150;

	private static FarmGame instance;

	private FarmGame() {
		
	}

	private Player player1;
	private Player player2;
	private Player activePlayer;
	
	private FarmArea farmArea;

	public static synchronized FarmGame getInstance() {
		if (instance == null) {
			instance = new FarmGame();
		}

		return instance;
	}

	public void prepareGame() {

		player1 = new Player1();
		player1.setName("player-1");
		player1.setCoin(STARTING_COIN);
		player1.setXp(STARTING_XP);

		player2 = new Player2();
		player2.setName("player-2");
		player2.setCoin(STARTING_COIN);
		player2.setXp(STARTING_XP);

		farmArea = new FarmArea();
		farmArea.prepareFarmArea();
		farmArea.placePlayers(player1, player2);
		
		this.activePlayer = player1;

	}

	//Controller actions 
	
	public boolean buySection(Player player, String coordinate) {
		Section selectedSection = this.farmArea.selectSection(coordinate);
		return selectedSection.buySection(player);
	}
	
	public boolean sellSection(Player player, String coordinate) {
		Section selectedSection = this.farmArea.selectSection(coordinate);
		return selectedSection.sellSection(player);
	}
	
	public boolean recruitEmployee(Player player, Employee employee) {
		return employee.recruit(player);
	}
	
	public boolean fireEmployee(Player player, Employee employee) {
		return employee.fire(player);
	}
	
	public boolean plowSection(Player player, String coordinate, Employee employee) {
		Section selectedSection = this.farmArea.selectSection(coordinate);
		return selectedSection.plow(player, employee);
	}
	
	public boolean plantSeed(Player player, String coordinate, String seed, Employee employee) {
		Section selectedSection = this.farmArea.selectSection(coordinate);
		return selectedSection.plant(player, seed, employee);
	}
	
	public boolean harvestSection(Player player, String coordinate, Employee employee) {
		Section selectedSection = this.farmArea.selectSection(coordinate);
		return selectedSection.harvest(player, employee);
	}
	
	
	public boolean constructBuilding(Player player, String coordinate, Employee employee) {
		Section selectedSection = this.farmArea.selectSection(coordinate);
		return selectedSection.constructBuilding(player, employee);
	}
	
	public boolean teardownBuilding(Player player, String coordinate, Employee employee) {
		Section selectedSection = this.farmArea.selectSection(coordinate);
		return selectedSection.teardownBuilding(player, employee);
	}

	public boolean isGameFinished() {
		return this.farmArea.allSectionsOccupied();
	}
	
	public void showLayout() {
		this.farmArea.printFarmArea();
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public void computeRound() {
		// TODO Auto-generated method stub
		
		if(activePlayer.equals(player1)) {
			this.activePlayer = player2;
		} else {
			this.activePlayer = player1;
		}
		
	}

	public void showResults() {
		System.out.println(player1.getName() +" has "+player1.getXp()+" XP");
		System.out.println(player2.getName() +" has "+player2.getXp()+" XP");
		
		String winner = "We have no winner, xp rates are equal.";
		if(player1.getXp() > player2.getXp()) {
			winner = "The winner is: " + player1.getName();
		} else if(player1.getXp() < player2.getXp()) {
			winner = "The winner is: " + player2.getName();
		} 
		
		System.out.println(winner);
		
	}

	public boolean isValidSelection(String coordinate) {
		Section selectSection = this.farmArea.selectSection(coordinate);
		return (selectSection != null ? true: false);
	}

}
