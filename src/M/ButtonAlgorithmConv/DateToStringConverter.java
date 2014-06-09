package M.ButtonAlgorithmConv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import M.Date.Date;
import M.Algorithms.DateConverter.NormalToInd;
import M.Algorithms.NearestDayForPointAlgorithm;

public class DateToStringConverter extends AbstractButtonAlgorithmConverter {
	public DateToStringConverter(String S, int d, int m, int y, int dd, int mm,
			int yy) {
		/*
		 * System.out.println(S); System.out.println(d); System.out.println(m);
		 * System.out.println(y); System.out.println(dd);
		 * System.out.println(mm); System.out.println(yy);
		 */
		Date Beginning = new Date(d, m, y);
		Date Ending = new Date(dd, mm, yy);
		NormalToInd Conv = new NormalToInd();
		NearestDayForPointAlgorithm Alg = new NearestDayForPointAlgorithm(Conv,
				S);
		Alg.executeAlgorithm(Beginning, Ending);

		ArrayList<Date> res = new ArrayList<Date>();

		res = Alg.GetResult();
		ListIterator<Date> iter = res.listIterator();
		while (iter.hasNext()) {
			Date dat = iter.next();
			// System.out.println(dat.toString());
			Result.add(dat.toString());
		}
		;
	}
}
