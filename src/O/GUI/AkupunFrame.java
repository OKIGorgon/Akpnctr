package O.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import M.ButtonAlgorithmConv.DateToStringConverter;
import M.ButtonAlgorithmConv.PointToStringConverter;
import O.ToTable.ToTable;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.JTextArea;
//import javax.swing.SpinnerDateModel;
//import java.util.Date;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
//import java.awt.Component;
//import javax.swing.JToolBar;
//import javax.swing.JScrollBar;

public class AkupunFrame extends JFrame {

	private JPanel contentPane;
	public static JTable PointsSTable;
	public static JTable DaysSTable;
	private boolean english;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final AkupunFrame frame = new AkupunFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AkupunFrame() {
		setTitle("Akoo-timer v0.9.5(still missing)");

		Calendar CurDate = Calendar.getInstance();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		final JMenu mnLanguage = new JMenu("Language"); // en - "Language" pl -
														// "J黝yk"
		mnMenu.add(mnLanguage);

		final JMenuItem LanguageEnglishBtn = new JMenuItem("V English");
		mnLanguage.add(LanguageEnglishBtn);
		english = true;

		final JMenuItem LanguagePolskiBtn = new JMenuItem("Polski");
		mnLanguage.add(LanguagePolskiBtn);

		final JMenuItem AboutBtn = new JMenuItem("About"); // en - "About" pl -
															// "O programie"

		mnMenu.add(AboutBtn);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JPanel PictureLogoHere = new JPanel();
		PictureLogoHere.setBounds(10, 15, getWidth() - 30, 50);
		contentPane.add(PictureLogoHere);

		final JLabel BirthdayLabel = new JLabel("Birthday:"); // en -
																// "Birthday:"
																// pl -
																// "Urodziny:"
		BirthdayLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		BirthdayLabel.setBounds(10,
				PictureLogoHere.getY() + PictureLogoHere.getHeight() + 10, 55,
				16);
		contentPane.add(BirthdayLabel);

		final JSpinner DayChoose = new JSpinner();
		DayChoose.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		DayChoose.setBounds(BirthdayLabel.getX() + BirthdayLabel.getWidth()
				+ 10, BirthdayLabel.getY(), 40, 20);
		contentPane.add(DayChoose);

		final JSpinner MonthChoose = new JSpinner();
		MonthChoose.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		MonthChoose.setBounds(DayChoose.getX() + DayChoose.getWidth() + 10,
				BirthdayLabel.getY(), 40, 20);
		contentPane.add(MonthChoose);

		final JSpinner YearChoose = new JSpinner();
		YearChoose
				.setModel(new SpinnerNumberModel(new Integer(CurDate
						.get(Calendar.YEAR) - 80), new Integer(1), null,
						new Integer(1)));
		YearChoose.setBounds(MonthChoose.getX() + MonthChoose.getWidth() + 5,
				BirthdayLabel.getY(), 80, 20);
		contentPane.add(YearChoose);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, DayChoose.getY() + DayChoose.getHeight() + 5,
				0, 0);
		tabbedPane.setBounds(10, DayChoose.getY() + DayChoose.getHeight() + 5,
				getWidth() - 30, getHeight() - tabbedPane.getY() - 65);
		contentPane.add(tabbedPane);

		final JPanel PointsSHere = new JPanel();
		tabbedPane.addTab("Find points in day", null, PointsSHere, null); // en
																			// -
																			// "Find points in day"
																			// pl
																			// -
																			// "Punkty w danym dniu"
		PointsSHere.setLayout(null);

		final JLabel PointsSDayLabel = new JLabel("Day:"); // en - "Day:" pl -
															// "Dzie�:"
		PointsSDayLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		PointsSDayLabel.setBounds(10, 20, 30, 20);
		PointsSHere.add(PointsSDayLabel);

		final JSpinner PointsSDays = new JSpinner();
		PointsSDays.setModel(new SpinnerNumberModel(CurDate
				.get(Calendar.DAY_OF_MONTH), 1, 31, 1));
		PointsSDays.setBounds(
				PointsSDayLabel.getX() + PointsSDayLabel.getWidth() + 10,
				PointsSDayLabel.getY(), 40, 20);
		PointsSHere.add(PointsSDays);

		final JLabel PointsSMonthLabel = new JLabel("Month:"); // en - "Month:"
																// pl -
																// "Miesiｹc:"
		PointsSMonthLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		PointsSMonthLabel.setBounds(PointsSDays.getX() + PointsSDays.getWidth()
				+ 10, PointsSDayLabel.getY(), 50, 20);
		PointsSHere.add(PointsSMonthLabel);

