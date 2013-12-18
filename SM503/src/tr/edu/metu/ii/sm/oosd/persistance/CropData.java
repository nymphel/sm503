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

	public void setName(String name) {
		this.name = name;
	}

	public void setCostToPlant(int costToPlant) {
		this.costToPlant = costToPlant;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public void setXpGainedWhenHarvested(int xpGainedWhenHarvested) {
		this.xpGainedWhenHarvested = xpGainedWhenHarvested;
	}

	public void setTimeToHarvest(int timeToHarvest) {
		this.timeToHarvest = timeToHarvest;
	}

}
