package api;

public class StringTest4 {
	public static void main(String[] args) {
		String str = "실수란 신을 용서하는 인간의 행위이다.";
		System.out.println(str.charAt(10));
		System.out.println(str.indexOf("는"));
		System.out.println(str.length());
		System.out.println(str.lastIndexOf("다")); // 오른쪽 부터 접근

		System.out.println(str.replace("인간", "용빈"));
		System.out.println("SilSu".toLowerCase());
		System.out.println("silSu".toUpperCase());
		System.out.println(str.substring(4, 6));
	}
}
