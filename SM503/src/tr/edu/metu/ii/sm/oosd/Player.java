package tr.edu.metu.ii.sm.oosd;

import java.util.HashMap;
import java.util.UUID;

public class Player {
	
	private String name;
	private String letter;
	private int coin;
	private int xp;
	private boolean uppercase;
	
	private HashMap<UUID, Employee> employees = new HashMap<>();
	
	public void addXp(int xp) {
		this.xp += xp;
	}
	
	public void addCoin(int coin) {
		this.coin += coin;
	}
	
	public void charge(int coin) {
		this.coin -= coin;
	}
	
	public boolean buySection(String coordinate) {
		Section selectedSection = FarmGame.getInstance().getFarmArea().selectSection(coordinate);
		return selectedSection.buySection(this);
	}
	
	public boolean sellSection(String coordinate) {
		Section selectedSection = FarmGame.getInstance().getFarmArea().selectSection(coordinate);
		return selectedSection.sellSection(this);
	}
	
	public boolean recruitEmployee(Employee employee) {
		return employee.recruit(this);
	}
	
	public boolean fireEmployee(Employee employee) {
		return employee.fire(this);
	}
	
	public boolean plowSection(String coordinate, Employee employee) {
		Section selectedSection = FarmGame.getInstance().getFarmArea().selectSection(coordinate);
		return selectedSection.plow(this, employee);
	}
	
	public boolean plantSeed(String coordinate, String seed, Employee employee) {
		Section selectedSection = FarmGame.getInstance().getFarmArea().selectSection(coordinate);
		return selectedSection.plant(this, seed, employee);
	}
	
	public boolean harvestSection(String coordinate, Employee employee) {
		Section selectedSection = FarmGame.getInstance().getFarmArea().selectSection(coordinate);
		return selectedSection.harvest(this, employee);
	}
	
	public boolean constructBuilding(String coordinate, Employee employee) {
		Section selectedSection = FarmGame.getInstance().getFarmArea().selectSection(coordinate);
		return selectedSection.constructBuilding(this, employee);
	}
	
	public boolean teardownBuilding(String coordinate, Employee employee) {
		Section selectedSection = FarmGame.getInstance().getFarmArea().selectSection(coordinate);
		return selectedSection.teardownBuilding(this, employee);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public void registerEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
	}
	
	public void unregisterEmployee(Employee employee) {
		employees.remove(employee.getId());
	}

	public boolean isUppercase() {
		return uppercase;
	}

	public void setUppercase(boolean uppercase) {
		this.uppercase = uppercase;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public Employee selectEmployee(Employee employeePrototype) {
		for (Employee employee : employees.values()) {
			if(employee.getClass().equals(employeePrototype.getClass())) {
				return employee;
			}
		}
		return null;
	}

}
