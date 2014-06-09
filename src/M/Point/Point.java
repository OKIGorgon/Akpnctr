package M.Point;

import java.util.ArrayList;

public class Point {
	private String Name;
	private ArrayList<String> Activation;

	public Point() {
	};

	public Point(String s) {
		Name = s;
		Activation = new ArrayList<String>();
	}

	public void addActivation(String s) {
		Activation.add(s);
	}

	public boolean checkCompatibility(String s) {
		return Activation.contains(s);
	}

	public String getName() {
		return Name;
	}

}
