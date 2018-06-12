package Gameobjects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class entity extends objects {

	// movement
		protected int speed;
		protected boolean moveup, movedown, moveright, moveleft;
	// appearance
		protected BufferedImage texture;
	
	public entity(int x, int y, int width, int height, int speed, BufferedImage texture) {
		super(x, y, width, height);
		this.speed = speed;
		this.texture = texture;
	}
	
	public void update() {
	}
	
	public void move() {	
		if(moveup) y -= speed;
		if(movedown) y += speed;
		if(moveright) x += speed;
		if(moveleft) x= speed;	
	}
	
	public void render(Graphics2D g) {
		g.drawImage(texture, x, y, width, height, null);
	}

}
