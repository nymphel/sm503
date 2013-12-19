package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

public class DataStore implements Serializable {

	private static final long serialVersionUID = 962722147320943661L;

	private HashMap<String,SeedData> seedData;
	private HashMap<ActionData.Type,ActionData> actionData;
	private BuildingData buildingData;
	private HashMap<String,EmployeeData> employeeData;
	
	private static DataStore instance;
	
	private DataStore() {
		
	}
	
	public static synchronized DataStore getInstance() {
		if (instance == null) {
			instance = new DataStore();
		}

		return instance;
	}
	
	private Object readResolve()  {
	    return instance;
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	    ois.defaultReadObject();
	    instance = this;
	}

	public HashMap<String, SeedData> getSeedData() {
		return seedData;
	}

	public void setSeedData(HashMap<String, SeedData> seedData) {
		this.seedData = seedData;
	}

	public HashMap<ActionData.Type, ActionData> getActionData() {
		return actionData;
	}

	public void setActionData(HashMap<ActionData.Type, ActionData> actionData) {
		this.actionData = actionData;
	}

	public BuildingData getBuildingData() {
		return buildingData;
	}

	public void setBuildingData(BuildingData buildingData) {
		this.buildingData = buildingData;
	}

	public HashMap<String, EmployeeData> getEmployeeData() {
		return employeeData;
	}

	public void setEmployeeData(HashMap<String, EmployeeData> employeeData) {
		this.employeeData = employeeData;
	}

	
}
