package oop.exam7;

public class Point3D extends Point2D {
	int z;

	public Point3D() { // class 의 접근 제한자를 따라간다.
		super(); // super()를 따라가보면 Point2D의 생성자를 수행한다.
		z = 1;
		System.out.println("Point3D()");
	}

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		System.out.println("Point3D(x,y,z)");
	}

}
