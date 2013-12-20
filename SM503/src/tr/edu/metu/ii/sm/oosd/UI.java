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
	public static final int TIMEOUT = 10;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean interpretCommand = interpretCommand(input, activePlayer);
		if(!interpretCommand) {
			interpret(activePlayer);
		}
	}

	private static boolean interpretCommand(String input, Player activePlayer) {
		System.out.println(input);
		//switch case 
		//pass 
		return true;
		
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
