package O.ToTable;

import java.util.ListIterator;
import javax.swing.table.DefaultTableModel;
import O.GUI.AkupunFrame;

public class ToTable {
	public static void WriteResults(ListIterator<String> Iter, boolean side) {
		DefaultTableModel model;
		if (side) {
			model = (DefaultTableModel) AkupunFrame.PointsSTable.getModel();
		} else {
			model = (DefaultTableModel) AkupunFrame.DaysSTable.getModel();
		}
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
		}
		while (Iter.hasNext()) {
			model.addRow(new Object[] { Iter.next() });
		}
	}
}
