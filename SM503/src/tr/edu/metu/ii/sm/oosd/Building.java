package tr.edu.metu.ii.sm.oosd;

import tr.edu.metu.ii.sm.oosd.persistance.BuildingData;

public class Building {

	private int roundsBuilt;
	private boolean completed;
	private BuildingData buildingData;
	private Player owner;
	
	public void takeRound() {
		roundsBuilt ++;
		if(buildingData.getTimeToConstruct() == roundsBuilt) {
			this.completed = true;
			int xp = this.owner.getXp();
			xp += buildingData.getXpWhenCompleted();
			this.owner.setXp(xp);
		}
		
		if(completed) {
			int coin = this.owner.getCoin();
			coin += buildingData.getCoinIncome();
			this.owner.setCoin(coin);
		}
		
	}

	protected int getRoundsBuilt() {
		return roundsBuilt;
	}

	protected void setRoundsBuilt(int roundsBuilt) {
		this.roundsBuilt = roundsBuilt;
	}

	protected boolean isCompleted() {
		return completed;
	}

	protected void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public BuildingData getBuildingData() {
		return buildingData;
	}

	public void setBuildingData(BuildingData buildingData) {
		this.buildingData = buildingData;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
