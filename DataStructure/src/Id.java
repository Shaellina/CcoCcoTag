
public class Id {
	public static void main(String[] args) {
		// int i = (int) (Math.random() * 26) + 97;
		int[] id = new int[6];
		for (int re = 0; re < 15; re++) {
			for (int idx = 0; idx < id.length; idx++) {
				System.out.print((char) ((Math.random() * 26) + 97));
			}
			System.out.println();
		}
	}
}
