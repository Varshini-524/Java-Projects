import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NumberPad extends JPanel {
	private JButton[] buttons;
	private CalculatorGUI parent;
	public NumberPad(CalculatorGUI dad){
		parent = dad;
		this.setLayout(new GridLayout(4,3));
		buttons = new JButton[12];
		for(int i = 0; i < 10; i++){
			buttons[i] = new JButton(""+(9-i));
			buttons[i].addActionListener(parent);
		}
		buttons[10] = new JButton("(-)");
		buttons[11] = new JButton("ENTER");
		buttons[10].addActionListener(parent);
		buttons[11].addActionListener(parent);
		add(buttons[8]);
		add(buttons[7]);
		add(buttons[6]);
		add(buttons[5]);
		add(buttons[4]);
		add(buttons[3]);
		add(buttons[2]);
		add(buttons[1]);
		add(buttons[0]);
		add(buttons[9]);
		add(buttons[10]);
		add(buttons[11]);
	}
}
