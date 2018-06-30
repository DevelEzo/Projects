package Extension;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import Loader.spritesheetloader;
import Manager.mousemanager;
import States.sandbox;

public class tiles {
	
	// position
		private int x, y;
	// size
		private int width, height;
	// id 
		private int id;
	// spritesheet
		private spritesheetloader spritesheet;
	// managers
		private mousemanager m;
	
	
	public tiles(int x, int y, int width, int height, int id, spritesheetloader spritesheet, mousemanager m) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.spritesheet = spritesheet;
		this.m = m;
	}
	
	public Rectangle getBox() {
		return new Rectangle(x * width , y * height, width, height);
	}
	
	public boolean update() {
		
		if(m.getBox().intersects(getBox()) && m.isClicked) {
			return true;
		}
		return false;
	}
	
	
	
	public void render(Graphics2D g) {
		// slot
			g.drawImage(spritesheet.getTexture(id), x * width, y * height, width, height, null);
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public spritesheetloader getSpritesheet() {
		return spritesheet;
	}

	public void setSpritesheet(spritesheetloader spritesheet) {
		this.spritesheet = spritesheet;
	}
	
	

}
