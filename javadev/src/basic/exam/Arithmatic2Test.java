package basic.exam;

import java.util.Scanner;

public class Arithmatic2Test {
	public static void main(String[] args) {
		// 논리연산
		Scanner s = new Scanner(System.in);
		System.out.print("i : ");
		int i = s.nextInt();
		System.out.print("j : ");
		int j = s.nextInt();

		System.out.println(i > j);
		System.out.println(i < j);
		System.out.println(i >= j);
		System.out.println(i <= j);
		System.out.println(i == j);
		System.out.println(i != j);
	}
}
