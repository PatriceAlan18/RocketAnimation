package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

import graphics.CustomColors;
import graphics.MyGraphics2D;
import graphics.Point2D;
import musicNotes.Music;
import space.Meteors;
import space.Planets;
import space.Rocket;
import space.Star;
import utils.Utils;


@SuppressWarnings("serial")
public class Window extends JFrame{

	//Some constants
	private final int PLANETS_NUMBER = Utils.getRandom(8, 12);
	private final int METEORS_NUMBER = Utils.getRandom(24, 30);
	private final int ROCKET_X_MOVEMENT = 2;
	private Point2D musicPosition;
	
	//Values
	private Point2D rocketPosition;
	private boolean rocketMoved = false;
	
	//Graphic Manager
	private MyGraphics2D gManager;

	//BufferedImages
	private BufferedImage background, screen, starBuffer, planetsBuffer, rocketBuffer, rocketLessFireBuffer, meteorBuffer, musicBuffer;
	private Graphics gBackground, gScreen, gStarBuffer;
	
	//Animation elements
	private Star[] stars, shiningStars;
	private Planets planets;
	private Rocket rocket;
	private Meteors meteors;
	private Music music;
	
	public Window() {
		this.setTitle("Rocket");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		gManager = new MyGraphics2D();
		rocketPosition = new Point2D(getWidth()/2-100,getHeight()/2-50);

		initBufferedImages();
		
		planets = new Planets(getWidth(),getHeight(), PLANETS_NUMBER);
		meteors = new Meteors(getWidth(),getHeight(), METEORS_NUMBER);
		rocket = new Rocket();

		initMusic();

	}
	
	@Override 
	public void paint(Graphics g) {
		gScreen.drawImage(background, 0,0,this);
		gScreen.drawImage(starBuffer, 0,0, this);
		gScreen.drawImage(planetsBuffer, 0,0,this);
		gScreen.drawImage(meteorBuffer, 0,0,this);
		gScreen.drawImage(musicBuffer,0,0,this);
		paintRocket();
		
		this.getGraphics().drawImage(screen, 0,0,this);
	}
	
	private void initBufferedImages() {
		background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		gBackground = background.createGraphics();
		screen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		gScreen = screen.createGraphics();
		starBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		gStarBuffer = starBuffer.createGraphics();
	}
	
	private void initMusic() {
		Point2D banjoPosition = rocket.getBanjoPosition();
		musicPosition = new Point2D(rocketPosition);
		musicPosition.movePoint(banjoPosition);
		music = new Music(musicPosition);
	}

	public void draw() {
		drawBackground();
		drawStars();
		drawPlanets();
		drawMeteors();
		drawRocket();
		drawMusic();
		repaint();
	}
	
	private void drawBackground() {
		gManager.setGraphics(gBackground);
		gManager.drawRectangle(0, 0, getWidth()-1, getHeight()-1);
		gManager.paintSL(background, 1, 1, CustomColors.SPACE_COLOR );
	}
	
	private void drawStars() {
		gManager.setGraphics(gStarBuffer);
		stars = new Star[Utils.getRandom(400, 550)];
		for(int i = 0; i<stars.length; i++) {
			stars[i] = new Star(Utils.getRandom(5, this.getWidth()-5),Utils.getRandom(5, this.getHeight()-5));
			stars[i].drawStar(gManager);
		}
	}
	
	private void drawPlanets() {
		planetsBuffer = planets.getPlanets();
	}
	
	private void drawRocket() {
		rocketBuffer = rocket.getRocket();
		rocketLessFireBuffer = rocket.getRocketLessFire();
	}
	
	private void drawMeteors() {
		meteorBuffer = meteors.getMeteors();
	}
	
	private void drawMusic() {
		musicBuffer = music.getMusicBuffer();
	}
	
	public void shineStars() {
		gManager.setGraphics(gStarBuffer);
		shiningStars = new Star[Utils.getRandom(30, stars.length-1)];
		for(int i = 0; i<shiningStars.length; i++) {
			shiningStars[i] = stars[Utils.getRandom(0, stars.length-1)];
			shiningStars[i].shine(gManager);
		}
	}
	
	public void stopShineStars() {
		gManager.setGraphics(gStarBuffer);
		for(int i = 0; i<shiningStars.length; i++) {
			shiningStars[i].stopShine(gManager);
		}
	}
	
	public void movePlanets() {
		planets.movePlanets();
		planetsBuffer = planets.getPlanets();
	}
	
	private void paintRocket() {
		if(rocketMoved) gScreen.drawImage(rocketLessFireBuffer, rocketPosition.x, rocketPosition.y, this);
		else gScreen.drawImage(rocketBuffer, rocketPosition.x, rocketPosition.y, this);

	}
	
	public void moveRocket() {
		if(rocketMoved)rocketPosition.movePoint(-ROCKET_X_MOVEMENT, 0);
		else rocketPosition.movePoint(ROCKET_X_MOVEMENT, 0);
		rocketMoved = !rocketMoved;
		
	}
	
	public void moveMeteors() {
		meteors.moveMeteors();
		meteorBuffer = meteors.getMeteors();
	}
	
	public void moveMusic() {
		music.moveNotes();
		musicBuffer = music.getMusicBuffer();
	}
}
