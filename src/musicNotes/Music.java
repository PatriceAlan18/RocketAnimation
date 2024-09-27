package musicNotes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphics.Point2D;

public class Music {
	
	private final int Y_LIMIT = - 50;
	
	//Speed note values
	private final int X_MIN_SPEED = -3;
	private final int X_MAX_SPEED = -1;
	private final int Y_SPEED = -1;
	
	private Point2D jumpPosition;
	private Point2D jumpTracker;
	private int sizeX = 50;
	private int sizeY = 50;
	private BufferedImage musicBuffer;
	private Graphics gMusic;
	private Point2D musicPosition;
	
	private MusicNotes[] notes = new MusicNotes[4];
	
	private MusicNotesDrawer notesDrawer;
	
	public Music(Point2D _musicPosition) {
		this.musicPosition = _musicPosition;
		sizeX += musicPosition.x;
		sizeY += musicPosition.y;
		jumpPosition = new Point2D(
				musicPosition.x /8,
				musicPosition.y /3
				);
		
		jumpTracker = new Point2D(jumpPosition);
		jumpTracker.movePoint(musicPosition.x / 2, - jumpPosition.y);
				
		notesDrawer = new MusicNotesDrawer();
		
		createNotes();
		drawNotes();
	}
	
	private void createNotes() {
		notes[0] = new MusicNotes(
				notesDrawer.getNote0(), new Point2D(jumpTracker.x, jumpTracker.y),X_MIN_SPEED, X_MAX_SPEED, Y_SPEED);
		jumpTracker.movePoint(jumpPosition);
		notes[1] = new MusicNotes(
				notesDrawer.getNote1(), new Point2D(jumpTracker.x, jumpTracker.y),X_MIN_SPEED, X_MAX_SPEED, Y_SPEED);
		jumpTracker.movePoint(jumpPosition);
		notes[2] = new MusicNotes(
				notesDrawer.getNote2(), new Point2D(jumpTracker.x, jumpTracker.y),X_MIN_SPEED, X_MAX_SPEED, Y_SPEED);
		notes[3] = new MusicNotes(
				notesDrawer.getNote3(), new Point2D(musicPosition.x, musicPosition.y),X_MIN_SPEED, X_MAX_SPEED, Y_SPEED);
	}
	
	private void drawNotes() {
		musicBuffer = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);
		gMusic = musicBuffer.createGraphics();
		for(int i = 0; i < notes.length; i++) gMusic.drawImage(notes[i].getNote(), notes[i].getX(), notes[i].getY(), null);
		
	}
	
	public void moveNotes() {
		for(int i = 0; i < notes.length; i++) {
			notes[i].moveNote();
			if(noteOutOfLimits(notes[i]))notes[i] = new MusicNotes(notes[i].getNote(), musicPosition ,X_MIN_SPEED, X_MAX_SPEED, Y_SPEED);
		}
		drawNotes();
	}
	
	private boolean noteOutOfLimits(MusicNotes note) {
		return (note.getY() < Y_LIMIT);
	}
	
	public BufferedImage getMusicBuffer() {
		return musicBuffer;
	}
	
}
