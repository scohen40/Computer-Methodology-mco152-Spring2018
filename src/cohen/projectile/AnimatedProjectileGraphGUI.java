package cohen.projectile;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimatedProjectileGraphGUI extends JFrame {
	
	private AnimatedProjectileGraph projectileGraph;
	
	public AnimatedProjectileGraphGUI() {
		setTitle("Animated Projectile Graph Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0,2));
		
		projectileGraph = new AnimatedProjectileGraph();
		panel.add(projectileGraph, BorderLayout.CENTER);
		
		setContentPane(panel);
		
		Thread thread = new Thread(this::advanceGraph);
		thread.start();
	}
	
	
	public void advanceGraph( ) {
		while(true) {
			projectileGraph.repaint();
		}
		
	}
	
	public static void main(String[] args) {
		new AnimatedProjectileGraphGUI().setVisible(true);
		
	}

}
