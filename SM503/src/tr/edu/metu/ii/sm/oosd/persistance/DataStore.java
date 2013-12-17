package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DataStore implements Serializable {

	private static final long serialVersionUID = 962722147320943661L;

	private HashMap<String,Crop> crops;
	private HashMap<Action.Type,Action> actions;
	private Building building;
	private List<Employee> employees;

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
