package basic.exception;

public class ExceptionTest01 {
	public static void main(String[] args) {
		String str = "ㅁㅁ";
		// System.out.println(str.toString());
		// String str이 heap에 있는 어떤 값을 가리키고 있어야하는데 없기 때문에 예외가 발생한다.
		
		/* java.Object
		 * 		Throwable
		 * 			Exception
		 * 				Null... and so on
		 */
		
		// *****************************************************************
		// multi-catch를 할 경우 superclass 일수록 아래 쪽에 작성해주어야 함
		// *****************************************************************

		// java 7 부터 catch 하나에서 여러개의 Exception 처리가 가능
		try {
			System.out.println(str.toString());
			// System.out.println(10 / 0);
			// throw new NullPointerException();
		} catch (NullPointerException | NumberFormatException e) {
			// } catch (Throwable e) { Throwable이 가장 superclass이다.
			// 하지만 Throwable은 구분하지 못한다.
			System.out.println("Null error");

			// AOP 방식으로 처리를 해야할 때 Throwable을 사용해야 한다.
			// e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Others error");
			// e.printStackTrace();
		} finally {
			// try-catch문을 수행하는 과정에서 마지막에 무조건 수행
			// catch에서 수행이 되었던 되지 않았던 마지막에 반드시 수행
			// 주로 자원 반납, 메모리 해지, 문자열 전송 중 flush하는 것
			// java 7이후로 AutoCloseable이라는 게 생겼음 -> finally를 생략하는 경향이 있음
			// try - with - resources Statement라고 불림
			// try () {} 로 사용하면서 () 안에 사용할 자원을 넣은 후 자동으로 close 해주게 됨
			System.out.println("무조건 수행");
		}
		System.out.println("종료");
	}
}
