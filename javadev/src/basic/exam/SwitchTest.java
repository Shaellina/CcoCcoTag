package basic.exam;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// Q4
		/*
		 * switch (n) { case 1: case 3: System.out.println("남자"); break; case 2:
		 * case 4: System.out.println("여자"); break; default:
		 * System.out.println("에러"); break; }
		 */
		// Q5
		/*
		 * int n = s.nextInt(); switch (n) { case 100: case 99: case 98: case
		 * 97: case 96: case 95: case 94: case 93: case 92: case 91: case 90:
		 * System.out.println("A"); break; case 89: case 88: case 87: case 86:
		 * case 85: case 84: case 83: case 82: case 81: case 80:
		 * System.out.println("B"); break; case 79: case 78: case 77: case 76:
		 * case 75: case 74: case 73: case 72: case 71: case 70:
		 * System.out.println("C"); break; case 69: case 68: case 67: case 66:
		 * case 65: case 64: case 63: case 62: case 61: case 60:
		 * System.out.println("D"); break; default: System.out.println("F");
		 * break; }
		 */

		System.out.print("가위는 1, 바위는 2, 보는 3을 입력하세요 > ");
		int n = s.nextInt();

		int c = (int) (Math.random() * 3) + 1;
		String[] rsp = { "가위", "바위", "보" };
		System.out.println("you : " + rsp[n - 1]);
		System.out.println("com : " + rsp[c - 1]);
		String[] result = { "무승부", "당신의 승리", "컴퓨터의 승리" };
		switch (c) {
		case 1:
			switch (n) {
			case 1:
				System.out.print(result[0]);
				break;
			case 2:
				System.out.print(result[1]);
				break;
			case 3:
				System.out.print(result[2]);
				break;
			}
			break;
		case 2:
			switch (n) {
			case 1:
				System.out.print(result[2]);
				break;
			case 2:
				System.out.print(result[0]);
				break;
			case 3:
				System.out.print(result[1]);
				break;
			}
			break;
		case 3:
			switch (n) {
			case 1:
				System.out.print(result[1]);
				break;
			case 2:
				System.out.print(result[2]);
				break;
			case 3:
				System.out.print(result[0]);
				break;
			}
			break;
		}
		System.out.println("입니다.");
	}
}
