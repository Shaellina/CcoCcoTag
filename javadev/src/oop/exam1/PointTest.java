package oop.exam1;

public class PointTest {
	public static void main(String[] args) {
		Point2D pt = new Point2D();
		// memory에 실체를 만들어주는 키워드
		pt.setX(100);
		pt.setY(200);

		System.out.println("x = " + pt.getX());
		System.out.println("y = " + pt.getY());

		Point2D pt2 = new Point3D();

		Point3D pt3 = new Point3D();

		pt3.setX(6);
		pt3.setY(8);
		pt3.setZ(10);
		pt3.print();

		// OOP의 특징
		// 1. 캡슐화와 정보은폐
		// 2. 상속
		// 3. 다형성
	}
}
