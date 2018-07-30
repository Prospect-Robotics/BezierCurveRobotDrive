
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class TestWindow extends JDialog {
	Graphics2D g2d;
	BufferedImage img;

	public TestWindow(int width, int height) {
		super();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2d = img.createGraphics();
		JLabel imgLabel = new JLabel(new ImageIcon(img));
		this.add(imgLabel);
		this.pack();
	}

	public void drawPoint(Point p) {
		g2d.setPaint(Color.black);
		g2d.fillOval((int) p.x, (int) p.y, 2, 2);
	}
	
	public void drawString(Point p,String s) {
		g2d.setPaint(Color.red);
		g2d.drawString(s,(int) p.x, (int) p.y);
	}
}
