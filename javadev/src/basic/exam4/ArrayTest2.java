package basic.exam4;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ArrayTest2 {
	public static void main(String[] args) {
		boolean[] b = new boolean[1];
		System.out.println(b[0]);

		char[] c = new char[1];
		System.out.println(c[0]);

		int[] i = new int[1];
		System.out.println(i[0]);

		short[] s = new short[1];
		System.out.println(s[0]);

		long[] l = new long[1];
		System.out.println(l[0]);

		byte[] by = new byte[1];
		System.out.println(by[0]);

		float[] f = new float[1];
		System.out.println(f[0]);

		double[] d = new double[1];
		System.out.println(d[0]);

		System.out.println("------------");
		// 객체들의 기본은 null이다.
		// 참조자료형의 경우 heap 에 넣게 된다.

		String[] st = new String[1];
		System.out.println(st[0]);

		BigDecimal[] bd = new BigDecimal[1];
		System.out.println(bd[0]);

		BigInteger[] bi = new BigInteger[1];
		System.out.println(bi[0]);

		Boolean[] bool = new Boolean[1];
		System.out.println(bool[0]);

	}
}
