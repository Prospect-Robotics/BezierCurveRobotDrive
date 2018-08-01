package tests;

import java.awt.Color;

import bez.BezierChain;
import bez.MiscMath;
import bez.Point;

public class DrawCurve {
	public static void main(String[] args) {
		BezierChain curve = new BezierChain(new Point(46, 319), new Point(33, 426), new Point(470, 417),
				new Point(476, 372), new Point(466, 315), new Point(462, 306), new Point(173, 83), new Point(394, 328));
		TestWindow window = new TestWindow(500, 500);
		double step = 0.005;
		for (double t = 0.0; t <= 1 - step; t += step) {
			Point p1 = curve.getPoint(t);
			Point p2 = curve.getPoint(t + step);
			window.drawLine(p1,p2);
			window.repaint();
		}
		
	}
}
