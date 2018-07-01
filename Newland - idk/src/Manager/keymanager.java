package Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keymanager implements KeyListener {

	// keys
		public static boolean keys[] = new boolean[1000];
	
	@Override
	public void keyPressed(KeyEvent e) {

		// all keys
			keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		// all keys
			keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
