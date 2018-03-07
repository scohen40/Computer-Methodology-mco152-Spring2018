package cohen.projectile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ProjectileActionListener implements ActionListener {

	private JTextField textField;

	ProjectileActionListener(JTextField textField)
	{
		this.textField = textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText("Action Performed");
		
	}

}
