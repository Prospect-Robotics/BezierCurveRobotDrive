package bez;

import java.util.ArrayList;

public class LengthAdjustedBezierChain{//should this be a subclass? idk
	ArrayList<LengthyBezier> curves;
	public LengthAdjustedBezierChain(int totalSamples,Point... points) {
		if (points.length <= 4 || points.length % 2 != 0) {
			System.err.println("Wrong number of points");
			throw new IllegalArgumentException();
		}
		int samplesPer = totalSamples/((points.length-2)/2);
		curves = new ArrayList<LengthyBezier>();
		curves.add(new LengthyBezier(points[0], points[1], points[2], points[3],totalSamples));
		for (int i = 4; i < points.length; i += 2) {
			Point p1 = points[i - 1];
			Point p2 = MiscMath.mirrorAcrossPoint(points[i - 2],p1);
			Point p3 = points[i];
			Point p4 = points[i + 1];
			curves.add(new LengthyBezier(p1, p2, p3, p4,totalSamples));
		}
	}
}
