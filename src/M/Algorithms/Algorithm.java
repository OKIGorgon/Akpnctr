package M.Algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import M.Date.Date;
import M.Point.Point;
import M.Algorithms.DateConverter.*;

public abstract class Algorithm {
	protected ArrayList ResultList;
	static protected ArrayList<Point> PointList;
	static protected boolean is_set;
	protected DateConverter Converter;

	public abstract void executeAlgorithm(Date Dat);

	public ArrayList GetResult() {
		// /ListIterator<Date> iter=ResultList.listIterator();
		// while(iter.hasNext())
		// {
		// Date dat=iter.next();
		// System.out.println(dat.toString());

		// }
		return ResultList;
	}

	public Algorithm(DateConverter Conv) {
		Converter = Conv;
		ResultList = new ArrayList();
		PointList = new ArrayList<Point>();
		// /wype³nij PointList

		// /System.out.println("UTWORZENIE POINTLIST\n\n");
		Point Punkt1 = new Point("Punkt1");
		Punkt1.addActivation("Smok");
		Punkt1.addActivation("Koczkodan");
		Punkt1.addActivation("Dziobak");

		Point Punkt2 = new Point("Punkt2");
		Punkt2.addActivation("Smok");
		Punkt2.addActivation("Dziobak");

		Point Punkt3 = new Point("Punkt3");
		Punkt3.addActivation("Dzieciol");
		Punkt3.addActivation("Koczkodan");

		Point Punkt4 = new Point("Punkt4");
		Punkt4.addActivation("Dzieciol");
		Punkt4.addActivation("Koczkodan");
		Punkt4.addActivation("Krokodyl");

		PointList.add(Punkt1);
		PointList.add(Punkt2);
		PointList.add(Punkt3);
		PointList.add(Punkt4);

	};

	Point getPoint(String s) {
		ListIterator<Point> iter = PointList.listIterator();
		Point p;
		while (iter.hasNext()) {
			p = iter.next();
			if (s == p.getName())
				return p;
		}
		return null;

	}
}
