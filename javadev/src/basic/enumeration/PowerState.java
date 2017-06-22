package basic.enumeration;

public enum PowerState {
	OFF("전원이 꺼졌습니다."), ON("전원이 켜졌습니다."), SUSPEND("중지되었습니다.");

	private String description;

	private PowerState(String description) {
		this.description = description;
		// 처음 생성이 될 때 String 값인 description 을 받게 되고 description을 저장하게 된다.
		// 그래서 처음 값을 받는 것 때문에 해당 값들 옆에 () 를 붙여 String 값인 description을 적어줘야한다.

	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return getDescription();
	}
}
