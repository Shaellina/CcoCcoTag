package basic.exam3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataExample {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();

		System.out.println(strNow1);

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY / MM / dd hh:mm:ss");
		// hh -> 12 시간 기준, HH -> 24 시간 기준
		System.out.println(sdf.format(now));

		Calendar cal = Calendar.getInstance();

		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.YEAR) + " / " + (cal.get(Calendar.MONTH) + 1) + " / "
				+ cal.get(Calendar.DAY_OF_MONTH) + " || " + cal.get(Calendar.DATE));

		// Calendar.DATE와 Calendar.DAY_OF_MONTH는 같다.

		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		// 일, 월, 화, 수, 목, 금, 토
		// 1 2 3 4 5 6 7

		System.out.println(cal.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후");
		cal.add(Calendar.DATE, 1);
		System.out.println(cal.getTime());
	}
}
