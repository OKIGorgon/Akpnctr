package M.Algorithms;

import java.util.ArrayList;
import java.util.ListIterator;

import M.Point.Point;

import M.Algorithms.DateConverter.DateConverter;
import M.Date.Date;

public class NearestDayForPointAlgorithm extends Algorithm {

	private Point Point;

	public NearestDayForPointAlgorithm(DateConverter Conv, String S) {
		super(Conv);
		Point = this.getPoint(S);
	}

	NearestDayForPointAlgorithm(DateConverter Conv) {
		super(Conv);
	}

	public void executeAlgorithm(Date Dat) {
		// System.out.println("SPRAWDZENIE");
		if (Converter.ConvertAndCheck(Point, Dat)) {
			// /Dat.print()
			// System.out.println("DODANO DATE");
			((ArrayList<Date>) ResultList).add(Dat);
		}

	}

	public void executeAlgorithm(Date DatFirst, Date DatLast) {
		if (Point != null) {
			for (Date Curr = DatFirst; Curr.notLarger(DatLast); Curr.Inc(1)) {
				// /Curr.print();
				Date dat = new Date(Curr.getDay(), Curr.getMonth(),
						Curr.getYear());
				executeAlgorithm(dat);
				// /Curr.print();
			}
			ListIterator<Date> iter = ResultList.listIterator();
			while (iter.hasNext()) {
				Date dat = iter.next();
				// /System.out.println(dat.toString());

			}
		}
	}

}
