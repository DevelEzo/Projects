package Display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import Gui.menu;
import Gui.spritesheet;
import Gui.toolbar;
import Loader.spritesheetloader;
import Manager.keymanager;
import Manager.mousemanager;
import States.manager;
import States.state;
import States.sandbox;
import Texture.TEXTURES;

public class panel extends JLabel {

	// guis
		public menu menu = new menu();
		public toolbar toolbar = new toolbar(-120 / 2, frame.HEIGHT / 2 - 400, 120, 300);
		public manager manager = new manager();
		public spritesheet spritesheet = new spritesheet(0, 0, frame.WIDTH, frame.HEIGHT,
			new spritesheetloader(TEXTURES.testspritesheet, 11, 32, 32));

	public panel() {

		// create states
			manager.states.add(new sandbox(frame.WIDTH / 2 - 640, 32, 1280, 1280, spritesheet));

		// add guis 
			add(spritesheet);
			add(menu);
			add(toolbar);
			for (int i = 0; i < manager.states.size(); i++) {
				add(manager.states.get(i));
			}
			
		// add listener
			setFocusable(true);
			requestFocus();
			addKeyListener(new keymanager());
			

	}

	public void update() {

		// guis
			manager.update();
			toolbar.update();
			spritesheet.update();
			for (int i = 0; i < manager.states.size(); i++) {
				manager.states.get(i).update();
			}
			
	}

	private void render(Graphics2D g) {

		// guis
			manager.render(g);
			toolbar.render(g, manager.states.get(0).toolmanager.tools);
			spritesheet.render(g);
			for (int i = 0; i < manager.states.size(); i++) {
			manager.states.get(i).render(g);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		render(g2d);
	}

}
