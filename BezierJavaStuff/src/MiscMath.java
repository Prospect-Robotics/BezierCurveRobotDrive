

public class MiscMath {
	public static double slope(Point a, Point b) {
		return (a.y - b.y) / (a.x - b.x);
	}
	
	public static double distance(Point a,Point b) {
		return Math.hypot(a.x-b.x,a.y-b.y);
	}
}
