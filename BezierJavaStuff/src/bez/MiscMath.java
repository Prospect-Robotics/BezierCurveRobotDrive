package bez;

public class MiscMath {
	public static double slope(Point a, Point b) {
		return (a.y - b.y) / (a.x - b.x);
	}

	public static double distance(Point a, Point b) {
		return Math.hypot(a.x - b.x, a.y - b.y);
	}

	public static Point mirrorAcrossPoint(Point p, Point center) {
		return new Point(((p.x - center.x) * -1) + center.x, ((p.y - center.y) * -1) + center.y);// https://www.desmos.com/calculator/icdj9pgftt
	}
}
