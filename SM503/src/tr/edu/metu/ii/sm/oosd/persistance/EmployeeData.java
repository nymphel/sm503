package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public class EmployeeData implements  Serializable {

	private static final long serialVersionUID = 4815172621448781316L;
	
	private int cost;
	private String type;
	private int salary;

	public int getCost() {
		return cost;
	}

	protected void setCost(int cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}