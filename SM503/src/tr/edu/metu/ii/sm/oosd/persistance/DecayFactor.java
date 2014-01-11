package tr.edu.metu.ii.sm.oosd.persistance;

import java.io.Serializable;

public abstract class DecayFactor implements Serializable {

	private static final long serialVersionUID = 456582989462055741L;
	
	protected int round;

	public abstract float getDecayFactor();

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

}
