package tr.edu.metu.ii.sm.oosd;

import java.util.HashMap;
import java.util.UUID;

public class Player {
	
	private String name;
	private int coin;
	private int xp;
	
	private HashMap<UUID, Employee> employees = new HashMap<>();
	
	public void takeTurn() {
		
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

}
