package filter.v2.main.dumbhead;

import java.util.ArrayList;

import filter.v2.common.AAA;
import filter.v2.utils.IO;

public class DumbHeadHelper {

	/**
	 * @param day
	 *            start by 1
	 */
	public static boolean isDumbHead(String head, int day, String month,
			String year) {
		AAA.applyPath(month, year);
		boolean result = true;
		try {
			ArrayList<String> listKetQua = AAA.sortArr(IO
					.read(AAA.PRIMITIVE_PATH + "v" + AAA.toWords(day)));
			for (String ketqua : listKetQua) {
				if (ketqua.substring(0, 1).equals(head))
					result = false;
			}
		} catch (Exception e) {
			return false;
		}

		return result;
	}
}
