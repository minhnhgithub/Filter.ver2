package filter.v2.main.loroi;

import filter.v2.common.AAA;
import filter.v2.common.Check;
import filter.v2.common.Target;

public class Loroi_Prc {

	private Target objTarget = new Target();

	public String x_run(String giai, String month, String year, int range) {
		AAA.applyPath(month, year);
		final StringBuilder sb = new StringBuilder(
				"Date\t Giai\tTarget\tRange\tAfter\tStatus\n");
		for (int day = 1; day <= 31; day++) {
			try {
				String sss = objTarget.getTarget(giai, day, month, year);
				String sGiai = objTarget
						.getTarget(giai, day, month, year, true);
				int res = Check.rangeDay_returnDay(range, day, sss);
				String sRes = String.valueOf(res);
				if (res == -1) {
					sRes = " -";
				} else if (res == 100) {
					sRes = "...";
				}

				final String check = (res == -1 || res == 100) ? "   ---"
						: "   OK";
				sb.append("  " + day + "\t" + sGiai + "\t   " + sss + "\t    "

				+ range + "\t    " + sRes + "\t" + check);

				sb.append("\n");
			} catch (Exception e) {
			}
		}

		return sb.toString();
	}
}
