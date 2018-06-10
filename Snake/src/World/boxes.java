package World;

public class boxes {
	
	// position
		private int x, y;
	// size
		private int size;
	// mode
		private boolean isUsed;
	public boxes(int x, int y, int size, boolean isUsed) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.isUsed = isUsed;
	}
	
	public void update() {
		
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
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	
	
	
	

}
