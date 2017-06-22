package basic.exception;

public class ExceptionTest02 {
	public static void main(String[] args) {
		try {
			throwException(); // <---------------------------- 호출한 녀석
		} catch (Exception e) { // 최소한 throws 한 것보다 같거나 superclass를 넣어주어야 한다.
			e.printStackTrace();
		}
		System.out.println("종료");
	}

	private static void throwException() throws Exception { // 내가 직접 예외 처리 안하고
															// 나를 호출한 녀석에게 넘기겠다.
		String str = null;
		throw new Error(); // 예외 강제 발생, 예외처리 강제 발생을 통해 실제 예외 상황을 만들어준다.
		// 예외 상황을 가정하고 실제로 만들어주기 어려우니까 software적으로 만들어주는 것이다.
		// Error로 했을 경우 Throwable로 잡아주어야 예외처리가 가능하다.
		// System.out.println(str.toString());
	}
}
