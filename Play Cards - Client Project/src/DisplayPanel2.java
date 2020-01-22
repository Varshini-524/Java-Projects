import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**Creates Display Panel for bottom of GUI
 */
public class DisplayPanel2 extends JPanel {
	private JTextField text1;
	private JTextField text2;
	private PlaysGUI parent;
	/**Creates the South Display Panel with JTextField
	 * @param a parent GUI: PlaysGUI
	 */
	public DisplayPanel2(PlaysGUI dad) throws IOException{
		text1 = new JTextField(30); text2 = new JTextField(30);
		text1.setEditable(false); text2.setEditable(false);
		Font font = new Font("Sans Serif",Font.BOLD,12);
		text1.setText("            Changes the Numbering of the Play Cards");
		text2.setText("    Creates a Randomized List of the Plays (for Practices)");
		text1.setBackground(Color.BLACK); text2.setBackground(Color.BLACK);
		text1.setFont(font); text2.setFont(font);
		text1.setForeground(new Color(218, 165, 32)); text2.setForeground(new Color(218, 165, 32));
		JPanel bottom = new JPanel();
		bottom.setBackground(Color.BLACK);
		this.setBackground(Color.BLACK); 
		bottom.setLayout(new GridLayout(1,2,160,10));
		bottom.add(text1); bottom.add(text2);
		this.add(bottom);
	}
}
