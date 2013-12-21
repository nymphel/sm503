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
	
	public void takeTurn() {
		//TODO: players can take turn by entering commands
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
