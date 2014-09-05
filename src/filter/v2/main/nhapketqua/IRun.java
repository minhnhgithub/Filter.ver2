package filter.v2.main.nhapketqua;

import java.util.ArrayList;

import filter.v2.common.AAA;
import filter.v2.utils.IO;

public class IRun {

	// public static ArrayList<String> v_today = new ArrayList<String>();
	// public static ArrayList<String> existList = null;

	public static String month;
	public static String year;

	public static void x_import(int day, String ssmonth, String ssyear,
			String str) {
		month = ssmonth;
		year = ssyear;
		AAA.applyPath(month, year);

		str = doGetStringImport(str);

		doImportToPrimitive(day, str);

		ArrayList<String> arrtemp = new ArrayList<String>();
		arrtemp.add(str);
		IO.write(arrtemp, AAA.IMPORT_PATH + "data");
		FilterUtil.export();
		StringBuilder sb2 = new StringBuilder(String.valueOf(day));
		sb2.append("\n");
		IO.writeSb(sb2, AAA.PRIMITIVE_PATH + "exist");
	}

	private static void doImportToPrimitive(int day, String str) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(str.substring(3, 5));
		arr.add(str.substring(8, 10));
		arr.add(str.substring(13, 15));
		arr.add(str.substring(18, 20));
		arr.add(str.substring(23, 25));
		arr.add(str.substring(28, 30));
		arr.add(str.substring(33, 35));
		arr.add(str.substring(38, 40));
		arr.add(str.substring(43, 45));
		arr.add(str.substring(48, 50));

		arr.add(str.substring(52, 54));
		arr.add(str.substring(56, 58));
		arr.add(str.substring(60, 62));
		arr.add(str.substring(64, 66));
		arr.add(str.substring(68, 70));
		arr.add(str.substring(72, 74));
		arr.add(str.substring(76, 78));
		arr.add(str.substring(80, 82));
		arr.add(str.substring(84, 86));
		arr.add(str.substring(88, 90));

		arr.add(str.substring(91, 93));
		arr.add(str.substring(94, 96));
		arr.add(str.substring(97, 99));

		arr.add(str.substring(99, 101));
		arr.add(str.substring(101, 103));
		arr.add(str.substring(103, 105));
		arr.add(str.substring(105, 107));

		IO.write(arr, AAA.PRIMITIVE_PATH + "v" + AAA.toWords(day));
	}

	private static String doGetStringImport(String str) {
		char[] all = str.toCharArray();
		String s = "";
		for (int i = 0; i < all.length; i++) {
			if (Character.isDigit(all[i])) {
				s = s + all[i];
			}
		}

		return s;
	}
}
