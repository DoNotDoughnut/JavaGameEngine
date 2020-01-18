package net.rhys.gameengine.render;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import net.rhys.gameengine.input.EKeyInput;
import net.rhys.gameengine.input.EMouseInput;

public class ECanvas extends Canvas {
	
	private static final long serialVersionUID = 1L;	
	private BufferedImage image;
	private int[] pixels;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public ECanvas(int width, int height, int scale, EKeyInput keyInput, EMouseInput mouseInput) {
		image =  new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //render image
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		setPreferredSize(new Dimension(width*scale, height*scale));
		addKeyListener(keyInput);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}
	
	public void render(ERenderer graphics) {
		bs = getBufferStrategy();
		if(bs==null) {
			createBufferStrategy(3);
			return;
		}		
		System.arraycopy(graphics.pixels, 0, pixels, 0, graphics.pixels.length);
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		EText.render(g);
		g.dispose();
		bs.show();
		graphics.clear();
	}
	
}
