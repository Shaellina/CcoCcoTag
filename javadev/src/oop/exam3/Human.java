package oop.exam3;

public class Human {
	private String name;
	private String job;
	private String hobby;
	private int gender;
	private int year;
	private int weight;
	private int height;
	private boolean married;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	// @Override
	// public String toString() {
	// return "Human [name=" + name + ", job=" + job + ", hobby=" + hobby + ",
	// gender=" + gender + ", year=" + year
	// + ", weight=" + weight + ", height=" + height + ", married=" + married +
	// "]";
	// }

	@Override
	public String toString() {
		return name + "회원님은 " + whatGender() + "이며\n"
				+ "출생년도는 " + year + "년 이며 직업은 " + job + "이고\n" 
				+ whatMarried()+ "이며 체중은 " + weight + "(Kg), 키는 " + height + "(cm), 취미는 " + hobby + "입니다.";
	}

	private String whatMarried() {
		return married ? "미혼" : "기혼";
	}

	private String whatGender() {
		return gender == 1 || gender == 3 ? "남성" : gender == 2 || gender == 4 ? "여성" : "에러";
	}

}
