

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

	public Point(double[] ds) {
		this(ds[0],ds[1]);
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
