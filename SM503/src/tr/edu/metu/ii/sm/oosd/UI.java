package tr.edu.metu.ii.sm.oosd;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tr.edu.metu.ii.sm.oosd.persistance.DataStore;

public class UI {

	public static final String fileName = "D:\\objects.dat";
	public static final int TIMEOUT = 3;

	public static void main(String[] args) {
		try {
//			StartingDataInjector.setupSampleDataStore();
//			saveDataStore();
			loadDataStore();
		} catch (Exception e) {
			e.printStackTrace();
		}

		FarmGame farmGame = FarmGame.getInstance();
		farmGame.prepareGame();

		int round = 1;
		while(!farmGame.isGameFinished() && round <= TIMEOUT) {
			Player activePlayer = farmGame.getActivePlayer();
			
			System.out.println("\n");
			farmGame.showLayout();
			System.out.println("\n");
			System.out.print("(ROUND-"+round+") "+activePlayer.getName()+": Please enter a command :");
			
			interpret(activePlayer);
			
			farmGame.computeRound();
			
			round ++;
		}
		
		farmGame.showResults();
		
	}

	private static void interpret(Player activePlayer) {
		String input = readLine();

		boolean interpretCommand = interpretCommand(input, activePlayer);
		if(!interpretCommand) {
			System.out.println("Please enter a command again:");
			interpret(activePlayer);
		}
	}

	private static String readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	private static boolean interpretCommand(String input, Player activePlayer) {
		FarmGame farmGame = FarmGame.getInstance();
		String coordinate;
		
		switch(input) {
		
		case "pass":
			return true;
			
		case "buy section":
			coordinate = selectSection();
			if(coordinate == null) {
				return false;
			}
			return farmGame.buySection(activePlayer, coordinate);
			
		case "sell section":
			coordinate = selectSection();
			if(coordinate == null) {
				return false;
			}
			return farmGame.sellSection(activePlayer, coordinate);
			
		}
		
		//switch case 
		//pass 
		return true;
		
	}

	private static String selectSection() {
		System.out.println("Please enter a section coordinate: ");
		String coordinate = readLine();
		boolean validSelection = FarmGame.getInstance().isValidSelection(coordinate);
		if(!validSelection) {
			System.out.println("There is no section with given coodinate" + coordinate);
			return null;
		}
		return coordinate;
	}

	public static void loadDataStore() throws Exception {
		ObjectInputStream stream = new java.io.ObjectInputStream(new FileInputStream(fileName));
		try {
			@SuppressWarnings("unused")
			DataStore ds = (DataStore) stream.readObject();
		} finally {
			stream.close();
		}
	}

	public static void saveDataStore() throws Exception {
		ObjectOutputStream stream = new java.io.ObjectOutputStream(new FileOutputStream(fileName));
		try {
			stream.writeObject(DataStore.getInstance());
		} finally {
			stream.close();
		}
	}

}
