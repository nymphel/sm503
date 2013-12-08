package tr.edu.metu;

import java.io.Serializable;

public class Other implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String data;

	public Other() { // default constructor
	}

	public void writeData() {
		System.out.println(data);
	}

}
