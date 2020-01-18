package net.rhys.gameengine.render.fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class EFonts {
	
	public static Font dialogueFont, guiFont;
	
	public EFonts(int scale) {
		try {
			Font basicFont = Font.createFont(Font.TRUETYPE_FONT, EFonts.class.getClassLoader().getResourceAsStream("/net/rhys/gameengine/render/fonts/monogram.ttf"));
			guiFont = basicFont.deriveFont((float) (12*scale));
			dialogueFont = basicFont.deriveFont((float) (16*scale));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
