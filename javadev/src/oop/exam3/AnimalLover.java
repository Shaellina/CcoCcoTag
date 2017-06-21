package oop.exam3;

public class AnimalLover extends Human {
	private String animalType;
	private int ayear;

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public int getAyear() {
		return ayear;
	}

	public void setAyear(int ayear) {
		this.ayear = ayear;
	}

	@Override
	public String toString() {
		
		return super.toString() + "키우는 동물은 " + animalType + "이며 " + ayear + "년생 입니다.";
	}
	
	
}
