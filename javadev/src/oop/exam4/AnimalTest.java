package oop.exam4;

public class AnimalTest {
	public static void main(String[] args) {
		// sub type 인스턴스는 super type으로 참조 가능
		// 자동 형변환(묵시적 형변환) * Up Casting
		Animal animal = new Eagle();
		System.out.println(animal);

		// super type 인스턴스는 sub type으로 참조가 불가능
		// 단 강제 형변환 했을 떄는 가능하다.
		// 하지만 sub type에서 정의한 메소드나 속성에 대해서는 접근이 불가하다.
		// 강제 형변환(명시적 형변환) *Down Casting
		// Bird bird = (Bird) new Animal(); // 실행 시에 에러가 발생
		// System.out.println(bird);

		// 다음과 같을 때 가능

		// super type으로 참조하고 있을 떄 Down Casting이 가능하다.
		// Down Casting을 하려고 할 때 sub type까지만 해야한다.
		// 만약 그 하위 sub type으로 참조하려고 한다면 Error가 발생한다.

		// Condor condor = new Condor();
		Animal condor = new Condor();
		Condor condor2 = (Condor) condor;
		System.out.println(condor2);

		Animal eagle = new Eagle();
		// Tiger tiger = (Tiger) eagle;
		// System.out.println(tiger);

		// UpCasting 과 DownCasting은 상속 관계에서만 가능하다.

	}
}
