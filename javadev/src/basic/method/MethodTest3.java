package basic.method;

public class MethodTest3 {
	public static void main(String[] args) {
		int i = 10, j = 5;
		System.out.println(i + "+" + j + "=" + add(i, j));
		System.out.println(i + "-" + j + "=" + sub(i, j));
		System.out.println(i + "*" + j + "=" + mul(i, j));
		System.out.println(i + "/" + j + "=" + div(i, j) + "..." + mod(i, j));
	}

	private static int add(int i, int j) {
		return i + j;
	}

	private static int sub(int i, int j) {
		return i - j;
	}

	private static int mul(int i, int j) {
		return i * j;
	}

	private static int div(int i, int j) {
		return i / j;
	}

	private static int mod(int i, int j) {
		return i % j;
	}

}
