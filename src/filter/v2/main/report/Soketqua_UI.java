package filter.v2.main.report;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;

import filter.v2.common.AAA;
import filter.v2.utils.IO;

public class Soketqua_UI extends Frame implements ActionListener {
	private static final String TITLE = "Sổ kết quả @kus.kit";
	private static final long serialVersionUID = 1L;
	Choice choiceYear = new Choice();

	TextField tfDay = new TextField();
	TextField tfMonth = new TextField();

	Button btnAddDate = new Button("+");
	Button btnSubDate = new Button(" -");

	Button btnAddMonth = new Button("+");
	Button btnSubMonth = new Button(" -");
	Button bRun = new Button("View");
	Button bExit = new Button("Exit");

	static Panel pp = new Panel();
	static String smonth = "";
	static String sdate = "";
	static String syear = "";
	static boolean fopen = false;

	public static void main(String[] args) {
		Soketqua_UI m = new Soketqua_UI(TITLE);
		m.setVisible(true);
	}

	public Soketqua_UI(String title) {
		super(title);

		Calendar calendar = Calendar.getInstance();
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);

		this.bExit.setBackground(Color.RED);
		this.bExit.setForeground(Color.WHITE);
		this.bRun.setBackground(Color.GREEN);
		this.btnAddDate.setBackground(Color.ORANGE);
		this.btnAddMonth.setBackground(Color.ORANGE);
		this.btnSubDate.setBackground(Color.ORANGE);
		this.btnSubMonth.setBackground(Color.ORANGE);

		createChoice(calendar.get(Calendar.YEAR));
		if (!smonth.equals(""))
			this.tfMonth.setText(smonth);
		else {
			this.tfMonth
					.setText(String.valueOf(calendar.get(Calendar.MONTH) + 1));
		}
		if (!sdate.equals("")) {
			this.tfDay.setText(sdate);
		} else if (hour >= 20)
			this.tfDay.setText(String.valueOf(date));
		else {
			this.tfDay.setText(String.valueOf(date - 1));
		}

		if (!syear.equals("")) {
			this.choiceYear.select(syear);
		}

		Panel p1 = new Panel();
		p1.setLayout(new FlowLayout());
		p1.add(this.tfDay);
		p1.add(this.btnAddDate);
		p1.add(this.btnSubDate);

		Panel p2 = new Panel();
		p2.setLayout(new FlowLayout());
		p2.add(this.tfMonth);
		p2.add(this.btnAddMonth);
		p2.add(this.btnSubMonth);

		Panel p3 = new Panel();
		p3.setLayout(new FlowLayout());
		p3.add(this.choiceYear);
		p3.add(p2);
		p3.add(p1);
		p3.add(this.bRun);
		p3.add(new Label("                          "));

