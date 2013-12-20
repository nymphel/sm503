package tr.edu.metu.ii.sm.oosd;

import java.util.HashMap;
import java.util.UUID;

public abstract class Player {
	
	private String name;
	private int coin;
	private int xp;
	
	private HashMap<UUID, Employee> employees = new HashMap<>();
	
	public void takeTurn() {
		//TODO: players can take turn by entering commands
	}
	
	public abstract boolean uppercase();

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

}
