package tr.edu.metu.ii.sm.oosd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tr.edu.metu.ii.sm.oosd.persistance.DataStore;

public class UI {

	public static void main(String[] args) {
		try {
			loadDataStore();
		} catch (Exception e) {
			e.printStackTrace();
		}

		FarmGame farmGame = FarmGame.getInstance();
		farmGame.prepareGame();
		// farmGame.startGame();
		// farmGame.printFarmArea();
	}

	public static final String fileName = "D:\\objects.dat";

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
