package tr.edu.metu.ii.sm.oosd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.bethecoder.ascii_table.ASCIITable;

public class FarmGame {

	private static final int startingXp = 0;

	private static FarmGame instance;

	private FarmGame() {

	}

	private HashMap<String, Section> sections;
	private List<Lot> lots;

	private Player player1;
	private Player player2;

	public static synchronized FarmGame getInstance() {
		if (instance == null) {
			instance = new FarmGame();
		}

		return instance;
	}

	public void prepareGame() {

		player1 = new Player();
		player1.setName("player-1");
		player1.setCoin(Currency.STARTING_COIN);
		player1.setXp(startingXp);

		player2 = new Player();
		player2.setName("player-2");
		player2.setCoin(Currency.STARTING_COIN);
		player2.setXp(startingXp);

		lots = new ArrayList<>();
		Lot lot1 = new Lot("lot-1");
		Lot lot2 = new Lot("lot-2");
		Lot lot3 = new Lot("lot-3");
		Lot lot4 = new Lot("lot-4");
		lots.add(lot1);
		lots.add(lot2);
		lots.add(lot3);
		lots.add(lot4);

		Lot randomLot = getRandomLot();
		randomLot.setOwner(player1);
		System.out.println("random lot is selected as: " + randomLot.getName() + " and assigned to player-1");

		lots.remove(randomLot);
		randomLot = getRandomLot();
		randomLot.setOwner(player2);
		System.out.println("random lot is selected as: " + randomLot.getName() + " and assigned to player-2");

		sections = new HashMap<>();
		for (char column = 'a'; column <= 'j'; column++) {
			for (int row = 1; row <= 10; row++) {
				String coordinate = column + "" + row;
				if (('a' <= column) && (column <= 'e') && (1 <= row) && (row <= 5)) {

					Section section = new Section();
					section.setCoordinate(coordinate);
					section.setLot(lot1);
					sections.put(coordinate, section);

				} else if (('a' <= column) && (column <= 'e') && (6 <= row) && (row <= 10)) {

					Section section = new Section();
					section.setCoordinate(coordinate);
					section.setLot(lot2);
					sections.put(coordinate, section);

				} else if (('f' <= column) && (column <= 'j') && (1 <= row) && (row <= 5)) {

					Section section = new Section();
					section.setCoordinate(coordinate);
					section.setLot(lot3);
					sections.put(coordinate, section);

				} else if (('f' <= column) && (column <= 'j') && (6 <= row) && (row <= 10)) {

					Section section = new Section();
					section.setCoordinate(coordinate);
					section.setLot(lot4);
					sections.put(coordinate, section);
				}

			}
		}

	}

	public void startGame() {
		while (true) {
			player1.takeTurn();
			if (allSectionsOccupied()) {
				break;
			}

			player2.takeTurn();
			if (allSectionsOccupied()) {
				break;
			}
		}
	}

	private boolean allSectionsOccupied() {
		for (Section section : sections.values()) {
			if (section.getOwner() == null) {
				return false;
			}
		}
		return true;
	}

	private Lot getRandomLot() {
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(lots.size());
		Lot lot = lots.get(index);
		return lot;
	}

	public Section selectSection(String coordinate) {
		return sections.get(coordinate);
	}

	public void printFarmArea() {

		String[][] data = new String[10][11];
		String [] header = {"","a","b","c","d","e","f","g","h","i","j"};

		int i = 0;
		for (int row = 1; row <= 10; row++, i++) {
			int j = 0;
			for (char column = 'a'; column <= 'j'; column++, j++) {
				if(j==0) {
					data[i][j] = (i+1)+"";
				}
				String label = column + "" + row;
				Section section = selectSection(label);
				label += "[" +section.getLetter()+ "]";
				
				data[i][j+1] = label;
			}
		}
		
		// library is used to print farming area as an ascii table
		ASCIITable.getInstance().printTable(header, data);

	}

}
