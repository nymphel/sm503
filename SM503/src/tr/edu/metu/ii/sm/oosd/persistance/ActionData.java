package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public class ActionData implements Serializable {

	private static final long serialVersionUID = -4944378382871918644L;

	public enum Type {
		PLOW, PLANT, HARVEST, CONSTRUCT_BUILDING, TEAR_DOWN_BUILDING, BUY_SECTION, SELL_SECTION
	};

	private Type type;
	private int cost;
	private int xpGained;

	public Type getType() {
		return type;
	}

	protected void setType(Type type) {
		this.type = type;
	}

	public int getCost() {
		return cost;
	}

	protected void setCost(int cost) {
		this.cost = cost;
	}

	public int getXpGained() {
		return xpGained;
	}

	protected void setXpGained(int xpGained) {
		this.xpGained = xpGained;
	}

}
