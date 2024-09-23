package space;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.CustomColors;
import graphics.MyGraphics2D;

public class Fire {

	private final int BUFFER_SIZE_x = 45;
	private final int BUFFER_SIZE_Y = 35;
	private BufferedImage fireBuffer, lessFireBuffer;
	private Graphics2D gFire, gLessFire;
	private MyGraphics2D gManager;
	
	public Fire() {
		fireBuffer = new BufferedImage(BUFFER_SIZE_x,BUFFER_SIZE_Y,BufferedImage.TYPE_INT_ARGB);
		gFire = fireBuffer.createGraphics();
		lessFireBuffer = new BufferedImage(BUFFER_SIZE_x,BUFFER_SIZE_Y,BufferedImage.TYPE_INT_ARGB);
		gLessFire =lessFireBuffer.createGraphics();
		gManager = new MyGraphics2D();
		drawFire();
		drawFireBigger();
	}
	
	private void drawFire() {
		gManager.setGraphics(gFire);
		gManager.setColor(CustomColors.FIRE_ORANGE_COLOR);
		gManager.drawLine(40,0,20,5);
		gManager.drawLine(40,30,20,25);
		gManager.drawLine(20,5,0,15);
		gManager.drawLine(20,25,0,15);
		gManager.drawVerticalLine(40,0, 30);
		gManager.setColor(CustomColors.FIRE_YELLOW_COLOR);
		gManager.drawLine(40,10,20,15);
		gManager.drawLine(40,20,20,15);
	
		gManager.paintFlood(fireBuffer, 5, 15, CustomColors.FIRE_ORANGE_COLOR);
		gManager.paintFlood(fireBuffer, 35, 15, CustomColors.FIRE_YELLOW_COLOR );

	}
	
	private void drawFireBigger() {
		gManager.setGraphics(gLessFire);
		gManager.setColor(CustomColors.FIRE_ORANGE_COLOR);
		gManager.drawLine(40,5,15,10);
		gManager.drawLine(40,25,15,20);
		gManager.drawLine(15,10,5,15);
		gManager.drawLine(15,20,5,15);
		gManager.drawVerticalLine(40,0, 25);
		gManager.setColor(CustomColors.FIRE_YELLOW_COLOR);
		gManager.drawLine(40,12,25,15);
		gManager.drawLine(40,18,25,15);
		//gManager.drawPixel(15,15,Color.pink);
		gManager.paintFlood(lessFireBuffer,15,15,CustomColors.FIRE_ORANGE_COLOR);
		gManager.paintFlood(lessFireBuffer, 35,15,CustomColors.FIRE_YELLOW_COLOR);

	}
	
	public BufferedImage getFire() {
		return fireBuffer;
	}

	public BufferedImage getLessFire() {
		return lessFireBuffer;
	}
	
}
