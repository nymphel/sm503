package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public class CropData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int costToPlant;
	private int salePrice;
	private int xpGainedWhenHarvested;
	private int timeToHarvest;

	public String getName() {
		return name;
	}

	public int getCostToPlant() {
		return costToPlant;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public int getXpGainedWhenHarvested() {
		return xpGainedWhenHarvested;
	}

	public int getTimeToHarvest() {
		return timeToHarvest;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setCostToPlant(int costToPlant) {
		this.costToPlant = costToPlant;
	}

	protected void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	protected void setXpGainedWhenHarvested(int xpGainedWhenHarvested) {
		this.xpGainedWhenHarvested = xpGainedWhenHarvested;
	}

	protected void setTimeToHarvest(int timeToHarvest) {
		this.timeToHarvest = timeToHarvest;
	}

}
