package space;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.CustomColors;
import graphics.MyGraphics2D;

public class RocketWindow {

	private BufferedImage windowBuffer;
	private Graphics2D gWindow;
	private MyGraphics2D gManager;
	
	public void drawWindow(int r, int thickness) {
		windowBuffer = new BufferedImage((r*2)+6, (r*2)+6,BufferedImage.TYPE_INT_ARGB );
		gWindow = windowBuffer.createGraphics();
		
		gManager = new MyGraphics2D();
		gManager.setGraphics(gWindow);
		
		gManager.setThickness(thickness);
		gManager.setColor(CustomColors.BLACK);
		
		int position = r+3;
		
		gManager.drawCircle(position, position, r);
		gManager.setThickness(gManager.DEFAULT_THICKNESS);

		gManager.paintFlood(windowBuffer, position, position, CustomColors.ROCKET_WINDOW_COLOR);
		
	}
	
	
	public BufferedImage getWindow() {
		if(windowBuffer == null)throw new NullPointerException("You need to draw a window first");
		return windowBuffer;
	}
	

	
	
}
