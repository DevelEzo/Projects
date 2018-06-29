package Tools;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Extension.tiles;

public abstract class tool {
	
	// size
		protected int size;
		
	// texture 
		protected  BufferedImage texture;
	
	public tool(BufferedImage texture) {
		this.texture = texture;
	}
		
	public abstract void update();
	public abstract void render(Graphics2D g, tiles ct);
	
	
	public int getSize() {
		return size;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
}
