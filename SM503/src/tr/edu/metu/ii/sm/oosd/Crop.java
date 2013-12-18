package tr.edu.metu.ii.sm.oosd;

public class Crop {
	
	private String name;
	private int roundsPlanted;
	private boolean readyToHarvest;
	
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
	
	

}
