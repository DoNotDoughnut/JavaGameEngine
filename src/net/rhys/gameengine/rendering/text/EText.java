package net.rhys.gameengine.rendering.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class EText {

	public int x, y;
	public String text;
	public Color color;
	public Font font;
	public final int id;
	
	private static ArrayList<EText> texts = new ArrayList<>();
	private static int ids = 0;
	
	public EText(int x, int y, Font font, int color, String text) {
		this.x=x;
		this.y=y;
		this.font=font;
		this.color=new Color((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF);
		this.text=text;
		
		this.id = ids;
		texts.add(id, null);
		ids++;
	}
	
	public void spawn() {
		texts.set(id, this);
	}
	
	public void despawn() {
		texts.set(id, null);
	}

	public static void render(Graphics graphics) {
		for(EText text : texts) {
			if(text!=null) {
				graphics.setFont(text.font);
				graphics.setColor(text.color);
				graphics.drawString(text.text, text.x, text.y);
			}
		}
	}
	
}
