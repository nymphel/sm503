package tr.edu.metu.ii.sm.oosd;

public class Building {

	private int roundsBuilt;
	private boolean completed;

	protected int getRoundsBuilt() {
		return roundsBuilt;
	}

	protected void setRoundsBuilt(int roundsBuilt) {
		this.roundsBuilt = roundsBuilt;
	}

	protected boolean isCompleted() {
		return completed;
	}

	protected void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
