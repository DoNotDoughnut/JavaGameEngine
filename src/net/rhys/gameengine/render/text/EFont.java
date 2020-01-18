package net.rhys.gameengine.render.text;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class EFont {
	
	private static Font basicFont;
	public static Font dialogueFont, guiFont;

	public static void init(int scale) {
		
		try {
			basicFont = Font.createFont(Font.TRUETYPE_FONT, EFont.class.getClassLoader().getResourceAsStream("net/rhys/gameengine/render/text/monogram.ttf"));			
		} catch (FontFormatException | IOException e) {e.printStackTrace();}
		
		guiFont = basicFont.deriveFont((float) (12*scale));
		dialogueFont = basicFont.deriveFont((float) (16*scale));
		
	}
	
}
