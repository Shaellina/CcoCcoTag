package basic.method;

public class MethodTest9 {
	public static void main(String[] args) {
		int[] n = { 100, 200 };

		// 참조 자료형의 경우 가리키는 새로운 주소값이 새로 생긴다.

		swapFunction(n); // stack 에서 array n 을 가리키는 새로운 변수가 선언된다.
		// call by reference : 참조에 의한 호출
		System.out.println(n[0] + ", " + n[1]);
	}

	private static void swapFunction(int[] n) { // <- 여기 n이 새롭게 만들어지는 변수이다.
		int tmp = n[0];
		n[0] = n[1];
		n[1] = tmp;
	}
}
