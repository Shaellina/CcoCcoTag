package oop.exam6;

public class ShapeTest {
	public static void main(String[] args) {
		printArea(new Circle());
		printArea(new Triangle());
		printArea(new Rectangle());
		/*****************************/
	}

	public static void printArea(Shape s) {
		s.area();

		if (s instanceof Circle) { // Down Casting 할 수 있는지 없는지 알 수 있는 연산자
			Circle c = (Circle) s;
			System.out.println("반지름은 " + c.r + "인 원의 넓이는 " + c.res);
		} else if (s instanceof Rectangle) {
			Rectangle r = (Rectangle) s;
			System.out.println("너비는 " + r.w + ", 높이는 " + r.h + "인 사각형의 넓이는 " + r.res);
		} else if (s instanceof Triangle) {
			Triangle t = (Triangle) s;
			System.out.println("너비는 " + t.w + ", 높이는 " + t.h + "인 사각형의 넓이는 " + t.res);
		}
	}
}
