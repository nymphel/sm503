package tr.edu.metu.ii.sm.oosd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.bethecoder.ascii_table.ASCIITable;

public class FarmArea {

	private HashMap<String, Section> sections;
	private List<Lot> lots;

	public void prepareFarmArea() {
		lots = new ArrayList<>();
		Lot lot1 = new Lot("lot1");
		Lot lot2 = new Lot("lot2");
		Lot lot3 = new Lot("lot3");
		Lot lot4 = new Lot("lot4");
		lots.add(lot1);
		lots.add(lot2);
		lots.add(lot3);
		lots.add(lot4);

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
	
	public void placePlayers(Player player1, Player player2) {
		Lot randomLot = getRandomLot();
		randomLot.setOwner(player1);
		System.out.println("random lot is selected as: " + randomLot.getName() + " and assigned to player-1");

		lots.remove(randomLot);
		randomLot = getRandomLot();
		randomLot.setOwner(player2);
		System.out.println("random lot is selected as: " + randomLot.getName() + " and assigned to player-2");
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
				label += ","+ section.getLot().getName();
				label += "[" +section.getLetter()+ "]";
				
				data[i][j+1] = label;
			}
		}
		
		// library is used to print farming area as an ascii table
		ASCIITable.getInstance().printTable(header, data);

	}
	
	public boolean allSectionsOccupied() {
		for (Section section : sections.values()) {
			if (section.getOwner() == null) {
				return false;
			}
		}
		return true;
	}

	public HashMap<String, Section> getSections() {
		return sections;
	}
	
	

}