		setLayout(new BorderLayout());
		add(p3, "North");
		add(this.bExit, "South");
		add(new Label(), "East");
		add(new Label(), "West");
		add(pp, "Center");
		setBackground(Color.lightGray);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Soketqua_UI.fopen = false;
				Soketqua_UI.this.dispose();
			}
		});
		this.btnAddDate.addActionListener(this);
		this.btnAddMonth.addActionListener(this);
		this.btnSubDate.addActionListener(this);
		this.btnSubMonth.addActionListener(this);
		this.bRun.addActionListener(this);
		this.bExit.addActionListener(this);

		setSize(550, 350);
		setLocation(300, 50);
	}

	private void createChoice(int year) {
		this.choiceYear = new Choice();
		for (int i = year; i >= 2009; i--) {
			this.choiceYear.add(String.valueOf(i));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnAddDate) {
			int index = Integer.parseInt(this.tfDay.getText()) + 1;
			if (index < 100)
				this.tfDay.setText(String.valueOf(index));
		} else if (e.getSource() == this.btnSubDate) {
			int index = Integer.parseInt(this.tfDay.getText()) - 1;
			if (index > 0)
				this.tfDay.setText(String.valueOf(index));
		} else if (e.getSource() == this.btnAddMonth) {
			int index = Integer.parseInt(this.tfMonth.getText()) + 1;
			if (index < 13)
				this.tfMonth.setText(String.valueOf(index));
		} else if (e.getSource() == this.btnSubMonth) {
			int index = Integer.parseInt(this.tfMonth.getText()) - 1;
			if (index > 0)
				this.tfMonth.setText(String.valueOf(index));
		} else if (e.getSource() == this.bExit) {
			fopen = false;
			dispose();
		} else if (e.getSource() == this.bRun) {
			String day = this.tfDay.getText();
			String month = AAA
					.toWords(Integer.parseInt(this.tfMonth.getText()));
			String year = this.choiceYear.getSelectedItem();

			AAA.applyPath(month, year);

			smonth = month;
			sdate = day;
			syear = year;
			pp = ketqua(Integer.parseInt(day) - 1, month, year);
			int x = getX();
			int y = getY();
			dispose();
			fopen = false;
			callMain(day + "/" + month + "/" + year, x, y);
		}
	}

	public static void callMain(String s) {
		if (!fopen) {
			Soketqua_UI m = new Soketqua_UI(s);
			m.setVisible(true);
		}
		fopen = true;
	}

	public static void callMain(String s, int x, int y) {
		if (!fopen) {
			Soketqua_UI m = new Soketqua_UI(s);
			m.setLocation(x, y);
			m.setVisible(true);
		}
		fopen = true;
	}

	public Panel ketqua(int day, String month, String year) {
		Panel p1 = new Panel();

		ArrayList<String> arr = getketqua(day, month, year);

		ArrayList<String> thu = IO.read(AAA.IMPORT_PATH + "thu" + month + year);
		String sThu = (String) thu.get(day);
		if (sThu.equals("1")) {
			sThu = "CN";
		}
		StringBuilder sb = new StringBuilder();
		if (!sThu.equals("CN"))
			sb.append("                     ----- KQXS thu " + sThu + " ngay "
					+ (day + 1) + "/" + month + "/" + year + " -----");
		else {
			sb.append("                     ----- KQXS CN ngay " + (day + 1)
					+ "/" + month + "/" + year + " -----");
		}
		sb.append("\n");
		sb.append("\n");

		sb.append("\t").append("\t").append("\t");
		sb.append((String) arr.get(0)).append("\t");
		sb.append("\t").append("\t").append("\t");
		sb.append("\n");

		sb.append("\t").append("\t").append("\t");
		sb.append((String) arr.get(1)).append("\t");
		sb.append("\t").append("\t").append("\t");
		sb.append("\n");

		sb.append("\t").append("\t");
		sb.append((String) arr.get(2)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(3)).append("\t");
		sb.append("\t").append("\t");
		sb.append("\n");

		sb.append("\t");
		sb.append((String) arr.get(4)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(5)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(6)).append("\t");
		sb.append("\t");
		sb.append("\n");
		sb.append("\t");
		sb.append((String) arr.get(7)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(8)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(9)).append("\t");
		sb.append("\t");
		sb.append("\n");

		sb.append("\t").append("\t");
		sb.append((String) arr.get(10)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(11)).append("\t");
		sb.append("\t").append("\t");
		sb.append("\n");
		sb.append("\t").append("\t");
		sb.append((String) arr.get(12)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(13)).append("\t");
		sb.append("\t").append("\t");
		sb.append("\n");

		sb.append("\t");
		sb.append((String) arr.get(14)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(15)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(16)).append("\t");
		sb.append("\t");
		sb.append("\n");
		sb.append("\t");
		sb.append((String) arr.get(17)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(18)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(19)).append("\t");
		sb.append("\t");
		sb.append("\n");

		sb.append("\t");
		sb.append((String) arr.get(20)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(21)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(22)).append("\t");
		sb.append("\t");
		sb.append("\n");

		sb.append((String) arr.get(23)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(24)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(25)).append("\t");
		sb.append("\t");
		sb.append((String) arr.get(26)).append("\t");
		sb.append("\t");

		TextArea ta = new TextArea();
		ta.setForeground(Color.WHITE);
		ta.setBackground(Color.BLACK);
		ta.setText(sb.toString());

		p1.setLayout(new BorderLayout());
		p1.add(ta, "Center");

		Panel p2 = new Panel();
		arr = IO.read(AAA.PRIMITIVE_PATH + "v" + AAA.toWords(day + 1));

		String s0 = "  0 :    ";
		String s1 = "  1 :    ";
		String s2 = "  2 :    ";
		String s3 = "  3 :    ";
		String s4 = "  4 :    ";
		String s5 = "  5 :    ";
		String s6 = "  6 :    ";
		String s7 = "  7 :    ";
		String s8 = "  8 :    ";
		String s9 = "  9 :    ";

		for (String s : arr) {
			String ss = s.substring(0, 1);
			String ss2 = s.substring(1, 2);
			if (ss.equals("0"))
				s0 = s0 + ss2 + " ";
			else if (ss.equals("1"))
				s1 = s1 + ss2 + " ";
			else if (ss.equals("2"))
				s2 = s2 + ss2 + " ";
			else if (ss.equals("3"))
				s3 = s3 + ss2 + " ";
			else if (ss.equals("4"))
				s4 = s4 + ss2 + " ";
			else if (ss.equals("5"))
				s5 = s5 + ss2 + " ";
			else if (ss.equals("6"))
				s6 = s6 + ss2 + " ";
			else if (ss.equals("7"))
				s7 = s7 + ss2 + " ";
			else if (ss.equals("8"))
				s8 = s8 + ss2 + " ";
			else if (ss.equals("9")) {
				s9 = s9 + ss2 + " ";
			}
		}

		p2.setLayout(new GridLayout(10, 1, 1, 1));
		p2.add(new Label(s0));
		p2.add(new Label(s1));
		p2.add(new Label(s2));
		p2.add(new Label(s3));
		p2.add(new Label(s4));
		p2.add(new Label(s5));
		p2.add(new Label(s6));
		p2.add(new Label(s7));
		p2.add(new Label(s8));
		p2.add(new Label(s9));

		p2.setBackground(Color.ORANGE);

		p1.add(p2, "East");
		return p1;
	}

	public ArrayList<String> getketqua(int day, String month, String year) {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> temp = IO.read(AAA.IMPORT_PATH + "DBG1_" + month
				+ "_" + year);
		String temps = (String) temp.get(day);
		arr.add(temps.substring(0, 5));
		arr.add(temps.substring(5, 10));

		temp = IO.read(AAA.IMPORT_PATH + "G2_" + month + "_" + year);
		temps = (String) temp.get(day);
		arr.add(temps.substring(0, 5));
		arr.add(temps.substring(7, 12));

		temp = IO.read(AAA.IMPORT_PATH + "G3_" + month + "_" + year);
		temps = (String) temp.get(2 * day);
		arr.add(temps.substring(0, 5));
		arr.add(temps.substring(7, 12));
		arr.add(temps.substring(14, 19));
		temps = (String) temp.get(2 * day + 1);
		arr.add(temps.substring(0, 5));
		arr.add(temps.substring(7, 12));
		arr.add(temps.substring(14, 19));

		temp = IO.read(AAA.IMPORT_PATH + "G4_" + month + "_" + year);
		temps = (String) temp.get(2 * day);
		arr.add(temps.substring(0, 4));
		arr.add(temps.substring(6, 10));
		temps = (String) temp.get(2 * day + 1);
		arr.add(temps.substring(0, 4));
		arr.add(temps.substring(6, 10));

		temp = IO.read(AAA.IMPORT_PATH + "G5_" + month + "_" + year);
		temps = (String) temp.get(2 * day);
		arr.add(temps.substring(0, 4));
		arr.add(temps.substring(6, 10));
		arr.add(temps.substring(12, 16));
		temps = (String) temp.get(2 * day + 1);
		arr.add(temps.substring(0, 4));
		arr.add(temps.substring(6, 10));
		arr.add(temps.substring(12, 16));

		temp = IO.read(AAA.IMPORT_PATH + "G6_" + month + "_" + year);
		temps = (String) temp.get(day);
		arr.add(temps.substring(0, 3));
		arr.add(temps.substring(5, 8));
		arr.add(temps.substring(10, 13));

		temp = IO.read(AAA.IMPORT_PATH + "G7_" + month + "_" + year);
		temps = (String) temp.get(day);
		arr.add(temps.substring(0, 2));
		arr.add(temps.substring(4, 6));
		arr.add(temps.substring(8, 10));
		arr.add(temps.substring(12, 14));

		return arr;
	}

	public class MyKeyListener extends KeyAdapter {
		public MyKeyListener() {
		}

		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			if (key == 27) {
				Soketqua_UI.this.dispose();
				System.exit(0);
			}
		}
	}
}