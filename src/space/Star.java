package space;

import graphics.CustomColors;
import graphics.MyGraphics2D;
import graphics.Point2D;

public class Star{
	
	private boolean shining = false;
	private int x;
	private int y;

	
	public Star(Point2D center) {
		this.x = center.x;
		this.y = center.y;
	}
	
	public Star(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void drawStar(MyGraphics2D g) {
		g.drawPixel(x, y, CustomColors.STAR_CENTER);
		g.drawPixel(x+1, y, CustomColors.STAR);
		g.drawPixel(x-1, y, CustomColors.STAR);
		g.drawPixel(x, y+1, CustomColors.STAR);
		g.drawPixel(x, y-1, CustomColors.STAR);
		g.drawPixel(x+1, y+1, CustomColors.STAR_EDGE);
		g.drawPixel(x-1, y+1, CustomColors.STAR_EDGE);
		g.drawPixel(x+1, y-1, CustomColors.STAR_EDGE);
		g.drawPixel(x-1, y-1, CustomColors.STAR_EDGE);
		g.drawPixel(x+2, y, CustomColors.STAR_EDGE);
		g.drawPixel(x-2, y, CustomColors.STAR_EDGE);
		g.drawPixel(x, y+2, CustomColors.STAR_EDGE);
		g.drawPixel(x, y-2, CustomColors.STAR_EDGE);
	}
	
	public void shine(MyGraphics2D g) {
		g.drawPixel(x+3, y, CustomColors.STAR_EDGE);
		g.drawPixel(x-3, y, CustomColors.STAR_EDGE);
		g.drawPixel(x, y+3, CustomColors.STAR_EDGE);
		g.drawPixel(x, y-3, CustomColors.STAR_EDGE);
		g.drawPixel(x+4, y, CustomColors.STAR_EDGE);
		g.drawPixel(x-4, y, CustomColors.STAR_EDGE);
		g.drawPixel(x, y+4, CustomColors.STAR_EDGE);
		g.drawPixel(x, y-4, CustomColors.STAR_EDGE);
	}
	
	public void stopShine(MyGraphics2D g) {
		g.drawPixel(x+3, y, CustomColors.BLACK);
		g.drawPixel(x-3, y, CustomColors.BLACK);
		g.drawPixel(x, y+3, CustomColors.BLACK);
		g.drawPixel(x, y-3, CustomColors.BLACK);
		g.drawPixel(x+4, y, CustomColors.BLACK);
		g.drawPixel(x-4, y, CustomColors.BLACK);
		g.drawPixel(x, y+4, CustomColors.BLACK);
		g.drawPixel(x, y-4, CustomColors.BLACK);
	}
	

	public boolean isShining() {
		return shining;
	}
	
}
