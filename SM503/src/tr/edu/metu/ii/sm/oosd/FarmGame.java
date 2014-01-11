package tr.edu.metu.ii.sm.oosd;

import java.util.HashMap;

import tr.edu.metu.ii.sm.oosd.persistance.DataStore;
import tr.edu.metu.ii.sm.oosd.persistance.SeedData;


public class FarmGame {

	private static final int STARTING_XP = 0;
	private static final int STARTING_COIN = 140;

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

		player1 = new Player();
		player1.setName("player-1");
		player1.setUppercase(true);
		player1.setLetter("P1");
		player1.setCoin(STARTING_COIN);
		player1.setXp(STARTING_XP);

		player2 = new Player();
		player2.setName("player-2");
		player2.setLetter("p2");
		player2.setCoin(STARTING_COIN);
		player2.setXp(STARTING_XP);

		farmArea = new FarmArea();
		farmArea.prepareFarmArea();
		farmArea.placePlayers(player1, player2);
		
		this.activePlayer = player1;

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

	public FarmArea getFarmArea() {
		return farmArea;
	}

	public boolean computeRound() {
		
		if(activePlayer.equals(player1)) {
			this.activePlayer = player2;
		} else {
			this.activePlayer = player1;
		}
		
		//manage crops & buildings
		HashMap<String, Section> sections = this.farmArea.getSections();
		for (Section section : sections.values()) {
			Crop activeCrop = section.getActiveCrop();
			if(activeCrop != null) {
				activeCrop.takeRound();
			}
			
			Building activeBuilding = section.getActiveBuilding();
			if(activeBuilding != null) {
				activeBuilding.takeRound();
			}
			
			Employee assignedEmployee = section.getAssignedEmployee();
			if(assignedEmployee != null) {
				assignedEmployee.takeRound();

				int activePlayerCoin = this.activePlayer.getCoin();
				if(activePlayerCoin < 0) {
					System.out.println(this.activePlayer.getName() +" has no f-coins to pay salary for her/his employees!!!");
					return true;
				}
			}
		}
		
		return false;
	}

	public void showResults() {
		System.out.println(player1.getName() +" has "+player1.getXp()+" XP");
		System.out.println(player2.getName() +" has "+player2.getXp()+" XP");
		
		String winner = "We have no winner, xp rates are equal.";
		
		Player winnerPlayer = null;
		
		if(player1.getCoin() < 0) {
			winnerPlayer = player2;
		} else if(player2.getCoin() < 0) {
			winnerPlayer = player1;
		} else if(player1.getXp() > player2.getXp()) {
			winnerPlayer = player1;
		} else if(player1.getXp() < player2.getXp()) {
			winnerPlayer = player2;
		} 
		
		if(winnerPlayer != null) {
			winner = "The winner is: " + winnerPlayer.getName();
		}
		
		System.out.println(winner);
		
	}

	public boolean isValidSelection(String coordinate) {
		Section selectSection = this.farmArea.selectSection(coordinate);
		return (selectSection != null ? true: false);
	}

	public boolean isValidSeed(String seed) {
		HashMap<String, SeedData> seedData = DataStore.getInstance().getSeedData();
		SeedData sData = seedData.get(seed);
		return (sData != null ? true : false);
	}

	public String getAvailableSeeds() {
		String seeds = "";
		HashMap<String, SeedData> seedData = DataStore.getInstance().getSeedData();
		for (String key : seedData.keySet()) {
			seeds += key + " | ";
		}
		
		return seeds;
		
	}
}
