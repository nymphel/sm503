package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DataStore implements Serializable {

	private static final long serialVersionUID = 962722147320943661L;

	private HashMap<String,Crop> crops;
	private HashMap<Action.Type,Action> actions;
	private Building building;
	private List<Employee> employees;
	
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

	public HashMap<String, Crop> getCrops() {
		return crops;
	}

	public void setCrops(HashMap<String, Crop> crops) {
		this.crops = crops;
	}

	public HashMap<Action.Type, Action> getActions() {
		return actions;
	}

	public void setActions(HashMap<Action.Type, Action> actions) {
		this.actions = actions;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
