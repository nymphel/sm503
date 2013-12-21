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
			System.out.println("::::: crop "+name+" is ready to for "+owner.getName());
		}
		System.out.println("::::: crop "+name+" took round for "+owner.getName());
		
	}
	
	public void harvest() {
		int xpGainedWhenHarvested = seedData.getXpGainedWhenHarvested();
		this.owner.addXp(xpGainedWhenHarvested);
		
		int salePrice = seedData.getSalePrice();
		this.owner.addCoin(salePrice);
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
