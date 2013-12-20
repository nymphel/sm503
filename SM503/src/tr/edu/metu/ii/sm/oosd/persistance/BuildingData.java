package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public class BuildingData implements Serializable {

	private static final long serialVersionUID = -5342744623558426336L;
	
	private int timeToConstruct;
	private int xpWhenCompleted;
	private int coinIncome;

	public int getTimeToConstruct() {
		return timeToConstruct;
	}

	public int getXpWhenCompleted() {
		return xpWhenCompleted;
	}

	public int getCoinIncome() {
		return coinIncome;
	}

	protected void setTimeToConstruct(int timeToConstruct) {
		this.timeToConstruct = timeToConstruct;
	}

	protected void setXpWhenCompleted(int xpWhenCompleted) {
		this.xpWhenCompleted = xpWhenCompleted;
	}

	protected void setCoinIncome(int coinIncome) {
		this.coinIncome = coinIncome;
	}

}
