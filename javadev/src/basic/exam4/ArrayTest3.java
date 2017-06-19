package basic.exam4;

public class ArrayTest3 {
	public static void main(String[] args) {
		int[][] score = { { 100, 90, 80, 70 }, { 90, 80, 70, 60 }, { 80, 70, 60, 50 } };

		int rowlen = score.length;

		System.out.println("국어\t영어\t수학\t철학\t총점\t평균");

		for (int row = 0; row < rowlen; row++) {
			int sum = 0;
			for (int col = 0; col < score[row].length; col++) {
				System.out.print(score[row][col] + "\t");
				sum += score[row][col];
			}
			System.out.print(sum + "\t" + sum / 4 + "\n");
		}
	}
}
