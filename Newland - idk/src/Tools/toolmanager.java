package Tools;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Extension.tiles;

public class toolmanager {
	
	public ArrayList<tool> tools = new ArrayList<tool>();
	public int tool = 0;
	
	public void update() {
		tools.get(tool).update();
	}
	
	public void render(Graphics2D g, tiles ct) {
		tools.get(tool).render(g, ct);
	}

}
