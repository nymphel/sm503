package tr.edu.metu.ii.sm.oosd;

public class Lot {
	
	private String name;
	private Player owner;
	
	public Lot(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
