package Gameobjects;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Display.frame;
import Managers.keymanager;

public class snake extends entity {

	
	// loopspeed
		int temp = 0;
		
	// movement
		/* 
		 * 0 - up
		 * 1 - down
		 * 2 - right
		 * 3 - left
		 */
		int move = -1;
	
	// body
		public int lenght = 4;
		int[] bodyX = new int[200];
		int[] bodyY = new int[200]; 
	
	
	public snake(int x, int y, int width, int height, int speed, BufferedImage texture) {
		super(x, y, width, height, speed, texture);
		
		// body 
			for(int i = 0; i <= lenght; i++) {
				bodyX[i] = i * 32;
				bodyY[i] = 0;
			}
			
	}
	
	public void update() {
		
		// movement		
			if(keymanager.keys[KeyEvent.VK_W]) move = 0;
			else if(keymanager.keys[KeyEvent.VK_S])	move = 1;
			else if(keymanager.keys[KeyEvent.VK_D])	move = 2;
			else if(keymanager.keys[KeyEvent.VK_A]) move = 3;
			
			if(move == 0) move(0, -speed);
			if(move == 1) move(0, speed);
			if(move == 2) move(speed, 0);
			if(move == 3) move(-speed, 0);
		
		// gameover	
			if(isGameover()) frame.panel.m.state = 1;
	}
	
	public boolean isGameover() {
		// field 
			if(bodyX[0] < 0 || bodyX[0] + width > 800) return true;
			if(bodyY[0] < 0 || bodyY[0] + height > 600) return true;
		
		// snake
			for(int i = lenght; i > 1; i--) {
				if(bodyX[0] == bodyX[i] && bodyY[0] == bodyY[i]) return true;
			}
		
		return false;
	}
	
	public void move(int dx, int dy) {
		// body
			// head
				if(temp < 4) {
					temp++;
				} else {
					temp = 0;
				bodyY[0] += dy;
				bodyX[0] += dx;
				
			// tail
				for (int i = lenght; i > 0; i--) {
					bodyX[i] = bodyX[i - 1];
					bodyY[i] = bodyY[i - 1];
				}
					
		}
	
	}
	
	public Rectangle getBox() {
		return new Rectangle(bodyX[0], bodyY[0], width, height);
	}
	
	public void render(Graphics2D g) {
		
		// body 
			for(int i = 0; i <= lenght; i++) {
				g.fillRect(bodyX[i], bodyY[i], width - 1, height - 1);
			}
		
	}

}
