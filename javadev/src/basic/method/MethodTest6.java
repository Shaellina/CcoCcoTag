package basic.method;

public class MethodTest6 {
	public static void main(String[] args) {
		// print(1);
		// print(2, 3);
		// print(4, 5, 6);
		int i = 1_2345__________67_89;

		System.out.println(i);
		// String name = "최지웅";
		// print(name);
		// System.out.println(name);

		// String type 은 예외이다.

		// int[] lotto = { 1, 2, 3, 4, 5, 6 };
		//
		// swapRandom(lotto);
		// for (int k : lotto)
		// System.out.print(k + " ");
		int a = 10, b = 5;
		swapNumber(a, b);
		System.out.println(a + ", " + b);

	}

	private static void swapNumber(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	private static void swapRandom(int[] lotto) {
		int tmp = lotto[0];
		lotto[0] = lotto[5];
		lotto[5] = tmp;
		// 기본자료형은 안바뀐다.
		// 객체에 대해서만 바뀐다.
	}

	private static void print(String name) {
		name = "박병규";
	}

	private static void print(int... i) {
		// 자동으로 배열화 시킨다. java 5부터 갱신된 부분
		// String의 Template 때문에 java 6, 7을 주로 사용
		for (int j : i)
			System.out.print(j + "\t");

		for (int j = 0; j < i.length; j++) {
			System.out.print(j + "\t");
		}

		System.out.println();
	}

	// private static void print(int i, int j, int k) {
	// System.out.println(i + " " + j + " " + k);
	// }
	//
	// private static void print(int i, int j) {
	// System.out.println(i + " " + j);
	// }
	//
	// private static void print(int i) {
	// System.out.println(i);
	// }
}

/*
 * jdk 1.5 --> java 5
 * 
 * 
 */