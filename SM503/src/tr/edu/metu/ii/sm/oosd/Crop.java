package tr.edu.metu.ii.sm.oosd;

import tr.edu.metu.ii.sm.oosd.persistance.SeedData;

public class Crop {
	
	private String name;
	private int roundsPlanted;
	private boolean readyToHarvest;
	private SeedData seedData;
	private Player owner;
	
	public void takeRound() {
		roundsPlanted ++;
		if(seedData.getTimeToHarvest() == roundsPlanted) {
			this.readyToHarvest = true;
		}
		
	}
	
	public void harvest() {
		int xpGainedWhenHarvested = seedData.getXpGainedWhenHarvested();
		int xp = this.owner.getXp();
		xp += xpGainedWhenHarvested;
		this.owner.setXp(xp);
		
		int salePrice = seedData.getSalePrice();
		int coin = this.owner.getCoin();
		coin += salePrice;
		this.owner.setCoin(coin);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoundsPlanted() {
		return roundsPlanted;
	}
	public void setRoundsPlanted(int roundsPlanted) {
		this.roundsPlanted = roundsPlanted;
	}
	public boolean isReadyToHarvest() {
		return readyToHarvest;
	}
	public void setReadyToHarvest(boolean readyToHarvest) {
		this.readyToHarvest = readyToHarvest;
	}
	public SeedData getSeedData() {
		return seedData;
	}
	public void setSeedData(SeedData seedData) {
		this.seedData = seedData;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	

}
