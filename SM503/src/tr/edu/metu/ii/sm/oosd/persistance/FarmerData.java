package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public class FarmerData implements EmployeeData, Serializable {

	private static final long serialVersionUID = 4815172621448781316L;
	
	private int cost;

	public int getCost() {
		return cost;
	}

	protected void setCost(int cost) {
		this.cost = cost;
	}

}