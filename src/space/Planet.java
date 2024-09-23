package space;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphics.CustomColors;
import graphics.MyGraphics2D;
import graphics.Point2D;
import utils.Utils;

public class Planet {

	private final int PLANET_BUFFER_SIZE = 80;
	private final int RING_THICKNESS = Utils.getRandom(3, 5);
	
	private boolean hasRing = false;
	private int size;

	private Color ringColor, edgeColor;
	private Color[] planetColor;
	
	private Point2D position, center;
	
	private BufferedImage planetBuffered;
	
	private Graphics gPlanet;
	
	private MyGraphics2D gManager;
	
	public Planet(Point2D _position,  int _size, Color[] _planetColor) {
		this.position = _position;
		this.planetColor = _planetColor;
		this.size = _size;
		this.edgeColor = new Color(planetColor[0].getRed(), planetColor[0].getGreen(), planetColor[0].getBlue(), 80);
		
		planetBuffered = new BufferedImage(PLANET_BUFFER_SIZE, PLANET_BUFFER_SIZE, BufferedImage.TYPE_INT_ARGB);
		gPlanet = planetBuffered.createGraphics();
		
		gManager = new MyGraphics2D();
		gManager.setGraphics(gPlanet);
	}
	
	public void setRing(Color _ringColor) {
		hasRing = true;
		this.ringColor = _ringColor;
	}
	
	public BufferedImage getImage() {
		return planetBuffered;
	}
	
	public void movePlanet(int dx, int dy) {
		position.movePoint(dx, dy);
	}
	
	public void drawPlanet() {
		center = new Point2D((int) (PLANET_BUFFER_SIZE * (0.5)), (int) (PLANET_BUFFER_SIZE * (0.5)));
		gManager.setColor(edgeColor);
		gManager.drawCircle(center, size);
		gManager.paintFlood(planetBuffered, center, CustomColors.BLACK);
		gManager.paintFlood(planetBuffered, center, planetColor);
		if(hasRing)drawRing();
	}
	
	private void drawRing() {
		
		gManager.setColor(ringColor);
		gManager.setThickness(RING_THICKNESS);
		Point2D left = new Point2D(center.x - size -1, center.y + Utils.getRandom(-4, 4));
		Point2D right = new Point2D(center.x + size, center.y + Utils.getRandom(-4, 4));
		gManager.drawLine(left, center);
		gManager.drawLine(center, right);
		gManager.setThickness(gManager.DEFAULT_THICKNESS);
	}
	
	public int getX() {return position.x;}
	
	public int getY() {return position.y;}
	
	public void setX(int x) {this.position.x = x;}
	
	
}
