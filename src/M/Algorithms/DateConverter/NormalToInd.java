package M.Algorithms.DateConverter;

import M.Date.Date;
import M.Point.Point;

public class NormalToInd extends DateConverter {

	@Override
	public boolean ConvertAndCheck(Point Point, Date Dat) {
		String IndDate;
		{
			if ((Dat.getDay() % 2) == 0) {
				if ((Dat.getMonth() % 2) == 0) {
					if ((Dat.getYear() % 2) == 0) {
						IndDate = new String("Smok");
					} else {
						IndDate = new String("Koczkodan");
					}
				} else {
					IndDate = new String("Krokodyl");
				}
			} else {
				if ((Dat.getDay() % 3) == 0) {
					IndDate = new String("Dziobak");
				} else {
					IndDate = new String("Dzieciol");
				}
			}

		}
		// /System.out.println(IndDate);
		return Point.checkCompatibility(IndDate);
	}

}
