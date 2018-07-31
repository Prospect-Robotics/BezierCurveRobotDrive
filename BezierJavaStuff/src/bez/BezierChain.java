package bez;
import java.util.ArrayList;

public class BezierChain {
	ArrayList<Bezier> curves;
	public BezierChain(Point... points) {
		if (points.length <= 4 || points.length % 2 != 0) {
			System.err.println("Wrong number of points");
			throw new IllegalArgumentException();
		}
		curves = new ArrayList<Bezier>();
		curves.add(new Bezier(points[0], points[1], points[2], points[3]));
		for (int i = 4; i < points.length; i += 2) {
			Point p1 = points[i - 1];
			Point p2 = MiscMath.mirrorAcrossPoint(points[i - 2],p1);
			Point p3 = points[i];
			Point p4 = points[i + 1];
			curves.add(new Bezier(p1, p2, p3, p4));
		}
	}

	public Point getPoint(double t) {
		double t1 = t * curves.size();
		return curves.get((int) t1).getPoint(t1 % 1);
	}
}
