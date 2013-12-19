package tr.edu.metu.ii.sm.oosd;

import tr.edu.metu.ii.sm.oosd.persistance.StartingDataInjector;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StartingDataInjector.setupSampleDataStore();
		FarmGame.getInstance().recruitEmployee(new Player(), new Farmer());
		FarmGame.getInstance().recruitEmployee(new Player(), new Constructor());

	}

}
