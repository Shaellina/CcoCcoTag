package basic.exam3;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarExample {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		Scanner s = new Scanner(System.in);
		int y = s.nextInt();
		int m = s.nextInt();

		cal.set(Calendar.YEAR, y);
		cal.set(Calendar.MONTH, m - 1);
		cal.set(Calendar.DATE, 1);
		// cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		// GregorianCalendar gc = (GregorianCalendar)
		// GregorianCalendar.getInstance();
		// System.out.println(gc.getTime());

		// System.out.println("end date : " +
		// cal.getActualMaximum(Calendar.DATE));
		int last_day = cal.getActualMaximum(Calendar.DATE);
		int w = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("일 월 화 수 목 금 토");

		for (int l = 1; l < w; l++)
			System.out.print("   ");

		for (int d = 1; d <= last_day; d++) {
			System.out.print(d < 10 ? " " + d + " " : d + " ");
			System.out.print(cal.get(Calendar.DAY_OF_WEEK) % 7 == 0 ? "\n" : "");
			cal.add(Calendar.DATE, 1);
		}
	}
}
