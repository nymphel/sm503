package tr.edu.metu.ii.sm.oosd;

import tr.edu.metu.ii.sm.oosd.persistance.DecayStrategy;
import tr.edu.metu.ii.sm.oosd.persistance.SeedData;

public class Crop {
	
	private String name;
	private int roundsPlanted;
	private boolean readyToHarvest;
	private SeedData seedData;
	private Player owner;
	
	private int decayRound = 0;
	
	public void takeRound() {
		roundsPlanted ++;
		int timeToHarvest = seedData.getTimeToHarvest();
		if(timeToHarvest == roundsPlanted) {
			this.readyToHarvest = true;
			System.out.println("::::: crop "+name+" is READY to for "+owner.getName());
		}
		System.out.println("::::: crop "+name+" took round for "+owner.getName());
		
		// calculate decay rounds passed if ready to harvest
		if(readyToHarvest) {
			decayRound = roundsPlanted - timeToHarvest;
			System.out.println("decay round is :"+decayRound);
		}
		
	}
	
	public void harvest() {
		int xpGainedWhenHarvested = seedData.getXpGainedWhenHarvested();
		this.owner.addXp(xpGainedWhenHarvested);
		
		int salePrice = seedData.getSalePrice();
		
		//according to decayRounds, calculate sale price with seed data decay strategy
		DecayStrategy decayStrategy = seedData.getDecayFactor();
		decayStrategy.setRound(decayRound);
		float decayFactor = decayStrategy.getDecayFactor();
		System.out.println("decay factor is "+decayFactor);
		
		float calculatedSalePrice = (float) salePrice * decayFactor;
		salePrice = Math.round(calculatedSalePrice);
		
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