		final JSpinner PointsSMonth = new JSpinner();
		PointsSMonth.setModel(new SpinnerNumberModel(CurDate
				.get(Calendar.MONTH), 1, 12, 1));
		PointsSMonth.setBounds(
				PointsSMonthLabel.getX() + PointsSMonthLabel.getWidth() + 10,
				PointsSDayLabel.getY(), 40, 20);
		PointsSHere.add(PointsSMonth);

		final JLabel PointsSYearLabel = new JLabel("Year:"); // en - "Year:" pl
																// - "Rok:"
		PointsSYearLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		PointsSYearLabel.setBounds(
				+PointsSMonth.getX() + PointsSMonth.getWidth() + 10,
				PointsSDayLabel.getY(), 30, 20);
		PointsSHere.add(PointsSYearLabel);

		final JSpinner PointsSYear = new JSpinner();
		PointsSYear.setModel(new SpinnerNumberModel(new Integer(CurDate
				.get(Calendar.YEAR)), new Integer(1), null, new Integer(1)));
		PointsSYear.setBounds(
				PointsSYearLabel.getX() + PointsSYearLabel.getWidth() + 10,
				PointsSDayLabel.getY(), 80, 20);
		PointsSHere.add(PointsSYear);

		final JButton PointsSBtn = new JButton("Calculate"); // en - "Calculate"
																// pl - "Oblicz"
		PointsSBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PointToStringConverter Ptsc = new PointToStringConverter(
						(int) PointsSDays.getValue(), (int) PointsSMonth
								.getValue(), (int) PointsSYear.getValue());
				ArrayList<String> res = new ArrayList<String>();
				res = Ptsc.getResult();
				ListIterator<String> Iter = res.listIterator();
				ToTable.WriteResults(Iter, true);
			}
		});
		PointsSBtn.setBounds(10, PointsSDays.getY() + PointsSDays.getHeight()
				+ 5, 90, 25);
		PointsSHere.add(PointsSBtn);

		final JScrollPane PointsSScroll = new JScrollPane();
		PointsSScroll.setBounds(10, 80, 690, 165);
		PointsSHere.add(PointsSScroll);

		PointsSTable = new JTable(
				new DefaultTableModel(new Object[] { " " }, 0));
		PointsSScroll.setViewportView(PointsSTable);

		final JPanel DaysSHere = new JPanel();
		tabbedPane.addTab("Find days with point", null, DaysSHere, null); // en
																			// -
																			// "Find days with point"
																			// pl
																			// -
																			// "Dni z punktem"
		DaysSHere.setLayout(null);

		final JLabel DaysSPointLabel = new JLabel("Point:"); // en - "Point:" pl
																// - "Punkt:"
		DaysSPointLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		DaysSPointLabel.setBounds(10, 10, 40, 20);
		DaysSHere.add(DaysSPointLabel);

		final JComboBox PointsSComboBox = new JComboBox();
		PointsSComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Punkt1", "Punkt2", "Punkt3", "Punkt4" }));
		PointsSComboBox.setBounds(
				DaysSPointLabel.getX() + DaysSPointLabel.getWidth() + 5,
				DaysSPointLabel.getY(), 90, 20);
		DaysSHere.add(PointsSComboBox);

		final JLabel DaysSStarLabel = new JLabel("Start:");
		DaysSStarLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		DaysSStarLabel.setBounds(10,
				DaysSPointLabel.getY() + DaysSPointLabel.getHeight() + 5, 55,
				20);
		DaysSHere.add(DaysSStarLabel);

		final JSpinner DaysSSDayChoose = new JSpinner();
		DaysSSDayChoose.setModel(new SpinnerNumberModel(CurDate
				.get(Calendar.DAY_OF_MONTH), 1, 31, 1));
		DaysSSDayChoose.setBounds(
				DaysSStarLabel.getX() + DaysSStarLabel.getWidth() + 5,
				DaysSStarLabel.getY(), 40, 20);
		DaysSHere.add(DaysSSDayChoose);

		final JSpinner DaysSSMonthChoose = new JSpinner();
		DaysSSMonthChoose.setModel(new SpinnerNumberModel(CurDate
				.get(Calendar.MONTH), 1, 12, 1));
		DaysSSMonthChoose.setBounds(
				DaysSSDayChoose.getX() + DaysSSDayChoose.getWidth() + 5,
				DaysSStarLabel.getY(), 40, 20);
		DaysSHere.add(DaysSSMonthChoose);

		final JSpinner DaysSSYearChoose = new JSpinner();
		DaysSSYearChoose.setModel(new SpinnerNumberModel(new Integer(CurDate
				.get(Calendar.YEAR)), new Integer(1), null, new Integer(1)));
		DaysSSYearChoose.setBounds(
				DaysSSMonthChoose.getX() + DaysSSMonthChoose.getWidth() + 5,
				DaysSStarLabel.getY(), 70, 20);
		DaysSHere.add(DaysSSYearChoose);

		final JLabel DaysSEndLabel = new JLabel("End:");
		DaysSEndLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		DaysSEndLabel.setBounds(10,
				DaysSStarLabel.getY() + DaysSStarLabel.getHeight() + 5, 55, 20);
		DaysSHere.add(DaysSEndLabel);

		final JSpinner DaysSEDayChoose = new JSpinner();
		DaysSEDayChoose.setModel(new SpinnerNumberModel(CurDate
				.get(Calendar.DAY_OF_MONTH), 1, 31, 1));
		DaysSEDayChoose.setBounds(
				DaysSStarLabel.getX() + DaysSStarLabel.getWidth() + 5,
				DaysSEndLabel.getY(), 40, 20);
		DaysSHere.add(DaysSEDayChoose);

		final JSpinner DaysSEMonthChoose = new JSpinner();
		DaysSEMonthChoose.setModel(new SpinnerNumberModel(CurDate
				.get(Calendar.MONTH), 1, 12, 1));
		DaysSEMonthChoose.setBounds(
				DaysSEDayChoose.getX() + DaysSEDayChoose.getWidth() + 5,
				DaysSEndLabel.getY(), 40, 20);
		DaysSHere.add(DaysSEMonthChoose);

		final JSpinner DaysSEYearChoose = new JSpinner();
		DaysSEYearChoose.setModel(new SpinnerNumberModel(new Integer(CurDate
				.get(Calendar.YEAR)), new Integer(1), null, new Integer(1)));
		DaysSEYearChoose.setBounds(
				DaysSEMonthChoose.getX() + DaysSEMonthChoose.getWidth() + 5,
				DaysSEndLabel.getY(), 70, 20);
		DaysSHere.add(DaysSEYearChoose);

		final JButton DaysSBtn = new JButton("Calculate"); // en - "Calculate"
															// pl - "Oblicz"
		DaysSBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateToStringConverter Dtsc = new DateToStringConverter(
						(String) PointsSComboBox.getSelectedItem(),
						(int) DaysSSDayChoose.getValue(),
						(int) DaysSSMonthChoose.getValue(),
						(int) DaysSSYearChoose.getValue(),
						(int) DaysSEDayChoose.getValue(),
						(int) DaysSEMonthChoose.getValue(),
						(int) DaysSEYearChoose.getValue());
				// System.out.println((String)PointsSComboBox.getSelectedItem());
				ArrayList<String> res = new ArrayList<String>();
				res = Dtsc.getResult();
				ListIterator<String> Iter = res.listIterator();
				ToTable.WriteResults(Iter, false);
			}
		});
		DaysSBtn.setBounds(10, DaysSEndLabel.getY() + DaysSEndLabel.getHeight()
				+ 5, 90, 25);
		DaysSHere.add(DaysSBtn);

		final JScrollPane DaysSScroll = new JScrollPane();
		DaysSScroll.setBounds(10, 120, 690, 125);
		DaysSHere.add(DaysSScroll);

		DaysSTable = new JTable(new DefaultTableModel(new Object[] { " " }, 0));
		DaysSScroll.setViewportView(DaysSTable);

		final JLabel jLabel1 = new JLabel("empty");
		final JLabel jLabel2 = new JLabel("empty");
		LanguageEnglishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				english = true;
				LanguageEnglishBtn.setText("V English");
				LanguagePolskiBtn.setText("Polski");
				mnLanguage.setText("Language");
				AboutBtn.setText("About");
				BirthdayLabel.setText("Birthday:");
				jLabel1.setText("Find points in day");
				tabbedPane.setTabComponentAt(0, jLabel1);
				PointsSDayLabel.setText("Day:");
				PointsSMonthLabel.setText("Month:");
				PointsSYearLabel.setText("Year:");
				PointsSBtn.setText("Calculate");
				jLabel2.setText("Find days with point");
				tabbedPane.setTabComponentAt(1, jLabel2);
				DaysSPointLabel.setText("Point:");
				DaysSStarLabel.setText("Start:");
				DaysSEndLabel.setText("End:");
				DaysSBtn.setText("Calculate");
			}
		});

		LanguagePolskiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				english = false;
				LanguageEnglishBtn.setText("English");
				LanguagePolskiBtn.setText("V Polski");
				mnLanguage.setText("Język");
				AboutBtn.setText("O programie");
				BirthdayLabel.setText("Urodziny:");
				jLabel1.setText("Punkty w dniu");
				tabbedPane.setTabComponentAt(0, jLabel1);
				PointsSDayLabel.setText("Dzień:");
				PointsSMonthLabel.setText("Miesiąc:");
				PointsSYearLabel.setText("Rok:");
				PointsSBtn.setText("Oblicz");
				jLabel2.setText("Dni z punktem");
				tabbedPane.setTabComponentAt(1, jLabel2);
				DaysSPointLabel.setText("Punkt:");
				DaysSStarLabel.setText("Początek:");
				DaysSEndLabel.setText("Koniec:");
				DaysSBtn.setText("Oblicz");
			}
		});

		AboutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mess, title;
				if (english) {
					mess = "Authors: Mateusz Dominiak and Oskar Grudziński";
					title = "About";
				} else {
					mess = "Autorzy: Mateusz Dominiak i Oskar Grudziński";
					title = "O programie";
				}
				JOptionPane.showMessageDialog(null, mess, title, 1);// Znaleźć
																	// przeciążenia
			}
		});

		this.getContentPane().addHierarchyBoundsListener(
				new HierarchyBoundsListener() {
					@Override
					public void ancestorMoved(HierarchyEvent e) {
					}

					@Override
					public void ancestorResized(HierarchyEvent e) {
						if (getWidth() < 400) {
							setBounds(getX(), getY(), 400, getHeight());
						} else {
							PictureLogoHere.setBounds(10, 15, getWidth() - 30,
									50);
							BirthdayLabel.setBounds(10, PictureLogoHere.getY()
									+ PictureLogoHere.getHeight() + 10, 55, 16);
							tabbedPane.setBounds(10, DayChoose.getY()
									+ DayChoose.getHeight() + 10,
									getWidth() - 30,
									getHeight() - tabbedPane.getY() - 65);
							PointsSScroll.setBounds(10, PointsSBtn.getY()
									+ PointsSBtn.getHeight() + 10,
									getWidth() - 60,
									tabbedPane.getHeight() - PointsSBtn.getY()
											- PointsSBtn.getHeight() - 50);
							PointsSTable.setBounds(10, PointsSBtn.getY()
									+ PointsSBtn.getHeight() + 10,
									getWidth() - 60,
									tabbedPane.getHeight() - PointsSBtn.getY()
											- PointsSBtn.getHeight() - 50);
							DaysSScroll.setBounds(10, DaysSBtn.getY()
									+ DaysSBtn.getHeight() + 10,
									getWidth() - 60,
									tabbedPane.getHeight() - DaysSBtn.getY()
											- DaysSBtn.getHeight() - 50);
							DaysSTable.setBounds(
									10,
									DaysSBtn.getY() + DaysSBtn.getHeight() + 10,
									getWidth() - 60,
									tabbedPane.getHeight() - DaysSBtn.getY()
											- DaysSBtn.getHeight() - 50);
						}
						if (getHeight() < 400) {
							setBounds(getX(), getY(), getWidth(), 400);
						} else {
							tabbedPane.setBounds(10, DayChoose.getY()
									+ DayChoose.getHeight() + 5,
									getWidth() - 30,
									getHeight() - tabbedPane.getY() - 65);
							PointsSScroll.setBounds(10, PointsSBtn.getY()
									+ PointsSBtn.getHeight() + 10,
									getWidth() - 60,
									tabbedPane.getHeight() - PointsSBtn.getY()
											- PointsSBtn.getHeight() - 50);
							PointsSTable.setBounds(10, PointsSBtn.getY()
									+ PointsSBtn.getHeight() + 5,
									getWidth() - 60,
									tabbedPane.getHeight() - PointsSBtn.getY()
											- PointsSBtn.getHeight() - 50);
							DaysSScroll.setBounds(10, DaysSBtn.getY()
									+ DaysSBtn.getHeight() + 10,
									getWidth() - 60,
									tabbedPane.getHeight() - DaysSBtn.getY()
											- DaysSBtn.getHeight() - 50);
							DaysSTable.setBounds(10,
									DaysSBtn.getY() + DaysSBtn.getHeight() + 5,
									getWidth() - 60,
									tabbedPane.getHeight() - DaysSBtn.getY()
											- DaysSBtn.getHeight() - 50);
						}
					}
				});
	}
}
