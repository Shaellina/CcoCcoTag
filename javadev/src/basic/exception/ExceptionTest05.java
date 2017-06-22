package basic.exception;

public class ExceptionTest05 {

	/*************************************************main*************************************************/
	
	public static void main(String[] args) {
		try {
			System.out.println("a() 호출전"); 				// <--------------------------------------- 1
			a();							  				// <--------------------------------------- 2
			System.out.println("a()호출후"); 				// <--------------------------------------- 13
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e){
			System.out.println("메인 메서드의 catch블럭");
			e.printStackTrace();
		} finally {
			System.out.println("메인 메서드의 finally블럭");// <--------------------------------------- 14
		}
		System.out.println("수행완료");						// <--------------------------------------- 15
	}

	/******************************************************************************************************/
	/************************************************others************************************************/
	/******************************************************************************************************/
	
	public static void a() {
		try {
			System.out.println("b() 호출전"); 				// <--------------------------------------- 3
			b();							  				// <--------------------------------------- 4
			System.out.println("b()호출후");
		} catch (ClassCastException e) {					// <--------------------------------------- 8		error 예외처리 불가, 발생한 에러 처리가 안됨
			e.printStackTrace();
		} catch (Exception e){								// <--------------------------------------- 9		error 예외처리 가능!, 
															//													Exception 이 Exception들의 superclass라서
			System.out.println("a메서드의 catch블럭");		// <--------------------------------------- 10
			e.printStackTrace();							// <--------------------------------------- 11
		} finally {
			System.out.println("a메서드의 finally블럭");	// <--------------------------------------- 12
		}
	}

	/******************************************************************************************************/
	
	public static void b() {
		try {
			System.out.println("c() 호출전"); 				// <--------------------------------------- 5
			int x = 1;
			int y = 0;
			int z;
			z = x / y;										// <--------------------------------------- 6		error 발생
			System.out.println(z);			  				
			c();							  
			System.out.println("c()호출후");
		} catch (NumberFormatException e) {	  				// <--------------------------------------- NumberFormatException 대신 ArithmeticException으로 했다면
			e.printStackTrace();							//											예외를 처리하고 계속 수행 가능

		} finally {
			System.out.println("b메서드의 finally블럭");	// <--------------------------------------- 7
		}
	}

	/******************************************************************************************************/
	
	public static void c() {
		try {
			System.out.println("d() 호출전"); 
			d();							  				
			System.out.println("d()호출후");
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} finally {
			System.out.println("c블럭");
		}
	}
	
	/******************************************************************************************************/

	public static void d() {
		try {
			System.out.println("나누기전"); 				
			int x = 1;
			int y = 1;
			System.out.println(x / y);						
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} finally {
			System.out.println("d블럭");
		}
	}
}
