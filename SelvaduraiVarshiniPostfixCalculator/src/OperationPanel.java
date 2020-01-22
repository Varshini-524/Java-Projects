import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class OperationPanel extends JPanel {
	private JButton [] buttons;
	private CalculatorGUI parent;
	public OperationPanel(CalculatorGUI dad){
		parent = dad;
		this.setLayout(new GridLayout(5,1));
		buttons = new JButton[5];
		buttons[0] = new JButton("/");
		buttons[1] = new JButton("*");
		buttons[2] = new JButton("-");
		buttons[3] = new JButton("+");
		buttons[4] = new JButton("CLEAR");
		for(int i = 0; i < 5; i++){
			buttons[i].addActionListener(parent);
			this.add(buttons[i]);
		}
	}
}
