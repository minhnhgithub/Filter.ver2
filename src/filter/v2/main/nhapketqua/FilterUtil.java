package filter.v2.main.nhapketqua;

import filter.v2.common.AAA;
import filter.v2.utils.IO;

public class FilterUtil {
	public static void export() {
		String str = (String) IO.read(AAA.IMPORT_PATH + "data").get(0);

		String DBG1 = str.substring(0, 10);

		String G2 = "";
		G2 = str.substring(10, 15) + "  " + str.substring(15, 20);

		String G31 = "";
		G31 = str.substring(20, 25) + "  " + str.substring(25, 30) + "  "
				+ str.substring(30, 35);

		String G32 = "";
		G32 = str.substring(35, 40) + "  " + str.substring(40, 45) + "  "
				+ str.substring(45, 50);

		String G41 = "";
		G41 = str.substring(50, 54) + "  " + str.substring(54, 58);

		String G42 = "";
		G42 = str.substring(58, 62) + "  " + str.substring(62, 66);

		String G51 = "";
		G51 = str.substring(66, 70) + "  " + str.substring(70, 74) + "  "
				+ str.substring(74, 78);

		String G52 = "";
		G52 = str.substring(78, 82) + "  " + str.substring(82, 86) + "  "
				+ str.substring(86, 90);

		String G6 = "";
		G6 = str.substring(90, 93) + "  " + str.substring(93, 96) + "  "
				+ str.substring(96, 99);

		String G7 = "";
		G7 = str.substring(99, 101) + "  " + str.substring(101, 103) + "  "
				+ str.substring(103, 105) + "  " + str.substring(105, 107);

		StringBuilder sb1 = new StringBuilder();
		sb1.append(DBG1).append("\n");
		IO.writeSb(sb1, AAA.IMPORT_PATH + "DBG1_" + IRun.month + "_"
				+ IRun.year);

		StringBuilder sb2 = new StringBuilder();
		sb2.append(G2).append("\n");
		IO.writeSb(sb2, AAA.IMPORT_PATH + "G2_" + IRun.month + "_" + IRun.year);

		StringBuilder sb3 = new StringBuilder();
		sb3.append(G31).append("\n");
		sb3.append(G32).append("\n");
		IO.writeSb(sb3, AAA.IMPORT_PATH + "G3_" + IRun.month + "_" + IRun.year);

		StringBuilder sb4 = new StringBuilder();
		sb4.append(G41).append("\n");
		sb4.append(G42).append("\n");
		IO.writeSb(sb4, AAA.IMPORT_PATH + "G4_" + IRun.month + "_" + IRun.year);

		StringBuilder sb5 = new StringBuilder();
		sb5.append(G51).append("\n");
		sb5.append(G52).append("\n");
		IO.writeSb(sb5, AAA.IMPORT_PATH + "G5_" + IRun.month + "_" + IRun.year);

		StringBuilder sb6 = new StringBuilder();
		sb6.append(G6).append("\n");
		IO.writeSb(sb6, AAA.IMPORT_PATH + "G6_" + IRun.month + "_" + IRun.year);

		StringBuilder sb7 = new StringBuilder();
		sb7.append(G7).append("\n");
		IO.writeSb(sb7, AAA.IMPORT_PATH + "G7_" + IRun.month + "_" + IRun.year);
	}
}