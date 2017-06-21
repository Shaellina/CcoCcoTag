package oop.exam3;

public class HumanTest {
	public static void main(String[] args) {
		Human h1 = new Human();
		h1.setName("JB");
		h1.setGender(1);
		h1.setYear(1991);
		h1.setJob("Developer");
		h1.setHeight(181);
		h1.setWeight(80);
		h1.setHobby("Tennis");
		h1.setMarried(true);

		System.out.println(h1.toString() + "\n");

		Human h2 = new Human();
		h2.setName("JW");
		h2.setGender(2);
		h2.setYear(1994);
		h2.setJob("Student");
		h2.setHeight(158);
		h2.setWeight(45);
		h2.setHobby("Shopping");
		h2.setMarried(true);

		System.out.println(h2.toString() + "\n");

		AnimalLover al = new AnimalLover();
		al.setName("JB");
		al.setGender(1);
		al.setYear(1991);
		al.setJob("Developer");
		al.setHeight(181);
		al.setWeight(80);
		al.setHobby("Tennis");
		al.setMarried(true);
		al.setAnimalType("고양이");
		al.setAyear(2016);

		System.out.println(al.toString());
	}
}
