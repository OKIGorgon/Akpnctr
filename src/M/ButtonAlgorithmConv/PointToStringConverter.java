package M.ButtonAlgorithmConv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import M.Algorithms.PointsInDayAlgorithm;
import M.Algorithms.DateConverter.NormalToInd;
import M.Date.Date;
import M.Point.Point;

public class PointToStringConverter extends AbstractButtonAlgorithmConverter {
	public PointToStringConverter(int d, int m, int y) {
		Date Dat = new Date(d, m, y);
		NormalToInd Conv = new NormalToInd();
		PointsInDayAlgorithm Alg = new PointsInDayAlgorithm(Conv);
		Alg.executeAlgorithm(Dat);
		ArrayList<Point> res = new ArrayList<Point>();

		res = Alg.GetResult();
		ListIterator<Point> iter = res.listIterator();
		while (iter.hasNext()) {
			Point p = iter.next();
			// /System.out.println(p.getName());
			Result.add(p.getName());
		}
		;

	}

}
