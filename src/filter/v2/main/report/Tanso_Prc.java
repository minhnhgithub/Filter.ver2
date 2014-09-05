package filter.v2.main.report;

import filter.v2.common.AAA;
import filter.v2.common.Check;
import filter.v2.common.Target;

public class Tanso_Prc {

	private Target targetx = new Target();

	/**
	 * Chay phan ko ve
	 */
	public String x_1(String giai, String year, String fromMonth,
			String toMonth, int range, int addOptDate) {

		final StringBuilder sb = new StringBuilder();
		addOptDate -= 1;

		int loop = 12;
		if (toMonth != "") {
			loop = AAA.sToI(toMonth);
		}
		if (Integer.valueOf(fromMonth) > 1) {
			loop = loop - Integer.valueOf(fromMonth) + 1;
		}

		// Loop 12 months
		for (int i = 1; i <= loop; i++) {
			String month = AAA.toWords(Integer.valueOf(fromMonth) + i - 1);
			AAA.applyPath(month, year);
			sb.append("." + month + "/" + year.substring(2, 4) + "\t");

			for (int day = 1; day < 31; day++) {
				try {
					String target = targetx.getTarget(giai, day, month, year,
							false);
					int res = Check.rangeDay_returnDay(range, day, target,
							addOptDate);
					if (res == -1) {
						// FIXME
						String exactDate = AAA.returnExactlyDate(day, month,
								year);

						sb.append(exactDate + " ");
					}

				} catch (Exception e) {
				}
			}

			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * Chay phan ve luon
	 */
	public String x_2(String giai, String year, String fromMonth,
			String toMonth, int range, int addOptDate) {

		final StringBuilder sb = new StringBuilder();
		addOptDate -= 1;

		int loop = 12;
		if (toMonth != "") {
			loop = AAA.sToI(toMonth);
		}
		if (Integer.valueOf(fromMonth) > 1) {
			loop = loop - Integer.valueOf(fromMonth) + 1;
		}

		// Loop 12 months
		for (int i = 1; i <= loop; i++) {
			String month = AAA.toWords(Integer.valueOf(fromMonth) + i - 1);
			AAA.applyPath(month, year);
			sb.append("." + month + "/" + year.substring(2, 4) + "\t");

			for (int day = 1; day < 31; day++) {
				try {
					String target = targetx.getTarget(giai, day, month, year);
					int res = Check.rangeDay_returnDay(range, day, target,
							addOptDate);
					if (res == 1 + addOptDate) {
						String exactDate = AAA.returnExactlyDate(day, month,
								year);

						sb.append(exactDate + " ");
					}

				} catch (Exception e) {
				}
			}

			sb.append("\n");
		}

		return sb.toString();
	}
}
