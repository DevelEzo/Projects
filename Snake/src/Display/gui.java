package Display;

import javax.swing.JFrame;

public class gui extends JFrame {

	gui(){
		
		// setting characteristics of frame
			setTitle("Snake");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(800, 600);
			setResizable(false);
			setUndecorated(true);
			setLocationRelativeTo(null);
			add(new gamepanel());
			setVisible(true);
			
		
		
	}
	
}
