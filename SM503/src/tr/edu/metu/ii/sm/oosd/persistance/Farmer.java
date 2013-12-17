package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public class Farmer implements Employee, Serializable {

	private static final long serialVersionUID = 4815172621448781316L;
	
	private int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}