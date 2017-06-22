package basic.enumeration;

public class ComputerTest {
	public static void main(String[] args) {
		Computer com = new Computer();
		PowerState state = PowerState.OFF;
		com.setState(state);
		// setState() 안에 잘못된 값이 들어갈 수 있다.
		// enum을 만들어서 정해진 경우에만 가능하도록 정한다.
		// -> 잘못된 값을 넣지 않도록 하기 위해서 Enum을 이용한다!
	}
}
