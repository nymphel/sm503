package tr.edu.metu.ii.sm.oosd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tr.edu.metu.ii.sm.oosd.persistance.ActionData;
import tr.edu.metu.ii.sm.oosd.persistance.BuildingData;
import tr.edu.metu.ii.sm.oosd.persistance.ConstructorData;
import tr.edu.metu.ii.sm.oosd.persistance.CropData;
import tr.edu.metu.ii.sm.oosd.persistance.DataStore;
import tr.edu.metu.ii.sm.oosd.persistance.EmployeeData;
import tr.edu.metu.ii.sm.oosd.persistance.FarmerData;

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


	public static void loadDataStore() throws Exception {
		ObjectInputStream stream = new java.io.ObjectInputStream(new FileInputStream(fileName));
		try {
			@SuppressWarnings("unused")
			DataStore ds = (DataStore)stream.readObject();
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
	
public static void setupSampleDataStore() throws Exception {
		
		DataStore dataStore = DataStore.getInstance();

		HashMap<String,CropData> crops = new HashMap<>();
		CropData c = new CropData();
		c.setName("wheat");
		c.setCostToPlant(5);
		c.setSalePrice(40);
		c.setXpGainedWhenHarvested(11);
		c.setTimeToHarvest(10);
		crops.put(c.getName(), c);
		dataStore.setCropData(crops);
		
		HashMap<ActionData.Type,ActionData> actions = new HashMap<>();
		ActionData action = new ActionData();
		action.setType(ActionData.Type.BUY_SECTION);
		action.setCost(100);
		action.setXpGained(20);
		actions.put(action.getType(),action);
		dataStore.setActionData(actions);
		
		BuildingData building = new BuildingData();
		building.setTimeToConstruct(8);
		building.setXpIncome(4);
		building.setCoinIncome(1);
		dataStore.setBuildingData(building);
		
		List<EmployeeData> employees = new ArrayList<>();
		EmployeeData farmer = new FarmerData();
		farmer.setCost(10);
		employees.add(farmer);
		
		ConstructorData constructor = new ConstructorData();
		constructor.setCost(12);
		employees.add(constructor);
		dataStore.setEmployeeData(employees);
		
		saveDataStore();
	}

}
