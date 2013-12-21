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
			int xpWhenCompleted = buildingData.getXpWhenCompleted();
			this.owner.addXp(xpWhenCompleted);
			System.out.println("::::: building is completed for "+owner.getName());
		}
		
		if(completed) {
			int coinIncome =buildingData.getCoinIncome();
			this.owner.addCoin(coinIncome);
			System.out.println("::::: building rent income is gained for "+owner.getName());
		}
		
		System.out.println("::::: building took round for "+owner.getName());
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
