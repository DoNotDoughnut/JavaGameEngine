package net.rhys.gameengine.rendering.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ETextureSheet {

	public final int width, height, spriteWidth, spriteHeight;
	public int[] pixels;
	
	public ETextureSheet(String path, int spriteWidth, int spriteHeight) {
		this.spriteHeight=spriteHeight;
		this.spriteWidth=spriteWidth;
		
		BufferedImage image;
		try {
			image = ImageIO.read(ETextureSheet.class.getResource(path));
			pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
		} catch (IOException | IllegalArgumentException e) {
			System.err.println("Cannot find texture sheet at: "+path+"!");
			image = null;
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
	}
	
}
