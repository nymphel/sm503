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
		//farmGame.startGame();
		//farmGame.printFarmArea();
	}
	
	public static final String fileName = "D:\\objects.dat";
	public static DataStore dataStore;



	public static void loadDataStore() throws Exception {
		ObjectInputStream stream = new java.io.ObjectInputStream(new FileInputStream(fileName));
		try {
			dataStore = (DataStore) stream.readObject();
		} finally {
			stream.close();
		}
	}

	public static void saveDataStore() throws Exception {
		ObjectOutputStream stream = new java.io.ObjectOutputStream(new FileOutputStream(fileName));
		try {
			stream.writeObject(dataStore);
		} finally {
			stream.close();
		}
	}
	
//	public static void setupSampleDataStore() throws Exception {
//		dataStore = new DataStore();
//		HashMap<String,Crop> crops = new HashMap<>();
//		Crop c = new Crop();
//		c.setName("wheat");
//		c.setCostToPlant(5);
//		c.setSalePrice(40);
//		c.setXpGainedWhenHarvested(11);
//		c.setTimeToHarvest(10);
//		crops.put(c.getName(), c);
//		dataStore.setCrops(crops);
//		
//		HashMap<Action.Type,Action> actions = new HashMap<>();
//		Action action = new Action();
//		action.setType(Action.Type.BUY_SECTION);
//		action.setCost(100);
//		action.setXpGained(20);
//		actions.put(action.getType(),action);
//		dataStore.setActions(actions);
//		
//		Building building = new Building();
//		building.setTimeToConstruct(8);
//		building.setXpIncome(4);
//		building.setCoinIncome(1);
//		dataStore.setBuilding(building);
//		
//		List<Employee> employees = new ArrayList<>();
//		Employee farmer = new Farmer();
//		farmer.setCost(10);
//		employees.add(farmer);
//		
//		Constructor constructor = new Constructor();
//		constructor.setCost(12);
//		employees.add(constructor);
//		dataStore.setEmployees(employees);
//		
//		saveDataStore();
//	}
//
//}

}
