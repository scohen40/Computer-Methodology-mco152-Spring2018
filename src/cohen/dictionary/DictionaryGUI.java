package cohen.dictionary;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class DictionaryGUI extends JFrame{
	JFormattedTextField word = new JFormattedTextField();
	JButton button = new JButton("Get Definition");
	JFormattedTextField definition = new JFormattedTextField();
	
	public DictionaryGUI() {
		setTitle("Dictionary Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel enter = new JPanel();
		enter.setLayout(new GridLayout(0,2));
		JPanel answer = new JPanel();
		answer.setLayout(new GridLayout(0,1));
		panel.add(enter, BorderLayout.NORTH);
		panel.add(answer);
		
		enter.add(word);
		enter.add(button);
		answer.add(definition);
		
		button.addActionListener(e -> {
			try {
				changeTextField(e);
			} catch (FileNotFoundException e1) {
				System.out.println("dictionary file not found. contact system admin.");
			}
		});
		
		add(panel);
	}
	
	public void changeTextField(ActionEvent event) throws FileNotFoundException {
		Dictionary D = new Dictionary("src/cohen/Dictionary/dictionary.txt");
		String w =  word.getText();
		word.setText(w);
		if(D.contains(w)) {
			definition.setText(D.getDefinition(w));
		}
		else {
			definition.setValue("Word not found. Try another word.");
		}
		
	}
	
	public static void main(String[] args) {
		new DictionaryGUI().setVisible(true);
		
	}
}
