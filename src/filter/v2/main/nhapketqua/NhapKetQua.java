package filter.v2.main.nhapketqua;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import filter.v2.common.AAA;
import filter.v2.utils.IO;

@SuppressWarnings("serial")
public class NhapKetQua extends Frame implements ActionListener {

	static boolean fopen = false;

	Label lblMess = new Label();

	TextArea taData = new TextArea();
	// Button help = new Button("HELP");
	Button btnImport = new Button("Import");
	Button btnExit = new Button("Exit");

	Button oPrimitive = new Button("Pri");
	Button oImport = new Button("Imp");

	Button btnAddDate = new Button("+");
	Button btnSubDate = new Button(" -");

	Button btnAddMonth = new Button("+");
	Button btnSubMonth = new Button(" -");

	Button btnAddYear = new Button("+");
	Button btnSubYear = new Button(" -");

	static TextField tfDay = new TextField("");
	static TextField tfMonth = new TextField("");
	static TextField tfYear = new TextField("");

	Panel impanel = new Panel();
	Panel filterPanel = new Panel();
	Panel btnPanel = new Panel();

	public static String impDay = "";
	public static String impMonth = "";
	public static String impYear = "";
	public static String strImport = "";

	public static void main(String[] args) {
		callImport(null);
	}

	public NhapKetQua(String title, String message) {
		super(title);

		this.btnAddDate.setBackground(Color.ORANGE);
		this.btnAddMonth.setBackground(Color.ORANGE);
		this.btnSubDate.setBackground(Color.ORANGE);
		this.btnSubMonth.setBackground(Color.ORANGE);
		this.btnAddYear.setBackground(Color.ORANGE);
		this.btnSubYear.setBackground(Color.ORANGE);

		this.lblMess.setForeground(Color.BLUE);
		this.lblMess.setText(message);

		setBackground(Color.lightGray);
		this.btnExit.setBackground(Color.RED);
		this.btnExit.setForeground(Color.WHITE);
		this.btnImport.setBackground(Color.GREEN);

		this.taData.setBackground(Color.LIGHT_GRAY);

		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		AAA.applyPath(AAA.toWords(month), AAA.toWords(year));

		StringBuilder sb = new StringBuilder();
		ArrayList<String> data = IO.read(AAA.IMPORT_PATH + "data");
		for (String s : data) {
			sb.append(s).append("\n");
		}
		this.taData.setText(sb.toString());

		if (tfDay.getText().trim().equals("")) {
			ArrayList<String> existday = IO.read(AAA.PRIMITIVE_PATH + "exist");
			if (existday.size() == 0) {
				tfDay.setText("1");
			} else {
				String lastday = (String) existday.get(existday.size() - 1);
				lastday = String.valueOf(Integer.parseInt(lastday) + 1);
				tfDay.setText(lastday);
			}
		}
		this.filterPanel.setLayout(new GridLayout(2, 1, 1, 1));

		if (tfMonth.getText().trim().equals("")) {
			tfMonth.setText(AAA.toWords(month));
		}

		if (tfYear.getText().trim().equals("")) {
			tfYear.setText(String.valueOf(year));
		}

		Panel daypal = new Panel(new FlowLayout());
		daypal.add(new Label("Day"));
		daypal.add(tfDay);
		daypal.add(this.btnAddDate);
		daypal.add(this.btnSubDate);

		Panel monthpal = new Panel(new FlowLayout());
		monthpal.add(new Label("Month"));
		monthpal.add(tfMonth);
		monthpal.add(this.btnAddMonth);
		monthpal.add(this.btnSubMonth);

		Panel yearpal = new Panel(new FlowLayout());
		yearpal.add(new Label("Year"));
		yearpal.add(tfYear);
		yearpal.add(this.btnAddYear);
		yearpal.add(this.btnSubYear);

		Panel datetimepal = new Panel();
		datetimepal.setLayout(new GridLayout(3, 1));
		datetimepal.add(daypal);
		datetimepal.add(monthpal);
		datetimepal.add(yearpal);

		this.impanel.setLayout(new FlowLayout());
		this.impanel.add(datetimepal);
		// this.impanel.add(this.btnImport);

		Panel openfolderpanel = new Panel(new FlowLayout());
		openfolderpanel.add(this.oPrimitive);
		openfolderpanel.add(this.oImport);

		this.btnPanel.setLayout(new GridLayout(4, 1, 1, 1));
		this.btnPanel.add(this.impanel);
		// this.btnPanel.add(openfolderpanel);
		// this.btnPanel.add(this.help);
		btnPanel.add(new Label());
		btnPanel.add(btnImport);
		this.btnPanel.add(new Label());

		setLayout(new BorderLayout());
		add(this.lblMess, "North");
		add(new Label(""), "West");
		add(this.taData, "Center");
		add(this.btnPanel, "East");
		add(this.btnExit, "South");

		this.btnImport.addActionListener(this);

		this.btnExit.addActionListener(this);
		this.btnImport.addKeyListener(new MyKeyListener());

		this.btnExit.addKeyListener(new MyKeyListener());

		this.btnAddDate.addActionListener(this);
		this.btnAddMonth.addActionListener(this);
		this.btnSubDate.addActionListener(this);
		this.btnAddYear.addActionListener(this);
		this.btnSubYear.addActionListener(this);
		this.btnSubMonth.addActionListener(this);
		this.oImport.addActionListener(this);
		this.oPrimitive.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				NhapKetQua.fopen = false;
				NhapKetQua.this.dispose();
			}
		});
		setLocation(300, 50);
		setSize(470, 500);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnImport) {
			impDay = tfDay.getText();
			impMonth = tfMonth.getText();
			impYear = tfYear.getText();

			strImport = this.taData.getText();

			fopen = false;
			dispose();
			ConfirmImport.callConfirmImport();
		} else if (e.getSource() == this.oImport) {
			Desktop d = Desktop.getDesktop();
			impMonth = tfMonth.getText();
			impYear = tfYear.getText();
			AAA.applyPath(impMonth, impYear);
			try {
				final ArrayList<String> arrr = IO
						.read("./setting/filter.v2.kk");
				final String dataPath = (String) arrr.get(0);
				d.open(new File(dataPath + impYear + "\\" + impMonth
						+ "\\Import"));
			} catch (IOException e1) {
				this.lblMess.setForeground(Color.red);
				this.lblMess.setText("File does not exist.");
			}
		} else if (e.getSource() == this.oPrimitive) {
			Desktop d = Desktop.getDesktop();
			impMonth = tfMonth.getText();
			impYear = tfYear.getText();
			AAA.applyPath(impMonth, impYear);
			try {
				final ArrayList<String> arrr = IO
						.read("./setting/filter.v2.kk");
				final String dataPath = (String) arrr.get(0);
				d.open(new File(dataPath + impYear + "\\" + impMonth
						+ "\\Primitive"));
			} catch (IOException e1) {
				this.lblMess.setForeground(Color.red);
				this.lblMess.setText("File does not exist.");
			}
		} else if (e.getSource() == this.btnExit) {
			fopen = false;
			dispose();
		} else if (e.getSource() == this.btnAddDate) {
			int index = Integer.parseInt(tfDay.getText()) + 1;
			if (index < 100)
				tfDay.setText(String.valueOf(index));
		} else if (e.getSource() == this.btnSubDate) {
			int index = Integer.parseInt(tfDay.getText()) + -1;
			if (index > 0)
				tfDay.setText(String.valueOf(index));
		} else if (e.getSource() == this.btnSubYear) {
			int index = Integer.parseInt(tfYear.getText()) + -1;
			if (index > 0)
				tfYear.setText(String.valueOf(index));
		} else if (e.getSource() == this.btnAddMonth) {
			int index = Integer.parseInt(tfMonth.getText()) + 1;
			if (index < 13)
				tfMonth.setText(AAA.toWords(index));
		} else if (e.getSource() == this.btnAddYear) {
			int index = Integer.parseInt(tfYear.getText()) + 1;
			if (index <= Calendar.getInstance().get(Calendar.YEAR))
				tfYear.setText(AAA.toWords(index));
		} else if (e.getSource() == this.btnSubMonth) {
			int index = Integer.parseInt(tfMonth.getText()) - 1;
			if (index > 0)
				tfMonth.setText(AAA.toWords(index));
		}
	}

	public static void callImport(String message) {
		if (!fopen) {
			if ((message == null) || (message.equals(""))) {
				NhapKetQua importMain = new NhapKetQua("Import Data", "");
				importMain.setVisible(true);
			} else {
				NhapKetQua importMain = new NhapKetQua("Import Data", message);
				importMain.setVisible(true);
			}
		}
		fopen = true;
	}

	public static ArrayList<String> doTokenizer(String s, String delim) {
		ArrayList<String> arr = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(s, delim);
		while (token.hasMoreTokens()) {
			arr.add(token.nextToken());
		}
		return arr;
	}

	public static String doConcat(ArrayList<String> arr) {
		String s = "";
		for (String ss : arr) {
			s = s.concat(ss);
		}
		return s;
	}

	public class MyKeyListener extends KeyAdapter {
		public MyKeyListener() {
		}

		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			if (key == 27)
				NhapKetQua.this.dispose();
		}
	}

}
