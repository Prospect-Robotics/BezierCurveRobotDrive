package bez;

public class LengthyBezier extends Bezier {

	
	public double length;
	
	/**
	 * @param samples
	 *            - number of samples used in length calculation
	 */
	public LengthyBezier(Point a, Point b, Point c, Point d, double samples) {
		super(a, b, c, d);
		double lengthCalcStep = 1 / samples;
		length = 0;
		Point last = this.getPoint(0);
		for(double t=lengthCalcStep;t<=1;t+=lengthCalcStep) {
			Point current = this.getPoint(t);
			length+=MiscMath.distance(last, current);
			last=current;
		}
	}

}
