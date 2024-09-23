package space;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphics.Point2D;

import utils.Utils;

public class Meteors {
	
	private final int MIN_SIZE = 4;
	private final int MAX_SIZE = 15;
	
	private final int MIN_X_SPEED = -3;
	private final int MAX_X_SPEED = -8;
	
	private final int MIN_Y_SPEED = -1;
	private final int MAX_Y_SPEED = 1;
	
	private final int LIMIT_X = 100;
	private final int LIMIT_Y = 40;
	
	private BufferedImage bufferMeteors;
	private Meteor[] meteors;
	private Graphics gMeteors;

	public Meteors(int sizeX, int sizeY, int nMeteors)
	{
		bufferMeteors = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);
		gMeteors = bufferMeteors.createGraphics();

		meteors = new Meteor[nMeteors];
		initMeteors();
	}
	
	private void initMeteors() {
		for(int i = 0; i < meteors.length; i++) {
			meteors[i] = createRandomMeteor();
			drawMeteor(meteors[i]);
		}
	}
	
	private void drawMeteor(Meteor meteor) {
		gMeteors.drawImage(meteor.getMeteor(), meteor.getPosition().x, meteor.getPosition().y, null);		

	}
		
	public void moveBufferMeteors() {
		bufferMeteors = new BufferedImage(bufferMeteors.getWidth(), bufferMeteors.getHeight(), BufferedImage.TYPE_INT_ARGB);
		gMeteors = bufferMeteors.createGraphics();
		for(int i = 0; i < meteors.length; i++) {
			if(outOfLimits(meteors[i])) {
				meteors[i] = createRandomMeteor();
				meteors[i].setX(bufferMeteors.getWidth() + LIMIT_X);
			}
			gMeteors.drawImage(meteors[i].getMeteor(), meteors[i].getPosition().x, meteors[i].getPosition().y, null);
		}
		
	}
	
	private boolean outOfLimits(Meteor meteor) {
		return meteor.getPosition().x < -LIMIT_X || meteor.getPosition().y > (LIMIT_Y + bufferMeteors.getHeight());

	}

	private Meteor createRandomMeteor() {
		return new Meteor(getRandomSize(), getRandomPosition(), getRandomSpeed());
	}
	
	private Point2D getRandomPosition() {
		return new Point2D(
				Utils.getRandom(LIMIT_X,bufferMeteors.getWidth() + LIMIT_X),
				Utils.getRandom(LIMIT_Y,bufferMeteors.getHeight() - LIMIT_Y)
				);		
	}
	
	private Point2D getRandomSpeed() {
		return new Point2D(
				Utils.getRandom(MIN_X_SPEED, MAX_X_SPEED),
				Utils.getRandom(MIN_Y_SPEED, MAX_Y_SPEED)
				);		
	}
	
	private int getRandomSize() {
		return Utils.getRandom(MIN_SIZE, MAX_SIZE);
	}

	public BufferedImage getMeteors() {
		return bufferMeteors;
	}

	public void moveMeteors() {
		for(int i = 0; i < meteors.length; i++) {
			meteors[i].move();
		}
		moveBufferMeteors();
	}

}
