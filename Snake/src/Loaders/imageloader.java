package Loaders;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageloader {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(imageloader.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
