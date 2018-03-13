package cohen.dictionary;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class DictionaryGUI extends JFrame{
	private JFormattedTextField word = new JFormattedTextField();
	private JButton button = new JButton();
	private JFormattedTextField definition = new JFormattedTextField();
	private Dictionary D;
	private Image searchImage;
	
	public DictionaryGUI() throws IOException {
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
		
		try {
			D = new Dictionary("src/cohen/Dictionary/dictionary.txt");
		} catch (IOException e) {
			System.out.println("dictionary file could not be loaded. contact system admin.");
		}
		try {
			searchImage = ImageIO.read(new File("src/cohen/Dictionary/magnifying-glass.png"));
		} catch (IOException e) {
			System.out.println("magnifying glass image for search button could not be loaded. contact system admin.");
		}
		
		button.setIcon((Icon) searchImage);
		button.addActionListener(e -> {
			changeTextField(e);
		});
		
		add(panel);
	}
	
	public void changeTextField(ActionEvent event){
		
		String w =  word.getText();
		word.setText(w);
		if(D.contains(w)) {
			definition.setText(D.getDefinition(w));
		}
		else {
			definition.setValue("Word not found. Try another word.");
		}
		
	}
	
	public static void main(String[] args) throws IOException {
	
		new DictionaryGUI().setVisible(true);
		
		
	}
}
