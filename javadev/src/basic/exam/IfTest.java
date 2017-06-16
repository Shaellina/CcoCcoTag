package basic.exam;

import java.util.Scanner;

public class IfTest {
	public static void main(String[] args) {
		
//		int i = 2;
//		
//		if(i == 2)
//			System.out.println("여자");
		
		Scanner s = new Scanner(System.in);
		System.out.print("0 ~ 100 점 사이의 정수를 입력하세요 : ");
		int score = s.nextInt();

		if (score >= 90)
			System.out.println("A");
		else if (score >= 80)
			System.out.println("B");
		else if (score >= 70)
			System.out.println("C");
		else if (score >= 60)
			System.out.println("D");
		else
			System.out.println("F");
	}
}
