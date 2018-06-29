package Display;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class frame extends JFrame{
	
	// size
		public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
		public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	// panel 
		public static panel panel = new panel();
	
	public frame(String title) {
		
		// adjust frame & add components
			super(title);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(new Dimension(WIDTH, HEIGHT));
			setMinimumSize(new Dimension(800, 600));
			setResizable(false);
			setLocationRelativeTo(null);
			add(panel);
			setVisible(true);
	}

}
