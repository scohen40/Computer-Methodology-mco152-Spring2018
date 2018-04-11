package cohen.projectile;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import com.sun.prism.Image;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ProjectileGraph extends JComponent {
	// Graphics graph;
	private BufferedImage projectileImage;
	private Projectile projectile1 = new Projectile(45, 150);
	private Projectile projectile2 = new Projectile(40, 160);
	private Projectile projectile3 = new Projectile(75, 200);

	protected void paintComponent(Graphics g) {
		try {
			projectileImage = ImageIO.read(new File("src/cohen/projectile/projectile-icon.png"));
		} catch (IOException e) {
			System.out.println("projectile image for search button could not be loaded. contact system admin.");
		}

		super.paintComponent(g);

		g.translate(0, this.getHeight());

		addGridLines(g);

		g.setColor(Color.RED);
		drawProjectilePath20Sec(g, projectile1);
		g.setColor(Color.BLUE);
		drawProjectilePath20Sec(g, projectile2);
		g.setColor(Color.GREEN);
		drawProjectilePath20Sec(g, projectile3);

	}

	public void drawProjectilePath20Sec(Graphics g, Projectile proj) {
		ArrayList<Integer> xPoints = new ArrayList();
		ArrayList<Integer> yPoints = new ArrayList();
		// plot the coordinates, fill them, and add a cute icon at ever point
		for (int i = 0; i < 20; i++) {
			int x = (int) proj.getX(i);
			int y = (int) proj.getY(i);
			g.fillOval(x, -y, 5, 5);
			g.drawString("(" + x + ", " + y + ")", x, -y);
			xPoints.add(x);
			yPoints.add(y);
			g.drawImage(projectileImage, x, -y, null);
		}
		// connect the dots
		for (int i = 0; i < xPoints.size() - 1; i++) {
			g.drawLine(xPoints.get(i), -yPoints.get(i), xPoints.get(i + 1), -yPoints.get(i + 1));
		}
	}

	public void addGridLines(Graphics g) {
		for (int i = 0; i < this.getWidth(); i += 50) {
			// horizontal line
			g.drawLine(0, -i, this.getWidth(), -i);
			// vertical line
			g.drawLine(i, -0, i, -this.getHeight());
		}
	}
	
	

}
