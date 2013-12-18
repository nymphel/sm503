package tr.edu.metu.ii.sm.oosd.persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		
		List<EmployeeData> employees = new ArrayList<>();
		FarmerData farmer = new FarmerData();
		farmer.setCost(10);
		employees.add(farmer);
		
		ConstructorData constructor = new ConstructorData();
		constructor.setCost(12);
		employees.add(constructor);
		dataStore.setEmployeeData(employees);
		
	}

}
