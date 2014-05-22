import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AkupunFrame extends JFrame {

	private JPanel contentPane;
	private JTable PointsSTable;
	private JTable DaysSTable;

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
		setTitle("TitleHere v0.0.01a");
		
		Calendar CurDate=Calendar.getInstance();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenu mnLanguage = new JMenu("Language"); //en - "Language"   pl - "Język"
		mnMenu.add(mnLanguage);
		
		JMenuItem LanguageEnglishBtn = new JMenuItem("English");
		mnLanguage.add(LanguageEnglishBtn);
		
		JMenuItem LanguagePolskiBtn = new JMenuItem("Polski");
		mnLanguage.add(LanguagePolskiBtn);
		
		JMenuItem AboutBtn = new JMenuItem("About..."); //en - "About"   pl - "O programie"
		mnMenu.add(AboutBtn);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel PictureLogoHere = new JPanel();
		PictureLogoHere.setBounds(10, 15, getWidth()-30, 50);
		contentPane.add(PictureLogoHere);
		
		final JLabel BirthdayLabel = new JLabel("Birthday:"); //en - "Birthday:"   pl - "Urodziny:"
		BirthdayLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		BirthdayLabel.setBounds(10, PictureLogoHere.getY()+PictureLogoHere.getHeight()+10, 55, 16);
		contentPane.add(BirthdayLabel);
		
		final JSpinner DayChoose = new JSpinner();
		DayChoose.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		DayChoose.setBounds(BirthdayLabel.getX()+BirthdayLabel.getWidth()+10, BirthdayLabel.getY(), 40, 20);
		contentPane.add(DayChoose);
		
		final JSpinner MonthChoose = new JSpinner();
		MonthChoose.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		MonthChoose.setBounds(DayChoose.getX()+DayChoose.getWidth()+10, BirthdayLabel.getY(), 40, 20);
		contentPane.add(MonthChoose);
		
		final JSpinner YearChoose = new JSpinner();
		YearChoose.setModel(new SpinnerNumberModel(new Integer(CurDate.get(Calendar.YEAR)-80), new Integer(1), null, new Integer(1)));
		YearChoose.setBounds(MonthChoose.getX()+MonthChoose.getWidth()+5, BirthdayLabel.getY(), 80, 20);
		contentPane.add(YearChoose);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, DayChoose.getY()+DayChoose.getHeight()+5, 0, 0);
		tabbedPane.setBounds(10, DayChoose.getY()+DayChoose.getHeight()+5, getWidth()-30, getHeight()-tabbedPane.getY()-65);
		contentPane.add(tabbedPane);
		
		final JPanel PointsSHere = new JPanel();
		tabbedPane.addTab("Find points in day", null, PointsSHere, null); //en - "Find points in day"   pl - "Punkty w danym dniu"
		PointsSHere.setLayout(null);
		
		final JLabel PointsSDayLabel = new JLabel("Day:"); //en - "Day:"   pl - "Dzień:"
		PointsSDayLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		PointsSDayLabel.setBounds(10, 20, 30, 20);
		PointsSHere.add(PointsSDayLabel);
		
		final JSpinner PointsSDays = new JSpinner();
		PointsSDays.setModel(new SpinnerNumberModel(CurDate.get(Calendar.DAY_OF_MONTH), 1, 31, 1));
		PointsSDays.setBounds(PointsSDayLabel.getX()+PointsSDayLabel.getWidth()+10, PointsSDayLabel.getY(), 40, 20);
		PointsSHere.add(PointsSDays);
		
		final JLabel PointsSMonthLabel = new JLabel("Month:"); //en - "Month:"   pl - "Miesiąc:"
		PointsSMonthLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		PointsSMonthLabel.setBounds(PointsSDays.getX()+PointsSDays.getWidth()+10, PointsSDayLabel.getY(), 50, 20);
		PointsSHere.add(PointsSMonthLabel);
		
		final JSpinner PointsSMonth = new JSpinner();
		PointsSMonth.setModel(new SpinnerNumberModel(CurDate.get(Calendar.MONTH), 1, 12, 1));
		PointsSMonth.setBounds(PointsSMonthLabel.getX()+PointsSMonthLabel.getWidth()+10, PointsSDayLabel.getY(), 40, 20);
		PointsSHere.add(PointsSMonth);
		
		final JLabel PointsSYearLabel = new JLabel("Year:"); //en - "Year:"   pl - "Rok:"
		PointsSYearLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		PointsSYearLabel.setBounds(PointsSMonth.getX()+PointsSMonth.getWidth()+10, PointsSDayLabel.getY(), 30, 20);
		PointsSHere.add(PointsSYearLabel);
		
		final JSpinner PointsSYear = new JSpinner();
		PointsSYear.setModel(new SpinnerNumberModel(new Integer(CurDate.get(Calendar.YEAR)), new Integer(1), null, new Integer(1)));
		PointsSYear.setBounds(PointsSYearLabel.getX()+PointsSYearLabel.getWidth()+10, PointsSDayLabel.getY(), 80, 20);
		PointsSHere.add(PointsSYear);
		
		final JButton PointsSBtn = new JButton("Calculate"); //en - "Calculate"   pl - "Oblicz"
		PointsSBtn.setBounds(10, PointsSDays.getY()+PointsSDays.getHeight()+5, 90, 25);
		PointsSHere.add(PointsSBtn);
		
		PointsSTable = new JTable();
		PointsSTable.setBounds(10, PointsSBtn.getY()+PointsSBtn.getHeight()+10, getWidth()-60, tabbedPane.getHeight()-PointsSBtn.getY()-PointsSBtn.getHeight()-50);
		PointsSHere.add(PointsSTable);
		
		final JPanel DaysSHere = new JPanel();
		tabbedPane.addTab("Find days with point", null, DaysSHere, null); //en - "Find days with point"   pl - "Dni z punktem"
		DaysSHere.setLayout(null);
		
		final JLabel DaysSPointLabel = new JLabel("Point:"); //en - "Point:"   pl - "Punkt:"
		DaysSPointLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		DaysSPointLabel.setBounds(10, 10, 40, 20);
		DaysSHere.add(DaysSPointLabel);
		
		final JComboBox PointsSComboBox = new JComboBox();
		PointsSComboBox.setBounds(DaysSPointLabel.getX()+DaysSPointLabel.getWidth()+5, DaysSPointLabel.getY(), 90, 20);
		DaysSHere.add(PointsSComboBox);
		
		final JLabel DaysSStarLabel = new JLabel("Start:");
		DaysSStarLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		DaysSStarLabel.setBounds(10, DaysSPointLabel.getY()+DaysSPointLabel.getHeight()+5, 55, 20);
		DaysSHere.add(DaysSStarLabel);
		
		final JSpinner DaysSSDayChoose = new JSpinner();
		DaysSSDayChoose.setModel(new SpinnerNumberModel(CurDate.get(Calendar.DAY_OF_MONTH), 1, 31, 1));
		DaysSSDayChoose.setBounds(DaysSStarLabel.getX()+DaysSStarLabel.getWidth()+5, DaysSStarLabel.getY(), 40, 20);
		DaysSHere.add(DaysSSDayChoose);
		
		final JSpinner DaysSSMonthChoose = new JSpinner();
		DaysSSMonthChoose.setModel(new SpinnerNumberModel(CurDate.get(Calendar.MONTH), 1, 12, 1));
		DaysSSMonthChoose.setBounds(DaysSSDayChoose.getX()+DaysSSDayChoose.getWidth()+5, DaysSStarLabel.getY(), 40, 20);
		DaysSHere.add(DaysSSMonthChoose);
		
		final JSpinner DaysSSYearChoose = new JSpinner();
		DaysSSYearChoose.setModel(new SpinnerNumberModel(new Integer(CurDate.get(Calendar.YEAR)), new Integer(1), null, new Integer(1)));
		DaysSSYearChoose.setBounds(DaysSSMonthChoose.getX()+DaysSSMonthChoose.getWidth()+5, DaysSStarLabel.getY(), 70, 20);
		DaysSHere.add(DaysSSYearChoose);
		
		final JLabel DaysSEndLabel = new JLabel("End:");
		DaysSEndLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		DaysSEndLabel.setBounds(10, DaysSStarLabel.getY()+DaysSStarLabel.getHeight()+5, 55, 20);
		DaysSHere.add(DaysSEndLabel);
		
		final JSpinner DaysSEDayChoose = new JSpinner();
		DaysSEDayChoose.setModel(new SpinnerNumberModel(CurDate.get(Calendar.DAY_OF_MONTH), 1, 31, 1));
		DaysSEDayChoose.setBounds(DaysSStarLabel.getX()+DaysSStarLabel.getWidth()+5, DaysSEndLabel.getY(), 40, 20);
		DaysSHere.add(DaysSEDayChoose);
		
		final JSpinner DaysSEMonthChoose = new JSpinner();
		DaysSEMonthChoose.setModel(new SpinnerNumberModel(CurDate.get(Calendar.MONTH), 1, 12, 1));
		DaysSEMonthChoose.setBounds(DaysSEDayChoose.getX()+DaysSEDayChoose.getWidth()+5, DaysSEndLabel.getY(), 40, 20);
		DaysSHere.add(DaysSEMonthChoose);
		
		final JSpinner DaysSEYearChoose = new JSpinner();
		DaysSEYearChoose.setModel(new SpinnerNumberModel(new Integer(CurDate.get(Calendar.YEAR)), new Integer(1), null, new Integer(1)));
		DaysSEYearChoose.setBounds(DaysSEMonthChoose.getX()+DaysSEMonthChoose.getWidth()+5, DaysSEndLabel.getY(), 70, 20);
		DaysSHere.add(DaysSEYearChoose);
		
		final JButton DaysSBtn = new JButton("Calculate"); //en - "Calculate"  pl - "Oblicz"
		DaysSBtn.setBounds(10, DaysSEndLabel.getY()+DaysSEndLabel.getHeight()+5, 90, 25);
		DaysSHere.add(DaysSBtn);

		DaysSTable = new JTable();
		DaysSTable.setBounds(10, DaysSBtn.getY()+DaysSBtn.getHeight()+10, getWidth()-60, tabbedPane.getHeight()-DaysSBtn.getY()-DaysSBtn.getHeight()-50);
		DaysSHere.add(DaysSTable);

		this.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsListener(){
			@Override
			public void ancestorMoved(HierarchyEvent e) {
			}
			@Override
			public void ancestorResized(HierarchyEvent e) {
				if(getWidth()<400){
					setBounds(getX(), getY(), 400, getHeight());
				}else{
					PictureLogoHere.setBounds(10, 15, getWidth()-30, 50);
					BirthdayLabel.setBounds(10, PictureLogoHere.getY()+PictureLogoHere.getHeight()+10, 55, 16);
					tabbedPane.setBounds(10, DayChoose.getY()+DayChoose.getHeight()+10, getWidth()-30, getHeight()-tabbedPane.getY()-65);
					PointsSTable.setBounds(10, PointsSBtn.getY()+PointsSBtn.getHeight()+10, getWidth()-60, tabbedPane.getHeight()-PointsSBtn.getY()-PointsSBtn.getHeight()-50);
					DaysSTable.setBounds(10, DaysSBtn.getY()+DaysSBtn.getHeight()+10, getWidth()-60, tabbedPane.getHeight()-DaysSBtn.getY()-DaysSBtn.getHeight()-50);
				}
				if(getHeight()<400){
					setBounds(getX(), getY(), getWidth(), 400);
				}else{
					tabbedPane.setBounds(10, DayChoose.getY()+DayChoose.getHeight()+5, getWidth()-30, getHeight()-tabbedPane.getY()-65);
					PointsSTable.setBounds(10, PointsSBtn.getY()+PointsSBtn.getHeight()+5, getWidth()-60, tabbedPane.getHeight()-PointsSBtn.getY()-PointsSBtn.getHeight()-50);
					DaysSTable.setBounds(10, DaysSBtn.getY()+DaysSBtn.getHeight()+5, getWidth()-60, tabbedPane.getHeight()-DaysSBtn.getY()-DaysSBtn.getHeight()-50);
				}
			}
		});
	}
}
