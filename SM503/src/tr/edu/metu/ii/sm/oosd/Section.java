package tr.edu.metu.ii.sm.oosd;

import java.util.HashMap;

import tr.edu.metu.ii.sm.oosd.persistance.ActionData;
import tr.edu.metu.ii.sm.oosd.persistance.BuildingData;
import tr.edu.metu.ii.sm.oosd.persistance.SeedData;
import tr.edu.metu.ii.sm.oosd.persistance.ActionData.Type;
import tr.edu.metu.ii.sm.oosd.persistance.DataStore;

public class Section {

	private String coordinate;
	private Lot lot;
	private Player owner;
	private String letter;

	private Crop activeCrop;
	private Building activeBuilding;
	private boolean plaught;
	private Employee assignedEmployee;
	
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
			return false;
		} else if(this.activeCrop != null || this.activeBuilding != null) {
			System.out.println("you cannot sell this section that it not empty.");
			return false;
		}
		
		ActionData action = actionData.get(Type.SELL_SECTION);
		
		affectPlayer(player, action);

		return true;
	}
	
	public boolean plow(Player player, Employee employee) {
		if(this.owner != player) {
			System.out.println("you cannot plow this section that you don't own.");
			return false;
		} else if(this.activeCrop != null || this.activeBuilding != null) {
			System.out.println("you cannot plow this section that it not empty.");
			return false;
		}
		
		//TODO: what to do with farmer
		
		ActionData action = actionData.get(Type.PLOW);
		affectPlayer(player, action);
		
		this.plaught = true;
		
		return false;
	}
	
	public boolean plant(Player player, String seed, Employee employee) {
		if(this.owner != player) {
			System.out.println("you cannot plant this section that you don't own.");
			return false;
		} else if(this.activeCrop != null || this.activeBuilding != null) {
			System.out.println("you cannot plant this section that it not empty.");
			return false;
		} else if(!this.plaught) {
			System.out.println("you must first plow this section.");
			return false;
		}
		
		//create a crop according to seed type
		boolean plaughtSuccessful = plantSeed(player, seed);
		if(!plaughtSuccessful) {
			return false;
		}
		
		//assign an employee 
		this.assignedEmployee = employee;
		employee.setAssignedSection(this);
		
		//plowing is over
		this.plaught = false;
		
		
		ActionData action = actionData.get(Type.PLANT);
		affectPlayer(player, action);
		
		return true;
	}
	
	private boolean plantSeed(Player player, String seed) {
		HashMap<String, SeedData> seedData = DataStore.getInstance().getSeedData();
		SeedData sData = seedData.get(seed);
		
		int costToPlant = sData.getCostToPlant();
		if (this.owner.getCoin() < costToPlant) {
			System.out.println("you cannot plant this seed, you dont have enough coins.");
			return false;
		}
		
		Crop crop = new Crop();
		crop.setName(seed);
		crop.setSeedData(sData);
		crop.setOwner(player);
		
		this.activeCrop = crop;
		return true;
		
		
	}

	public boolean harvest(Player player, Employee employee) {
		if(this.owner != player) {
			System.out.println("you cannot harvest this section that you don't own.");
			return false;
		} else if(this.activeBuilding != null) {
			System.out.println("you cannot harvest this section that it not empty.");
			return false;
		} else if(this.activeCrop == null) {
			System.out.println("there is no crop to harvest");
			return false;
		} else if(!this.activeCrop.isReadyToHarvest()) {
			System.out.println("crop is not ready to harvest");
			return false;
		}
		
		ActionData action = actionData.get(Type.HARVEST);
		affectPlayer(player, action);
		
		this.activeCrop.harvest();
		//no active crop
		this.activeCrop = null;
		
		//resign employee
		this.assignedEmployee.setAssignedSection(null);
		this.assignedEmployee = null;
		
		return true;
	}
	
	public boolean constructBuilding(Player player, Employee employee) {
		
		ActionData action = actionData.get(Type.CONSTRUCT_BUILDING);

		if(this.owner != player) {
			System.out.println("you cannot build a building on this section that you don't own.");
			return false;
		} else if(this.activeCrop != null || this.activeBuilding != null) {
			System.out.println("you cannot build a building on this section that it not empty.");
			return false;
		} else if (this.owner.getCoin() < action.getCost()) {
			System.out.println("you cannot construct a building, you dont have enough coins.");
			return false;
		}
		
		BuildingData buildingData = DataStore.getInstance().getBuildingData();
		Building building = new Building();
		building.setBuildingData(buildingData);
		building.setOwner(player);
		this.activeBuilding = building;
		
		this.assignedEmployee = employee;
		employee.setAssignedSection(this);
		
		affectPlayer(player, action);
		
		return true;
	}
	
	public boolean teardownBuilding(Player player, Employee employee) {
		ActionData action = actionData.get(Type.TEAR_DOWN_BUILDING);

		if(this.owner != player) {
			System.out.println("you cannot teardown a building on this section that you don't own.");
			return false;
		} else if(this.activeBuilding == null) {
			System.out.println("there is no building to tear down");
			return false;
		}
		
		this.activeBuilding = null;
		
		//resign employee
		this.assignedEmployee.setAssignedSection(null);
		this.assignedEmployee = null;
		
		affectPlayer(player, action);
		
		return true;
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

	public boolean isPlaught() {
		return plaught;
	}

	public void setPlaught(boolean plaught) {
		this.plaught = plaught;
	}

}
