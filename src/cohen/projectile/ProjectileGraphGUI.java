package cohen.projectile;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProjectileGraphGUI extends JFrame {
	
	public ProjectileGraphGUI() {
		setTitle("Projectile Graph Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0,2));
		
		panel.add(new ProjectileGraph(), BorderLayout.CENTER);
		
		setContentPane(panel);
	}
	
	public static void main(String[] args) {
		new ProjectileGraphGUI().setVisible(true);
		
	}

}
