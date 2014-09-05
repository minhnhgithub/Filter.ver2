package filter.v2.main.x80;

import filter.v2.common.AAA;
import filter.v2.common.Check;
import filter.v2.common.Target;

public class TongHnayChamHsau_Prc {

	private Target target = new Target();

	public String x_run(String giai, String month, String year) {

		AAA.applyPath(month, year);

		final StringBuilder sb = new StringBuilder(
				"Date\t  Giai\t   DB\tCham\tRange\n");
		for (int day = 1; day < 32; day++) {
			try {
				final String sGiai = target.getTarget(giai, day, month, year,
						true);
				final String db = target
						.getTarget("DB", day, month, year, true);
				final String cham = AAA.iToS(AAA.getSum(target.getTarget(giai,
						day, month, year)) % 10);

				int result = Check.chamDe_returnDay(day, cham);
				String sResult = AAA.iToS(result);
				if (result == -1) {
					sResult = "-";
				} else if (result == 100) {
					sResult = "...";
				}

				sb.append("  " + day + "\t" + sGiai + "\t" + db + "\t       " + cham
						+ "\t      " + sResult + "\n");
			} catch (Exception e) {
			}
		}

		return sb.toString();
	}
}
