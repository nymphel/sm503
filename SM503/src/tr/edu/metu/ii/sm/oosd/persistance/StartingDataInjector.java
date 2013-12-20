package tr.edu.metu.ii.sm.oosd.persistance;

import java.util.HashMap;

public class StartingDataInjector {
	
public static void setupSampleDataStore() throws Exception {
		
		DataStore dataStore = DataStore.getInstance();

		HashMap<String,SeedData> seeds = new HashMap<>();
		SeedData seed = new SeedData();
		seed.setName("wheat");
		seed.setCostToPlant(5);
		seed.setSalePrice(40);
		seed.setXpGainedWhenHarvested(11);
		seed.setTimeToHarvest(10);
		seeds.put(seed.getName(), seed);
		dataStore.setSeedData(seeds);
		
		HashMap<ActionData.Type,ActionData> actions = new HashMap<>();
		ActionData action = new ActionData();
		action.setType(ActionData.Type.BUY_SECTION);
		action.setCost(100);
		action.setXpGained(20);
		actions.put(action.getType(),action);
		dataStore.setActionData(actions);
		
		BuildingData building = new BuildingData();
		building.setTimeToConstruct(8);
		building.setXpWhenCompleted(4);
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
