package Loader;

import java.awt.image.BufferedImage;

public class spritesheetloader {
	
	private BufferedImage spritesheet;
	private int cols;
	private int width, height;
	
	public spritesheetloader(BufferedImage spritesheet, int cols, int width, int height) {
		this.spritesheet = spritesheet;
		this.cols = cols;
		this.width = width;
		this.height = height;
	}
	
	public BufferedImage getTexture(int id) {
		
		// get the row & col
		int x = (id % cols) * width;
		int y = (id / cols) * height;
		
		// get right part of spritesheet 
		return spritesheet.getSubimage(x, y, width, height);
		
	}
	
	public int getCols() {
		return cols;
	}
	
	public int getTileWidth() {
		return width;
	}
	
	public int getTileHeight() {
		return height;
	}
	
	public int getWidth() {
		return spritesheet.getWidth();
	}
	
	public int getHeight() {
		return spritesheet.getHeight();
	}
	
	public int getCount() {
		return getHeight() / height * cols;
	}


	
}
