package Manager;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Extension.texturebox;
import Extension.tiles;
import Gui.spritesheet;

public class mousemanager implements MouseListener, MouseMotionListener {

	// position
		public int x, y;
	// mode
		public boolean[] isClicked = new boolean[2];
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// mode 
			if(e.getButton() == 1) {
				isClicked[0] = true;
			} else if(e.getButton() == 3) {
				isClicked[1] = true;
			}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// mode
			if(e.getButton() == 1) {
				isClicked[0] = false;
			} else if(e.getButton() == 3) {
				isClicked[1] = false;
			}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// position
			x = e.getX();
			y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// position
			x = e.getX();
			y = e.getY();
	}
	
	public Rectangle getBox() {
		return new Rectangle(x, y, 1, 1);
	}
	
}
