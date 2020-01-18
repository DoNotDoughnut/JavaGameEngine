package net.rhys.gameengine.render;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;

import net.rhys.gameengine.EEngine;

public class EFonts {
	
	public static Font dialogueFont, guiFont;
	
	public EFonts(int scale) {
		try {
			Font basicFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(EEngine.resources+"monogram.ttf"));
			guiFont = basicFont.deriveFont((float) (12*scale));
			dialogueFont = basicFont.deriveFont((float) (16*scale));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
