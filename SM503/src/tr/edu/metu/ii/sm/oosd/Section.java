package tr.edu.metu.ii.sm.oosd;

public class Section {
	
	private String coordinate;
	private Lot lot;
	private Player owner;
	
	public boolean buySection(Player player) {
		
		if(owner != null) {
			System.out.println("this section has an owner already");
			return false;
		} else if(lot.getOwner() != null && !lot.getOwner().equals(player)) {
			System.out.println("you cannot purchase this section, because it is located in opponents lot");
			return false;
		} else if(player.getCoin() < Currency.SECTION_BUY_COIN) {
			System.out.println("you cannot purchase this section, you dont have enough coins");
			return false;
		}
		
		int coin = player.getCoin();
		coin = coin - Currency.SECTION_BUY_COIN;
		player.setCoin(coin);
		
		int xp = player.getXp();
		xp += Currency.SECTION_BUY_XP;
		player.setXp(xp);
		
		return true;
	}
	
public boolean sellSection(Player player) {
		
		return false;
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

}
