package tr.edu.metu;

import java.io.Serializable;
import java.util.List;

public class Root implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 962722147320943661L;
	/**
	 * Keep each type of object (that needs persistence) in a separate
	 * container...
	 */
	List<Other> otherObjects;

	public Root() { // default constructor
	}

	public void aMethod() {
	}

}
