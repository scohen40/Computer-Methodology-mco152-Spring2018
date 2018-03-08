package cohen.dictionary;


import java.awt.*;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class DictionaryGUI extends JFrame{
	JFormattedTextField word = new JFormattedTextField("Enter Word");
	JButton button = new JButton("Get Definition");
	JFormattedTextField definition = new JFormattedTextField();
	
	public DictionaryGUI() {
		setTitle("Dictionary Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0,2));
		JPanel enter = new JPanel();
		enter.setLayout(new GridLayout);
		
	}
	
	public void propertyChange(PropertyChangeEvent event) {
		
	}
	
	public static void main(String[] args) {
		new DictionaryGUI().setVisible(true);
		
	}
}
