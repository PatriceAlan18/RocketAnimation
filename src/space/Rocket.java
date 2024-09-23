package space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.CustomColors;
import graphics.MyGradient2D;
import graphics.MyGraphics2D;
import graphics.Point2D;

public class Rocket {
	
	private final int ROCKET_BUFFER_SIZE_X = 260;
	private final int ROCKET_BUFFER_SIZE_Y = 110;
	
	private final int FIRE_POSITION_X = 0;
	private final int FIRE_POSITION_Y = 40;
	
	private BufferedImage rocketBuffer, rocketBufferLessFire, fireBuffer, lessFireBuffer;
	
	private Graphics gRocket, gRocketLessFire;
	
	private MyGraphics2D gManager;
	
	private MyGradient2D gradient;
	
	private RocketWindow rocketWindow;
	
	private Fire rocketFire;
	
	public Rocket() {
		rocketBuffer = new BufferedImage(ROCKET_BUFFER_SIZE_X,ROCKET_BUFFER_SIZE_Y,BufferedImage.TYPE_INT_ARGB);
		rocketBufferLessFire = new BufferedImage(ROCKET_BUFFER_SIZE_X, ROCKET_BUFFER_SIZE_Y, BufferedImage.TYPE_INT_ARGB);
		gRocket = (Graphics2D) rocketBuffer.createGraphics();
		gRocketLessFire = (Graphics2D) rocketBufferLessFire.createGraphics();
		gManager = new MyGraphics2D();
		gManager.setGraphics(gRocket);
		
		rocketFire = new Fire();
		
		drawRocket();
	}
	
	
	private void drawRocket() {
		drawRocketBody();	
		paintRocket();
		drawRocketDetails();
		drawAstronaut();
		copyRocket();
		drawFire();
	}
	
	private void drawRocketBody() {
		gManager.setColor(CustomColors.GRAY);
		gManager.drawLine(40, 30, 180, 40);
		gManager.drawLine(40, 80, 180, 70);  
		gManager.drawVerticalLine(40,30,80); //Rocket vertical size 50, 30 to 80, 180 x
		gManager.setColor(CustomColors.BLACK);
		gManager.drawParametricCircleArc(30,55,50,0,65);
		gManager.drawParametricCircleArc(30,55,50,0,65);
		gManager.drawParametricCircleArc(30,55,50,115,180);
		gManager.drawHorizontalLine(30,20,5);
		gManager.drawHorizontalLine(30,20,105);
		gManager.drawParametricCircleArc(25,55,40,30,55);
		gManager.drawParametricCircleArc(25,55,40,125,150);
		gManager.drawLine(20,5,45,20);
		gManager.drawLine(20,105,45,90);
		gManager.drawParametricCircleArc(180, 70, 30, 145, 180);
		gManager.drawParametricCircleArc(180, 40, 30, 0, 35);
		gManager.drawLine(198,46,210,55);
		gManager.drawLine(198,64,210,55);
		gManager.setColor(CustomColors.RED);
		gManager.drawVerticalLine(180,40,70);
	}
	
	private void paintRocket() {
		
		Point2D point = initGradient();

		gManager.paintFloodWithGradient(gradient, rocketBuffer, point);
		gManager.paintFlood(rocketBuffer, 181,55,CustomColors.RED);
		gManager.paintFlood(rocketBuffer, 60,30,CustomColors.RED);
		gManager.paintFlood(rocketBuffer,60,82,CustomColors.RED);
	}
	
	private Point2D initGradient() {
		Point2D p1 = new Point2D(41,55);
		Point2D p2 = new Point2D(180, 55);
		gradient = new MyGradient2D(p1, CustomColors.LIGHT_GRAY, p2, CustomColors.GRAY);
		return p1;
	}
	
	private void drawRocketDetails() {
		drawRocketLines();
		drawRocketDoor();
		drawWindows();
	}
	
	private void drawRocketLines() {
		gManager.setColor(CustomColors.GRAY);
		gManager.drawParametricCircleArc(0,55, 60, 67,113);
		gManager.drawParametricCircleArc(40,55, 60, 70,110);
		gManager.drawParametricCircleArc(100,55, 60, 74,106);
	}
	
	private void drawRocketDoor() {
		gManager.setColor(CustomColors.BLACK);
		gManager.drawRectangle(80, 42, 100, 67);
		gManager.drawParametricCircleArc(90, 52, 10, 90, 270);
		gManager.drawParametricCircleArc(90, 57, 10, 270, 450);
		gManager.paintFloodDifferentColor(rocketBuffer, 82, 44, CustomColors.BLACK, CustomColors.BLACK);
		gManager.paintFloodDifferentColor(rocketBuffer, 98, 44, CustomColors.BLACK, CustomColors.BLACK);
		gManager.paintFloodDifferentColor(rocketBuffer, 82, 65, CustomColors.BLACK, CustomColors.BLACK);
		gManager.paintFloodDifferentColor(rocketBuffer, 98, 65, CustomColors.BLACK, CustomColors.BLACK);
		gManager.drawLine(92,60,96,60);
	}
	
	private void drawWindows() {
		rocketWindow = new RocketWindow();
		
		
		rocketWindow.drawWindow(6, 1);
		gRocket.drawImage(rocketWindow.getWindow(), 80,41, null);
		
		rocketWindow.drawWindow(10, 3);
		gRocket.drawImage(rocketWindow.getWindow(), 140, 43,null);
		
		gManager.setColor(CustomColors.WHITE_GRAY);
		gManager.drawParametricCircleArc(152, 62, 10, 145,195);
		
	}
	
