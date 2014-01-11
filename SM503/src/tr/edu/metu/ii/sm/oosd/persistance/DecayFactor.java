package tr.edu.metu.ii.sm.oosd.persistance;

public abstract class DecayFactor {

	protected int round;

	public abstract float getDecayFactor();

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

}
