package api;

public class StringTest2 {
	public static void main(String[] args) {

		// 하나가 생성 되어 있는데 같은 내용을 참조하게 될 경우 다시 생성 하지 않는다.
		String str1 = "안녕하세요";
		String str2 = "안녕하세요";

		// new를 이용해서 새로운 인스턴스를 만들어서 집어 넣게 된다.
		String str3 = new String("안녕하세요");
		String str4 = new String("안녕하세요");

		System.out.println("str1 == str2");
		if (str1 == str2) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}
		System.out.println("str1 eqauls str2");
		if (str1.equals(str2)) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}

		System.out.println("str3 == str4");
		if (str3 == str4) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}
		System.out.println("str3 equals str4");
		if (str3.equals(str4)) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}
	}
}
