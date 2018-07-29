

import java.awt.Graphics2D;

import javax.swing.JDialog;

public class Tester {
	public static void main(String[] args) {
		Bezier bez = new Bezier(new Point(0.0,0.0),new Point(0.0,1.0),new Point(1.0,0.0),new Point(1.0,1.0));
		for(double t=0.0;t<=1;t+=0.05) {
			System.out.println(bez.getPoint(t));
		}
	}
}
