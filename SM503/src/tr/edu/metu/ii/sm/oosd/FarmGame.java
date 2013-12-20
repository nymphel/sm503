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

}
