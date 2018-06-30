package Tools;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Display.frame;
import Display.panel;
import Extension.texturebox;
import Extension.tiles;
import Gui.spritesheet;
import Manager.mousemanager;

public class builder extends tool{
	
	// tiles
		private spritesheet s;
		private tiles[][] tiles;
		private tiles ct;
	// managers
		mousemanager m;
	// size
		private int width, height;
		
	public builder(spritesheet spritesheet, tiles[][] tiles, int size, mousemanager m, BufferedImage texture, int width, int height) {
		super(texture);
		this.s = spritesheet;
		this.tiles = tiles;
		this.size = size;
		this.m = m;
		this.width = width;
		this.height = height;
	}	

	public void update() {
		if(m.isClicked) {
			setBlock(ct);
		}

	}
	
	public void setBlock(tiles ct) {
		
		if(m.x <= width && m.x >= 0 
				&& m.y <= height && m.y >= 0) {
			frame.panel.manager.states.get(0).tiles[m.x / size][m.y / size].setId(ct.getId());
		}
	}

	@Override
	public void render(Graphics2D g, tiles ct) {
		// pointer 
			this.ct = ct;
			g.drawImage(ct.getSpritesheet().getTexture(ct.getId()),tiles[m.x / size][m.y / size].getX() * size,
					tiles[m.x / size][m.y / size].getY() * size, size, size, null);
		
	}

}
