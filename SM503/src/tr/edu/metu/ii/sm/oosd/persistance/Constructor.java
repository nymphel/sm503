package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public class Constructor implements Employee, Serializable {
	
	private static final long serialVersionUID = 2923842624347682804L;
	
	private int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
