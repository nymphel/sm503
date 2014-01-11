package tr.edu.metu.ii.sm.oosd;

import java.util.HashMap;
import java.util.UUID;

import tr.edu.metu.ii.sm.oosd.persistance.DataStore;
import tr.edu.metu.ii.sm.oosd.persistance.EmployeeData;


public abstract class Employee {
	
	private UUID id;
	private Section assignedSection;
	private Player owner;
	
	private HashMap<String,EmployeeData> employeeData = DataStore.getInstance().getEmployeeData();

	
	public boolean recruit(Player player) {
		// this will return of class, Farmer/Constructor
		String type = this.getClass().getSimpleName();
		EmployeeData empData = employeeData.get(type);
		int cost = empData.getCost();
		
		if (player.getCoin() < cost) {
			System.out.println("you cannot recruit this employee, you dont have enough coins.");
			return false;
		}
		
		this.id = UUID.randomUUID();
		this.owner = player;
		this.owner.registerEmployee(this);
		
		player.charge(cost);
		
		System.out.println("Employee is recruited by "+ player.getName());
		return true;
	}
	public boolean fire(Player player) {
		
		if(this.assignedSection != null) {
			System.out.println("you cannot fire this employee, "
					+ "because it is assigned to section: "+this.assignedSection.getCoordinate());
			return false;
		}
	
		this.owner.unregisterEmployee(this);
		System.out.println("Employee is fired by "+ player.getName());
		return true;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Section getAssignedSection() {
		return assignedSection;
	}
	public void setAssignedSection(Section assignedSection) {
		this.assignedSection = assignedSection;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	public void takeRound() {
		// this will return of class, Farmer/Constructor
		String type = this.getClass().getSimpleName();
		EmployeeData empData = employeeData.get(type);
		int salary = empData.getSalary();
		
		System.out.println("Salary of "+type+" is charged from player.");
		owner.charge(salary);
	}

}
