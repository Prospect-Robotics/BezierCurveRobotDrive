public class Tester {
	public static void main(String[] args) {
		// Bezier bez = new Bezier(new Point(0.0,0.0),new Point(0.0,500.0),new
		// Point(500.0,0.0),new Point(500.0,500.0));
		BezierChain chain = new BezierChain(new Point(173, 188), new Point(93, 190), new Point(83, 100),
				new Point(157, 83), new Point(270, 151), new Point(191, 233), new Point(185, 343), new Point(247, 329),
				new Point(315, 302), new Point(265, 409), new Point(421, 477), new Point(350, 410), new Point(403, 366),
				new Point(403, 233));
		TestWindow window = new TestWindow(500, 500);
		for (double t = 0.0; t <= 1; t += 0.001) {
			window.drawPoint(chain.getPoint(t));
		}
		window.repaint();
	}
}
