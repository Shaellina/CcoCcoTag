package api;

public class StringTest {
	public static void main(String[] args) {
		// ""은 문자열 인스턴스이다. 바로 Heap으로 들어간다.
		String str = "Hello"; // Heap에 있는 Hello를 참조한다.
		str += " World"; // 원본 데이터는 그대로 두고 따로 2개를 더해서 새로운 문자열을 만든다.
							// 원본 데이터는 바로 삭제 되지 않는다.
		str += "!";

		// 이러한 방법으로 문자열을 짜르고 붙이게 되면 원래 있던 메모리의 그 자리에 있지 않고 복제해서 사용한다.
		// 그 결과, 메모리의 누수가 발생

		// 해결하기 위해서 StringBuffer나 StringBuilder를 사용해야 한다.
		// 이 두 가지를 사용한다면 수정을 하더라도, 즉 늘리고 자르더라도 문제가 없다.

		// StringBuffer는 미리 일정 메모리 할당량을 잡아두고 초과하면 새로운 Buffer 를 할당하고 두 개를 합친다.
		// Buffer를 계속 일정량 할당하므로써 메모리 누수를 막을 수 있다.
		
		// StirngBuilder는 

		// Thread-safe 라는 게 동기화 한다는 의미
		// 둘의 차이는 Synchronize 차이

		// str.length()는 문자열의 길이를 의미하지만
		// StringBuffer의 경우 capacity() 메소드로 Buffer 메모리를 얼마나 할당하고 있는지도 알 수 있다.

		// StringBuffer sbf = new StringBuffer();
		// StringBuilder sbl = new StringBuilder();

	}
}
