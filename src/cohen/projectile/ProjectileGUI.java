package cohen.projectile;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ProjectileGUI extends JFrame {
	private JFormattedTextField angle = new JFormattedTextField("");
	private JFormattedTextField velocity = new JFormattedTextField("");
	private JFormattedTextField time = new JFormattedTextField("");
	private JFormattedTextField x = new JFormattedTextField();
	private JFormattedTextField y = new JFormattedTextField();
	
	
	
	public ProjectileGUI() {
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		panel.add(new JLabel("Angle: ", SwingConstants.CENTER));
		panel.add(angle);
		panel.add(new JLabel("Velocity: ", SwingConstants.CENTER));
		panel.add(velocity);
		panel.add(new JLabel("Time: ", SwingConstants.CENTER));
		panel.add(time);
		panel.add(new JLabel("Coordinates", SwingConstants.CENTER));
		panel.add(new JLabel("", SwingConstants.CENTER));
		panel.add(new JLabel("X: ", SwingConstants.CENTER));
		panel.add(x);
		panel.add(new JLabel("Y: ", SwingConstants.CENTER));
		panel.add(y);
		
		angle.addPropertyChangeListener("value", this::propertyChange);
		velocity.addPropertyChangeListener("value", this::propertyChange);
		time.addPropertyChangeListener("value", this::propertyChange);
		

		add(panel);
	}

	public void propertyChange(PropertyChangeEvent event) {
		Projectile p = new Projectile(Double.parseDouble(angle.getText()), 
				Double.parseDouble(velocity.getText()), 
				Double.parseDouble(time.getText()));
		x.setValue(p.getX());
		y.setValue(p.getY());
	}
	
	public static void main(String[] args) {
		new ProjectileGUI().setVisible(true);
		
	}

}
