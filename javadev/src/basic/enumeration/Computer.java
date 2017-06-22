package basic.enumeration;

import static basic.enumeration.PowerState.*;
// 이걸 적어주면서 Private PowerState state = OFF; 가 가능하다.
// 인스턴스가 1개씩만 만들어지므로 정해진 하나의 값으로 import해도 무방하다.

public class Computer extends ElectricDevice {

	// private int state = 0; // 0: off, 1: on, 2: suspend
	private PowerState state = OFF;

	@Override
	public void turnOn() {
		state = ON;
	}

	@Override
	public void turnOff() {
		state = OFF;
	}

	public void suspend() { // 중지 상태
		state = SUSPEND;
	}

	public void setState(PowerState state) {
		switch (state) {
		case OFF:
			System.out.println("전원이 꺼진 상태입니다.");
			break;
		case ON:
			System.out.println("전원이 켜졌습니다.");
			break;
		case SUSPEND:
			System.out.println("중지하였습니다.");
			break;
		}
	}
}
