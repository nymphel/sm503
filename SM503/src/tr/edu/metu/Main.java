package tr.edu.metu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static final String fileName = "D:\\objects.dat";
	public static Root root;

	public static void main(String[] args) throws Exception {
		loadRoot();
		// initialize and run your application here....
		// do not forget to call saveRoot() before exiting!!!
	}

	public static void loadRoot() throws Exception {
		ObjectInputStream stream = new java.io.ObjectInputStream(new FileInputStream(fileName));
		try {
			root = (Root) stream.readObject();
		} finally {
			stream.close();
		}
	}

	public static void saveRoot() throws Exception {
		ObjectOutputStream stream = new java.io.ObjectOutputStream(new FileOutputStream(fileName));
		try {
			stream.writeObject(root);
		} finally {
			stream.close();
		}
	}

}
