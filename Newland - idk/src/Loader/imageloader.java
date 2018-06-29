package Loader;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageloader {

	public static BufferedImage load(String path) {
		try {
			return ImageIO.read(imageloader.class.getClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			System.err.println("Imageloader - Couldn't load " + path);
			e.printStackTrace();
		}
		return null;
	}
	
}
