package api;

public class StringTest5 {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("실수란 신을 용서하는 인간의 행위이다.");
		// String class와 달리 바로 수정이 된다.
		str.replace(4, 6, "가드를");
		System.out.println(str);

		str.insert(13, "모든");
		System.out.println(str);

		str.delete(13, 15);
		System.out.println(str);
	}
}
