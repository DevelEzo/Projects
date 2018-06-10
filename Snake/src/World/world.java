package World;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Items.apple;

public class world extends state {

	// boxes
		boxes[][] boxes = new boxes[800/32][600/32];
		ArrayList<boxes> notusedbox = new ArrayList<boxes>();
	
	// items
		apple a;
	
	public world() {
		
		// boxes
			for(int x = 0; x < 800/32; x++) {
				for(int y = 0; y < 600/32; y++) {
					boxes[x][y] = new boxes(x, y, 32, false);
					notusedbox.add(boxes[x][y]);
				}
			}
			
			// ********SET IT IN APPLE AS A METHOD
			int bn = (int) (Math.random() * notusedbox.size()); 
			boxes b = notusedbox.get(bn);
			a = new apple(b.getX() * 32, b.getY() * 32, 32);
			notusedbox.remove(bn);
			
			
	
	}
	
	private void setAppleANewPos() {
		int bn = (int) (Math.random() * notusedbox.size()); 
		boxes b = notusedbox.get(bn);
		a.setX(b.getX() * 32);
		a.setY(b.getY() * 32);
		notusedbox.remove(bn);
	}
	@Override
	public void update() {
		// boxes
			for(int x = 0; x < 800/32; x++) {
				for(int y = 0; y < 600/32; y++) {
					boxes[x][y].update();
				}
			}
			
			setAppleANewPos();
		}

	@Override
	public void render(Graphics2D g) {
		a.render(g);
	}
	
}
