import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**Creates Buttons needed for GUI
 */
public class Clicky extends JPanel {
	private JButton[] buttons;
	private PlaysGUI parent;
	/**Creates Buttons
	 * @param a parent GUI: PlaysGUI
	 */
	public Clicky(PlaysGUI dad){
		parent = dad;
		this.setLayout(new GridLayout(1,2));
		buttons = new JButton[2];
		buttons[1] = new JButton("RANDOMIZE LIST OF PLAYS");
		buttons[0] = new JButton("RANDOMIZE PLAY NUMBERS");
		buttons[0].addActionListener(parent);
		buttons[1].addActionListener(parent);
		add(buttons[0]);
		add(buttons[1]);
		Font font = new Font("Sans Serif",Font.BOLD,32);
		buttons[0].setBackground(Color.BLACK);
		buttons[0].setForeground(new Color(218, 165, 32));
		buttons[0].setFont(font);
		buttons[1].setBackground(Color.BLACK);
		buttons[1].setForeground(new Color(218, 165, 32));
		buttons[1].setFont(font);
		this.setBackground(Color.BLACK); 
	}
	/**Diables Buttons
	 */
	public void disable(){
		buttons[0].disable();
		buttons[1].disable();
	}
}
