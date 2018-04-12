package cohen.polynomials;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PolynomialCalculatorGUI extends JFrame {
	private JTextField coef = new JTextField("");
	private JLabel xLabel = new JLabel(" x ^ ");
	private JTextField deg = new JTextField("");
	private JButton add = new JButton(" +/add ");
	private JButton multiply = new JButton(" x/multiply ");
	private JButton clear = new JButton(" clear polynomial ");
	private JLabel current = new JLabel("Input both a non-zero Coeficient and a Degree. Current Polynomial:");
	private JTextField polynomial = new JTextField(" ");
	
	private Polynomial poly = new Polynomial();
	
	
	public PolynomialCalculatorGUI() {
		setTitle("Change Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		
		JPanel enter = new JPanel();
		enter.setLayout(new GridLayout(0,2));
		JPanel output = new JPanel();
		output.setLayout(new GridLayout(0, 2));	
		JPanel input = new JPanel();
		input.setLayout(new GridLayout(0, 3));
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(0,1));
	
		panel.add(enter);
		panel.add(output);	
		enter.add(input);
		enter.add(buttons);
		
		input.add(coef);
		input.add(xLabel);
		input.add(deg);
		buttons.add(add);
		buttons.add(multiply);
		buttons.add(clear);
		output.add(current, SwingConstants.CENTER);
		output.add(polynomial);
		
		add.addActionListener(this::addMonomial);
		multiply.addActionListener(this::multMonomial);
		clear.addActionListener(this::clearPolynomial);
		
		add(panel);
	}
	

	public void addMonomial(ActionEvent event) {
		int coefNum = Integer.parseInt(coef.getText());
		int degNum = Integer.parseInt(deg.getText());
		coef.setText("");
		deg.setText("");
		if(coefNum != 0 && (Integer)degNum != null) {
			poly.addTerm(degNum, coefNum);
			polynomial.setText(poly.printPolynomial());
		}	
	}
	
	public void multMonomial(ActionEvent event) {
		int coefNum = Integer.parseInt(coef.getText());
		int degNum = Integer.parseInt(deg.getText());
		coef.setText("");
		deg.setText("");
		
		if(coefNum != 0 && (Integer)degNum != null) {
			if(degNum == 0) {
				poly.timesConst(coefNum);
			}
			else {
				poly.multiplyMonomial(degNum, coefNum);
			}
			polynomial.setText(poly.printPolynomial());
		}	
	}

	public void clearPolynomial(ActionEvent event) {
		coef.setText("");
		deg.setText("");
		poly.makeEmpty();
		polynomial.setText(" ");
	}
	
	public static void main(String[] args) {
		new PolynomialCalculatorGUI().setVisible(true);	
	}
}
