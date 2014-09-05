package filter.v2.main.x80;

import java.awt.BorderLayout;
import java.awt.Button;
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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import filter.v2.common.AAA;
import filter.v2.common.Target;

@SuppressWarnings("serial")
public class X_80_1_UI extends Frame implements ActionListener {

	private static final String TITLE = "x80 @kus.kit";

	public static void main(String[] args) {
		X_80_1_UI ui = new X_80_1_UI(TITLE);
		ui.setVisible(true);
	}

	public X_80_1_UI(String title) {
		super(title);

		buildUI();
		addListener();

		setSize(600, 710);
		setLocation(300, 50);

		analize();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.brun) {
			analize();
		} else if (e.getSource() == this.btnAddMonth) {
			int index = Integer.parseInt(this.tfMonth.getText()) + 1;
			if (index < 13)
				this.tfMonth.setText(AAA.toWords(index));
			if (selectedGiai != "") {
				tongandcham(selectedGiai, null);
			} else
				analize();
		} else if (e.getSource() == this.btnSubMonth) {
			int index = Integer.parseInt(this.tfMonth.getText()) - 1;
			if (index > 0)
				this.tfMonth.setText(AAA.toWords(index));
			if (selectedGiai != "") {
				tongandcham(selectedGiai, null);
			} else
				analize();
		} else if (e.getSource() == this.btnAddDay) {
			int index = Integer.parseInt(this.tfDay.getText()) + 1;
			if (index < 32)
				this.tfDay.setText(AAA.toWords(index));
			analize();
		} else if (e.getSource() == this.btnSubDay) {
			int index = Integer.parseInt(this.tfDay.getText()) - 1;
			if (index > 0)
				this.tfDay.setText(AAA.toWords(index));
			analize();
		} else if (e.getSource() == this.btnAddYear) {
			int index = Integer.parseInt(this.tfYear.getText()) + 1;
			if (index <= Calendar.getInstance().get(Calendar.YEAR))
				this.tfYear.setText(String.valueOf(index));
			if (selectedGiai != "") {
				tongandcham(selectedGiai, null);
			} else
				analize();
		} else if (e.getSource() == this.btnSubYear) {
			int index = Integer.parseInt(this.tfYear.getText()) - 1;
			if (index > 2008)
				this.tfYear.setText(String.valueOf(index));
			if (selectedGiai != "") {
				tongandcham(selectedGiai, null);
			} else
				analize();
		} else if (e.getSource() == this.bExit) {
			selectedGiai = "";
			dispose();
		} else if (e.getSource() == this.bdb) {
			tongandcham("DB", this.bdb);
		} else if (e.getSource() == this.bg1) {
			tongandcham("G1", this.bg1);
		} else if (e.getSource() == this.bg21) {
			tongandcham("G21", this.bg21);
		} else if (e.getSource() == this.bg22) {
			tongandcham("G22", this.bg22);
		} else if (e.getSource() == this.bg31) {
			tongandcham("G31", this.bg31);
		} else if (e.getSource() == this.bg32) {
			tongandcham("G32", this.bg32);
		} else if (e.getSource() == this.bg33) {
			tongandcham("G33", this.bg33);
		} else if (e.getSource() == this.bg34) {
			tongandcham("G34", this.bg34);
		} else if (e.getSource() == this.bg35) {
			tongandcham("G35", this.bg35);
		} else if (e.getSource() == this.bg36) {
			tongandcham("G36", this.bg36);
		} else if (e.getSource() == this.bg41) {
			tongandcham("G41", this.bg41);
		} else if (e.getSource() == this.bg42) {
			tongandcham("G42", this.bg42);
		} else if (e.getSource() == this.bg43) {
			tongandcham("G43", this.bg43);
		} else if (e.getSource() == this.bg44) {
			tongandcham("G44", this.bg44);
		} else if (e.getSource() == this.bg51) {
			tongandcham("G51", this.bg51);
		} else if (e.getSource() == this.bg52) {
			tongandcham("G52", this.bg52);
		} else if (e.getSource() == this.bg53) {
			tongandcham("G53", this.bg53);
		} else if (e.getSource() == this.bg54) {
			tongandcham("G54", this.bg54);
		} else if (e.getSource() == this.bg55) {
			tongandcham("G55", this.bg55);
		} else if (e.getSource() == this.bg56) {
			tongandcham("G56", this.bg56);
		} else if (e.getSource() == this.bg61) {
			tongandcham("G61", this.bg61);
		} else if (e.getSource() == this.bg62) {
			tongandcham("G62", this.bg62);
		} else if (e.getSource() == this.bg63) {
			tongandcham("G63", this.bg63);
		} else if (e.getSource() == this.bg71) {
			tongandcham("G71", this.bg71);
		} else if (e.getSource() == this.bg72) {
			tongandcham("G72", this.bg72);
		} else if (e.getSource() == this.bg73) {
			tongandcham("G73", this.bg73);
		} else if (e.getSource() == this.bg74) {
			tongandcham("G74", this.bg74);
		}
	}

	private void resetAllBtn() {
		this.bExit.setBackground(Color.RED);
		this.bExit.setForeground(Color.WHITE);
		this.bStatus.setBackground(null);
		this.bdb.setBackground(Color.GRAY);
		this.bdb.setForeground(Color.WHITE);
		this.bg1.setBackground(Color.GRAY);
		this.bg1.setForeground(Color.WHITE);
		this.bg21.setBackground(Color.GRAY);
		this.bg21.setForeground(Color.WHITE);
		this.bg22.setBackground(Color.GRAY);
		this.bg22.setForeground(Color.WHITE);
		this.bg31.setBackground(Color.GRAY);
		this.bg31.setForeground(Color.WHITE);
		this.bg32.setBackground(Color.GRAY);
		this.bg32.setForeground(Color.WHITE);
		this.bg33.setBackground(Color.GRAY);
		this.bg33.setForeground(Color.WHITE);
		this.bg34.setBackground(Color.GRAY);
		this.bg34.setForeground(Color.WHITE);
		this.bg35.setBackground(Color.GRAY);
		this.bg35.setForeground(Color.WHITE);
		this.bg36.setBackground(Color.GRAY);
		this.bg36.setForeground(Color.WHITE);
		this.bg41.setBackground(Color.GRAY);
		this.bg41.setForeground(Color.WHITE);
		this.bg42.setBackground(Color.GRAY);
		this.bg42.setForeground(Color.WHITE);
		this.bg43.setBackground(Color.GRAY);
		this.bg43.setForeground(Color.WHITE);
		this.bg44.setBackground(Color.GRAY);
		this.bg44.setForeground(Color.WHITE);
		this.bg51.setBackground(Color.GRAY);
		this.bg51.setForeground(Color.WHITE);
		this.bg52.setBackground(Color.GRAY);
		this.bg52.setForeground(Color.WHITE);
		this.bg53.setBackground(Color.GRAY);
		this.bg53.setForeground(Color.WHITE);
		this.bg54.setBackground(Color.GRAY);
		this.bg54.setForeground(Color.WHITE);
		this.bg55.setBackground(Color.GRAY);
		this.bg55.setForeground(Color.WHITE);
		this.bg56.setBackground(Color.GRAY);
		this.bg56.setForeground(Color.WHITE);
		this.bg61.setBackground(Color.GRAY);
		this.bg61.setForeground(Color.WHITE);
		this.bg62.setBackground(Color.GRAY);
		this.bg62.setForeground(Color.WHITE);
		this.bg63.setBackground(Color.GRAY);
		this.bg63.setForeground(Color.WHITE);
		this.bg71.setBackground(Color.GRAY);
		this.bg71.setForeground(Color.WHITE);
		this.bg72.setBackground(Color.GRAY);
		this.bg72.setForeground(Color.WHITE);
		this.bg73.setBackground(Color.GRAY);
		this.bg73.setForeground(Color.WHITE);
		this.bg74.setBackground(Color.GRAY);
		this.bg74.setForeground(Color.WHITE);

		this.brun.setBackground(Color.DARK_GRAY);
		this.brun.setForeground(Color.white);
	}

	public class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			if (key == KeyEvent.VK_ESCAPE) {
				dispose();
			}
		}
	}

	private void analize() {
		resetAllBtn();
		selectedGiai = "";
		if (!clicked) {
			this.brun.setBackground(Color.BLUE);
			clicked = true;
		} else {
			this.brun.setBackground(Color.DARK_GRAY);
			clicked = false;
		}

		StringBuilder sb = new StringBuilder();

		try {
			int date = AAA.sToI(tfDay.getText());
			String month = tfMonth.getText();
			String year = tfYear.getText();

			// Lay dc position pos1 tu ngay bat dau
			ArrayList<String> o_arr = AAA.getListKetqua(date, month, year);
			String db1 = target.getTarget("DB", date + 1, month, year);
			ArrayList<Integer> pos1 = getPos(o_arr, db1);

			ArrayList<String> arr2 = AAA.getListKetqua(date + 1, month, year);

			sb.append("\n\t: ");
			for (int i = 0; i < pos1.size(); i++) {
				if ((i > 0) && (i % 12 == 0)) {
					sb.append("\n\t: ");
				}
				sb.append(arr2.get(pos1.get(i)) + "     ");
			}
			sb.append("\n\n\t");

			ArrayList<Integer> sizeelement = getSizeEachElement(arr2, pos1);
			for (int i = 0; i < 10; i++) {
				sb.append(i + ":" + sizeelement.get(i) + "     ");
			}
			sb.append("\n");
			sb.append("\n" + (date + 2) + "\t");

			ArrayList<String> arr3 = getNextNumber(arr2, pos1);

			for (int i = 0; i < arr3.size(); i++) {
				String s = arr3.get(i);
				if ((i > 0)
						&& (!s.substring(0, 1).equals(
								arr3.get(i - 1).substring(0, 1)))) {
					sb.append("\n\t");
				}
				sb.append(s + "     ");
			}
			sb.append("\n\n\t:size:" + arr3.size() + "\t\t");
			String db2 = target.getTarget("DB", date + 2, month, year);
			sb.append("DB:" + db2 + "\t\t" + isNumberReturn(db2, arr3));
			sb.append("\n\n\t: ");

			if (isNumberReturn(db2, arr3)) {
				bStatus.setBackground(Color.green);
				area.setBackground(Color.green);
				Thread.sleep(150);
				area.setBackground(Color.black);
				ArrayList<Integer> pos2 = getNextPos(arr2, pos1, db2);

				ArrayList<String> arr4 = AAA.getListKetqua(date + 2, month,
						year);
				for (Integer i : pos2) {
					sb.append(arr4.get(i) + "      ");
				}
				sb.append("\n");
				sb.append("\n" + (date + 3) + "\t");

				ArrayList<String> arr5 = getNextNumber(arr4, pos2);
				for (int i = 0; i < arr5.size(); i++) {
					String s = arr5.get(i);
					if ((i > 0)
							&& (!s.substring(0, 1).equals(
									arr5.get(i - 1).substring(0, 1)))) {
						sb.append("\n\t");
					}
					sb.append(s + "     ");
				}
				sb.append("\n\n\tsize:" + arr5.size());

				String db3 = target.getTarget("DB", date + 3, month, year);
				sb.append("\t\tDB:" + db3 + "\t\t" + isNumberReturn(db3, arr5)
						+ "\n");
			} else {
				bStatus.setBackground(Color.red);
				area.setBackground(Color.red);
				Thread.sleep(150);
				area.setBackground(Color.black);
			}
		} catch (Exception e) {
		}

		area.setText(sb.toString());
	}

	private void buildUI() {
		resetAllBtn();

		Calendar calendar = Calendar.getInstance();

		this.tfDay.setText(AAA.toWords(calendar.get(Calendar.DATE) - 2));
		this.tfMonth.setText(AAA.toWords(calendar.get(Calendar.MONTH) + 1));
		this.tfYear.setText(AAA.toWords(calendar.get(Calendar.YEAR)));

		Panel p1 = new Panel(new FlowLayout());
		p1.add(new Label("Day"));
		p1.add(tfDay);
		p1.add(btnAddDay);
		p1.add(btnSubDay);

		Panel p2 = new Panel(new FlowLayout());
		p2.add(new Label("Month"));
		p2.add(tfMonth);
		p2.add(btnAddMonth);
		p2.add(btnSubMonth);

		Panel p3 = new Panel(new FlowLayout());
		p3.add(new Label("Year"));
		p3.add(tfYear);
		p3.add(btnAddYear);
		p3.add(btnSubYear);

		Panel p4 = new Panel(new FlowLayout());
		p4.add(bStatus);
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		p4.add(brun);

		Panel p5 = new Panel(new GridLayout(3, 9));
		p5.add(bdb);
		p5.add(bg1);
		p5.add(bg21);
		p5.add(bg22);
		p5.add(bg31);
		p5.add(bg32);
		p5.add(bg33);
		p5.add(bg34);
		p5.add(bg35);
		p5.add(bg36);
		p5.add(bg41);
		p5.add(bg42);
		p5.add(bg43);
		p5.add(bg44);
		p5.add(bg51);
		p5.add(bg52);
		p5.add(bg53);
		p5.add(bg54);
		p5.add(bg55);
		p5.add(bg56);
		p5.add(bg61);
		p5.add(bg62);
		p5.add(bg63);
		p5.add(bg71);
		p5.add(bg72);
		p5.add(bg73);
		p5.add(bg74);

		Panel p6 = new Panel(new GridLayout(2, 1));
		p6.add(p4);
		p6.add(p5);

		area.setBackground(Color.black);
		area.setForeground(Color.white);

		setLayout(new BorderLayout());
		add(p6, "North");
		add(area, "Center");
		add(bExit, "South");
		add(new Label(), "East");
		add(new Label(), "West");
		setBackground(Color.lightGray);
	}

	public TextArea area = new TextArea();
	public Button bExit = new Button("Exit");
	public Button bStatus = new Button("     ");

	public TextField tfYear = new TextField();
	public TextField tfMonth = new TextField();
	public TextField tfDay = new TextField();

	Button btnAddYear = new Button("+");
	Button btnSubYear = new Button(" -");
	Button btnAddMonth = new Button("+");
	Button btnSubMonth = new Button(" -");
	Button btnAddDay = new Button("+");
	Button btnSubDay = new Button(" -");

	Button brun = new Button("Run");

	private static boolean clicked = false;

	Target target = new Target();

	private void addListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		this.btnAddYear.addActionListener(this);
		this.btnAddMonth.addActionListener(this);
		this.btnSubYear.addActionListener(this);
		this.btnSubMonth.addActionListener(this);
		this.btnAddDay.addActionListener(this);
		this.btnSubDay.addActionListener(this);
		this.brun.addActionListener(this);
		this.bdb.addActionListener(this);
		this.bg1.addActionListener(this);
		this.bg21.addActionListener(this);
		this.bg22.addActionListener(this);
		this.bg31.addActionListener(this);
		this.bg32.addActionListener(this);
		this.bg33.addActionListener(this);
		this.bg34.addActionListener(this);
		this.bg35.addActionListener(this);
		this.bg36.addActionListener(this);
		this.bg41.addActionListener(this);
		this.bg42.addActionListener(this);
		this.bg43.addActionListener(this);
		this.bg44.addActionListener(this);
		this.bg51.addActionListener(this);
		this.bg52.addActionListener(this);
		this.bg53.addActionListener(this);
		this.bg54.addActionListener(this);
		this.bg55.addActionListener(this);
		this.bg56.addActionListener(this);
		this.bg61.addActionListener(this);
		this.bg62.addActionListener(this);
		this.bg63.addActionListener(this);
		this.bg71.addActionListener(this);
		this.bg72.addActionListener(this);
		this.bg73.addActionListener(this);
		this.bg74.addActionListener(this);

		this.bExit.addActionListener(this);

		MyKeyListener keyListener = new MyKeyListener();
		this.bdb.addKeyListener(keyListener);
		this.bg1.addKeyListener(keyListener);
		this.bg21.addKeyListener(keyListener);
		this.bg22.addKeyListener(keyListener);
		this.bg31.addKeyListener(keyListener);
		this.bg32.addKeyListener(keyListener);
		this.bg33.addKeyListener(keyListener);
		this.bg34.addKeyListener(keyListener);
		this.bg35.addKeyListener(keyListener);
		this.bg36.addKeyListener(keyListener);
		this.bg41.addKeyListener(keyListener);
		this.bg42.addKeyListener(keyListener);
		this.bg43.addKeyListener(keyListener);
		this.bg44.addKeyListener(keyListener);
		this.bg51.addKeyListener(keyListener);
		this.bg52.addKeyListener(keyListener);
		this.bg53.addKeyListener(keyListener);
		this.bg54.addKeyListener(keyListener);
		this.bg55.addKeyListener(keyListener);
		this.bg56.addKeyListener(keyListener);
		this.bg61.addKeyListener(keyListener);
		this.bg62.addKeyListener(keyListener);
		this.bg63.addKeyListener(keyListener);
		this.bg71.addKeyListener(keyListener);
		this.bg72.addKeyListener(keyListener);
		this.bg73.addKeyListener(keyListener);
		this.bg74.addKeyListener(keyListener);
		this.btnAddDay.addKeyListener(keyListener);
		this.btnAddMonth.addKeyListener(keyListener);
		this.btnAddYear.addKeyListener(keyListener);
		this.btnSubDay.addKeyListener(keyListener);
		this.btnSubMonth.addKeyListener(keyListener);
		this.btnSubYear.addKeyListener(keyListener);
		this.brun.addKeyListener(keyListener);
		this.tfDay.addKeyListener(keyListener);
	}

	private static ArrayList<Integer> getSizeEachElement(ArrayList<String> arr,
			ArrayList<Integer> pos) {
		int i0 = 0;
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		int i5 = 0;
		int i6 = 0;
		int i7 = 0;
		int i8 = 0;
		int i9 = 0;

		for (Integer i : pos) {
			if (arr.get(i).equals("0")) {
				i0++;
			} else if (arr.get(i).equals("1")) {
				i1++;
			} else if (arr.get(i).equals("2")) {
				i2++;
			} else if (arr.get(i).equals("3")) {
				i3++;
			} else if (arr.get(i).equals("4")) {
				i4++;
			} else if (arr.get(i).equals("5")) {
				i5++;
			} else if (arr.get(i).equals("6")) {
				i6++;
			} else if (arr.get(i).equals("7")) {
				i7++;
			} else if (arr.get(i).equals("8")) {
				i8++;
			} else if (arr.get(i).equals("9")) {
				i9++;
			}
		}

		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(i0);
		arr2.add(i1);
		arr2.add(i2);
		arr2.add(i3);
		arr2.add(i4);
		arr2.add(i5);
		arr2.add(i6);
		arr2.add(i7);
		arr2.add(i8);
		arr2.add(i9);

		return arr2;
	}

	private static ArrayList<Integer> getNextPos(ArrayList<String> arr,
			ArrayList<Integer> pos, String db) {
		ArrayList<Integer> newpos = new ArrayList<Integer>();

		for (Integer i : pos) {
			if (db.substring(0, 1).equals(arr.get(i))
					|| db.substring(1, 2).equals(arr.get(i))) {
				newpos.add(i);
			}
		}

		return newpos;
	}

	private static boolean isNumberReturn(String db, ArrayList<String> arr) {
		for (String s : arr) {
			if (s.equals(db)) {
				return true;
			}
		}

		return false;
	}

	private static ArrayList<Integer> getPos(ArrayList<String> arr, String db) {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		if (arr.size() > 0) {
			for (int i = 0; i < arr.size(); i++) {
				if (db.substring(0, 1).equals(arr.get(i))
						|| db.substring(1, 2).equals(arr.get(i))) {
					pos.add(i);
				}
			}
		}

		return pos;
	}

	private static ArrayList<String> getNextNumber(ArrayList<String> arr,
			ArrayList<Integer> pos) {
		Set<String> setNext = new HashSet<String>();

		for (int i = 0; i < pos.size() - 1; i++) {
			String s1 = arr.get(pos.get(i));
			for (int j = i + 1; j < pos.size(); j++) {
				String s2 = arr.get(pos.get(j));
				String ss1 = s1 + s2;
				String ss2 = s2 + s1;
				setNext.add(ss1);
				setNext.add(ss2);
			}
		}

		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> iterator = setNext.iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}

		Collections.sort(list);
		return list;
	}

	public Button bdb = new Button("DB");
	public Button bg1 = new Button("G1");
	public Button bg21 = new Button("G21");
	public Button bg22 = new Button("G22");
	public Button bg31 = new Button("G31");
	public Button bg32 = new Button("G32");
	public Button bg33 = new Button("G33");
	public Button bg34 = new Button("G34");
	public Button bg35 = new Button("G35");
	public Button bg36 = new Button("G36");
	public Button bg41 = new Button("G41");
	public Button bg42 = new Button("G42");
	public Button bg43 = new Button("G43");
	public Button bg44 = new Button("G44");
	public Button bg51 = new Button("G51");
	public Button bg52 = new Button("G52");
	public Button bg53 = new Button("G53");
	public Button bg54 = new Button("G54");
	public Button bg55 = new Button("G55");
	public Button bg56 = new Button("G56");
	public Button bg61 = new Button("G61");
	public Button bg62 = new Button("G62");
	public Button bg63 = new Button("G63");
	public Button bg71 = new Button("G71");
	public Button bg72 = new Button("G72");
	public Button bg73 = new Button("G73");
	public Button bg74 = new Button("G74");

	private static String selectedGiai = "";
	private TongHnayChamHsau_Prc prc = new TongHnayChamHsau_Prc();

	private void tongandcham(String giai, Button d) {
		if (d != null) {
			resetAllBtn();
			d.setBackground(Color.BLUE);
		}

		try {
			area.setBackground(Color.gray);
			Thread.sleep(50);
			area.setBackground(Color.black);
		} catch (Exception e) {
		}
		area.setText(prc.x_run(giai, tfMonth.getText(), tfYear.getText()));
		selectedGiai = giai;
	}
}
