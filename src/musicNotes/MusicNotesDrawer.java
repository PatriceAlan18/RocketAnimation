package musicNotes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.CustomColors;
import graphics.MyGraphics2D;

public class MusicNotesDrawer {
	
	private final int BUFFER_SIZE = 50;
	private final int SIZE = 3;
	private final int X_DPO = 10;
	private final int Y_DPO = 40;
	
	private BufferedImage note0, note1, note2, note3;
	private Graphics2D gNote0, gNote1, gNote2, gNote3;
	
	private MyGraphics2D gManager;
	
	public MusicNotesDrawer() {
		gManager = new MyGraphics2D();
		drawNotes();
	}
	
	private void drawNotes() {
		drawNote0();
		drawNote1();
		drawNote2();
		drawNote3();
	}
	
	private void drawNote0() {
		note0 = new BufferedImage(BUFFER_SIZE,BUFFER_SIZE,BufferedImage.TYPE_INT_ARGB);
		gNote0 = note0.createGraphics();
		gManager.setGraphics(gNote0);
		gManager.setColor(CustomColors.RED);
		
		gManager.drawParametricCircleArc(X_DPO + SIZE, Y_DPO + SIZE, SIZE, 165, 455);
		gManager.drawParametricCircleArc(X_DPO + SIZE + 12, Y_DPO + SIZE - 3,SIZE, 165, 455);

		gManager.drawVerticalLine(X_DPO + SIZE + SIZE, Y_DPO - SIZE, Y_DPO + SIZE);
		gManager.drawVerticalLine(X_DPO + SIZE, Y_DPO, Y_DPO - SIZE -SIZE);
		
		gManager.drawVerticalLine(X_DPO + SIZE + 12, Y_DPO -3, Y_DPO - SIZE -3);
		gManager.drawVerticalLine(X_DPO + SIZE + SIZE + 12, Y_DPO + SIZE -3 , Y_DPO - SIZE -SIZE -3);

		gManager.drawLine(X_DPO + SIZE, Y_DPO - SIZE - SIZE, X_DPO+SIZE+SIZE+12, Y_DPO - SIZE - SIZE -3);
		gManager.drawLine(X_DPO + SIZE + SIZE, Y_DPO - SIZE, X_DPO + SIZE + 12, Y_DPO - SIZE -3);
		
		gManager.paintFlood(note0,X_DPO + SIZE, Y_DPO + SIZE, CustomColors.RED);
	}
	
	private void drawNote1() {
		note1 = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB);
		gNote1 = note1.createGraphics();
		gManager.setGraphics(gNote1);
		gManager.setColor(CustomColors.GREEN);
		
		gManager.drawParametricCircleArc(X_DPO + SIZE, Y_DPO + SIZE, SIZE, 165, 455);
		gManager.drawVerticalLine(X_DPO + SIZE + SIZE, Y_DPO - SIZE - SIZE -3, Y_DPO + SIZE);
		gManager.drawVerticalLine(X_DPO + SIZE, Y_DPO, Y_DPO - SIZE - SIZE -3);
		gManager.drawHorizontalLine(X_DPO + SIZE, X_DPO + SIZE + SIZE, Y_DPO - SIZE - SIZE -3);
		
		gManager.paintFlood(note1, X_DPO + SIZE, Y_DPO + SIZE, CustomColors.GREEN);
	}
	
	private void drawNote2() {
		note2 = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB);
		gNote2 = note2.createGraphics();
		gManager.setGraphics(gNote2);
		gManager.setColor(CustomColors.BLUE);

		gManager.drawParametricCircleArc(X_DPO + SIZE, Y_DPO + SIZE, SIZE, 165, 455);
		gManager.drawVerticalLine(X_DPO + SIZE + SIZE, Y_DPO - SIZE -3, Y_DPO + SIZE);
		
		gManager.drawParametricCircleArc(X_DPO + SIZE, Y_DPO + SIZE, SIZE * 4, 150, 180);
		gManager.drawParametricCircleArc(X_DPO + SIZE + SIZE, Y_DPO + SIZE, SIZE * 3, 160,180);
		
		gManager.drawVerticalLine(X_DPO + SIZE, Y_DPO, Y_DPO - SIZE - SIZE -3);
		gManager.drawHorizontalLine(X_DPO + SIZE, X_DPO + SIZE + SIZE, Y_DPO - SIZE - SIZE -3);

		gManager.paintFlood(note2, X_DPO + SIZE, Y_DPO + SIZE, CustomColors.BLUE);
	}
	
	private void drawNote3() {
		note3 = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB);
		gNote3 = note3.createGraphics();
		gManager.setGraphics(gNote3);
		gManager.setColor(CustomColors.YELLOW);

		gManager.drawParametricCircleArc(X_DPO + SIZE, Y_DPO + SIZE, SIZE, 165, 455);
		gManager.drawParametricCircleArc(X_DPO + SIZE + 12, Y_DPO + SIZE -3, SIZE, 165, 455);

		gManager.drawVerticalLine(X_DPO + SIZE + SIZE, Y_DPO - SIZE, Y_DPO + SIZE);
		gManager.drawVerticalLine(X_DPO + SIZE,Y_DPO,  Y_DPO - SIZE - SIZE);
		
		gManager.drawVerticalLine(X_DPO + SIZE + 12, Y_DPO - 3, Y_DPO - SIZE - 3);
		gManager.drawVerticalLine(X_DPO + SIZE + SIZE + 12, Y_DPO + SIZE -3, Y_DPO - SIZE - SIZE);

		gManager.drawLine(X_DPO + SIZE + SIZE + 12, Y_DPO - SIZE - SIZE, X_DPO + SIZE + SIZE + 20, Y_DPO - SIZE - SIZE -1);
		gManager.drawLine(X_DPO + SIZE + SIZE + 12, Y_DPO - SIZE - SIZE -3, X_DPO+ SIZE + SIZE + 24 , Y_DPO - SIZE - SIZE -4); 

		gManager.drawVerticalLine(X_DPO + SIZE + SIZE +24, Y_DPO - SIZE - SIZE -4, Y_DPO - SIZE);
		gManager.drawVerticalLine(X_DPO + SIZE + SIZE + 21, Y_DPO - SIZE - SIZE -1, Y_DPO - SIZE -2);

		gManager.drawParametricCircleArc(X_DPO + SIZE + SIZE + 21, Y_DPO + SIZE -5, SIZE, 165, 455);

		gManager.drawLine(X_DPO + SIZE, Y_DPO - SIZE - SIZE, X_DPO + SIZE + SIZE + 12, Y_DPO - SIZE - SIZE -3);
		gManager.drawLine(X_DPO + SIZE + SIZE, Y_DPO - SIZE, X_DPO  + SIZE + 12, Y_DPO - SIZE - 3);

		gManager.paintFlood(note3, X_DPO + SIZE, Y_DPO + SIZE, CustomColors.YELLOW);
	}

	public BufferedImage getNote0() {
		return note0;
	}
	
	public BufferedImage getNote1() {
		return note1;
	}
	
	public BufferedImage getNote2() {
		return note2;
	}
	
	public BufferedImage getNote3() {
		return note3;
	}
	
}