	private void drawAstronaut() {
		drawAstronautString();
		drawAstronautHelmet();
		drawAstronautBody();
		drawAstronautBoots();
		drawBox();
		drawBanjo();
		drawAstronautSleeves();
		
	}
	
	private void drawAstronautString() {
		gManager.setColor(CustomColors.BLACK);
		gManager.drawCircle(70, 43,2);	
		gManager.setColor(CustomColors.WHITE);
		gManager.drawPixel(70,43);
		gManager.drawPixel(71,43);
		gManager.drawPixel(72,43);
		gManager.drawPixel(72,42);
		gManager.drawPixel(72,41);
		gManager.drawPixel(73,41);
		gManager.drawLine(74, 41, 77, 21);
		gManager.drawParametricCircleArc(81, 24, 5, 150, 270);
		gManager.drawLine(82, 18, 89, 20);
		gManager.drawLine(89, 20, 96, 18);
	}

	private void drawAstronautHelmet() {
		gManager.setColor(CustomColors.BLACK);
		gManager.drawRectangle(100, 10, 106, 15);
		gManager.paintFlood(rocketBuffer, 101,11, CustomColors.HELMET_COLOR);
		gManager.drawHorizontalLine(101, 105, 16);
		gManager.drawHorizontalLine(101, 105, 9);
		gManager.setColor(CustomColors.SPACE_SUIT_COLOR);
		gManager.drawPixel(100, 16);
		gManager.drawPixel(106, 16);
		gManager.drawPixel(107, 16);
		gManager.drawPixel(100, 9);
		gManager.drawHorizontalLine(100, 107,8);
		gManager.drawHorizontalLine(101, 106,7);
		gManager.drawPixel(106, 9);
		gManager.drawPixel(107, 9);
		gManager.drawVerticalLine(99, 8, 16);
		gManager.drawVerticalLine(98, 9, 15);
		gManager.drawVerticalLine(97, 10, 16);
	}
	
	private void drawAstronautBody() {
		gManager.drawRectangle(98, 16, 104, 25);
		gManager.paintFlood(rocketBuffer,99,17, CustomColors.SPACE_SUIT_COLOR);
		gManager.drawHorizontalLine(99, 105,16);
		gManager.drawRectangle(99, 25, 111, 28);
		gManager.paintFlood(rocketBuffer,100,27, CustomColors.SPACE_SUIT_COLOR);
		gManager.drawRectangle(108, 28, 112,31);
		gManager.paintFlood(rocketBuffer,109,29, CustomColors.SPACE_SUIT_COLOR);
	}
	
	private void drawAstronautBoots() {
		gManager.setColor(CustomColors.SLEEVE_COLOR);
		gManager.drawVerticalLine(97, 18, 22);
		gManager.drawVerticalLine(111,32, 35);
		gManager.drawVerticalLine(110,32, 35);
		gManager.drawVerticalLine(109,32, 35);
		gManager.drawVerticalLine(108,32, 35);
	}
	
	private void drawBox() {
		gManager.setColor(CustomColors.BOX_EDGE);
		gManager.drawRectangle(98, 28, 107, 34);
		gManager.paintFlood(rocketBuffer, 99, 29, CustomColors.BOX);
	}

	private void drawBanjo() {
		gManager.setColor(CustomColors.BROWN);
		gManager.drawRectangle(106, 20, 109, 23);
		gManager.paintFlood(rocketBuffer, 107, 21, CustomColors.BANJO_COLOR);
		gManager.drawVerticalLine(105, 21, 22);
		gManager.drawVerticalLine(110, 21, 22);
		gManager.drawHorizontalLine(107, 108, 19);
		gManager.drawHorizontalLine(107, 108, 24);
		gManager.drawLine(108, 19, 114, 13);
		gManager.drawLine(109, 19, 115, 13);

	}
	
	private void drawAstronautSleeves() {
		gManager.setColor(CustomColors.SLEEVE_COLOR);
		gManager.drawVerticalLine(103, 18,24);
		gManager.drawVerticalLine(102, 18,24);
		gManager.drawVerticalLine(101, 18,23);		
		gManager.drawLine(104, 24, 108, 23);
		gManager.drawLine(104, 23, 108, 22);
		gManager.drawLine(104, 22, 108, 21);
		gManager.drawHorizontalLine(105, 110,16);
		gManager.drawHorizontalLine(105, 109,17);
		gManager.drawPixel(105, 19);
	}
	
	private void copyRocket() {
		gRocketLessFire.drawImage(rocketBuffer, 0,0,null);
	}
	
	private void drawFire() {
		fireBuffer = rocketFire.getFire();
		gRocket.drawImage(fireBuffer, FIRE_POSITION_X, FIRE_POSITION_Y, null);
		
		lessFireBuffer = rocketFire.getLessFire();
		gRocketLessFire.drawImage(lessFireBuffer, FIRE_POSITION_X, FIRE_POSITION_Y, null);
	}
	
	public BufferedImage getRocket() {
		return rocketBuffer;
	}
	
	public BufferedImage getRocketLessFire() {
		return rocketBufferLessFire;
	}
	



}
