package api;

public class StringTest3 {
	public static void main(String[] args) {

		// 둘은 같은 것을 가리키고 있다.
		String str1 = "제이비는 몇살때부터 자바를 잘했나?";
		String str2 = "제이비는 몇살때부터 자바를 잘했나?";

		// string class는 수정을 가할 때 항상 복제를 한다.
		// str1과 str2 는 같은 것을 가리키고 있었다.
		System.out.println(str1 = str1.replace("몇살때", "언제"));
		// str1은 새로운 것을 가리키고 있고 str2는 이전의 것을 가리키고 있다.
		System.out.println(str1 == str2 ? "같다" : "다르다");
	}
}
