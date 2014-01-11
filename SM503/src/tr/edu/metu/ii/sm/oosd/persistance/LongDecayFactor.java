package tr.edu.metu.ii.sm.oosd.persistance;

public class LongDecayFactor extends DecayFactor {

	private static final long serialVersionUID = -4220822964500093702L;

	@Override
	public float getDecayFactor() {
		int startRound = 0;
		int endRound = 16;

		if (startRound <= round && round < endRound) {
			return (float) 1;
		} else if (round >= endRound) {
			return (float) 0;
		}

		return (float) 1;
	}

}
