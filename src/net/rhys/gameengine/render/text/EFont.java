package net.rhys.gameengine.render.text;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class EFont {
	
	public Font gui, dialogue;

	protected EFont(String path, int scale) {
		try {
			Font basicFont = Font.createFont(Font.TRUETYPE_FONT, EFonts.class.getResourceAsStream("/fonts/"+path));
			gui = basicFont.deriveFont((float) (12*scale));
			dialogue = basicFont.deriveFont((float) (16*scale));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
