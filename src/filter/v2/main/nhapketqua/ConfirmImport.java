package filter.v2.main.nhapketqua;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import filter.v2.common.AAA;
import filter.v2.utils.IO;

public class ConfirmImport extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Label lblMess = new Label("             Import ?");
	Button btn_Yes = new Button("YES");
	Button btn_No = new Button("NO");

	Panel btnPanel = new Panel();

	public ConfirmImport(String title) {
		super(title);

		setBackground(Color.PINK);

		this.btnPanel.setLayout(new FlowLayout());
		this.btnPanel.add(this.btn_Yes);
		this.btnPanel.add(this.btn_No);

		setLayout(new BorderLayout());
		add(this.lblMess, "North");
		add(this.btnPanel, "Center");

		this.btn_Yes.addActionListener(this);
		this.btn_No.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ConfirmImport.this.dispose();
			}
		});
		setLocation(600, 200);
		setSize(130, 100);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btn_Yes) {
			int day = AAA.sToI(NhapKetQua.impDay);
			IRun.x_import(day, NhapKetQua.impMonth, NhapKetQua.impYear,
					NhapKetQua.strImport);

			if (day < 11 && !NhapKetQua.impMonth.equals("01")) {
				String newMonth = AAA
						.toWords(AAA.sToI(NhapKetQua.impMonth) - 1);
				AAA.applyPath(newMonth, NhapKetQua.impYear);
				ArrayList<String> exists = IO
						.read(AAA.PRIMITIVE_PATH + "exist");
				int newDay = AAA.sToI(exists.get(exists.size() - 1)) + 1;
				IRun.x_import(newDay, newMonth, NhapKetQua.impYear,
						NhapKetQua.strImport);
			}

			dispose();

			NhapKetQua
					.callImport("                           Import successful !!!!");
		} else if (e.getSource() == this.btn_No) {
			dispose();
			NhapKetQua.callImport(null);
		}
	}

	public static void callConfirmImport() {
		ConfirmImport c = new ConfirmImport("Confirm");
		c.setVisible(true);
	}
}