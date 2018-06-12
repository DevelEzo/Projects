package Display;

import javax.swing.JFrame;

public class frame extends JFrame {

	public static gamepanel panel = new gamepanel();
	
	frame(){
		// setting characteristics of frame
				setTitle("Snake");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setSize(800, 600);
				setResizable(false);
				setUndecorated(true);
				setLocationRelativeTo(null);
				add(panel);
				setVisible(true);
			
		
		
	}
	
}
