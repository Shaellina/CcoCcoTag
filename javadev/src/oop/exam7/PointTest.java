package oop.exam7;

public class PointTest {
	public static void main(String[] args) {
		Point2D pt = new Point2D();
		System.out.println("x = " + pt.x);
		System.out.println("y = " + pt.y);

		Point2D pt2 = new Point2D(100, 200);
		System.out.println("x = " + pt2.x);
		System.out.println("y = " + pt2.y);

		Point3D pt3 = new Point3D();
		System.out.println("x = " + pt3.x);
		System.out.println("y = " + pt3.y);
		System.out.println("z = " + pt3.z);

		// Point2D의 생성자를 먼저 수행하고 나서 Point3D의 생성자를 실행
		// 그 결과, Point2D의 기본값이 Point3D의 인스턴스에서 나타남

		Point3D pt4 = new Point3D(100, 200, 300);
		System.out.println("x = " + pt4.x);
		System.out.println("y = " + pt4.y);
		System.out.println("z = " + pt4.z);

	}
}
