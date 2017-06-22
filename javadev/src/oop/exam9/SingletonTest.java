package oop.exam9;

public class SingletonTest {
	public static void main(String[] args) {
		// Singleton s1 = new Singleton();
		// System.out.println(s1 + ":" + s1.hashCode());
		// Singleton s2 = new Singleton();
		// System.out.println(s2 + ":" + s2.hashCode());
		Singleton s1 = Singleton.getInstance();
		System.out.println(s1 + ":" + s1.hashCode());
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2 + ":" + s2.hashCode());
		Singleton s3 = Singleton.getInstance();
		System.out.println(s3 + ":" + s3.hashCode());
	}
}
