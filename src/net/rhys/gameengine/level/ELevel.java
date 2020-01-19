package net.rhys.gameengine.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import net.rhys.gameengine.EEngine;
import net.rhys.gameengine.rendering.ERenderer;
import net.rhys.gameengine.tile.ETile;


public class ELevel {

	public final int id;
	public int width, height;
	protected int[] tiles; //Tiles, stored in a color map
	protected String path;
	public final String name;
	public int spawnX, spawnY;
	
	private static ArrayList<ELevel> levels = new ArrayList<>();
	private static int ids = 0;

	public ELevel(String name, EEngine engine) {
		this.id=ids;
		ids++;
		this.name=name;
		loadLevel();
		generateLevel(engine);
		levels.add(this);
	}
	
	public ELevel(String name, String path, EEngine engine) {
		this.id=ids;
		ids++;
		this.name = name;
		this.path = path;
		loadLevel();
		generateLevel(engine);		
		levels.add(this);
	}
	
	protected void loadLevel() {
		BufferedImage image;
		try {
			image = ImageIO.read(ELevel.class.getResource(EEngine.resources+"levels/"+path));
		} catch (IOException e) {
			image = null;
			System.err.println("Could not load level file at path: "+EEngine.resources+"levels/"+path+"!");
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		tiles = image.getRGB(0,0,width,height,null,0,width);
	}

	protected void generateLevel(EEngine engine) {

	}
	
	public void update() {

	}
	
	public void render(ERenderer graphics) {
		
	}
	
	public void swapLevelTo() {
		
	}
	
	public void renderTiles(int xScroll, int yScroll, ERenderer graphics) {
		graphics.xOffset = xScroll;
		graphics.yOffset = yScroll;
		int x0 = xScroll >> 4,
			x1 = (xScroll + graphics.width + ETile.size) >> 4,
			y0 = yScroll >> 4,
			y1 = (yScroll + graphics.height + ETile.size) >> 4;		
			for(int y = y0; y < y1; y++)
				for(int x = x0; x < x1; x++)
					getTileFromCoordinates(x,y).render(x, y, graphics);
	}
	
	public ETile getTileFromCoordinates(int x, int y) {
		if(x < 0 || y < 0 || y >= height || x >= width) return ETile.boundTile;
		return getTileFromColor(tiles[x+y*width]);
	}
	
	public ETile getTileFromColor(int color) {
		return ETile.voidTile;
	}

	public void dispose() {
		
	}


}
