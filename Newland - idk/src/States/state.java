package States;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

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
		
		
		
		

}
