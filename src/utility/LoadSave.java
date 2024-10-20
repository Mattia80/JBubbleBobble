package utility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static final String PLAYER = "player.png";
	public static final String BUBBLE = "bubble.png";
	public static final String ENEMIES = "enemies.png";
	public static final String LEVEL_TILES = "level_tiles.png";
	public static final String ITEMS = "items.png";
	public static final String MENU_ITEM_1P = "menu_item_1p.png";
	public static final String MENU_ITEM_1P_CONTINUE = "menu_item_1p.png";
	public static final String MENU_ITEM_RECORDS = "menu_item_records.png";
	public static final String MENU_TITLE = "title.png";
	
	public static BufferedImage loadSprite(String filename) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/sprites/" + filename);
		
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return img;
	}
	
	

}
