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
	private JTextField textfield;

	public ProjectileGUI() {
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		// panel.add(new JLabel);
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		northPanel.add(new JLabel("Hello World"), BorderLayout.NORTH);
		northPanel.add(new JLabel("Goodbye World"), BorderLayout.NORTH);
		panel.add(northPanel, BorderLayout.NORTH);
		
		textfield = new JTextField("Text Field");
		panel.add(textfield, BorderLayout.WEST);
		
		JButton button = new JButton("Button");
//		button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				textfield.setText("Action Performed");
//			}
//		});
		button.addActionListener(this::changeTextField);
		
		panel.add(button, BorderLayout.CENTER);
		panel.add(new JLabel("Can we take a break?"), BorderLayout.SOUTH);
		//panel.setLayout(new GridLayout(2,2));
		add(panel);
	}

	public void changeTextField(ActionEvent event) {
		textfield.setText("Action Performed");
	}
	
	public static void main(String[] args) {
		new ProjectileGUI().setVisible(true);
		
	}

}
