package cohen.projectile;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProjectileGUI extends JFrame {
	JTextField angle = new JTextField("");
	JTextField velocity = new JTextField("");
	JTextField x = new JTextField("");
	JTextField y = new JTextField("");
	
	
	
	public ProjectileGUI() {
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		
		JButton button = new JButton("Button");
//		
		
	}

	public void changeTextField(ActionEvent event) {
		
	}
	
	public static void main(String[] args) {
		new ProjectileGUI().setVisible(true);
		
	}

}
