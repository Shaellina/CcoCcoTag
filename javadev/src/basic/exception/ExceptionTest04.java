package basic.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest04 {
	public static void main(String[] args) {
		int n = -1, count = 0;
		Scanner s = new Scanner(System.in);
		do {
		System.out.print("1~99 사이의 정수를 입력하세요 > ");
		
		try {
			n = s.nextInt();
			if (!(0 < n && n < 100)) {
				throw new InputMismatchException("잘못된 입력입니다.");
			}
			System.out.println("입력된 값은 " + n);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		}while(!(0 < n && n < 100));
		
		int r = (int) (Math.random() * 99) + 1;

		System.out.println("1~99 사이의 정수를 입력하세요 > ");
		while (r != (n = s.nextInt())) {
			System.out.print(n < r ? "Up" : "Down");
			count++;
		}

		System.out.println("축하합니다. " + count + " 번 만에 맞추었습니다.");
	}
}
