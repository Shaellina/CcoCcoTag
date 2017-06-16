package basic.exam;

public class ForTest2 {
	public static void main(String[] args) {
		int sum = 0;

		// Q1
		for (int i = 1; i <= 1000 / 3; i++)
			sum += i * 3;
		System.out.println(sum);

		// Q2
		for (int i = 1; i <= 1000; i++)
			sum += i % 3 == 0 ? i : 0;
		System.out.println(sum);
	}
}
