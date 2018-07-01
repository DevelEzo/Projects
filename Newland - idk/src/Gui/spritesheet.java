package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import Display.frame;
import Display.main;
import Display.panel;
import Extension.texturebox;
import Loader.spritesheetloader;
import Manager.keymanager;
import Manager.mousemanager;
import States.sandbox;

public class spritesheet extends JPanel {

	// position
		private int x, y;
	// size
		private int width, height;
	// texturebox
		spritesheetloader spritesheet;
		texturebox texturebox;
	// managers
		private mousemanager m;
	// mode 
		private boolean mode = false;

	public spritesheet(int x, int y, int width, int height, spritesheetloader spritesheet, mousemanager m) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.spritesheet = spritesheet;
		this.m = m;
		
		// create texturebox
			texturebox = new texturebox(0, 20, width, height, spritesheet, m);

		// adjust panel
			setMinimumSize(new Dimension(width, height));
			setMaximumSize(new Dimension(width, height));

	}

	public void update() {
		// texturebox
			if(texturebox.isMode()) {
				texturebox.update();
			}
		// check used keys
			// TODO Verschieben
			if (keymanager.keys[KeyEvent.VK_CONTROL]) {
				// set visible of guis off
					frame.panel.spritesheet.setMode(true);
					frame.panel.spritesheet.setVisible(true);
					frame.panel.toolbar.setMode(false);
					texturebox.setMode(true);
					for (int i = 0; i < frame.panel.manager.states.size(); i++) {
						frame.panel.manager.states.get(frame.panel.manager.state).setMode(false);
						frame.panel.manager.states.get(frame.panel.manager.state).setVisible(false);
					}
		} else {
			// set visible of guis on
				frame.panel.spritesheet.setMode(false);
				frame.panel.spritesheet.setVisible(false);
				frame.panel.toolbar.setMode(true);
				texturebox.setMode(false);
				for (int i = 0; i < frame.panel.manager.states.size(); i++) {
					frame.panel.manager.states.get(frame.panel.manager.state).setMode(true);
					frame.panel.manager.states.get(frame.panel.manager.state).setVisible(true);
				}
		}
	}

	public void render(Graphics2D g) {
		// texturebox
			if(isMode()) {
				texturebox.render(g);
			}
	}
	
	public boolean isMode() {
		return mode;
	}
	
	public void setMode(boolean b) {
		mode = b;
	}
	
	public texturebox getTexturebox() {
		return texturebox;
	}
	
	public spritesheetloader getSpritesheetloader() {
		return spritesheet;
	}

}
