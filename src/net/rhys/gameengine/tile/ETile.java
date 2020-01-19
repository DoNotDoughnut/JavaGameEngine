package net.rhys.gameengine.tile;

import net.rhys.gameengine.rendering.ERenderer;
import net.rhys.gameengine.rendering.texture.ETexture;

public class ETile {

	public int x, y;
	public ETexture texture;

	private static ETexture boundTexture = new ETexture(0x45283C);
	private static ETexture voidTexture = new ETexture(0x000000);
	
	public static ETile boundTile = new BoundTile(boundTexture);
	public static ETile voidTile = new ETile(voidTexture);
	
	public static final int size = 16;
	
	public ETile(ETexture texture) {
		this.texture=texture;
	}
	
	//Change to cycle through ones on screen only
	
	public void render(int x, int y, ERenderer graphics) {
		graphics.render(x << 4, y << 4, this.texture, false);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public void onClick() {
		
	}
	
	public void onInteract() {
		
	}
}

class BoundTile extends ETile {

	public BoundTile(ETexture texture) {
		super(texture);
	}
	
	public boolean isSolid() {
		return true;
	}

}
