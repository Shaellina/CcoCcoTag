package oop.exam8;

public class Account {
	// int money1;
	// int money2;
	static int money1;
	static int money2;

	// method는 static area의 Class 안에만 존재
	// heap에 생긴 instance에는 property만 가지고 있다.
	// variable 중에 static이 붙은 것은 instance에서 관리하지 않고 static area에서 존재하게 된다.

	public Account() {
	}

	public Account(int money) {
		money1 += money;
		money2 += money;
	}
}
