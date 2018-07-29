

/*
 * Links to stuff I used as reference:
 * https://gamedev.stackexchange.com/questions/5373/moving-ships-between-two-planets-along-a-bezier-missing-some-equations-for-acce/5427#5427
 */
public class Bezier {

	Point a;
	Point b;
	Point c;
	Point d;

	public Bezier(Point a, Point b, Point c, Point d) {
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
	}

	/**
	 * 
	 * @param t
	 *            - double value between 0 and 1
	 * @return point along curve <b>not evenly spaced</b> <br>
	 *         <a href=
	 *         "https://gamedev.stackexchange.com/questions/5373/moving-ships-between-two-planets-along-a-bezier-missing-some-equations-for-acce/5427#5427">
	 *         read here for explanation</a>
	 */
	public Point getPoint(double t) {
		double x = ((1 - t) * (1 - t) * (1 - t)) * a.x + 3 * ((1 - t) * (1 - t)) * t * b.x + 3 * (1 - t) * (t * t) * c.x
				+ (t * t * t) * d.x;
		double y = ((1 - t) * (1 - t) * (1 - t)) * a.y + 3 * ((1 - t) * (1 - t)) * t * b.y + 3 * (1 - t) * (t * t) * c.y
				+ (t * t * t) * d.y;
		return new Point(x, y);
	}

	@Deprecated
	private double getX(double t) {
		return ((1 - t) * (1 - t) * (1 - t)) * a.x + 3 * ((1 - t) * (1 - t)) * t * b.x + 3 * (1 - t) * (t * t) * c.x
				+ (t * t * t) * d.x;
	}

	@Deprecated
	private double getY(double t) {
		return ((1 - t) * (1 - t) * (1 - t)) * a.y + 3 * ((1 - t) * (1 - t)) * t * b.y + 3 * (1 - t) * (t * t) * c.y
				+ (t * t * t) * d.y;
	}
	
	public String toString() {
		return a+","+c+","+b+","+d;
	}
}
