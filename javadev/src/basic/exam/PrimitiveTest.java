package basic.exam;

public class PrimitiveTest {
	public static void main(String[] args) {
		// 사용은 1bit만 하지만 주소 할당 체계가 1byte씩이라 7bit이 낭비
		/*
		 * Java에는 8가지의 기본 자료형이 있다.
		 */
		// 문자형 - char
		// 숫자형 - byte, short, int, long, float, double
		// 논리형 - boolean
		// *
		boolean b = true;
		System.out.println("b = " + b);
		// */

		// -128 ~ 127
		// *
		byte b2 = 127;
		System.out.println("b2 = " + b2);
		// */

		// -2147483648 ~ 2147483647 대략 +-20억의 크기
		// *
		int i = 2147483647;
		System.out.println("i = " + i);
		// */

		// -32768 ~ 32767
		// *
		short s = 32767;
		System.out.println("s = " + s);
		// */

		// 대략 +-900경의 크기
		// 대문자 L을 붙여서 long형의 정수임을 알려준다.
		// 붙이지 않을 경우 기본이 int type이라 error가 발생
		// *
		long l = 2147483648L;
		System.out.println("l = " + l);
		// */

		// char는 UniCode를 지원하기 위해서 character 하나 당 2byte 할당
		// *
		char c = '가';
		System.out.println("c = " + c);
		// */

		// 8byte 할당
		// *
		double d = 3.1415926535;
		System.out.println("d = " + d);
		// */

		// double의 절반 크기 4byte
		// *
		float f = 3.1415926535f;
		System.out.println("f = " + f);
		// */

		// 다음과 같은 문자들을 escape sequence라고 한다.
		System.out.println("가\t나\t다");
		System.out.println("가	나	다");
		System.out.println("\"\\\\\"");
		System.out.print("a");
		System.out.print("b");

		
		
		
	}
}
