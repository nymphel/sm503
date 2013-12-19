package tr.edu.metu.ii.sm.oosd.persistance;

import java.util.HashMap;

public class StartingDataInjector {
	
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
		
		HashMap<String, EmployeeData> employees = new HashMap<>();
		EmployeeData farmer = new EmployeeData();
		farmer.setType("Farmer");
		farmer.setCost(10);
		employees.put(farmer.getType(), farmer);
		
		EmployeeData constructor = new EmployeeData();
		constructor.setType("Constructor");
		constructor.setCost(12);
		employees.put(constructor.getType(), constructor);
		dataStore.setEmployeeData(employees);
		
	}

}
