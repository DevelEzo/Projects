package States;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import Extension.tiles;
import Tools.toolmanager;

public abstract class state extends JPanel{
	
	// all methods
		public abstract void render(Graphics2D g);
		public abstract void update();
		
	// mode
		protected boolean mode = false;
		
		public boolean isMode() {
			return mode;
		}
		
		public void setVisible(boolean b) {
			mode = b;
		}
		
	// sandbox
		public toolmanager toolmanager;
		public tiles[][] tiles = new tiles[2000][2000];
		
		
		
		

}
