package basic.exam;

import java.util.Scanner;

public class ArithmaticTest {
	public static void main(String[] args) {
		// 산술연산
		// Shift + F2를 누르면 Manual로 가게 된다.
		// Organize import 라고 한다.
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.print("a : ");
		a = sc.nextInt();
		System.out.print("b : ");
		b = sc.nextInt();

		// Alt + Shift + A를 누르면 열 모드로 사용
		// 같은 자료형으로 연산을 수행할 때는 그 자료형의 값이 출력된다.
		// 다른 자료형일 경우 조금 더 많은 자리 수를 표현하는 자료형으로 출력된다.
		System.out.println(a + "+" + b + "=" + (a + b));
		System.out.println(a + "-" + b + "=" + (a - b));
		System.out.println(a + "*" + b + "=" + (a * b));
		System.out.println(a + "/" + b + "=" + (a / b));
		System.out.println(a + "%" + b + "=" + (a % b));
	}
}
