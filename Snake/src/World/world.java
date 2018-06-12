package World;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Gameobjects.snake;
import Items.apple;
import Loaders.musicloader;
import TEXTURES.TEXTURES;

public class world extends state {

	// sounds and musics
		musicloader getAppleSound = new musicloader();
	
	// boxes
		boxes[][] boxes = new boxes[800/32][600/32];
		ArrayList<boxes> notusedbox = new ArrayList<boxes>();
	
	// items
		public apple a;
	
	// entities 
		public snake s = new snake(0, 0, 32, 32, 32, TEXTURES.apple);
	
	public world() {
		
		// sounds and musics
			getAppleSound.load("sounds/sound.wav");
			
		
		// boxes
			for(int x = 0; x < 800/32; x++) {
				for(int y = 0; y < 600/32; y++) {
					boxes[x][y] = new boxes(x, y, 32, false);
					notusedbox.add(boxes[x][y]);
				}
			}
			
			// apple created and get a random position
				int bn = (int) (Math.random() * notusedbox.size()); 
				boxes b = notusedbox.get(bn);
				a = new apple(b.getX() * 32, b.getY() * 32, 32);
				notusedbox.remove(bn);
			
			
	
	}
	
	private boolean isPlayerEatApple() {
		if(a.getBox().intersects(s.getBox())) {
			return true;
		}
		
		return false;
	}
	
	private void setAppleANewPos() {
		int bn = (int) (Math.random() * notusedbox.size()); 
		boxes b = notusedbox.get(bn);
		a.setX(b.getX() * 32);
		a.setY(b.getY() * 32);
		notusedbox.remove(bn);
		getAppleSound.play();
	}
	@Override
	public void update() {
		
		// boxes
			for(int x = 0; x < 800/32; x++) {
				for(int y = 0; y < 600/32; y++) {
					boxes[x][y].update();
				}
			}
			
		// entities
			s.update();
		
		// items
			if(isPlayerEatApple()) {
				setAppleANewPos();
				s.lenght++;
			}
	}
	
	@Override
	public void render(Graphics2D g) {
		// items
			a.render(g);
			
		// entities
			s.render(g);
	}
	
	public apple getApple() {
		return a;
	}
	
}
