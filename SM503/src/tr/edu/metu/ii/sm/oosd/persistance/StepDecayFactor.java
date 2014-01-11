package tr.edu.metu.ii.sm.oosd.persistance;

public class StepDecayFactor extends DecayFactor {

	@Override
	public float getDecayFactor() {
		int step1 = 0;
		int step2 = 3;
		int step3 = 7;

		if (step1 <= round && round < step2) {
			return (float) 1;
		} else if (round >= step2 && round < step3) {
			return (float) 0.5;
		} else if (round >= step3) {
			return (float) 0;
		}

		return (float) 1;
	}

}
