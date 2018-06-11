package Gameobjects;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Managers.keymanager;

public class snake extends entity {

	
	// loopspeed
		int temp = 0;
	
	// body
		int lenght = 4;
		int[] bodyX = new int[200];
		int[] bodyY = new int[200]; 
	
	public snake(int x, int y, int width, int height, int speed, BufferedImage texture) {
		super(x, y, width, height, speed, texture);
		
		// body 
			for(int i = 0; i < lenght; i++) {
				bodyX[i] = i * 32;
				bodyY[i] = 0;
			}
			
			move(600, 0);
		
		
	}
	
	public void update() {
		
		// movement		
			if(keymanager.keys[KeyEvent.VK_W]) move(0, -speed);
			else if(keymanager.keys[KeyEvent.VK_S])	move(0, speed);
			else if(keymanager.keys[KeyEvent.VK_D])	move(speed, 0);
			else if(keymanager.keys[KeyEvent.VK_A]) move(-speed, 0);
			
	}
	
	public void move(int dx, int dy) {
		// body
			// head
				if(temp < 2) {
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
	public void render(Graphics2D g) {
		
		// body 
		for(int i = 0; i < lenght; i++) {
			g.fillRect(bodyX[i], bodyY[i], width - 1, height - 1);
		}
		
	}

}
