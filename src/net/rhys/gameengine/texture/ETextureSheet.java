package net.rhys.gameengine.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ETextureSheet {
	
	private String path;
	public final int width, height;
	public int[] pixels;
	
	public ETextureSheet(String path, int width, int height, int spriteSize) {
		this.width=width*spriteSize;
		this.height=height*spriteSize;
		this.path=path;
		pixels = new int[this.width*this.height];
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(ETextureSheet.class.getResource(path));
			int w = image.getWidth(), h = image.getHeight();
			image.getRGB(0,0,w,h,pixels,0,w);
		} catch (IOException | IllegalArgumentException e) {
			
			e.printStackTrace();
			System.out.println("Cannot find file: "+path);
		}
	}
	
	public ETextureSheet(String path, int size, int spriteSize) {
		this(path, size, size, spriteSize);
	}

}
