package filter.v2.main.report;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import filter.v2.common.AAA;

/**
 * Clone from Tanso_UI. Get all data from 2009 -> now.
 * 
 * @since 21/07/2012
 * 
 * @author kus.kit
 */
@SuppressWarnings("serial")
public class Tanso_UI extends Frame implements ActionListener {

	private static final String TITLE = "Tần số @kus.kit";

	public static void main(String[] args) {
		Tanso_UI ui = new Tanso_UI(TITLE);
		ui.setVisible(true);
	}

	public Tanso_UI(String title) {
		super(title);

		buildUI();
		addListener();

		setSize(980, 686);
		setLocation(300, 50);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnAddYear) {
			int index = Integer.parseInt(this.tfFromYear.getText()) + 1;
			if (index <= Calendar.getInstance().get(Calendar.YEAR))
				this.tfFromYear.setText(String.valueOf(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnAddYearTo) {
			int index = Integer.parseInt(this.tfToYear.getText()) + 1;
			if (index <= Calendar.getInstance().get(Calendar.YEAR))
				this.tfToYear.setText(String.valueOf(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.dAll) {
			StringBuilder sb = new StringBuilder();

			resetAllDateBtn();
			for (int i = 1; i <= 30; i++) {
				sb.append(analize(AAA.toWords(i), null) + "\n");
			}

			selectedD = "";
			this.dAll.setBackground(Color.blue);
			this.dAll.setForeground(Color.white);

			if (sb.toString().contains("ERROR")) {
				tfKetquaPhantich.setText("Chua chon giai");
			} else {
				tfKetquaPhantich.setText("Execute all !");
				area1.setText(sb.toString());
				area2.setText("");
			}
		} else if (e.getSource() == this.ddAll) {
			runallDD();
		} else if (e.getSource() == this.btnSubYear) {
			int index = Integer.parseInt(this.tfFromYear.getText()) - 1;
			if (index > 2008)
				this.tfFromYear.setText(String.valueOf(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnSubYearTo) {
			int index = Integer.parseInt(this.tfToYear.getText()) - 1;
			if (index > 2008)
				this.tfToYear.setText(String.valueOf(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnAddRange) {
			int index = Integer.parseInt(this.tfRange.getText()) + 1;
			if (index <= 7)
				this.tfRange.setText(String.valueOf(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnSubRange) {
			int index = Integer.parseInt(this.tfRange.getText()) - 1;
			if (index > 0)
				this.tfRange.setText(String.valueOf(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnAddMonthTo) {
			int index = Integer.parseInt(this.tfToMonth.getText()) + 1;
			if (index <= 12)
				this.tfToMonth.setText(AAA.toWords(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnSubMonthTo) {
			int index = Integer.parseInt(this.tfToMonth.getText()) - 1;
			if (index > 0)
				this.tfToMonth.setText(AAA.toWords(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnAddMonthFrom) {
			int index = Integer.parseInt(this.tfFromMonth.getText()) + 1;
			if (index <= 12)
				this.tfFromMonth.setText(AAA.toWords(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnSubMonthFrom) {
			int index = Integer.parseInt(this.tfFromMonth.getText()) - 1;
			if (index > 0)
				this.tfFromMonth.setText(AAA.toWords(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnAddBeginAfter) {
			int index = Integer.parseInt(this.tfBeginAfter.getText()) + 1;
			if (index <= 7)
				this.tfBeginAfter.setText(String.valueOf(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.btnSubBeginAfter) {
			int index = Integer.parseInt(this.tfBeginAfter.getText()) - 1;
			if (index > 0)
				this.tfBeginAfter.setText(String.valueOf(index));
			if (selectedGiai != "") {
				run(selectedGiai, null);
			}
		} else if (e.getSource() == this.bExit) {
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
		} else if (e.getSource() == this.copy1) {
			doCopy1ClickAction();
		} else if (e.getSource() == this.copy2) {
			doCopy2ClickAction();
		} else if (e.getSource() == this.copy3) {
			doCopy3ClickAction();
		} else if (e.getSource() == this.copy4) {
			doCopy4ClickAction();
		} else if (e.getSource() == this.d01) {
			analize("01", this.d01);
		} else if (e.getSource() == this.d02) {
			analize("02", this.d02);
		} else if (e.getSource() == this.d03) {
			analize("03", this.d03);
		} else if (e.getSource() == this.d04) {
			analize("04", this.d04);
		} else if (e.getSource() == this.d05) {
			analize("05", this.d05);
		} else if (e.getSource() == this.d06) {
			analize("06", this.d06);
		} else if (e.getSource() == this.d07) {
			analize("07", this.d07);
		} else if (e.getSource() == this.d08) {
			analize("08", this.d08);
		} else if (e.getSource() == this.d09) {
			analize("09", this.d09);
		} else if (e.getSource() == this.d10) {
			analize("10", this.d10);
		} else if (e.getSource() == this.d11) {
			analize("11", this.d11);
		} else if (e.getSource() == this.d12) {
			analize("12", this.d12);
		} else if (e.getSource() == this.d13) {
			analize("13", this.d13);
		} else if (e.getSource() == this.d14) {
			analize("14", this.d14);
		} else if (e.getSource() == this.d15) {
			analize("15", this.d15);
		} else if (e.getSource() == this.d16) {
			analize("16", this.d16);
		} else if (e.getSource() == this.d17) {
			analize("17", this.d17);
		} else if (e.getSource() == this.d18) {
			analize("18", this.d18);
		} else if (e.getSource() == this.d19) {
			analize("19", this.d19);
		} else if (e.getSource() == this.d20) {
			analize("20", this.d20);
		} else if (e.getSource() == this.d21) {
			analize("21", this.d21);
		} else if (e.getSource() == this.d22) {
			analize("22", this.d22);
		} else if (e.getSource() == this.d23) {
			analize("23", this.d23);
		} else if (e.getSource() == this.d24) {
			analize("24", this.d24);
		} else if (e.getSource() == this.d25) {
			analize("25", this.d25);
		} else if (e.getSource() == this.d26) {
			analize("26", this.d26);
		} else if (e.getSource() == this.d27) {
			analize("27", this.d27);
		} else if (e.getSource() == this.d28) {
			analize("28", this.d28);
		} else if (e.getSource() == this.d29) {
			analize("29", this.d29);
		} else if (e.getSource() == this.d30) {
			analize("30", this.d30);
		} else if (e.getSource() == this.dd01) {
			analize_v2("01", this.dd01);
		} else if (e.getSource() == this.dd02) {
			analize_v2("02", this.dd02);
		} else if (e.getSource() == this.dd03) {
			analize_v2("03", this.dd03);
		} else if (e.getSource() == this.dd04) {
			analize_v2("04", this.dd04);
		} else if (e.getSource() == this.dd05) {
			analize_v2("05", this.dd05);
		} else if (e.getSource() == this.dd06) {
			analize_v2("06", this.dd06);
		} else if (e.getSource() == this.dd07) {
			analize_v2("07", this.dd07);
		} else if (e.getSource() == this.dd08) {
			analize_v2("08", this.dd08);
		} else if (e.getSource() == this.dd09) {
			analize_v2("09", this.dd09);
		} else if (e.getSource() == this.dd10) {
			analize_v2("10", this.dd10);
		} else if (e.getSource() == this.dd11) {
			analize_v2("11", this.dd11);
		} else if (e.getSource() == this.dd12) {
			analize_v2("12", this.dd12);
		} else if (e.getSource() == this.dd13) {
			analize_v2("13", this.dd13);
		} else if (e.getSource() == this.dd14) {
			analize_v2("14", this.dd14);
		} else if (e.getSource() == this.dd15) {
			analize_v2("15", this.dd15);
		} else if (e.getSource() == this.dd16) {
			analize_v2("16", this.dd16);
		} else if (e.getSource() == this.dd17) {
			analize_v2("17", this.dd17);
		} else if (e.getSource() == this.dd18) {
			analize_v2("18", this.dd18);
		} else if (e.getSource() == this.dd19) {
			analize_v2("19", this.dd19);
		} else if (e.getSource() == this.dd20) {
			analize_v2("20", this.dd20);
		} else if (e.getSource() == this.dd21) {
			analize_v2("21", this.dd21);
		} else if (e.getSource() == this.dd22) {
			analize_v2("22", this.dd22);
		} else if (e.getSource() == this.dd23) {
			analize_v2("23", this.dd23);
		} else if (e.getSource() == this.dd24) {
			analize_v2("24", this.dd24);
		} else if (e.getSource() == this.dd25) {
			analize_v2("25", this.dd25);
		} else if (e.getSource() == this.dd26) {
			analize_v2("26", this.dd26);
		} else if (e.getSource() == this.dd27) {
			analize_v2("27", this.dd27);
		} else if (e.getSource() == this.dd28) {
			analize_v2("28", this.dd28);
		} else if (e.getSource() == this.dd29) {
			analize_v2("29", this.dd29);
		} else if (e.getSource() == this.dd30) {
			analize_v2("30", this.dd30);
		}
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
	}

	private void resetAllDateBtn() {
		this.d01.setBackground(Color.GRAY);
		this.d01.setForeground(Color.WHITE);
		this.d02.setBackground(Color.GRAY);
		this.d02.setForeground(Color.WHITE);
		this.d03.setBackground(Color.GRAY);
		this.d03.setForeground(Color.WHITE);
		this.d04.setBackground(Color.GRAY);
		this.d04.setForeground(Color.WHITE);
		this.d05.setBackground(Color.GRAY);
		this.d05.setForeground(Color.WHITE);
		this.d06.setBackground(Color.GRAY);
		this.d06.setForeground(Color.WHITE);
		this.d07.setBackground(Color.GRAY);
		this.d07.setForeground(Color.WHITE);
		this.d08.setBackground(Color.GRAY);
		this.d08.setForeground(Color.WHITE);
		this.d09.setBackground(Color.GRAY);
		this.d09.setForeground(Color.WHITE);
		this.d10.setBackground(Color.GRAY);
		this.d10.setForeground(Color.WHITE);
		this.d11.setBackground(Color.GRAY);
		this.d11.setForeground(Color.WHITE);
		this.d12.setBackground(Color.GRAY);
		this.d12.setForeground(Color.WHITE);
		this.d13.setBackground(Color.GRAY);
		this.d13.setForeground(Color.WHITE);
		this.d14.setBackground(Color.GRAY);
		this.d14.setForeground(Color.WHITE);
		this.d15.setBackground(Color.GRAY);
		this.d15.setForeground(Color.WHITE);
		this.d16.setBackground(Color.GRAY);
		this.d16.setForeground(Color.WHITE);
		this.d17.setBackground(Color.GRAY);
		this.d17.setForeground(Color.WHITE);
		this.d18.setBackground(Color.GRAY);
		this.d18.setForeground(Color.WHITE);
		this.d19.setBackground(Color.GRAY);
		this.d19.setForeground(Color.WHITE);
		this.d20.setBackground(Color.GRAY);
		this.d20.setForeground(Color.WHITE);
		this.d21.setBackground(Color.GRAY);
		this.d21.setForeground(Color.WHITE);
		this.d22.setBackground(Color.GRAY);
		this.d22.setForeground(Color.WHITE);
		this.d23.setBackground(Color.GRAY);
		this.d23.setForeground(Color.WHITE);
		this.d24.setBackground(Color.GRAY);
		this.d24.setForeground(Color.WHITE);
		this.d25.setBackground(Color.GRAY);
		this.d25.setForeground(Color.WHITE);
		this.d26.setBackground(Color.GRAY);
		this.d26.setForeground(Color.WHITE);
		this.d27.setBackground(Color.GRAY);
		this.d27.setForeground(Color.WHITE);
		this.d28.setBackground(Color.GRAY);
		this.d28.setForeground(Color.WHITE);
		this.d29.setBackground(Color.GRAY);
		this.d29.setForeground(Color.WHITE);
		this.d30.setBackground(Color.GRAY);
		this.d30.setForeground(Color.WHITE);
		this.dAll.setBackground(Color.pink);
		this.dAll.setForeground(Color.black);
	}

	private void resetAllDDBtn() {
		this.dd01.setBackground(Color.GRAY);
		this.dd01.setForeground(Color.WHITE);
		this.dd02.setBackground(Color.GRAY);
		this.dd02.setForeground(Color.WHITE);
		this.dd03.setBackground(Color.GRAY);
		this.dd03.setForeground(Color.WHITE);
		this.dd04.setBackground(Color.GRAY);
		this.dd04.setForeground(Color.WHITE);
		this.dd05.setBackground(Color.GRAY);
		this.dd05.setForeground(Color.WHITE);
		this.dd06.setBackground(Color.GRAY);
		this.dd06.setForeground(Color.WHITE);
		this.dd07.setBackground(Color.GRAY);
		this.dd07.setForeground(Color.WHITE);
		this.dd08.setBackground(Color.GRAY);
		this.dd08.setForeground(Color.WHITE);
		this.dd09.setBackground(Color.GRAY);
		this.dd09.setForeground(Color.WHITE);
		this.dd10.setBackground(Color.GRAY);
		this.dd10.setForeground(Color.WHITE);
		this.dd11.setBackground(Color.GRAY);
		this.dd11.setForeground(Color.WHITE);
		this.dd12.setBackground(Color.GRAY);
		this.dd12.setForeground(Color.WHITE);
		this.dd13.setBackground(Color.GRAY);
		this.dd13.setForeground(Color.WHITE);
		this.dd14.setBackground(Color.GRAY);
		this.dd14.setForeground(Color.WHITE);
		this.dd15.setBackground(Color.GRAY);
		this.dd15.setForeground(Color.WHITE);
		this.dd16.setBackground(Color.GRAY);
		this.dd16.setForeground(Color.WHITE);
		this.dd17.setBackground(Color.GRAY);
		this.dd17.setForeground(Color.WHITE);
		this.dd18.setBackground(Color.GRAY);
		this.dd18.setForeground(Color.WHITE);
		this.dd19.setBackground(Color.GRAY);
		this.dd19.setForeground(Color.WHITE);
		this.dd20.setBackground(Color.GRAY);
		this.dd20.setForeground(Color.WHITE);
		this.dd21.setBackground(Color.GRAY);
		this.dd21.setForeground(Color.WHITE);
		this.dd22.setBackground(Color.GRAY);
		this.dd22.setForeground(Color.WHITE);
		this.dd23.setBackground(Color.GRAY);
		this.dd23.setForeground(Color.WHITE);
		this.dd24.setBackground(Color.GRAY);
		this.dd24.setForeground(Color.WHITE);
		this.dd25.setBackground(Color.GRAY);
		this.dd25.setForeground(Color.WHITE);
		this.dd26.setBackground(Color.GRAY);
		this.dd26.setForeground(Color.WHITE);
		this.dd27.setBackground(Color.GRAY);
		this.dd27.setForeground(Color.WHITE);
		this.dd28.setBackground(Color.GRAY);
		this.dd28.setForeground(Color.WHITE);
		this.dd29.setBackground(Color.GRAY);
		this.dd29.setForeground(Color.WHITE);
		this.dd30.setBackground(Color.GRAY);
		this.dd30.setForeground(Color.WHITE);
		this.ddAll.setBackground(Color.pink);
		this.ddAll.setForeground(Color.black);
	}

	private void resetCopyBtns() {
		this.copy1.setBackground(Color.GRAY);
		this.copy1.setForeground(Color.WHITE);
		this.copy2.setBackground(Color.GRAY);
		this.copy2.setForeground(Color.WHITE);
		this.copy3.setBackground(Color.GRAY);
		this.copy3.setForeground(Color.WHITE);
		this.copy4.setBackground(Color.GRAY);
		this.copy4.setForeground(Color.WHITE);
	}

	/**
	 * Year check. Start from 2009
	 */
	TextField tfFromYear = new TextField();
	TextField tfToYear = new TextField();
	TextField tfToMonth = new TextField();
	TextField tfFromMonth = new TextField();

	/**
	 * This is range for search the NOT return back.
	 */
	TextField tfRange = new TextField("5");

	/**
	 * This is range for search the return back
	 */
	TextField tfBeginAfter = new TextField("1");

	Button btnAddYear = new Button("+");
	Button btnSubYear = new Button(" -");
	Button btnAddYearTo = new Button("+");
	Button btnSubYearTo = new Button(" -");
	Button btnAddMonthTo = new Button("+");
	Button btnSubMonthTo = new Button(" -");
	Button btnAddMonthFrom = new Button("+");
	Button btnSubMonthFrom = new Button(" -");
	Button btnAddRange = new Button("+");
	Button btnSubRange = new Button(" -");
	Button btnAddBeginAfter = new Button("+");
	Button btnSubBeginAfter = new Button(" -");
	CheckboxGroup radio_group = new CheckboxGroup();
	Checkbox radio_tanso = new Checkbox("", true, radio_group);
	Checkbox radio_check = new Checkbox("", false, radio_group);

	private Tanso_Prc prc = new Tanso_Prc();

	public TextArea area1 = new TextArea();
	public TextArea area2 = new TextArea();

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

	Button copy1 = new Button("      ( Q )      ");
	Button copy2 = new Button("      ( W )      ");
	Button copy3 = new Button("      ( A )      ");
	Button copy4 = new Button("      ( S )      ");

	public Button d01 = new Button("01");
	public Button d02 = new Button("02");
	public Button d03 = new Button("03");
	public Button d04 = new Button("04");
	public Button d05 = new Button("05");
	public Button d06 = new Button("06");
	public Button d07 = new Button("07");
	public Button d08 = new Button("08");
	public Button d09 = new Button("09");
	public Button d10 = new Button("10");
	public Button d11 = new Button("11");
	public Button d12 = new Button("12");
	public Button d13 = new Button("13");
	public Button d14 = new Button("14");
	public Button d15 = new Button("15");
	public Button d16 = new Button("16");
	public Button d17 = new Button("17");
	public Button d18 = new Button("18");
	public Button d19 = new Button("19");
	public Button d20 = new Button("20");
	public Button d21 = new Button("21");
	public Button d22 = new Button("22");
	public Button d23 = new Button("23");
	public Button d24 = new Button("24");
	public Button d25 = new Button("25");
	public Button d26 = new Button("26");
	public Button d27 = new Button("27");
	public Button d28 = new Button("28");
	public Button d29 = new Button("29");
	public Button d30 = new Button("30");
	public Button dAll = new Button("All");
	public Button ddAll = new Button("All");

	public Button dd01 = new Button("01");
	public Button dd02 = new Button("02");
	public Button dd03 = new Button("03");
	public Button dd04 = new Button("04");
	public Button dd05 = new Button("05");
	public Button dd06 = new Button("06");
	public Button dd07 = new Button("07");
	public Button dd08 = new Button("08");
	public Button dd09 = new Button("09");
	public Button dd10 = new Button("10");
	public Button dd11 = new Button("11");
	public Button dd12 = new Button("12");
	public Button dd13 = new Button("13");
	public Button dd14 = new Button("14");
	public Button dd15 = new Button("15");
	public Button dd16 = new Button("16");
	public Button dd17 = new Button("17");
	public Button dd18 = new Button("18");
	public Button dd19 = new Button("19");
	public Button dd20 = new Button("20");
	public Button dd21 = new Button("21");
	public Button dd22 = new Button("22");
	public Button dd23 = new Button("23");
	public Button dd24 = new Button("24");
	public Button dd25 = new Button("25");
	public Button dd26 = new Button("26");
	public Button dd27 = new Button("27");
	public Button dd28 = new Button("28");
	public Button dd29 = new Button("29");
	public Button dd30 = new Button("30");

	TextField tfKetquaPhantich = new TextField("GIAI GIAI GIAI");
	TextField tfKetquaPhantich_v2 = new TextField("NGAY NGAY NGAY");

	private static String selectedGiai = "";
	private static String selectedD = "";
	private static String selectedDD = "";
	private static List<String> arr1 = new ArrayList<String>();
	private static List<String> arr2 = new ArrayList<String>();
	static String syear = "2009";

	public class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			if (key == KeyEvent.VK_Q) {
				doCopy1ClickAction();
			} else if (key == KeyEvent.VK_W) {
				doCopy2ClickAction();
			} else if (key == KeyEvent.VK_A) {
				doCopy3ClickAction();
			} else if (key == KeyEvent.VK_S) {
				doCopy4ClickAction();
			} else if (key == KeyEvent.VK_ESCAPE) {
				dispose();
			} else if (key == KeyEvent.VK_Z) {
				runallDD();
			}
		}
	}

	private void doCopy1ClickAction() {
		StringSelection s = new StringSelection(area1.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(s, s);

		resetCopyBtns();
		this.copy1.setBackground(Color.blue);
	}

	private void doCopy2ClickAction() {
		StringSelection s = new StringSelection(area2.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(s, s);

		resetCopyBtns();
		this.copy2.setBackground(Color.blue);
	}

	private void doCopy3ClickAction() {
		StringSelection s = new StringSelection(tfKetquaPhantich.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(s, s);

		resetCopyBtns();
		this.copy3.setBackground(Color.blue);
	}

	private void doCopy4ClickAction() {
		StringSelection s = new StringSelection(tfKetquaPhantich_v2.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(s, s);

		resetCopyBtns();
		this.copy4.setBackground(Color.blue);
	}

	private void buildUI() {
		resetAllBtn();
		resetAllDateBtn();
		resetAllDDBtn();
		resetCopyBtns();

		Calendar calendar = Calendar.getInstance();

		if (!syear.equals(""))
			this.tfFromYear.setText(syear);
		else {
			this.tfFromYear.setText(AAA.toWords(calendar.get(Calendar.YEAR)));
		}

		tfToYear.setText(String.valueOf(Calendar.getInstance().get(
				Calendar.YEAR)));
		tfToMonth.setText(AAA.toWords(Calendar.getInstance()
				.get(Calendar.MONTH) + 1));
		tfFromMonth.setText("01");

		Panel p1 = new Panel(new GridLayout(6, 5));
		p1.add(bdb);
		p1.add(bg1);
		p1.add(bg21);
		p1.add(bg22);
		p1.add(bg31);
		p1.add(bg32);
		p1.add(bg33);
		p1.add(bg34);
		p1.add(bg35);
		p1.add(bg36);
		p1.add(bg41);
		p1.add(bg42);
		p1.add(bg43);
		p1.add(bg44);
		p1.add(bg51);
		p1.add(bg52);
		p1.add(bg53);
		p1.add(bg54);
		p1.add(bg55);
		p1.add(bg56);
		p1.add(bg61);
		p1.add(bg62);
		p1.add(bg63);
		p1.add(bg71);
		p1.add(bg72);
		p1.add(bg73);
		p1.add(bg74);

		Panel p2 = new Panel(new FlowLayout());
		p2.add(new Label("Range"));
		p2.add(tfRange);
		p2.add(btnAddRange);
		p2.add(btnSubRange);

		Panel p3 = new Panel(new FlowLayout());
		p3.add(new Label("After"));
		p3.add(tfBeginAfter);
		p3.add(btnAddBeginAfter);
		p3.add(btnSubBeginAfter);

		Panel p4 = new Panel(new FlowLayout());
		p4.add(p2);
		p4.add(p3);

		Panel p51 = new Panel(new FlowLayout());
		p51.add(new Label("From"));
		p51.add(tfFromMonth);
		p51.add(btnAddMonthFrom);
		p51.add(btnSubMonthFrom);
		p51.add(tfFromYear);
		p51.add(btnAddYear);
		p51.add(btnSubYear);

		Panel p52 = new Panel(new FlowLayout());
		p52.add(new Label("To"));
		p52.add(tfToMonth);
		p52.add(btnAddMonthTo);
		p52.add(btnSubMonthTo);
		p52.add(tfToYear);
		p52.add(btnAddYearTo);
		p52.add(btnSubYearTo);

		Panel p5 = new Panel(new GridLayout(2, 1));
		p5.add(p51);
		p5.add(p52);

		Panel p6 = new Panel(new FlowLayout());
		p6.add(copy1);
		p6.add(copy2);

		Panel p8 = new Panel(new GridLayout(2, 1));
		p8.add(p6);

		Panel p7 = new Panel(new GridLayout(4, 8));
		p7.add(d01);
		p7.add(d02);
		p7.add(d03);
		p7.add(d04);
		p7.add(d05);
		p7.add(d06);
		p7.add(d07);
		p7.add(d08);
		p7.add(d09);
		p7.add(d10);
		p7.add(d11);
		p7.add(d12);
		p7.add(d13);
		p7.add(d14);
		p7.add(d15);
		p7.add(d16);
		p7.add(d17);
		p7.add(d18);
		p7.add(d19);
		p7.add(d20);
		p7.add(d21);
		p7.add(d22);
		p7.add(d23);
		p7.add(d24);
		p7.add(d25);
		p7.add(d26);
		p7.add(d27);
		p7.add(d28);
		p7.add(d29);
		p7.add(d30);
		p7.add(dAll);

		Panel p9 = new Panel(new GridLayout(4, 8));
		p9.add(dd01);
		p9.add(dd02);
		p9.add(dd03);
		p9.add(dd04);
		p9.add(dd05);
		p9.add(dd06);
		p9.add(dd07);
		p9.add(dd08);
		p9.add(dd09);
		p9.add(dd10);
		p9.add(dd11);
		p9.add(dd12);
		p9.add(dd13);
		p9.add(dd14);
		p9.add(dd15);
		p9.add(dd16);
		p9.add(dd17);
		p9.add(dd18);
		p9.add(dd19);
		p9.add(dd20);
		p9.add(dd21);
		p9.add(dd22);
		p9.add(dd23);
		p9.add(dd24);
		p9.add(dd25);
		p9.add(dd26);
		p9.add(dd27);
		p9.add(dd28);
		p9.add(dd29);
		p9.add(dd30);
		p9.add(ddAll);

		Panel p10 = new Panel(new FlowLayout());
		p10.add(tfKetquaPhantich);
		p10.add(copy3);

		Panel p11 = new Panel(new FlowLayout());
		p11.add(tfKetquaPhantich_v2);
		p11.add(copy4);

		Panel p = new Panel(new FlowLayout());
		p.add(p5);
		p.add(p4);
		p.add(p1);
		p.add(p8);
		p.add(p7);
		p.add(p10);
		p.add(p9);
		p.add(p11);

		Panel center = new Panel(new GridLayout(1, 3));
		center.add(p);
		center.add(area1);
		center.add(area2);

		area1.setBackground(Color.black);
		area1.setForeground(Color.white);
		area2.setBackground(Color.black);
		area2.setForeground(Color.white);

		setLayout(new BorderLayout());
		add(new Label(), "North");
		add(center, "Center");
		add(bExit, "South");
		add(new Label(), "East");
		add(new Label(), "West");
		setBackground(Color.LIGHT_GRAY);
	}

	private void addListener() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		this.btnAddYear.addActionListener(this);
		this.btnAddBeginAfter.addActionListener(this);
		this.btnSubYear.addActionListener(this);
		this.btnSubBeginAfter.addActionListener(this);
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
		this.copy1.addActionListener(this);
		this.copy2.addActionListener(this);
		this.copy3.addActionListener(this);
		this.copy4.addActionListener(this);
		this.d01.addActionListener(this);
		this.d02.addActionListener(this);
		this.d03.addActionListener(this);
		this.d04.addActionListener(this);
		this.d05.addActionListener(this);
		this.d06.addActionListener(this);
		this.d07.addActionListener(this);
		this.d08.addActionListener(this);
		this.d09.addActionListener(this);
		this.d10.addActionListener(this);
		this.d11.addActionListener(this);
		this.d12.addActionListener(this);
		this.d13.addActionListener(this);
		this.d14.addActionListener(this);
		this.d15.addActionListener(this);
		this.d16.addActionListener(this);
		this.d17.addActionListener(this);
		this.d18.addActionListener(this);
		this.d19.addActionListener(this);
		this.d20.addActionListener(this);
		this.d21.addActionListener(this);
		this.d22.addActionListener(this);
		this.d23.addActionListener(this);
		this.d24.addActionListener(this);
		this.d25.addActionListener(this);
		this.d26.addActionListener(this);
		this.d27.addActionListener(this);
		this.d28.addActionListener(this);
		this.d29.addActionListener(this);
		this.d30.addActionListener(this);
		this.dd01.addActionListener(this);
		this.dd02.addActionListener(this);
		this.dd03.addActionListener(this);
		this.dd04.addActionListener(this);
		this.dd05.addActionListener(this);
		this.dd06.addActionListener(this);
		this.dd07.addActionListener(this);
		this.dd08.addActionListener(this);
		this.dd09.addActionListener(this);
		this.dd10.addActionListener(this);
		this.dd11.addActionListener(this);
		this.dd12.addActionListener(this);
		this.dd13.addActionListener(this);
		this.dd14.addActionListener(this);
		this.dd15.addActionListener(this);
		this.dd16.addActionListener(this);
		this.dd17.addActionListener(this);
		this.dd18.addActionListener(this);
		this.dd19.addActionListener(this);
		this.dd20.addActionListener(this);
		this.dd21.addActionListener(this);
		this.dd22.addActionListener(this);
		this.dd23.addActionListener(this);
		this.dd24.addActionListener(this);
		this.dd25.addActionListener(this);
		this.dd26.addActionListener(this);
		this.dd27.addActionListener(this);
		this.dd28.addActionListener(this);
		this.dd29.addActionListener(this);
		this.dd30.addActionListener(this);
		this.ddAll.addActionListener(this);
		this.dAll.addActionListener(this);

		MyKeyListener keyListener = new MyKeyListener();
		bdb.addKeyListener(keyListener);
		bg1.addKeyListener(keyListener);
		bg21.addKeyListener(keyListener);
		bg22.addKeyListener(keyListener);
		bg31.addKeyListener(keyListener);
		bg32.addKeyListener(keyListener);
		bg33.addKeyListener(keyListener);
		bg34.addKeyListener(keyListener);
		bg35.addKeyListener(keyListener);
		bg36.addKeyListener(keyListener);
		bg41.addKeyListener(keyListener);
		bg42.addKeyListener(keyListener);
		bg43.addKeyListener(keyListener);
		bg44.addKeyListener(keyListener);
		bg51.addKeyListener(keyListener);
		bg52.addKeyListener(keyListener);
		bg53.addKeyListener(keyListener);
		bg54.addKeyListener(keyListener);
		bg55.addKeyListener(keyListener);
		bg56.addKeyListener(keyListener);
		bg61.addKeyListener(keyListener);
		bg62.addKeyListener(keyListener);
		bg63.addKeyListener(keyListener);
		bg71.addKeyListener(keyListener);
		bg72.addKeyListener(keyListener);
		bg73.addKeyListener(keyListener);
		bg74.addKeyListener(keyListener);
		d01.addKeyListener(keyListener);
		d02.addKeyListener(keyListener);
		d03.addKeyListener(keyListener);
		d04.addKeyListener(keyListener);
		d05.addKeyListener(keyListener);
		d06.addKeyListener(keyListener);
		d07.addKeyListener(keyListener);
		d08.addKeyListener(keyListener);
		d09.addKeyListener(keyListener);
		d10.addKeyListener(keyListener);
		d11.addKeyListener(keyListener);
		d12.addKeyListener(keyListener);
		d13.addKeyListener(keyListener);
		d14.addKeyListener(keyListener);
		d15.addKeyListener(keyListener);
		d16.addKeyListener(keyListener);
		d17.addKeyListener(keyListener);
		d18.addKeyListener(keyListener);
		d19.addKeyListener(keyListener);
		d20.addKeyListener(keyListener);
		d21.addKeyListener(keyListener);
		d22.addKeyListener(keyListener);
		d23.addKeyListener(keyListener);
		d24.addKeyListener(keyListener);
		d25.addKeyListener(keyListener);
		d26.addKeyListener(keyListener);
		d27.addKeyListener(keyListener);
		d28.addKeyListener(keyListener);
		d29.addKeyListener(keyListener);
		d30.addKeyListener(keyListener);
		dd01.addKeyListener(keyListener);
		dd02.addKeyListener(keyListener);
		dd03.addKeyListener(keyListener);
		dd04.addKeyListener(keyListener);
		dd05.addKeyListener(keyListener);
		dd06.addKeyListener(keyListener);
		dd07.addKeyListener(keyListener);
		dd08.addKeyListener(keyListener);
		dd09.addKeyListener(keyListener);
		dd10.addKeyListener(keyListener);
		dd11.addKeyListener(keyListener);
		dd12.addKeyListener(keyListener);
		dd13.addKeyListener(keyListener);
		dd14.addKeyListener(keyListener);
		dd15.addKeyListener(keyListener);
		dd16.addKeyListener(keyListener);
		dd17.addKeyListener(keyListener);
		dd18.addKeyListener(keyListener);
		dd19.addKeyListener(keyListener);
		dd20.addKeyListener(keyListener);
		dd21.addKeyListener(keyListener);
		dd22.addKeyListener(keyListener);
		dd23.addKeyListener(keyListener);
		dd24.addKeyListener(keyListener);
		dd25.addKeyListener(keyListener);
		dd26.addKeyListener(keyListener);
		dd27.addKeyListener(keyListener);
		dd28.addKeyListener(keyListener);
		dd29.addKeyListener(keyListener);
		dd30.addKeyListener(keyListener);
		ddAll.addKeyListener(keyListener);
		dAll.addKeyListener(keyListener);

		tfFromYear.addKeyListener(keyListener);
		tfToYear.addKeyListener(keyListener);
		tfToMonth.addKeyListener(keyListener);

		btnAddMonthTo.addActionListener(this);
		btnSubMonthTo.addActionListener(this);
		btnAddMonthFrom.addActionListener(this);
		btnSubMonthFrom.addActionListener(this);
		btnAddYearTo.addActionListener(this);
		btnSubYearTo.addActionListener(this);
	}

	private void run(String giai, Button d) {
		selectedGiai = giai;
		arr1 = new ArrayList<String>();
		arr2 = new ArrayList<String>();

		String year = tfFromYear.getText();
		String toYear = tfToYear.getText();

		int range = AAA.sToI(tfRange.getText());
		int addOptDate = AAA.sToI(tfBeginAfter.getText());
		StringBuilder sb1 = new StringBuilder(giai + "\n");
		StringBuilder sb2 = new StringBuilder(giai + "\n");
		for (int i = AAA.sToI(year); i <= AAA.sToI(toYear); i++) {
			String toMonth = "";
			String fromMonth = "01";
			if (i == AAA.sToI(year)) {
				fromMonth = tfFromMonth.getText();
			}
			if (i == AAA.sToI(toYear)) {
				toMonth = tfToMonth.getText();
			}
			String result1 = prc.x_1(giai, String.valueOf(i), fromMonth,
					toMonth, range, 1);
			String result2 = prc.x_2(giai, String.valueOf(i), fromMonth,
					toMonth, 1, addOptDate);
			sb1.append(result1);
			sb2.append(result2);
			String s1[] = result1.split("\n");
			String s2[] = result2.split("\n");
			for (String s : s1) {
				arr1.add(s.substring(6));
			}
			for (String s : s2) {
				arr2.add(s.substring(6));
			}
		}
		area1.setText(sb1.toString());
		area2.setText(sb2.toString());

		if (d != null) {
			resetAllBtn();
			d.setBackground(Color.BLUE);
		}

		if (selectedD != "") {
			analize(selectedD, null);

			if (selectedDD != "") {
				analize_v2(selectedDD, null);
			}
		}
	}

	private String analize(String checkedDate, Button d) {
		if (d != null) {
			resetAllDateBtn();
			d.setBackground(Color.BLUE);
			d.setForeground(Color.white);
		}

		selectedD = checkedDate;

		if (selectedGiai == "") {
			tfKetquaPhantich.setText("Chua chon giai");
			return "ERROR";
		}

		if (selectedDD != "") {
			analize_v2(selectedDD, null);
		}

		// tinh so vong se lap
		int loops = (AAA.sToI(tfToYear.getText()) - AAA.sToI(tfFromYear
				.getText()))
				* 12
				+ AAA.sToI(tfToMonth.getText())
				- 4
				- AAA.sToI(tfFromMonth.getText()) + 1;
		int max1 = 0;
		int maxtemp1 = 0;
		int max2 = 0;
		int maxtemp2 = 0;
		int max3 = 0;
		int maxtemp3 = 0;
		for (int k = 0; k < loops; k++) {
			if (arr1.get(k).contains(checkedDate)) {
				String temp1 = arr2.get(k + 1);
				String temp2 = arr2.get(k + 2);
				String temp3 = arr2.get(k + 3);

				if (!temp1.contains(checkedDate.substring(1) + " ")) {
					maxtemp1 += 1;
					if (maxtemp1 >= max1) {
						max1 = maxtemp1;
					}
				} else {
					maxtemp1 = 0;
				}

				if (!temp2.contains(checkedDate.substring(1) + " ")) {
					maxtemp2 += 1;
					if (maxtemp2 >= max2) {
						max2 = maxtemp2;
					}
				} else {
					maxtemp2 = 0;
				}

				if (!temp3.contains(checkedDate.substring(1) + " ")) {
					maxtemp3 += 1;
					if (maxtemp3 >= max3) {
						max3 = maxtemp3;
					}
				} else {
					maxtemp3 = 0;
				}
			}
		}

		// in ket qua
		String ketquaphantich = "." + checkedDate + " " + "+1(" + max1 + ")"
				+ " " + "+2(" + max2 + ")" + " " + "+3(" + max3 + ")";
		tfKetquaPhantich.setText(ketquaphantich);

		return ketquaphantich;
	}

	/**
	 * Duyet tung ngay ko ve, kiem tra ngay nao ben phai lo roi ve trong khoang
	 * thoi gian max la 4
	 */
	private String analize_v2(String checkedDate, Button d) {
		if (d != null) {
			resetAllDDBtn();
			d.setBackground(Color.BLUE);
			d.setForeground(Color.white);
		}

		selectedDD = checkedDate;

		if (selectedD == "") {
			tfKetquaPhantich_v2.setText("Chua chon ngay");
			return "ERROR";
		}

		if (selectedGiai == "") {
			tfKetquaPhantich_v2.setText("Chua chon giai");
			return "ERROR";
		}

		// tinh so vong se lap
		int loops = (AAA.sToI(tfToYear.getText()) - AAA.sToI(tfFromYear
				.getText()))
				* 12
				+ AAA.sToI(tfToMonth.getText())
				- 4
				- AAA.sToI(tfFromMonth.getText()) + 1;
		;
		int max1 = 0;
		int maxtemp1 = 0;
		int max2 = 0;
		int maxtemp2 = 0;
		int max3 = 0;
		int maxtemp3 = 0;
		int max4 = 0;
		int maxtemp4 = 0;
		for (int k = 0; k < loops; k++) {
			if (arr1.get(k).contains(selectedD)) {
				List<String> arrtemp = new ArrayList<String>();
				arrtemp.add(arr2.get(k + 1));

				for (int i = 0; i < 1; i++) {
					String s = arrtemp.get(i);
					if (!s.contains(checkedDate)) {
						maxtemp1 += 1;
						if (maxtemp1 >= max1) {
							max1 = maxtemp1;
						}
					} else {
						maxtemp1 = 0;
					}
				}
			}
		}

		if (max1 <= 1) {
			// in ket qua
			String ketquaphantich = "." + selectedD + " has " + checkedDate
					+ " in +1(" + max1 + ")";
			tfKetquaPhantich_v2.setText(ketquaphantich);

			return ketquaphantich;
		} else {
			for (int k = 0; k < loops; k++) {
				if (arr1.get(k).contains(selectedD)) {
					List<String> arrtemp = new ArrayList<String>();
					arrtemp.add(arr2.get(k + 1));
					arrtemp.add(arr2.get(k + 2));

					boolean b2 = false;
					for (int i = 0; i < 2 && !b2; i++) {
						String s = arrtemp.get(i);
						if (s.contains(checkedDate)) {
							b2 = true;
						}
					}

					if (!b2) {
						maxtemp2 += 1;
						if (maxtemp2 >= max2) {
							max2 = maxtemp2;
						}
					} else {
						maxtemp2 = 0;
					}
				}
			}

			if (max2 <= 1) {
				String ketquaphantich = "." + selectedD + " has " + checkedDate
						+ " in +2(" + max2 + ")";
				tfKetquaPhantich_v2.setText(ketquaphantich);

				return ketquaphantich;
			} else {
				for (int k = 0; k < loops; k++) {
					if (arr1.get(k).contains(selectedD)) {
						List<String> arrtemp = new ArrayList<String>();
						arrtemp.add(arr2.get(k + 1));
						arrtemp.add(arr2.get(k + 2));
						arrtemp.add(arr2.get(k + 3));

						boolean b3 = false;
						for (int i = 0; i < 3 && !b3; i++) {
							String s = arrtemp.get(i);
							if (s.contains(checkedDate)) {
								b3 = true;
							}
						}

						if (!b3) {
							maxtemp3 += 1;
							if (maxtemp3 >= max3) {
								max3 = maxtemp3;
							}
						} else {
							maxtemp3 = 0;
						}
					}
				}

				if (max3 <= 1) {
					String ketquaphantich = "." + selectedD + " has "
							+ checkedDate + " in +3(" + max3 + ")";
					tfKetquaPhantich_v2.setText(ketquaphantich);

					return ketquaphantich;
				} else {
					for (int k = 0; k < loops; k++) {
						if (arr1.get(k).contains(selectedD)) {
							List<String> arrtemp = new ArrayList<String>();
							arrtemp.add(arr2.get(k + 1));
							arrtemp.add(arr2.get(k + 2));
							arrtemp.add(arr2.get(k + 3));
							arrtemp.add(arr2.get(k + 4));

							boolean b4 = false;
							for (int i = 0; i < 4 && !b4; i++) {
								String s = arrtemp.get(i);
								if (s.contains(checkedDate)) {
									b4 = true;
								}
							}

							if (!b4) {
								maxtemp4 += 1;
								if (maxtemp4 >= max4) {
									max4 = maxtemp4;
								}
							} else {
								maxtemp4 = 0;
							}
						}
					}

					if (max4 <= 1) {
						String ketquaphantich = "." + selectedD + " has "
								+ checkedDate + " in +4(" + max4 + ")";
						tfKetquaPhantich_v2.setText(ketquaphantich);

						return ketquaphantich;
					} else {
						String ketquaphantich = ".";
						tfKetquaPhantich_v2.setText(ketquaphantich);

						return ketquaphantich;
					}
				}
			}
		}
	}

	private void runallDD() {
		StringBuilder sb = new StringBuilder();
		resetAllDDBtn();

		for (int i = 1; i <= 30; i++) {
			sb.append(analize_v2(AAA.toWords(i), null) + "\n");
		}

		selectedDD = "";
		this.ddAll.setBackground(Color.blue);
		this.ddAll.setForeground(Color.white);
		if (sb.toString().contains("ERROR")) {
			tfKetquaPhantich_v2.setText("Chua chon ngay");
		} else {
			tfKetquaPhantich_v2.setText("Execute all !");
			area1.setText(sb.toString());
			area2.setText("");
		}
	}
}
