package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import Display.frame;
import Tools.builder;
import Tools.tool;

public class toolbar extends JPanel {

	// position
		private int x, y;
	// size
		private int width, height;
	// mode
		private boolean mode = false;

	public toolbar(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		// adjust gui
			setBounds(x, y, width, height);
			setBackground(new Color(0, 0, 0, 0));
			setVisible(false);
	}

	public void update() {

		if(isMode()) {
			
		}
		
	}

	public void render(Graphics2D g, ArrayList<tool> tools ) {
		// background
			if(isMode()) {
				g.setColor(new Color(211, 211, 211));
				g.fillRoundRect(x - 3, y - 3, width + 6, height + 6, 40, 40);
				g.setColor(new Color(100, 100, 100));
				g.fillRoundRect(x, y, width, height, 40, 40);
		// tools	
			for(int i = 0; i < tools.size(); i++) {
				g.drawImage(tools.get(i).getTexture(), x + width / 2 + 1, y + (i * 48) + 6, 48, 48, null);
			}
			
		}
	}
	
	public boolean isMode() {
		return mode;
	}
	
	public void setMode(boolean b) {
		mode = b;
	}
			
}



