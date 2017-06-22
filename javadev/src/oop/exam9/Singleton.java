package oop.exam9;

/*
 * 1. 생성자의 접근제어자를 private로 만든다.
 *    아무곳에서나 인스턴스 생성하는 것을 금지
 * 2. 자기 자신의 인스턴스를 참조하는 공유변수를 선언하고 인스턴스를 생성 후 참조
 * 3. 공유변수를 리턴하는 getter메소드 작성
 * 4. 사용 : 수행하는 클래스에서 new 없는 상태로 클래스이름.getter메소드() 형태로 인스턴스를 생성하여 사용
*/

public class Singleton {
	private static Singleton singleton = null;

	private Singleton() {
		// This is SIngleton!!!
		// System.out.println("test start");
	}

	public static Singleton getInstance() {
		if (singleton == null)
			singleton = new Singleton();
		return singleton;
	}

	@Override
	public String toString() {
		return "Singleton!";
	}
}
