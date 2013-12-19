package tr.edu.metu.ii.sm.oosd;

import java.util.HashMap;

import tr.edu.metu.ii.sm.oosd.persistance.ActionData;
import tr.edu.metu.ii.sm.oosd.persistance.ActionData.Type;
import tr.edu.metu.ii.sm.oosd.persistance.DataStore;

public class Section {

	private String coordinate;
	private Lot lot;
	private Player owner;
	private String letter;

	private Crop activeCrop;
	private Building activeBuilding;
	
	private HashMap<Type, ActionData> actionData = DataStore.getInstance().getActionData();

	public boolean buySection(Player player) {
		
		ActionData action = actionData.get(Type.BUY_SECTION);
		
		if (this.owner != null) {
			System.out.println("this section has an owner already.");
			return false;
		} else if (lot.getOwner() != null && !lot.getOwner().equals(player)) {
			System.out.println("you cannot purchase this section, because it is located in opponents lot.");
			return false;
		} else if (player.getCoin() < action.getCost()) {
			System.out.println("you cannot purchase this section, you dont have enough coins.");
			return false;
		}

		affectPlayer(player, action);

		return true;
	}

	public boolean sellSection(Player player) {
		if(this.owner != player) {
			System.out.println("you cannot sell this section that you don't own.");
		} else if(this.activeCrop != null || this.activeBuilding != null) {
			System.out.println("you cannot sell this section that it not empty.");
			return false;
		}
		
		ActionData action = actionData.get(Type.SELL_SECTION);
		
		affectPlayer(player, action);

		return true;
	}
	
	public boolean plow(Player player, Employee employee) {
		//TODO: validation
		//TODO assign emp
		ActionData action = actionData.get(Type.PLOW);
		affectPlayer(player, action);
		
		return false;
	}
	
	public boolean plant(Player player, String seed, Employee employee) {
		//TODO: validation
		//TODO assign emp
		//TODO: create a crop according to seed type
		ActionData action = actionData.get(Type.PLANT);
		affectPlayer(player, action);
		
		return false;
	}
	
	public boolean harvest(Player player, Crop crop, Employee employee) {
		
		return false;
	}
	
	private void affectPlayer(Player player, ActionData action) {
		int coin = player.getCoin();
		coin = coin - action.getCost();
		player.setCoin(coin);

		int xp = player.getXp();
		xp += action.getXpGained();
		player.setXp(xp);
	}
	

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

}
