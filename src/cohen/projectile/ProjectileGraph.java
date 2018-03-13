package cohen.projectile;

import javax.swing.JComponent;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.*;

public class ProjectileGraph extends JComponent {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Projectile projectile = new Projectile(80, 120);
		g.translate(0, this.getHeight());
		
		ArrayList<Integer> xPoints = new ArrayList();
		ArrayList<Integer> yPoints = new ArrayList();
		int nPoints = 0;
		g.setColor(Color.RED);	
		for(int i = 0; i < 20; i++) {
			int x = (int)projectile.getX(i);
			int y = (int)projectile.getY(i);		
				
			
			g.fillOval(x, -y, 5, 5);
			g.drawString("("+x+", "+y+")", x, -y);	
			
			xPoints.add(x);
			yPoints.add(y);
			nPoints++;
		}	
		nPoints++;
		for(int i = 0; i < nPoints; i++) {
			if(xPoints.get(i+1) != null && yPoints.get(i+1) != null)
			{
				g.drawLine(xPoints.get(i), -yPoints.get(i), xPoints.get(i+1), -yPoints.get(i+1));
			}
			else
			{
				break;
			}
			
		}
		
	}
	
}


//hw 1: connect all the dots the lines to connect them  -----????
//hw 2: draw the coordinates(string) ----done
//hw 3: colors, fill the dots in ----done
//hw 4: put in graph lines  ----????
//hw 5: projectile image		----do 2nd to last
//hw 6: multiple projectiles, 3 with different color lines, different numbers -----do at the end (repeat the loops with diff colors)


