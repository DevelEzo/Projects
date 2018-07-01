package Texture;

import java.awt.image.BufferedImage;

import Loader.imageloader;
import Loader.spritesheetloader;

public class TEXTURES {
	
	// spritesheets (TEST)
		public static BufferedImage testspritesheet = imageloader.load("mapPack_spritesheet.png");
	// tools
		public static BufferedImage toolssheet = imageloader.load("toolssheet.png");
		
		// spritesheets
			public static spritesheetloader tools = new spritesheetloader(toolssheet, 3, 256, 256);

}
