package tr.edu.metu.ii.sm.oosd;

import java.util.HashMap;

import tr.edu.metu.ii.sm.oosd.persistance.Action;
import tr.edu.metu.ii.sm.oosd.persistance.Action.Type;

public class Section {

	private String coordinate;
	private Lot lot;
	private Player owner;
	private String letter;

	private enum Status {
		EMPTY, PLOUGH, HARVESTED, HASBUILDING
	};

	private Status status;

	public boolean buySection(Player player) {
		
		HashMap<Type, Action> actions = FarmGame.getInstance().getDataStore().getActions();
		Action action = actions.get(Type.BUY_SECTION);
		
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

		int coin = player.getCoin();
		coin = coin - action.getCost();
		player.setCoin(coin);

		int xp = player.getXp();
		xp += action.getXpGained();
		player.setXp(xp);

		return true;
	}

	public boolean sellSection(Player player) {
		if(this.owner != player) {
			System.out.println("you cannot sell this section that you don't own.");
		} else if(Status.HARVESTED.equals(this.status) || Status.HASBUILDING.equals(this.status)) {
			System.out.println("you cannot sell this section that it not empty.");
			return false;
		}
		
		HashMap<Type, Action> actions = FarmGame.getInstance().getDataStore().getActions();
		Action action = actions.get(Type.SELL_SECTION);
		
		int coin = player.getCoin();
		coin = coin + action.getCost();
		player.setCoin(coin);
		
		int xp = player.getXp();
		xp += action.getXpGained();
		player.setXp(xp);

		return true;
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
