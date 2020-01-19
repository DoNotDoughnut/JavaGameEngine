package net.rhys.gameengine.rendering.texture;

import java.util.ArrayList;
import java.util.Arrays;

public class ETexture {

	public final int width, height, totalSprites;
	private int x,y, idleTime;
	public int[] pixels;
	private ETextureSheet sheet;
	
	public static final int defaultSize = 16;
	
	private static ArrayList<ETexture> animatedSprites = new ArrayList<>();
	
	private static int tick = 0;
	
	public static void update() {
		
		if(tick < 65536)
			tick++;
		else
			tick = 0;
		
		for(ETexture spr : animatedSprites) {
			
			//Animation hooks here
			
			spr.setVariant(tick / spr.idleTime  % spr.totalSprites + 1);
		}
	}
	
	public ETexture(ETextureSheet sheet, int x, int y, int totalSprites, int idleTime) {
		this.sheet=sheet;
		this.x=x;
		this.y=y;
		this.width=sheet.spriteWidth;
		this.height=sheet.spriteHeight;
		this.totalSprites=totalSprites;
		pixels = new int[width*height];
		if(idleTime!=0)
			animatedSprites.add(this);
		this.idleTime=idleTime;
		
		load(x, y);
	}
	
	private void load(int inX, int inY) {
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				pixels[x+y*width] = sheet.pixels[(x+inX*width)+(y+inY*height)*sheet.width];
	}
	
	public ETexture(ETextureSheet sheet, int x, int y, int totalSprites) {
		this(sheet, x, y, totalSprites, 0);
	}
	
	public ETexture(ETextureSheet sheet, int x, int y) {
		this(sheet, x, y, 1);
	}
	
	public ETexture(ETextureSheet sheet) {
		this(sheet, 0, 0);
	}
	
	public ETexture(ETextureSheet sheet, int totalSprites) {
		this(sheet, 0, 0, totalSprites);
	}
	
	public ETexture(int color, int width, int height) {
		this.totalSprites=1;
		this.width=width;
		this.height=height;
		pixels = new int[width*height];
		Arrays.fill(pixels, color);
	}
	
	public ETexture(int color) {
		this(color, defaultSize, defaultSize);
	}
	
	public void setVariant(int variant) {
		if(variant>totalSprites) 
			throw new NullPointerException("This sprite does not have this many variations! "+variant+" variations were entered and "+totalSprites+" is the total available.");
		//if(onX)
			load(x+(variant-1),y);
		//else
		//	load(x,y+(variant-1));
	}
	
	public ETexture getVariant(int variant) {
		//if(defaultScan)
			return new ETexture(sheet, x+(variant-1), y, 1, idleTime);
		//else
		//	return new ETexture(sheet, x, y+(variant-1), width, height, 1, defaultScan, animated, idleTime);
	}

}
