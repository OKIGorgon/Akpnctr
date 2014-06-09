package M.Algorithms;

import java.util.Iterator;
import java.util.ListIterator;

import M.Algorithms.DateConverter.DateConverter;
import M.Date.Date;
import M.Point.Point;

public class PointsInDayAlgorithm extends Algorithm {

	public PointsInDayAlgorithm(DateConverter Conv) {
		super(Conv);
		// TODO Auto-generated constructor stub
	}

	public void executeAlgorithm(Date Dat) {
		ListIterator<Point> Iter = PointList.listIterator();

		while (Iter.hasNext()) {
			Point temp = new Point();
			temp = Iter.next();
			// /System.out.println(temp.getName());
			if (Converter.ConvertAndCheck(temp, Dat)) {
				// /System.out.println("dodano");
				ResultList.add(temp);
			}
		}
		;

	}

}
