import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DisplayPanel extends JPanel {
	private JTextField equation;
	private JTextField result;
	private CalculatorGUI parent;
	public DisplayPanel(CalculatorGUI dad){
		equation = new JTextField();
		result = new JTextField();
		equation.setEditable(false);
		result.setEditable(false);
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,5,10,10));
		top.add(equation);
		
		top.add(result);
		this.setLayout(new GridLayout(2,1));
		this.add(top);		
	}
	
	public String getEquation(){
		return equation.getText();
	}
	public void addToInput(String ch){
		equation.setText(equation.getText()+ ch);
	}
	public void setResult(String text){
		result.setText(text);
	}
	public void clear(){
		equation.setText(null);
		result.setText(null);
	}
}
