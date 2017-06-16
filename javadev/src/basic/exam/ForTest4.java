package basic.exam;

public class ForTest4 {
	public static void main(String[] args) {
		for (int t = 0; t < 2; t++) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 2+(4*t); j <= 5+(4*t); j++)
					System.out.print(j + "*" + i + "=" + j * i + "\t");
				System.out.println();
			}
			System.out.println();
		}
	}
}
