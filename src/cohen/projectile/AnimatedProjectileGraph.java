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

public class AnimatedProjectileGraph extends JComponent {
	// Graphics graph;
	double time = 0;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.translate(0, this.getHeight());
		Projectile projectile = new Projectile(45, 150);
		g.setColor(Color.RED);
		
		double x = projectile.getX(time);
		double y = -projectile.getY(time);
		
		g.drawOval((int)x, (int)y, 5, 5);
		
		time += 0.005; 
	}

}
