package States;

import java.awt.Color;
import java.awt.Graphics2D;

import Display.frame;
import Extension.texturebox;
import Extension.tiles;
import Gui.toolbar;
import Manager.mousemanager;
import Texture.TEXTURES;
import Tools.builder;
import Tools.toolmanager;
import Gui.spritesheet;

public class sandbox extends state {

	// position
		private int x, y;
	// size
		private int width, height;
	// tiles
		private tiles[][] tiles = new tiles[2000][2000];
		private spritesheet spritesheet;
		private builder b;
	// managers
		private mousemanager m;

	public sandbox(int x, int y, int width, int height, spritesheet spritesheet) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.spritesheet = spritesheet;
		// adjust gui
			setLayout(null);
			setSize(width, height);
			setLocation(x, y);
			setBackground(new Color(0, 0, 0, 0));
		
		// add listeners
			m = new mousemanager();
			setFocusable(true);
			requestFocus();
			addMouseListener(m);
			addMouseMotionListener(m);
			
		// sandbox
			createSandbox();
			
		// toolmanager
			toolmanager = new toolmanager();
			toolmanager.tools.add(new builder(spritesheet, tiles, 32, m, TEXTURES.tools.getTexture(1))); // tool 1
	}
	
	private void createSandbox() {
		
		for(int x = 0; x < width / 32; x++) {
			for(int y = 0; y < height / 32; y++) {
				tiles[x][y] = new tiles(x, y, 32, 32, 0, spritesheet.getSpritesheetloader());	
			}
		}
		for(int x = 0; x < width / 32; x++) {
			for(int y = 0; y < height / 32; y++) {
				tiles[x][y].setX(tiles[x][y].getX() + getX() / 32);
				tiles[x][y].setY(tiles[x][y].getY() + getY() / 32);
			
			}
		}
		
	}

	@Override
	public void render(Graphics2D g) {
		// background 
			g.fillRect(x, y, width, height);
			for(int ypos = 0; ypos <= height / 32; ypos++) {
				g.setColor(Color.red);
				g.drawLine(x, ypos * 32 + y, width + x, ypos * 32 + y);
			}
			for(int xpos = 0; xpos <= width / 32; xpos++) {
				g.setColor(Color.red);
				g.drawLine(xpos * 32 + x, y, xpos * 32 + x, height + y);
			}
		// tools 
			if(m.x <= width && m.x >= 0 
					&& m.y <= height && m.y >= 0) {
				toolmanager.render(g, spritesheet.getTexturebox().getCurrentTile());
			}
	}

	@Override
	public void update() {
		System.out.println(m.x);
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

	public tiles[][] getTiles() {
		return tiles;
	}

	public void setTiles(tiles[][] tiles) {
		this.tiles = tiles;
	}

	public spritesheet getSpritesheet() {
		return spritesheet;
	}

	public void setSpritesheet(spritesheet spritesheet) {
		this.spritesheet = spritesheet;
	}

	public builder getB() {
		return b;
	}

	public void setB(builder b) {
		this.b = b;
	}

}
