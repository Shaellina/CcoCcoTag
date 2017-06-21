package oop.exam6;

public abstract class Shape { // abstract의 메소드를 1개라도 가지려면 class도 abstract가 되어야
								// 한다.
	double res;

	public abstract void area(); // abstract 로 만들어서 강제로 상속하는 것들의 규칙을 정해준다.
}
