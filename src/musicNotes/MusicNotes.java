package musicNotes;

import java.awt.image.BufferedImage;

import graphics.Point2D;
import utils.Utils;

public class MusicNotes {

	private int x_maxSpeed, x_minSpeed;
	private int y_speed;
	
	private BufferedImage note;
	private Point2D position;
	
	public MusicNotes(BufferedImage _note, Point2D _position,int _x_minSpeed, int _x_maxSpeed, int _y_speed) {
		this.note = _note;
		this.position = new Point2D (_position);
		this.x_maxSpeed = _x_maxSpeed;
		this.x_minSpeed = _x_minSpeed;
		this.y_speed = _y_speed;
	}
	
	public void moveNote() {
		position.movePoint(getRandomSpeed());
	}
	
	public BufferedImage getNote() {
		return note;
	}
	
	public int getX() {
		return position.x;
	}
	
	public int getY() {
		return position.y;
	}
	
	private Point2D getRandomSpeed() {
		return new Point2D(
				Utils.getRandom(x_minSpeed, x_maxSpeed),
				y_speed
				);
	}
	
}
