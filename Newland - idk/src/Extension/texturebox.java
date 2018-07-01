package Extension;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Display.frame;
import Gui.spritesheet;
import Loader.spritesheetloader;
import Manager.mousemanager;

public class texturebox {

	// position
		private int x, y;
	// size
		private int width, height;
	// texturebox
		private spritesheetloader spritesheet;
		private tiles slots[][];
		private BufferedImage texturebox;
		private tiles currentTile;
	// managers
		private mousemanager m;

	public texturebox(int x, int y, int width, int height, spritesheetloader spritesheet, mousemanager m) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.spritesheet = spritesheet;
		this.m = m;
		
		// create texturebox
			texturebox = createTexturebox();
			this.currentTile = slots[0][0];
	}

	public BufferedImage createTexturebox() {

		// create slots
			slots = new tiles[spritesheet.getCols()][spritesheet.getCount()/spritesheet.getCols()];

			int id = 0;

			for (int yrow = 0; yrow < spritesheet.getCount() / spritesheet.getCols(); yrow++) {
				for (int xrow = 0; xrow < spritesheet.getCols(); xrow++) {
					slots[xrow][yrow] = new tiles(xrow, yrow, 64, 64, id, spritesheet, m);
					
					id++;
				}
			}
			
			System.out.println(spritesheet.getCols());
			System.out.println(spritesheet.getCount()/spritesheet.getCols());
			

			
		// create texturebox
			BufferedImage box = new BufferedImage(width, height, Image.SCALE_DEFAULT);
			Graphics2D g = (Graphics2D) box.getGraphics();

			for (int yrow = 0; yrow < spritesheet.getCount() / spritesheet.getCols(); yrow++) {
				for (int xrow = 0; xrow < spritesheet.getCols(); xrow++) {
					slots[xrow][yrow].render(g);
				}
			}

			g.dispose();

			return box;

	}

	public void update() {
		
		// all slots
			if(isMode()) {
				for (int yrow = 0; yrow < spritesheet.getCount() / spritesheet.getCols(); yrow++) {
					for (int xrow = 0; xrow < spritesheet.getCols(); xrow++) {
						if(slots[xrow][yrow].update()) currentTile = slots[xrow][yrow];
					}
		
				}
				
			}

	}

	public void render(Graphics2D g) {
		
		// texturebox
			if(isMode()) {
				g.drawImage(texturebox, frame.WIDTH - width, y, width, height, null);
			}

	}
	
	// mode
		protected boolean mode = false;
	
		public boolean isMode() {
			return mode;
		}
	
		public void setMode(boolean b) {
			mode = b;
		}
	
	
	public tiles[][] getTiles(){
		return slots;
	}
	
	public tiles getTiles(int x, int y){
		return slots[x][y];
	}
	
	public tiles getCurrentTile() {
		return currentTile;
	}

}
