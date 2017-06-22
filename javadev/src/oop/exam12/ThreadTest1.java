package oop.exam12;

public class ThreadTest1 implements Runnable {
	// Thread 가 생성되면 Stack이 생성되고 나머지 메모리 영역은 공유한다.
	public static void main(String[] args) {
		ThreadTest1 t = new ThreadTest1();
		
		Thread nt = new Thread(t);
		nt.start();
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + ":main()");
		}
		System.out.println("main() 종료");
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + ":run()");
		}
		System.out.println("run() 종료");
	}
}
