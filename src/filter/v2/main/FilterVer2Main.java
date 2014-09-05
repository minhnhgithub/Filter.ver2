package filter.v2.main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import filter.v2.main.dumbhead.DumbHeadGUI;
import filter.v2.main.loroi.Loroi_UI;
import filter.v2.main.nhapketqua.NhapKetQua;
import filter.v2.main.report.Soketqua_UI;
import filter.v2.main.report.Tanso_UI;
import filter.v2.main.x80.X_80_1_UI;

@SuppressWarnings("serial")
public class FilterVer2Main extends Frame implements ActionListener {
	private static final String TITLE = "@Create by kus.kit";
	Button btnNhapKetQua = new Button("    Import    ");
	Button btnLoroi = new Button("Drop / Sum");
	Button btnTanso = new Button("Report");
	Button btnSoketqua = new Button("    View    ");
	Button btnDumbHead = new Button("Dumb Head Report");

	Button btnx80 = new Button("x80");

	Button btnExit = new Button("Exit");

	public static void main(String[] args) {
		FilterVer2Main ui = new FilterVer2Main(TITLE);
		ui.setVisible(true);
	}

	public FilterVer2Main(String title) {
		super(title);

		resetColorBtns();
		buildUI();
		addListener();

		setSize(200, 360);
		setLocation(100, 50);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnExit) {
			dispose();
			System.exit(0);
		} else if (e.getSource() == this.btnNhapKetQua) {
			NhapKetQua.main(null);
			resetColorBtns();
			this.btnNhapKetQua.setBackground(Color.green);
			this.btnNhapKetQua.setForeground(Color.black);
		} else if (e.getSource() == this.btnLoroi) {
			Loroi_UI.main(null);
			resetColorBtns();
			this.btnLoroi.setBackground(Color.MAGENTA);
			this.btnLoroi.setForeground(Color.black);
		} else if (e.getSource() == this.btnTanso) {
			Tanso_UI.main(null);
			resetColorBtns();
			this.btnTanso.setBackground(Color.magenta);
			this.btnTanso.setForeground(Color.black);
		} else if (e.getSource() == this.btnSoketqua) {
			Soketqua_UI.main(null);
			resetColorBtns();
			this.btnSoketqua.setBackground(Color.magenta);
			this.btnSoketqua.setForeground(Color.black);
		} else if (e.getSource() == this.btnx80) {
			X_80_1_UI.main(null);
			resetColorBtns();
			this.btnx80.setBackground(Color.magenta);
			this.btnx80.setForeground(Color.black);
		} else if (e.getSource() == this.btnDumbHead) {
			DumbHeadGUI.main(null);
			resetColorBtns();
			this.btnDumbHead.setBackground(Color.magenta);
			this.btnDumbHead.setForeground(Color.black);
		}
	}

	private void resetColorBtns() {
		this.btnExit.setBackground(Color.RED);
		this.btnExit.setForeground(Color.WHITE);

		this.btnNhapKetQua.setBackground(Color.black);
		this.btnNhapKetQua.setForeground(Color.green);

		this.btnLoroi.setBackground(Color.black);
		this.btnLoroi.setForeground(Color.white);

		this.btnTanso.setBackground(Color.black);
		this.btnTanso.setForeground(Color.white);

		this.btnSoketqua.setBackground(Color.black);
		this.btnSoketqua.setForeground(Color.green);

		this.btnx80.setBackground(Color.black);
		this.btnx80.setForeground(Color.white);

		this.btnDumbHead.setBackground(Color.black);
		this.btnDumbHead.setForeground(Color.white);
	}

	private void buildUI() {
		Panel p3 = new Panel(new FlowLayout());
		p3.add(this.btnSoketqua);
		p3.add(this.btnNhapKetQua);

		Panel p2 = new Panel(new GridLayout(7, 1, 2, 2));
		p2.add(new Label());

		p2.add(this.btnTanso);
		p2.add(this.btnLoroi);
		p2.add(this.btnx80);
		p2.add(this.btnDumbHead);
		p2.add(new Label());
		p2.add(p3);

		Panel p1 = new Panel(new GridLayout(1, 1));
		p1.add(p2);

		setLayout(new BorderLayout());
		add(new Label("   @Create by kus.kit"), "North");
		add(p1, "Center");
		add(this.btnExit, "South");
		add(new Label(), "East");
		add(new Label(), "West");
		setBackground(Color.lightGray);
	}

	private void addListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FilterVer2Main.this.dispose();
			}
		});
		this.btnExit.addActionListener(this);
		this.btnLoroi.addActionListener(this);
		this.btnNhapKetQua.addActionListener(this);
		this.btnTanso.addActionListener(this);
		this.btnSoketqua.addActionListener(this);
		this.btnx80.addActionListener(this);
		btnDumbHead.addActionListener(this);
	}
}