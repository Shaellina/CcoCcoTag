package basic.exam;

public class ConditionTest {
	public static void main(String[] args) {
		// 조건연산
		int n = 2;
		System.out.println(n == 1 ? "남자" : 
						   n == 3 ? "남자" :
						   n == 2 ? "여자" :
						   n == 4 ? "여자" :
							        "에러");
		
		System.out.println(n == 1 || n == 3 ? "남자" : 
						   n == 2 || n == 4 ? "여자" :
				                              "에러");
	}
}
