package api;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); // 리스트 형으로 Upcasting하여 받은
														// 이유 아래의 메소드를 사용하는 곳에서
														// 알 수 있다.

		// 오른쪽 <> 값을 생략하는 것은 java 7th 부터 가능하다.
		list.add("조지클루니");
		printStr(list);
		list.add("브레드 피트");
		printStr(list);
		list.add("디카프리오");
		printStr(list);
		list.add("지웅지웅");
		printStr(list);
	}

	private static void printStr(List list) { // 만약 ArrayList 형으로 받았다면 이 곳에는
												// ArrayList 밖에 들어오지 않는다.

		for (Object name : list) { // <> 설정하지 않았을 때 Object로 받을 수 있다.
									// Object를 <>에 자료형을 설정해주면 해당 형태로 받을 수 있다.
			System.out.print(name + "\t");
		}
		// for (int i = 0; i < list.size(); i++) {
		// System.out.print(list.get(i)+" \t");
		// }
		System.out.println();
	}
}
