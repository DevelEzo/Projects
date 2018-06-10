package Display;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import World.manager;
import World.world;

public class gamepanel extends JPanel {

	manager m = new manager();
	
	public gamepanel() {

		m.states.add(new world());
		
	}
	
	public void update() {
		m.update();
	}
	
	private void render(Graphics2D g) {
		
		g.fillRect(0, 0, 50, 50);
		m.render(g);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.clearRect(0, 0, 800, 600);
		render(g2d);
		repaint();

	}

}
