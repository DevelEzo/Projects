package Display;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gamepanel extends JPanel implements ActionListener {

	public gamepanel() {

		// creating and starting a timer which call ActionListener/ 'actionPerformed'- method every 3 ms 
			Timer timer = new Timer(30, this); 
			timer.start();

	}
	
	private void update() {
		
	}
	
	private void render(Graphics2D g) {
		
		g.fillRect(0, 0, 50, 50); // only a test for checking if rendering works
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g; // setting graphics 'g' to graphics which calling 'g2d'
		
		g2d.clearRect(0, 0, 800, 600); // doing the same as repaint
		render(g2d); // calling the 'render'- method and transfer 'g2d' for rendering there
		repaint(); // clearing the screen after every frame
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update(); // calling the 'update'- method
	}

}
