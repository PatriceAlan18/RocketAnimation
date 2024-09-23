package space;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphics.CustomColors;
import graphics.Point2D;
import utils.Utils;

public class Planets {

	private final int RING_PERCENT = 50;
	
	private final int PLANET_SPEED = -1;
	private final int X_MOVE_LIMIT = -50;
	private final int X_START_POSITION = 50;
	
	private final int POSITION_LIMIT_X = 100; 
	private final int POSITION_LIMIT_Y = 40;
	
	private final int MIN_SIZE = 12;
	private final int MAX_SIZE = 25;

	private BufferedImage bufferPlanets;
	private Graphics gPlanets;
	
	private Planet[] myPlanets;
	
	public Planets(int sizeX, int sizeY, int nPlanets) {
		bufferPlanets = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);
		gPlanets = bufferPlanets.createGraphics();

		myPlanets = new Planet[nPlanets];
		
		drawPlanets();
	}
	
	private void drawPlanets() {
		for(int i = 0; i < myPlanets.length; i++) {
			if(myPlanets[i] == null) myPlanets[i] = newRandomPlanet();
			myPlanets[i].drawPlanet();
			gPlanets.drawImage(myPlanets[i].getImage(), myPlanets[i].getX(), myPlanets[i].getY(), null);
		}
	}
	
	private Planet newRandomPlanet() {
		Planet planet =  new Planet(getRandomPosition(), getRandomSize(), CustomColors.getRandomPlanetColor());
		if(Utils.percentChance(RING_PERCENT))planet.setRing(CustomColors.getRandomRingColor());
		return planet;
				
	}
	
	public void movePlanets() {
		for(int i = 0; i < myPlanets.length; i++) {
			myPlanets[i].movePlanet(PLANET_SPEED, 0);
		}
		moveBufferPlanets();
	}
	
	public void moveBufferPlanets() {
		bufferPlanets = new BufferedImage(bufferPlanets.getWidth(), bufferPlanets.getHeight(), BufferedImage.TYPE_INT_ARGB);
		gPlanets = bufferPlanets.createGraphics();
		for(int i = 0; i < myPlanets.length; i++) {
			if(myPlanets[i].getX() < X_MOVE_LIMIT) {
				myPlanets[i] = newRandomPlanet();
				myPlanets[i].setX(bufferPlanets.getWidth() + X_START_POSITION);
				myPlanets[i].drawPlanet();
			}
			gPlanets.drawImage(myPlanets[i].getImage(), myPlanets[i].getX(), myPlanets[i].getY(), null);
		}
	}
	
	public BufferedImage getPlanets() {
		return bufferPlanets;
	}
	
	private Point2D getRandomPosition() {
		return new Point2D(
				Utils.getRandom( POSITION_LIMIT_X,  bufferPlanets.getWidth() + POSITION_LIMIT_X),
				Utils.getRandom( POSITION_LIMIT_Y,  bufferPlanets.getHeight() - POSITION_LIMIT_Y)
				);
	}
	
	private int getRandomSize() {
		return Utils.getRandom(MIN_SIZE, MAX_SIZE);
	}
	

	


	
	
}
