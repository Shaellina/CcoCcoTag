package oop.exam8;

public class ClassName {
	int field1;

	public void method1() {}

	static int field2;

	static void method2() {}

	static {
		// 이 곳 안에서 static variable과 static method만 사용 할 수 있다.
		// 메모리에 로딩할 때 static이 아닌 variable은 선언이 되어있지 않으므로 컴파일 에러가 발생

		// field1 = 10;
		// method1();
		field2 = 20;
		method2();
	}
}
