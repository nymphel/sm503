package tr.edu.metu.ii.sm.oosd.persistance;

import java.util.HashMap;

public class StartingDataInjector {
	
public static void setupSampleDataStore() throws Exception {
		
		DataStore dataStore = DataStore.getInstance();

		HashMap<String,SeedData> seeds = new HashMap<>();
		SeedData seed = new SeedData();
		seed.setName("Wheat");
		seed.setCostToPlant(5);
		seed.setSalePrice(40);
		seed.setXpGainedWhenHarvested(11);
		seed.setTimeToHarvest(10);
		seed.setDecayFactor(new LongDecayFactor());
		seeds.put(seed.getName(), seed);
		
		seed = new SeedData();
		seed.setName("Corn");
		seed.setCostToPlant(4);
		seed.setSalePrice(45);
		seed.setXpGainedWhenHarvested(14);
		seed.setTimeToHarvest(11);
		seed.setDecayFactor(new LongDecayFactor());
		seeds.put(seed.getName(), seed);
		
		seed = new SeedData();
		seed.setName("Strawberry");
		seed.setCostToPlant(10);
		seed.setSalePrice(52);
		seed.setXpGainedWhenHarvested(4);
		seed.setTimeToHarvest(5);
		seed.setDecayFactor(new PenaltyDecayFactor());
		seeds.put(seed.getName(), seed);
		
		seed = new SeedData();
		seed.setName("Eggplant");
		seed.setCostToPlant(8);
		seed.setSalePrice(35);
		seed.setXpGainedWhenHarvested(5);
		seed.setTimeToHarvest(4);
		seed.setDecayFactor(new StepDecayFactor());
		seeds.put(seed.getName(), seed);
		
		seed = new SeedData();
		seed.setName("Rice");
		seed.setCostToPlant(4);
		seed.setSalePrice(48);
		seed.setXpGainedWhenHarvested(16);
		seed.setTimeToHarvest(14);
		seed.setDecayFactor(new LongDecayFactor());
		seeds.put(seed.getName(), seed);
		
		seed = new SeedData();
		seed.setName("Peppers");
		seed.setCostToPlant(9);
		seed.setSalePrice(36);
		seed.setXpGainedWhenHarvested(6);
		seed.setTimeToHarvest(4);
		seed.setDecayFactor(new StepDecayFactor());
		seeds.put(seed.getName(), seed);
		
		seed = new SeedData();
		seed.setName("Tomatoes");
		seed.setCostToPlant(11);
		seed.setSalePrice(30);
		seed.setXpGainedWhenHarvested(4);
		seed.setTimeToHarvest(3);
		seed.setDecayFactor(new PenaltyDecayFactor());
		seeds.put(seed.getName(), seed);
		
		dataStore.setSeedData(seeds);
		
		HashMap<ActionData.Type,ActionData> actions = new HashMap<>();
		ActionData action = new ActionData();
		action.setType(ActionData.Type.PLOW);
		action.setCost(5);
		action.setXpGained(1);
		actions.put(action.getType(),action);
		
		action = new ActionData();
		action.setType(ActionData.Type.PLANT);
		action.setCost(5);
		action.setXpGained(1);
		actions.put(action.getType(),action);
		
		action = new ActionData();
		action.setType(ActionData.Type.HARVEST);
		action.setCost(10);
		action.setXpGained(2);
		actions.put(action.getType(),action);
		
		action = new ActionData();
		action.setType(ActionData.Type.CONSTRUCT_BUILDING);
		action.setCost(100);
		action.setXpGained(25);
		actions.put(action.getType(),action);
		
		action = new ActionData();
		action.setType(ActionData.Type.TEAR_DOWN_BUILDING);
		action.setCost(25);
		action.setXpGained(5);
		actions.put(action.getType(),action);
		
		action = new ActionData();
		action.setType(ActionData.Type.BUY_SECTION);
		action.setCost(100);
		action.setXpGained(20);
		actions.put(action.getType(),action);
		
		action = new ActionData();
		action.setType(ActionData.Type.SELL_SECTION);
		action.setCost(75);
		action.setXpGained(-16);
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
		farmer.setSalary(1);
		employees.put(farmer.getType(), farmer);
		
		EmployeeData constructor = new EmployeeData();
		constructor.setType("Constructor");
		constructor.setCost(12);
		constructor.setSalary(2);
		employees.put(constructor.getType(), constructor);
		dataStore.setEmployeeData(employees);
		
	}

}
