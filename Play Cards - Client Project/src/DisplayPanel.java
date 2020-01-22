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
/**Creates Display Panel for top of GUI
 */
public class DisplayPanel extends JPanel {
	private JTextField text;
	/**Creates the North Display Panel with JTextField
	 * @param a parent GUI: PlaysGUI
	 */
	private PlaysGUI parent;
	public DisplayPanel(PlaysGUI dad) throws IOException{
		text = new JTextField(17);
		text.setEditable(false);
		Font font = new Font("Sans Serif",Font.BOLD,64);
		text.setText("POOLESVILLE FOOTBALL PLAYS:");
		text.setBackground(Color.BLACK);
		text.setFont(font);
		text.setForeground(new Color(218, 165, 32));
		JPanel top = new JPanel();
		top.setBackground(Color.BLACK);
		this.setBackground(Color.BLACK); 
		top.setLayout(new GridLayout(2,1,10,10));
		top.add(text);
		BufferedImage myPicture = ImageIO.read(new File("/Users/VarshiniSelvadurai/Documents/FalconLogoNoBGD.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		top.add(picLabel);
		this.add(top);
	}
}
