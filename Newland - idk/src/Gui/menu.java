package Gui;


import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import Display.frame;

public class menu extends JMenuBar {
	
	// File 
	JMenu filemenu = new JMenu("File");
	ArrayList<JMenuItem> fileitems = new ArrayList<JMenuItem>();
	
	// Window
	JMenu windowmenu = new JMenu("Window");
	ArrayList<JMenuItem> windowitems = new ArrayList<JMenuItem>();
	
	public menu() {
		
		setLayout(null);
		setBorder(null);
		setBackground(new Color(211, 211, 211));
		setBounds(0, 0, frame.WIDTH, 20);
		
		// File
		fileitems.add(new JMenuItem("new workspace"));
		fileitems.add(new JMenuItem("open workspace"));
		fileitems.add(new JMenuItem("save it"));
		fileitems.add(new JMenuItem("export your map"));
	
		for(int i = 0; i < fileitems.size(); i++) {
			filemenu.add(fileitems.get(i));
		}
		
		filemenu.setBounds(0, 0, 40, 20);
		filemenu.setVisible(true);
		add(filemenu);
		
		// Window
		windowitems.add(new JMenuItem("toolbar"));
		
		for(int i = 0; i < windowitems.size(); i++) {
			windowmenu.add(windowitems.get(i));
		}
		
		windowmenu.setBounds(filemenu.getX() + filemenu.getWidth(), 0, 65, 20);
		windowmenu.setVisible(true);
		add(windowmenu);
		
		
	}

}
