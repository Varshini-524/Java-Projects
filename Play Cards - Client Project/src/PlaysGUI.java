import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**Creates GUI to edit Play Cards
 */
public class PlaysGUI extends JFrame implements ActionListener {
	private Clicky myclicky;
	private DisplayPanel myDisplay;
	private DisplayPanel2 myDisplay2;
	private Application app; 
	private Color c;
	/**Creates the GUI
	 * @param title of GUI
	 */
	public PlaysGUI(String title) throws IOException{
		super(title);
		app = new Application();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100,500);
		myclicky = new Clicky(this);
		this.setLayout(new BorderLayout());
		this.add(myclicky, BorderLayout.CENTER);
		myDisplay = new DisplayPanel(this);
		this.add(myDisplay, BorderLayout.NORTH);
		myDisplay2 = new DisplayPanel2(this);
		this.add(myDisplay2, BorderLayout.SOUTH);
		this.getContentPane().setBackground(Color.BLACK); 
	}
	/**Listens for action
	 * @param an ActionEvent
	 * when "RANDOMIZE PLAY NUMBERS" button is clicked calls randomizePlayNum() in Application
	 * when "RANDOMIZE LIST OF PLAYS" button is clicked calls randomizeOrder() in Application
	 * After button is clicked it is disabled (calls disable() in Clicky)
	 * After action is completed GUI is closed (dispose())
	 */
	public void actionPerformed(ActionEvent event) {
		JButton src = (JButton) event.getSource();
		String label = src.getText();
		if (label.equals("RANDOMIZE PLAY NUMBERS")){
			myclicky.disable();
			app.randomizePlayNum();
		}else if (label.equals("RANDOMIZE LIST OF PLAYS")){
			myclicky.disable();
			app.randomizeOrder();
		}
		for(int a = 0; a<999999999; a++){
			for(int b = 0; b<999999999; b++){
			}
		}
		setVisible(false);
		dispose();
	}
	public static void main(String[] args) {
		PlaysGUI frame;
		try {
			frame = new PlaysGUI("Play Cards");
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}