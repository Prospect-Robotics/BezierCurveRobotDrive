

public class Point {
	double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y) {
		this.x = (double) x;
		this.y = (double) y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
