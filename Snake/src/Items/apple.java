package Items;

import java.awt.Graphics2D;

import TEXTURES.TEXTURES;
import World.boxes;

public class apple {

	// position
		private int x, y;
	// size 
		private int size;
		
	public apple(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D g) {
		g.drawImage(TEXTURES.apple, x, y, size, size, null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
