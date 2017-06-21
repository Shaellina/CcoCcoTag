package oop.exam2;

public class Point2D extends Point1D {
	private int y;

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void print() {
		super.print();
		System.out.println("y = " + getY());
	}
}
