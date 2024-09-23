package space;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.CustomColors;
import graphics.MyGraphics2D;
import graphics.Point2D;

public class Meteor {
	
	private MyGraphics2D gManager;
	private BufferedImage meteorBuffer;
	private Graphics2D gMeteor;
	private int radius;
	private Point2D position, center, speed;
	
	public Meteor(int _radius, Point2D position, Point2D _speed) {
		this.radius = _radius;
		this.position = position;
		this.speed = _speed;
		int bufferSize = ((radius*2)+4);
		center = new Point2D(_radius + 2, radius + 2);
		
		meteorBuffer = new BufferedImage(bufferSize,bufferSize, BufferedImage.TYPE_INT_ARGB);
		gMeteor = meteorBuffer.createGraphics();
		gManager = new MyGraphics2D();
		
		drawMeteor();
	}
	
	public void drawMeteor() {
		gManager.setGraphics(gMeteor);
		gManager.drawCircle(center, radius);
		gManager.paintFlood(meteorBuffer, center, CustomColors.METEOR_COLOR);
	}
	
	public void move() {
		position.movePoint(speed);
	}
	
	public Point2D getPosition() {return position;}

	public void setX(int nX) {this.position.x = nX;}
		
	public BufferedImage getMeteor() {
		return meteorBuffer;
	}
	
}
