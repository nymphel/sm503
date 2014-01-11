package tr.edu.metu.ii.sm.oosd.persistance;

public abstract class DecayFactor {

	protected int round;

	protected abstract float getDecayFactor();

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

}
