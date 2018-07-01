package Extension;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Loader.spritesheetloader;
import Manager.mousemanager;
import States.sandbox;

public class tiles {
	
	// position
		private int x, y;
	// size
		private int width, height;
	// id 
		private ArrayList<Integer> ids = new ArrayList<Integer>();
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
		ids.add(id);
		this.spritesheet = spritesheet;
		this.m = m;
	}
	
	public Rectangle getBox() {
		return new Rectangle(x * width , y * height, width, height);
	}
	
	public boolean update() {
		
		if(m.getBox().intersects(getBox()) && m.isClicked[0]) {
			return true;
		}
		return false;
	}
	
	
	
	public void render(Graphics2D g) {
		// slot
			for(int id = 0; id <= ids.size() - 1; id++) {
				if(ids.get(id) >= 0) {
				g.drawImage(spritesheet.getTexture(ids.get(id)), x * width, y * height, width, height, null);
			}
				
		}
		
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
		return ids.get(ids.size() - 1);
	}

	public void setId(int id) {
		if(getId() != id) {
			ids.add(id);
		}
	}
	
	public void removeID() {
		if(ids.size() > 1) {
			ids.remove(ids.size() - 1);
		}
		
	}

	public spritesheetloader getSpritesheet() {
		return spritesheet;
	}

	public void setSpritesheet(spritesheetloader spritesheet) {
		this.spritesheet = spritesheet;
	}
	
	

}
