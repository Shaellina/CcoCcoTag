package oop.exam10;

public class AppleSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("AppleSpeaker : 소리를 올립니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("AppleSpeaker : 소리를 내립니다.");
	}
}
