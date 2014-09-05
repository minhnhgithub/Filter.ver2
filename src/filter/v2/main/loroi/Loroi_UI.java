package filter.v2.main.loroi;

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
import java.util.Calendar;

import filter.v2.common.AAA;

/**
 * Contain Loroi + Tongcacgiai
 * 
 */
@SuppressWarnings("serial")
public class Loroi_UI extends Frame implements ActionListener {

	private static final String TITLE = "Lô rơi @kus.kit";

	public static void main(String[] args) {
		Loroi_UI ui = new Loroi_UI(TITLE);
		ui.setVisible(true);
	}

	public Loroi_UI(String title) {
		super(title);

		buildUI();
		addListener();

		setSize(650, 600);
		setLocation(300, 50);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnAddMonth) {
			int index = Integer.parseInt(this.tfMonth.getText()) + 1;
			if (index < 13)
				this.tfMonth.setText(AAA.toWords(index));
			if (selectedDrop != "") {
				run(selectedDrop, null);
			} else if (selectedSum != "") {
				run_sum(selectedSum, null);
			}
		} else if (e.getSource() == this.btnSubMonth) {
			int index = Integer.parseInt(this.tfMonth.getText()) - 1;
			if (index > 0)
				this.tfMonth.setText(AAA.toWords(index));
			if (selectedDrop != "") {
				run(selectedDrop, null);
			} else if (selectedSum != "") {
				run_sum(selectedSum, null);
			}
		} else if (e.getSource() == this.btnAddYear) {
			int index = Integer.parseInt(this.tfYear.getText()) + 1;
			if (index <= Calendar.getInstance().get(Calendar.YEAR))
				this.tfYear.setText(String.valueOf(index));
			if (selectedDrop != "") {
				run(selectedDrop, null);
			} else if (selectedSum != "") {
				run_sum(selectedSum, null);
			}
		} else if (e.getSource() == this.btnSubYear) {
			int index = Integer.parseInt(this.tfYear.getText()) - 1;
			if (index > 2008)
				this.tfYear.setText(String.valueOf(index));
			if (selectedDrop != "") {
				run(selectedDrop, null);
			} else if (selectedSum != "") {
				run_sum(selectedSum, null);
			}
		} else if (e.getSource() == this.btnAddRange) {
			int index = Integer.parseInt(this.tfRange.getText()) + 1;
			if (index <= 7)
				this.tfRange.setText(String.valueOf(index));
			if (selectedDrop != "") {
				run(selectedDrop, null);
			} else if (selectedSum != "") {
				run_sum(selectedSum, null);
			}
		} else if (e.getSource() == this.btnSubRange) {
			int index = Integer.parseInt(this.tfRange.getText()) - 1;
			if (index > 0)
				this.tfRange.setText(String.valueOf(index));
			if (selectedDrop != "") {
				run(selectedDrop, null);
			} else if (selectedSum != "") {
				run_sum(selectedSum, null);
			}
		} else if (e.getSource() == this.bExit) {
			selectedDrop = "";
			selectedSum = "";
			dispose();
		} else if (e.getSource() == this.bdb) {
			run("DB", this.bdb);
		} else if (e.getSource() == this.bg1) {
			run("G1", this.bg1);
		} else if (e.getSource() == this.bg21) {
			run("G21", this.bg21);
		} else if (e.getSource() == this.bg22) {
			run("G22", this.bg22);
		} else if (e.getSource() == this.bg31) {
			run("G31", this.bg31);
		} else if (e.getSource() == this.bg32) {
			run("G32", this.bg32);
		} else if (e.getSource() == this.bg33) {
			run("G33", this.bg33);
		} else if (e.getSource() == this.bg34) {
			run("G34", this.bg34);
		} else if (e.getSource() == this.bg35) {
			run("G35", this.bg35);
		} else if (e.getSource() == this.bg36) {
			run("G36", this.bg36);
		} else if (e.getSource() == this.bg41) {
			run("G41", this.bg41);
		} else if (e.getSource() == this.bg42) {
			run("G42", this.bg42);
		} else if (e.getSource() == this.bg43) {
			run("G43", this.bg43);
		} else if (e.getSource() == this.bg44) {
			run("G44", this.bg44);
		} else if (e.getSource() == this.bg51) {
			run("G51", this.bg51);
		} else if (e.getSource() == this.bg52) {
			run("G52", this.bg52);
		} else if (e.getSource() == this.bg53) {
			run("G53", this.bg53);
		} else if (e.getSource() == this.bg54) {
			run("G54", this.bg54);
		} else if (e.getSource() == this.bg55) {
			run("G55", this.bg55);
		} else if (e.getSource() == this.bg56) {
			run("G56", this.bg56);
		} else if (e.getSource() == this.bg61) {
			run("G61", this.bg61);
		} else if (e.getSource() == this.bg62) {
			run("G62", this.bg62);
		} else if (e.getSource() == this.bg63) {
			run("G63", this.bg63);
		} else if (e.getSource() == this.bg71) {
			run("G71", this.bg71);
		} else if (e.getSource() == this.bg72) {
			run("G72", this.bg72);
		} else if (e.getSource() == this.bg73) {
			run("G73", this.bg73);
		} else if (e.getSource() == this.bg74) {
			run("G74", this.bg74);
		} else if (e.getSource() == this.bsdb) {
			run_sum("DB", this.bsdb);
		} else if (e.getSource() == this.bsg1) {
			run_sum("G1", this.bsg1);
		} else if (e.getSource() == this.bsg21) {
			run_sum("G21", this.bsg21);
		} else if (e.getSource() == this.bsg22) {
			run_sum("G22", this.bsg22);
		} else if (e.getSource() == this.bsg31) {
			run_sum("G31", this.bsg31);
		} else if (e.getSource() == this.bsg32) {
			run_sum("G32", this.bsg32);
		} else if (e.getSource() == this.bsg33) {
			run_sum("G33", this.bsg33);
		} else if (e.getSource() == this.bsg34) {
			run_sum("G34", this.bsg34);
		} else if (e.getSource() == this.bsg35) {
			run_sum("G35", this.bsg35);
		} else if (e.getSource() == this.bsg36) {
			run_sum("G36", this.bsg36);
		} else if (e.getSource() == this.bsg41) {
			run_sum("G41", this.bsg41);
		} else if (e.getSource() == this.bsg42) {
			run_sum("G42", this.bsg42);
		} else if (e.getSource() == this.bsg43) {
			run_sum("G43", this.bsg43);
		} else if (e.getSource() == this.bsg44) {
			run_sum("G44", this.bsg44);
		} else if (e.getSource() == this.bsg51) {
			run_sum("G51", this.bsg51);
		} else if (e.getSource() == this.bsg52) {
			run_sum("G52", this.bsg52);
		} else if (e.getSource() == this.bsg53) {
			run_sum("G53", this.bsg53);
		} else if (e.getSource() == this.bsg54) {
			run_sum("G54", this.bsg54);
		} else if (e.getSource() == this.bsg55) {
			run_sum("G55", this.bsg55);
		} else if (e.getSource() == this.bsg56) {
			run_sum("G56", this.bsg56);
		} else if (e.getSource() == this.bsg61) {
			run_sum("G61", this.bsg61);
		} else if (e.getSource() == this.bsg62) {
			run_sum("G62", this.bsg62);
		} else if (e.getSource() == this.bsg63) {
			run_sum("G63", this.bsg63);
		} else if (e.getSource() == this.bsg71) {
			run_sum("G71", this.bsg71);
		} else if (e.getSource() == this.bsg72) {
			run_sum("G72", this.bsg72);
		} else if (e.getSource() == this.bsg73) {
			run_sum("G73", this.bsg73);
		} else if (e.getSource() == this.bsg74) {
			run_sum("G74", this.bsg74);
		}
	}

	private void addListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				selectedDrop = "";
				selectedSum = "";
				dispose();
			}
		});

		this.btnAddYear.addActionListener(this);
		this.btnAddMonth.addActionListener(this);
		this.btnSubYear.addActionListener(this);
		this.btnSubMonth.addActionListener(this);
		this.btnSubRange.addActionListener(this);
		this.btnAddRange.addActionListener(this);

		this.bExit.addActionListener(this);

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

		this.bsdb.addActionListener(this);
		this.bsg1.addActionListener(this);
		this.bsg21.addActionListener(this);
		this.bsg22.addActionListener(this);
		this.bsg31.addActionListener(this);
		this.bsg32.addActionListener(this);
		this.bsg33.addActionListener(this);
		this.bsg34.addActionListener(this);
		this.bsg35.addActionListener(this);
		this.bsg36.addActionListener(this);
		this.bsg41.addActionListener(this);
		this.bsg42.addActionListener(this);
		this.bsg43.addActionListener(this);
		this.bsg44.addActionListener(this);
		this.bsg51.addActionListener(this);
		this.bsg52.addActionListener(this);
		this.bsg53.addActionListener(this);
		this.bsg54.addActionListener(this);
		this.bsg55.addActionListener(this);
		this.bsg56.addActionListener(this);
		this.bsg61.addActionListener(this);
		this.bsg62.addActionListener(this);
		this.bsg63.addActionListener(this);
		this.bsg71.addActionListener(this);
		this.bsg72.addActionListener(this);
		this.bsg73.addActionListener(this);
		this.bsg74.addActionListener(this);

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

		this.bsdb.addKeyListener(keyListener);
		this.bsg1.addKeyListener(keyListener);
		this.bsg21.addKeyListener(keyListener);
		this.bsg22.addKeyListener(keyListener);
		this.bsg31.addKeyListener(keyListener);
		this.bsg32.addKeyListener(keyListener);
		this.bsg33.addKeyListener(keyListener);
		this.bsg34.addKeyListener(keyListener);
		this.bsg35.addKeyListener(keyListener);
		this.bsg36.addKeyListener(keyListener);
		this.bsg41.addKeyListener(keyListener);
		this.bsg42.addKeyListener(keyListener);
		this.bsg43.addKeyListener(keyListener);
		this.bsg44.addKeyListener(keyListener);
		this.bsg51.addKeyListener(keyListener);
		this.bsg52.addKeyListener(keyListener);
		this.bsg53.addKeyListener(keyListener);
		this.bsg54.addKeyListener(keyListener);
		this.bsg55.addKeyListener(keyListener);
		this.bsg56.addKeyListener(keyListener);
		this.bsg61.addKeyListener(keyListener);
		this.bsg62.addKeyListener(keyListener);
		this.bsg63.addKeyListener(keyListener);
		this.bsg71.addKeyListener(keyListener);
		this.bsg72.addKeyListener(keyListener);
		this.bsg73.addKeyListener(keyListener);
		this.bsg74.addKeyListener(keyListener);
		this.tfMonth.addKeyListener(keyListener);
		this.tfRange.addKeyListener(keyListener);
		this.tfYear.addKeyListener(keyListener);
		this.btnAddYear.addKeyListener(keyListener);
		this.btnAddMonth.addKeyListener(keyListener);
		this.btnSubYear.addKeyListener(keyListener);
		this.btnSubMonth.addKeyListener(keyListener);
		this.btnSubRange.addKeyListener(keyListener);
		this.btnAddRange.addKeyListener(keyListener);
	}

	private void buildUI() {
		resetAllBtn();
		resetAllBSBtn();
		Calendar calendar = Calendar.getInstance();

		this.tfMonth.setText(AAA.toWords(calendar.get(Calendar.MONTH) + 1));
		this.tfYear.setText(AAA.toWords(calendar.get(Calendar.YEAR)));

		Panel p1 = new Panel(new FlowLayout());
		p1.add(tfMonth);
		p1.add(btnAddMonth);
		p1.add(btnSubMonth);

		Panel p2 = new Panel(new FlowLayout());
		p2.add(tfYear);
		p2.add(btnAddYear);
		p2.add(btnSubYear);

		Panel p11 = new Panel(new FlowLayout());
		p11.add(new Label("Range"));
		p11.add(tfRange);
		p11.add(btnAddRange);
		p11.add(btnSubRange);

		Panel p3 = new Panel(new GridLayout(6, 5));
		p3.add(bdb);
		p3.add(bg1);
		p3.add(bg21);
		p3.add(bg22);
		p3.add(bg31);
		p3.add(bg32);
		p3.add(bg33);
		p3.add(bg34);
		p3.add(bg35);
		p3.add(bg36);
		p3.add(bg41);
		p3.add(bg42);
		p3.add(bg43);
		p3.add(bg44);
		p3.add(bg51);
		p3.add(bg52);
		p3.add(bg53);
		p3.add(bg54);
		p3.add(bg55);
		p3.add(bg56);
		p3.add(bg61);
		p3.add(bg62);
		p3.add(bg63);
		p3.add(bg71);
		p3.add(bg72);
		p3.add(bg73);
		p3.add(bg74);
		p3.add(bDropTitle);

		Panel p7 = new Panel(new GridLayout(6, 5));
		p7.add(bsdb);
		p7.add(bsg1);
		p7.add(bsg21);
		p7.add(bsg22);
		p7.add(bsg31);
		p7.add(bsg32);
		p7.add(bsg33);
		p7.add(bsg34);
		p7.add(bsg35);
		p7.add(bsg36);
		p7.add(bsg41);
		p7.add(bsg42);
		p7.add(bsg43);
		p7.add(bsg44);
		p7.add(bsg51);
		p7.add(bsg52);
		p7.add(bsg53);
		p7.add(bsg54);
		p7.add(bsg55);
		p7.add(bsg56);
		p7.add(bsg61);
		p7.add(bsg62);
		p7.add(bsg63);
		p7.add(bsg71);
		p7.add(bsg72);
		p7.add(bsg73);
		p7.add(bsg74);
		p7.add(bSumTitle);

		Panel p4 = new Panel(new GridLayout(1, 2));
		p4.add(p1);
		p4.add(p2);

		Panel p5 = new Panel(new FlowLayout());
		p5.add(p11);
		p5.add(p4);
		p5.add(p3);
		p5.add(new Label("--------------------------------"));
		p5.add(p7);

		Label note = new Label("     Lô rơi 27 giải   ");
		note.setForeground(Color.WHITE);
		note.setBackground(Color.RED);
		// p5.add(note);

		Panel p6 = new Panel(new GridLayout(1, 2));
		p6.add(p5);
		p6.add(area);

		area.setBackground(Color.black);
		area.setForeground(Color.white);

		setLayout(new BorderLayout());
		add(new Label(), "North");
		add(p6, "Center");
		add(bExit, "South");
		add(new Label(), "East");
		add(new Label(), "West");
		setBackground(Color.lightGray);
	}

	private void resetAllBtn() {
		this.bExit.setBackground(Color.RED);
		this.bExit.setForeground(Color.WHITE);

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
		this.bDropTitle.setBackground(Color.pink);
		this.bDropTitle.setForeground(Color.black);
	}

	private void resetAllBSBtn() {
		this.bsdb.setBackground(Color.GRAY);
		this.bsdb.setForeground(Color.WHITE);
		this.bsg1.setBackground(Color.GRAY);
		this.bsg1.setForeground(Color.WHITE);
		this.bsg21.setBackground(Color.GRAY);
		this.bsg21.setForeground(Color.WHITE);
		this.bsg22.setBackground(Color.GRAY);
		this.bsg22.setForeground(Color.WHITE);
		this.bsg31.setBackground(Color.GRAY);
		this.bsg31.setForeground(Color.WHITE);
		this.bsg32.setBackground(Color.GRAY);
		this.bsg32.setForeground(Color.WHITE);
		this.bsg33.setBackground(Color.GRAY);
		this.bsg33.setForeground(Color.WHITE);
		this.bsg34.setBackground(Color.GRAY);
		this.bsg34.setForeground(Color.WHITE);
		this.bsg35.setBackground(Color.GRAY);
		this.bsg35.setForeground(Color.WHITE);
		this.bsg36.setBackground(Color.GRAY);
		this.bsg36.setForeground(Color.WHITE);
		this.bsg41.setBackground(Color.GRAY);
		this.bsg41.setForeground(Color.WHITE);
		this.bsg42.setBackground(Color.GRAY);
		this.bsg42.setForeground(Color.WHITE);
		this.bsg43.setBackground(Color.GRAY);
		this.bsg43.setForeground(Color.WHITE);
		this.bsg44.setBackground(Color.GRAY);
		this.bsg44.setForeground(Color.WHITE);
		this.bsg51.setBackground(Color.GRAY);
		this.bsg51.setForeground(Color.WHITE);
		this.bsg52.setBackground(Color.GRAY);
		this.bsg52.setForeground(Color.WHITE);
		this.bsg53.setBackground(Color.GRAY);
		this.bsg53.setForeground(Color.WHITE);
		this.bsg54.setBackground(Color.GRAY);
		this.bsg54.setForeground(Color.WHITE);
		this.bsg55.setBackground(Color.GRAY);
		this.bsg55.setForeground(Color.WHITE);
		this.bsg56.setBackground(Color.GRAY);
		this.bsg56.setForeground(Color.WHITE);
		this.bsg61.setBackground(Color.GRAY);
		this.bsg61.setForeground(Color.WHITE);
		this.bsg62.setBackground(Color.GRAY);
		this.bsg62.setForeground(Color.WHITE);
		this.bsg63.setBackground(Color.GRAY);
		this.bsg63.setForeground(Color.WHITE);
		this.bsg71.setBackground(Color.GRAY);
		this.bsg71.setForeground(Color.WHITE);
		this.bsg72.setBackground(Color.GRAY);
		this.bsg72.setForeground(Color.WHITE);
		this.bsg73.setBackground(Color.GRAY);
		this.bsg73.setForeground(Color.WHITE);
		this.bsg74.setBackground(Color.GRAY);
		this.bsg74.setForeground(Color.WHITE);
		this.bSumTitle.setBackground(Color.pink);
		this.bSumTitle.setForeground(Color.black);
	}

	public TextArea area = new TextArea();

	public Button bExit = new Button("Exit");
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

	public Button bsdb = new Button("DB");
	public Button bsg1 = new Button("G1");
	public Button bsg21 = new Button("G21");
	public Button bsg22 = new Button("G22");
	public Button bsg31 = new Button("G31");
	public Button bsg32 = new Button("G32");
	public Button bsg33 = new Button("G33");
	public Button bsg34 = new Button("G34");
	public Button bsg35 = new Button("G35");
	public Button bsg36 = new Button("G36");
	public Button bsg41 = new Button("G41");
	public Button bsg42 = new Button("G42");
	public Button bsg43 = new Button("G43");
	public Button bsg44 = new Button("G44");
	public Button bsg51 = new Button("G51");
	public Button bsg52 = new Button("G52");
	public Button bsg53 = new Button("G53");
	public Button bsg54 = new Button("G54");
	public Button bsg55 = new Button("G55");
	public Button bsg56 = new Button("G56");
	public Button bsg61 = new Button("G61");
	public Button bsg62 = new Button("G62");
	public Button bsg63 = new Button("G63");
	public Button bsg71 = new Button("G71");
	public Button bsg72 = new Button("G72");
	public Button bsg73 = new Button("G73");
	public Button bsg74 = new Button("G74");

	TextField tfYear = new TextField();
	TextField tfMonth = new TextField();
	TextField tfRange = new TextField("1");

	Button btnAddYear = new Button("+");
	Button btnSubYear = new Button(" -");
	Button btnAddRange = new Button("+");
	Button btnSubRange = new Button(" -");

	Button btnAddMonth = new Button("+");
	Button btnSubMonth = new Button(" -");

	Button bDropTitle = new Button("Drop");
	Button bSumTitle = new Button("Sum");

	private Loroi_Prc prc = new Loroi_Prc();
	private TongCacGiai_Prc prc2 = new TongCacGiai_Prc();

	private static String selectedDrop = "";
	private static String selectedSum = "";

	private void run(String giai, Button d) {
		selectedDrop = giai;
		selectedSum = "";
		if (d != null) {
			resetAllBtn();
			resetAllBSBtn();
			d.setBackground(Color.BLUE);
		}

		nhay();
		area.setText(prc.x_run(giai, tfMonth.getText(), tfYear.getText(),
				AAA.sToI(tfRange.getText())));
	}

	private void nhay() {
		try {
			area.setBackground(Color.gray);
			Thread.sleep(50);
			area.setBackground(Color.black);
		} catch (InterruptedException e) {
			area.setBackground(Color.red);
		}
	}

	private void run_sum(String giai, Button d) {
		selectedSum = giai;
		selectedDrop = "";
		if (d != null) {
			resetAllBtn();
			resetAllBSBtn();
			d.setBackground(Color.BLUE);
		}
		nhay();
		area.setText(prc2.x_run(giai, tfMonth.getText(), tfYear.getText(),
				AAA.sToI(tfRange.getText())));
	}

	public class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			if (key == KeyEvent.VK_ESCAPE) {
				selectedDrop = "";
				selectedSum = "";
				dispose();
			}
		}
	}
}
