package test.java.M.Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

import M.Algorithms.DateConverter.NormalToInd;
import M.ButtonAlgorithmConv.DateToStringConverter;
import M.ButtonAlgorithmConv.PointToStringConverter;
import M.Date.Date;
import M.Point.Point;

public class MyTest {

	@Test
	public void DateToStringConverterTest() {
		DateToStringConverter Dtsc = new DateToStringConverter("Punkt1", 25, 4,
				2014, 30, 4, 2014);
		ArrayList<String> res = new ArrayList<String>();
		res = Dtsc.getResult();
		assertTrue(res.contains("26.4.2014"));
		assertTrue(res.contains("27.4.2014"));
		assertTrue(res.contains("28.4.2014"));
		assertTrue(res.contains("30.4.2014"));
		assertTrue(res.size() == 4);
		res.clear();

		Dtsc = new DateToStringConverter("Punkt2", 25, 4, 2014, 30, 4, 2014);
		res = new ArrayList<String>();
		res = Dtsc.getResult();
		assertTrue(res.contains("26.4.2014"));
		assertTrue(res.contains("27.4.2014"));
		assertTrue(res.contains("28.4.2014"));
		assertTrue(res.contains("30.4.2014"));
		assertTrue(res.size() == 4);
		res.clear();

		Dtsc = new DateToStringConverter("Punkt3", 25, 4, 2014, 30, 4, 2014);
		res = new ArrayList<String>();
		res = Dtsc.getResult();
		assertTrue(res.contains("25.4.2014"));
		assertTrue(res.contains("29.4.2014"));
		assertTrue(res.size() == 2);
		res.clear();

		Dtsc = new DateToStringConverter("Punkt4", 25, 4, 2014, 30, 4, 2014);
		res = new ArrayList<String>();
		res = Dtsc.getResult();
		assertTrue(res.contains("25.4.2014"));
		assertTrue(res.contains("29.4.2014"));
		assertTrue(res.size() == 2);

	};

	@Test
	public void PointToStringConverterTest() {
		PointToStringConverter Ptsc = new PointToStringConverter(26, 4, 2014);
		ArrayList<String> res = new ArrayList<String>();
		res = Ptsc.getResult();
		assertTrue(res.contains("Punkt1"));
		assertTrue(res.contains("Punkt2"));
		assertTrue(res.size() == 2);
		res.clear();

		Ptsc = new PointToStringConverter(27, 4, 2014);
		res = new ArrayList<String>();
		res = Ptsc.getResult();
		assertTrue(res.contains("Punkt1"));
		assertTrue(res.contains("Punkt2"));
		assertTrue(res.size() == 2);
		res.clear();

		Ptsc = new PointToStringConverter(28, 4, 2014);
		res = new ArrayList<String>();
		res = Ptsc.getResult();
		assertTrue(res.contains("Punkt1"));
		assertTrue(res.contains("Punkt2"));
		assertTrue(res.size() == 2);
		res.clear();

		Ptsc = new PointToStringConverter(29, 4, 2014);
		res = new ArrayList<String>();
		res = Ptsc.getResult();
		assertTrue(res.contains("Punkt3"));
		assertTrue(res.contains("Punkt4"));
		assertTrue(res.size() == 2);
		res.clear();

		Ptsc = new PointToStringConverter(28, 5, 2014);
		res = new ArrayList<String>();
		res = Ptsc.getResult();
		assertTrue(res.contains("Punkt4"));
		assertTrue(res.size() == 1);
		res.clear();
	}

	@Test
	public void DateNotLargerTest() {
		Date dat = new Date(5, 5, 1990);
		assertTrue(dat.notLarger(new Date(5, 5, 1990)));
		assertTrue(dat.notLarger(new Date(8, 5, 1990)));
		assertTrue(!dat.notLarger(new Date(4, 5, 1990)));
		assertTrue(dat.notLarger(new Date(5, 6, 1990)));
		assertTrue(!dat.notLarger(new Date(5, 4, 1990)));
		assertTrue(dat.notLarger(new Date(5, 5, 1991)));
		assertTrue(!dat.notLarger(new Date(5, 5, 1989)));
	}

	@Test
	public void ConvertAndCheckTest() {
		NormalToInd nti = new NormalToInd();
		Point p = new Point("Punkt");
		p.addActivation("Smok");
		assertTrue(!nti.ConvertAndCheck(p, new Date(3, 1, 1)));
		assertTrue(!nti.ConvertAndCheck(p, new Date(1, 1, 1)));
		assertTrue(!nti.ConvertAndCheck(p, new Date(2, 1, 1)));
		assertTrue(!nti.ConvertAndCheck(p, new Date(2, 2, 1)));
		assertTrue(nti.ConvertAndCheck(p, new Date(2, 2, 2)));
		p.addActivation("Krokodyl");
		assertTrue(!nti.ConvertAndCheck(p, new Date(3, 1, 1)));
		assertTrue(!nti.ConvertAndCheck(p, new Date(1, 1, 1)));
		assertTrue(nti.ConvertAndCheck(p, new Date(2, 1, 1)));
		assertTrue(!nti.ConvertAndCheck(p, new Date(2, 2, 1)));
		assertTrue(nti.ConvertAndCheck(p, new Date(2, 2, 2)));
		p.addActivation("Koczkodan");
		p.addActivation("Dziobak");
		p.addActivation("Dzieciol");
		assertTrue(nti.ConvertAndCheck(p, new Date(3, 1, 1)));
		assertTrue(nti.ConvertAndCheck(p, new Date(1, 1, 1)));
		assertTrue(nti.ConvertAndCheck(p, new Date(2, 1, 1)));
		assertTrue(nti.ConvertAndCheck(p, new Date(2, 2, 1)));
		assertTrue(nti.ConvertAndCheck(p, new Date(2, 2, 2)));
	}

	@Test
	public void DateIncTest() {
		Date dat = new Date(5, 5, 1990);
		dat.Inc(1);
		assertTrue(dat.getMonth() == 5 && dat.getDay() == 6
				&& dat.getYear() == 1990);
		dat.Inc(5);
		assertTrue(dat.getMonth() == 5 && dat.getDay() == 11
				&& dat.getYear() == 1990);
		dat.Inc(30);
		assertTrue(dat.getMonth() == 6 && dat.getDay() == 10
				&& dat.getYear() == 1990);
		dat.Inc(365);
		assertTrue(dat.getMonth() == 6 && dat.getDay() == 10
				&& dat.getYear() == 1991);
	}
}
