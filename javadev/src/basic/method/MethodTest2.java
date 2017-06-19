package basic.method;

public class MethodTest2 {

	int i; // class 에 대한 속성 property라고 함

	public static void main(String[] args) {
		print();
		print();
		print();

		print("yongbin"); // 실 매개변수
		print("heenam");
		print("hyojin");
	}

	// method를 behavior라고 함

	private static void print() {
		System.out.println("*********");
		System.out.println("* hello *");
		System.out.println("*********");
	}

	private static void print(String name) { // 형식 매개변수
		for (int i = 0; i < name.length() + 3; i++) {
			System.out.print("*");
		}
		System.out.println("*******");
		System.out.println("* hello " + name + " *");
		for (int i = 0; i < name.length() + 3; i++) {
			System.out.print("*");
		}
		System.out.println("*******");
	}
}
