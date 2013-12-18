package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DataStore implements Serializable {

	private static final long serialVersionUID = 962722147320943661L;

	private HashMap<String,CropData> cropData;
	private HashMap<ActionData.Type,ActionData> actionData;
	private BuildingData buildingData;
	private List<EmployeeData> employeeData;
	
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

	public HashMap<String, CropData> getCropData() {
		return cropData;
	}

	public void setCropData(HashMap<String, CropData> cropData) {
		this.cropData = cropData;
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

	public List<EmployeeData> getEmployeeData() {
		return employeeData;
	}

	public void setEmployeeData(List<EmployeeData> employeeData) {
		this.employeeData = employeeData;
	}

	
	
}
