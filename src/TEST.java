import java.util.ArrayList;
import java.util.ListIterator;

import M.ButtonAlgorithmConv.DateToStringConverter;
import M.ButtonAlgorithmConv.PointToStringConverter;
import O.GUI.AkupunFrame;
import O.ToTable.ToTable;

public class TEST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AkupunFrame.main(args);
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
		}
		/*
		 * DateToStringConverter Dtsc= new
		 * DateToStringConverter("Punkt4",25,4,2014,30,4,2014);
		 * ArrayList<String> res=new ArrayList<String>(); res=Dtsc.getResult();
		 * ListIterator<String> Iter=res.listIterator(); while(Iter.hasNext()) {
		 * System.out.println(Iter.next()); }
		 */
		/*
		 * ToTable.WriteResults(Iter,false); PointToStringConverter Ptsc = new
		 * PointToStringConverter(28,5,2014); ArrayList<String> res2=new
		 * ArrayList<String>(); res2=Ptsc.getResult(); ListIterator<String>
		 * Iter2=res2.listIterator();
		 */
		/*
		 * while(Iter2.hasNext()) { System.out.println(Iter2.next()); }
		 */
		// ToTable.WriteResults(Iter2,true);
	}

}
