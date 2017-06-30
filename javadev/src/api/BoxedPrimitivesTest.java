package api;

public class BoxedPrimitivesTest {
	public static void main(String[] args) {

		// nf -> new feature

		Integer i = new Integer(10);
		Integer i2 = 10; // java 5th nf, auto boxing

		int i3 = i; // java 5th nf, auto unboxing

		Object i4 = 10; // java 5th nf, auto boxing

		int i5 = (int) i4; // java 7th nf

		int i6 = (Integer) i4; // java 5~6th nf

		// boxed Primitives를 이용할 때 사용하는 메소드
		int i7 = Integer.parseInt("100");

		long l1 = Long.parseLong("100");
	}
}
