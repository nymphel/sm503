package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public class Building implements Serializable {

	private static final long serialVersionUID = -5342744623558426336L;
	
	private int timeToConstruct;
	private int xpIncome;
	private int coinIncome;

	public int getTimeToConstruct() {
		return timeToConstruct;
	}

	public int getXpIncome() {
		return xpIncome;
	}

	public int getCoinIncome() {
		return coinIncome;
	}

	public void setTimeToConstruct(int timeToConstruct) {
		this.timeToConstruct = timeToConstruct;
	}

	public void setXpIncome(int xpIncome) {
		this.xpIncome = xpIncome;
	}

	public void setCoinIncome(int coinIncome) {
		this.coinIncome = coinIncome;
	}

}
