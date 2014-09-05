package filter.v2.main.dumbhead;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;

import filter.v2.common.AAA;
import filter.v2.common.Check;
import filter.v2.utils.IO;

@SuppressWarnings("serial")
public class DumbHeadGUI extends Frame implements ActionListener {

	public static void main(String[] args) {
		DumbHeadGUI ui = new DumbHeadGUI("Dumb Head");
		ui.setVisible(true);
	}

	public DumbHeadGUI(String title) {
		super(title);

		buildGUI();
		addListener();

		setSize(700, 198);
		setLocation(300, 50);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRun) {
			x_run();
		} else if (e.getSource() == btnExit) {
			this.dispose();
		} else if (e.getSource() == btnAddHead) {
			int index = AAA.sToI(tfHead.getText()) + 1;
			if (index <= 9) {
				this.tfHead.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnSubHead) {
			int index = AAA.sToI(tfHead.getText()) - 1;
			if (index >= 0) {
				this.tfHead.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnAddGhep) {
			int index = AAA.sToI(tfGhep.getText()) + 1;
			if (index <= 9) {
				this.tfGhep.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnSubGhep) {
			int index = AAA.sToI(tfGhep.getText()) - 1;
			if (index >= 0) {
				this.tfGhep.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnAddRange) {
			int index = AAA.sToI(tfRange.getText()) + 1;
			if (index <= 5) {
				this.tfRange.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnSubRange) {
			int index = AAA.sToI(tfRange.getText()) - 1;
			if (index >= 1) {
				this.tfRange.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnAddIgnoreDay) {
			int index = AAA.sToI(tfIgnoreDay.getText()) + 1;
			if (index <= 5) {
				this.tfIgnoreDay.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnSubIgnoreDay) {
			int index = AAA.sToI(tfIgnoreDay.getText()) - 1;
			if (index >= 0) {
				this.tfIgnoreDay.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnAddYearFrom) {
			int index = AAA.sToI(tfYearFrom.getText()) + 1;
			if (index <= Calendar.getInstance().get(Calendar.YEAR)) {
				this.tfYearFrom.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnSubYearFrom) {
			int index = AAA.sToI(tfYearFrom.getText()) - 1;
			if (index >= 2009) {
				this.tfYearFrom.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnAddYearTo) {
			int index = AAA.sToI(tfYearTo.getText()) + 1;
			if (index <= Calendar.getInstance().get(Calendar.YEAR)) {
				this.tfYearTo.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnSubYearTo) {
			int index = AAA.sToI(tfYearTo.getText()) - 1;
			if (index >= 2009) {
				this.tfYearTo.setText(AAA.iToS(index));
			}
		} else if (e.getSource() == btnAddMonthTo) {
			int index = AAA.sToI(tfMonthTo.getText()) + 1;
			if (index <= 12) {
				this.tfMonthTo.setText(AAA.toWords(index));
			}
		} else if (e.getSource() == btnSubMonthTo) {
			int index = AAA.sToI(tfMonthTo.getText()) - 1;
			if (index >= 1) {
				this.tfMonthTo.setText(AAA.toWords(index));
			}
		} else if (e.getSource() == btnAddMonthFrom) {
			int index = AAA.sToI(tfMonthFrom.getText()) + 1;
			if (index <= 12) {
				this.tfMonthFrom.setText(AAA.toWords(index));
			}
		} else if (e.getSource() == btnSubMonthFrom) {
			int index = AAA.sToI(tfMonthFrom.getText()) - 1;
			if (index >= 1) {
				this.tfMonthFrom.setText(AAA.toWords(index));
			}
		}
	}

	private String buildHeader(String head, String with, int ignore, int range) {
		String html = "<!DOCTYPE html><head><meta charset='UTF-8'><title>Report</title><link rel='stylesheet' href='style.css' type='text/css' /></head>";
		html += "<body><div class='main'><div class='content'><div class='dumbhead'>";
		html += "<div class='info'>If dumb " + head + " , check " + head
				+ with + "</div>";
		html += "<div class='title'><div class='camdaux'>Dumb " + head
				+ "</div><div class='ignoreday'>ignore " + ignore
				+ " days</div><div class='vaotien'>invest in " + range
				+ " days</div></div>";

		return html;
	}

	private String buildContent(String head, String with, int range, int day,
			int ignore, String fullday) {
		String hit = head + with;
		int res = Check.rangeDay_returnDay(range, day, hit, ignore);
		String statusmain = " bggreen'";
		if (res - ignore > range || res < 0) {
			statusmain = " bgred'";
		}

		String html = "<div class='dh_content'><div class='ngayxuathien"
				+ statusmain + ">" + fullday + "</div>";
		html += "<div class='ignoreday'>&nbsp;</div><div class='vaotien'>";
		for (int i = 1; i <= range; i++) {
			String statussub = "";
			if (res - ignore == i) {
				statussub = " bggreen";
			}
			html += "<div class='ngay" + range + statussub + "'>" + i
					+ "</div>";
		}
		html += "</div></div>";

		return html;
	}

	private String buildEndHtml() {
		return "</div></div></div></body></html>";
	}

	private void addListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		btnRun.addActionListener(this);
		btnAddYearFrom.addActionListener(this);
		btnSubYearFrom.addActionListener(this);
		btnAddMonthFrom.addActionListener(this);
		btnSubMonthFrom.addActionListener(this);
		btnAddYearTo.addActionListener(this);
		btnSubYearTo.addActionListener(this);
		btnAddMonthTo.addActionListener(this);
		btnSubMonthTo.addActionListener(this);
		btnAddHead.addActionListener(this);
		btnSubHead.addActionListener(this);
		btnAddGhep.addActionListener(this);
		btnSubGhep.addActionListener(this);
		btnAddIgnoreDay.addActionListener(this);
		btnSubIgnoreDay.addActionListener(this);
		btnAddRange.addActionListener(this);
		btnSubRange.addActionListener(this);
		btnExit.addActionListener(this);
	}

	private void buildGUI() {
		tfYearTo.setText(AAA.toWords(Calendar.getInstance().get(Calendar.YEAR)));
//		tfMonthTo.setText(AAA.toWords(Calendar.getInstance()
//				.get(Calendar.MONTH) + 1));

		Panel p1 = new Panel(new FlowLayout());
		p1.add(new Label("From year:"));
		p1.add(tfYearFrom);
		p1.add(btnAddYearFrom);
		p1.add(btnSubYearFrom);

		Panel p2 = new Panel(new FlowLayout());
		p2.add(new Label("From month:"));
		p2.add(tfMonthFrom);
		p2.add(btnAddMonthFrom);
		p2.add(btnSubMonthFrom);

		Panel p3 = new Panel(new FlowLayout());
		p3.add(new Label("To year:"));
		p3.add(tfYearTo);
		p3.add(btnAddYearTo);
		p3.add(btnSubYearTo);

		Panel p4 = new Panel(new FlowLayout());
		p4.add(new Label("To month:"));
		p4.add(tfMonthTo);
		p4.add(btnAddMonthTo);
		p4.add(btnSubMonthTo);

		Panel p5 = new Panel(new FlowLayout());
		p5.add(new Label("Dumb head:"));
		p5.add(tfHead);
		p5.add(btnAddHead);
		p5.add(btnSubHead);

		Panel p6 = new Panel(new FlowLayout());
		p6.add(new Label("Ignore days:"));
		p6.add(tfIgnoreDay);
		p6.add(btnAddIgnoreDay);
		p6.add(btnSubIgnoreDay);

		Panel p7 = new Panel(new FlowLayout());
		p6.add(new Label("In:"));
		p7.add(tfRange);
		p7.add(btnAddRange);
		p7.add(btnSubRange);

		Panel p10 = new Panel(new FlowLayout());
		p10.add(new Label("Join:"));
		p10.add(tfGhep);
		p10.add(btnAddGhep);
		p10.add(btnSubGhep);

		Panel p8 = new Panel(new FlowLayout());
		p8.add(p6);
		p8.add(p7);
		p8.add(p5);
		p8.add(p10);
		
		btnRun.setForeground(Color.white);
		btnRun.setBackground(Color.green);
		btnExit.setForeground(Color.white);
		btnExit.setBackground(Color.red);

		Panel center = new Panel(new GridLayout(3, 3));
		center.add(p2);
		center.add(p1);
		center.add(new Label());
		center.add(p4);
		center.add(p3);
		center.add(btnRun);
		center.add(new Label());

		setLayout(new BorderLayout());
		add(p8, "North");
		add(center, "Center");
		add(btnExit, "South");
		add(new Label(), "East");
		add(new Label(), "West");
		setBackground(Color.LIGHT_GRAY);
	}

	private void x_run() {
		String toYear = tfYearTo.getText();
		String fromYear = tfYearFrom.getText();
		String toMonth = tfMonthTo.getText();
		String head = tfHead.getText();
		String with = tfGhep.getText();
		int ignore = AAA.sToI(tfIgnoreDay.getText());
		int range = AAA.sToI(tfRange.getText());

		String html = buildHeader(head, with, ignore, range);
		try {
			for (int y = 0; y <= AAA.sToI(toYear) - AAA.sToI(fromYear); y++) {
				String year = AAA.toWords(AAA.sToI(toYear) - y);
				for (int m = AAA.sToI(toMonth); m >= 1; m--) {
					String month = AAA.toWords(m);
					for (int day = 31; day >= 1; day--) {
						if (DumbHeadHelper.isDumbHead(head, day, month, year)) {
							String fullday = day + "/" + month + "/" + year;
							html += buildContent(head, with, range, day,
									ignore, fullday);
						}
					}

				}
			}
		} catch (Exception e2) {
		}
		html += buildEndHtml();

		// write
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(html);
		String filename = AAA.HTML_PATH + "dumbHeadReport.html";
		IO.write(arr, filename);

		// open
		BareBonesBrowserLaunch.openUrl(filename);
	}

	public TextField tfYearFrom = new TextField("2009");
	public TextField tfMonthFrom = new TextField("01");
	public TextField tfYearTo = new TextField();
	public TextField tfMonthTo = new TextField("12");
	public Button btnAddYearFrom = new Button("+");
	public Button btnSubYearFrom = new Button(" -");
	public Button btnAddMonthFrom = new Button("+");
	public Button btnSubMonthFrom = new Button(" -");
	public Button btnAddYearTo = new Button("+");
	public Button btnSubYearTo = new Button(" -");
	public Button btnAddMonthTo = new Button("+");
	public Button btnSubMonthTo = new Button(" -");

	public TextField tfHead = new TextField("8");
	public TextField tfGhep = new TextField("8");
	public TextField tfIgnoreDay = new TextField("3");
	public TextField tfRange = new TextField("5");
	public Button btnAddHead = new Button("+");
	public Button btnSubHead = new Button(" -");
	public Button btnAddGhep = new Button("+");
	public Button btnSubGhep = new Button(" -");
	public Button btnAddIgnoreDay = new Button("+");
	public Button btnSubIgnoreDay = new Button(" -");
	public Button btnAddRange = new Button("+");
	public Button btnSubRange = new Button(" -");

	public Button btnExit = new Button("Exit");
	public Button btnRun = new Button("Go");
}
