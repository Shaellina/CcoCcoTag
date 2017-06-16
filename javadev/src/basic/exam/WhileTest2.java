package basic.exam;

public class WhileTest2 {
	public static void main(String[] args) {
		int i = 1;
		while (i < 11) {
			System.out.println(i * 10 + ":김지혁");
			i++;
		}
		System.out.println("종료");

		int j = 1, sum = 0;
		while (j <= 1000 / 3) {
			sum += j * 3;
			j++;
		}
		System.out.println("\n" + sum);
	}
}
