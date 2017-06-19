package basic.exam4;

public class ArrayTest4 {
	public static void main(String[] args) {
		int[][][] score = { { { 100, 90, 80, 70 }, { 90, 80, 70, 60 }, { 80, 70, 60, 50 } },

				{ { 100, 100, 90, 80 }, { 100, 90, 80, 70 }, { 90, 80, 70, 60 } } };

		int[][] total = new int[3][6];

		for (int tab = 0; tab < score.length; tab++) {
			System.out.println((tab + 1) + "학기 성적표");
			System.out.println("국어\t영어\t수학\t철학\t총점\t평균");
			for (int row = 0; row < score[tab].length; row++) {
				int sum = 0;
				for (int col = 0; col < score[tab][row].length; col++) {
					System.out.print(score[tab][row][col] + "\t");
					sum += score[tab][row][col];
					total[row][col] += score[tab][row][col];
					total[row][4] += score[tab][row][col];
				}
				System.out.print(sum + "\t" + sum / 4 + "\n");
				total[row][5] = total[row][4] / 4;
			}
			System.out.println("\n");
		}

		System.out.println("총계\n국어\t영어\t수학\t철학\t총점\t평균");
		for (int[] row : total) {
			for (int sco : row) {
				System.out.print(sco + "\t");
			}
			System.out.println();
		}
	}
}
