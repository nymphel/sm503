package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DataStore implements Serializable {

	private static final long serialVersionUID = 962722147320943661L;

	private HashMap<String,CropData> crops;
	private HashMap<ActionData.Type,ActionData> actions;
	private BuildingData building;
	private List<EmployeeData> employees;
	
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

	public HashMap<String, CropData> getCrops() {
		return crops;
	}

	public void setCrops(HashMap<String, CropData> crops) {
		this.crops = crops;
	}

	public HashMap<ActionData.Type, ActionData> getActions() {
		return actions;
	}

	public void setActions(HashMap<ActionData.Type, ActionData> actions) {
		this.actions = actions;
	}

	public BuildingData getBuilding() {
		return building;
	}

	public void setBuilding(BuildingData building) {
		this.building = building;
	}

	public List<EmployeeData> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeData> employees) {
		this.employees = employees;
	}

}
