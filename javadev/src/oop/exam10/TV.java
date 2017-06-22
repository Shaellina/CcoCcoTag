package oop.exam10;

public interface TV { // abstract가 생략됨
						// interface 내부의 method는 모두 abstract method이다.
	public void powerOn();

	public void powerOff();

	public void channelUp();

	public void channelDown();

	public void soundUp();

	public void soundDown();

	public void setSpeaker(Speaker speaker);
}
