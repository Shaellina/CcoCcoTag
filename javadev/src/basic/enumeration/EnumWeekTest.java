package basic.enumeration;

import java.util.Calendar;

public class EnumWeekTest {
	public static void main(String[] args) {

		Week today = null;

		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);

		switch (week) {
		case 1:
			today = Week.Sunday;
			break;
		case 2:
			today = Week.Monday;
			break;
		case 3:
			today = Week.TuesDay;
			break;
		case 4:
			today = Week.Wednesday;
			break;
		case 5:
			today = Week.Thursday;
			break;
		case 6:
			today = Week.Friday;
			break;
		case 7:
			today = Week.Saturday;
			break;
		}

		System.out.println(week);
		System.out.println("오늘 요일 : " + today.name());
		System.out.println(today.ordinal());
		// enum으로 만들어진 Week 상에 저장된 순서에 대해서 나오는데 index가 0번부터 계산된다.

		System.out.println(today.compareTo(Week.Thursday));
		System.out.println(today.compareTo(Week.Wednesday));
		System.out.println(today.compareTo(Week.Saturday));

		// compareTo() 는 오늘 날짜 - 해당 날짜로 계산
		// 미래의 날짜와 비교 시 -값 나오고 과거의 날짜와 비교 시 +값 나온다.
		System.out.println(today.ordinal());
		System.out.println(today.ordinal());

		Week[] days = Week.values();
		for(Week day:days)
			System.out.println(day);
		
		// name이 default이고 값을 그대로 저장한다.
		if (today == Week.Sunday) {
			System.out.println("일요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바 공부합니다.");
		}
	}
}
