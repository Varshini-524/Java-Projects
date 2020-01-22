import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class CalculatorGUI extends JFrame implements ActionListener {
	private NumberPad myNumPad;
	private OperationPanel myOpPad;
	private DisplayPanel myDisplay;

	public CalculatorGUI(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		myNumPad = new NumberPad(this);
		this.setLayout(new BorderLayout());
		this.add(myNumPad, BorderLayout.CENTER);
		myOpPad = new OperationPanel(this);
		this.add(myOpPad, BorderLayout.EAST);
		myDisplay = new DisplayPanel(this);
		this.add(myDisplay, BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent event) {
		JButton src = (JButton) event.getSource();
		String label = src.getText();
		if (label.equals("0")){
			myDisplay.addToInput("0");
			myDisplay.addToInput(" ");
		}else if (label.equals("1")){
			myDisplay.addToInput("1");
			myDisplay.addToInput(" ");
		}else if (label.equals("2")){
			myDisplay.addToInput("2");
			myDisplay.addToInput(" ");
		}else if (label.equals("3")){
			myDisplay.addToInput("3");
			myDisplay.addToInput(" ");
		}else if (label.equals("4")){
			myDisplay.addToInput("4");
			myDisplay.addToInput(" ");
		}else if (label.equals("5")){
			myDisplay.addToInput("5");
			myDisplay.addToInput(" ");
		}else if (label.equals("6")){
			myDisplay.addToInput("6");
			myDisplay.addToInput(" ");
		}else if (label.equals("7")){
			myDisplay.addToInput("7");
			myDisplay.addToInput(" ");
		}else if (label.equals("8")){
			myDisplay.addToInput("8");
			myDisplay.addToInput(" ");
		}else if (label.equals("9")){
			myDisplay.addToInput("9");
			myDisplay.addToInput(" ");
		}else if (label.equals("(-)")){
			myDisplay.addToInput("-");
		}else if (label.equals("+")){
			myDisplay.addToInput("+");
			myDisplay.addToInput(" ");
		}else if (label.equals("-")){
			myDisplay.addToInput("-");
			myDisplay.addToInput(" ");
		}else if (label.equals("/")){
			myDisplay.addToInput("/");
			myDisplay.addToInput(" ");
		}else if (label.equals("*")){
			myDisplay.addToInput("*");
			myDisplay.addToInput(" ");
		}else if (label.equals("ENTER")){
			PostfixExpressionSolver pes = new PostfixExpressionSolver(myDisplay.getEquation());
			myDisplay.setResult(pes.solve());
			//System.out.println(pes.solve());
			//myDisplay.setResult("HEYYY");
		}else if(label.equals("CLEAR")){
			myDisplay.clear();
		}

	}
	public static void main(String[] args) {
		CalculatorGUI frame = new CalculatorGUI("Calculator");
		frame.setVisible(true);
	}
}
