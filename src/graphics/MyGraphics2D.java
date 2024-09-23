package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.Utils;

public class MyGraphics2D {
	
	public int DEFAULT_THICKNESS = 1;
	
	private int currentThickness;
	private BufferedImage bufferAux, thickAuxBuffer;
	private Graphics g;
	private Color c;
	
	private boolean thickBufferReady;

	/**
	 * A factor that controls the smoothness of the parametric circle or arc.
	 */
	private final double SMOOTHNESSFACTOR = 40;
	
	public MyGraphics2D() {
		bufferAux = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
		c = Color.black;
		currentThickness = DEFAULT_THICKNESS;
		thickBufferReady = false;
	}
	
	public void setGraphics(Graphics graphics) {
		this.g=graphics;
	}
	
	public void setColor(Color color) {
		if(c==color)return;
		this.c = color;
		thickBufferReady = false;
	}
	
	public void drawVerticalLine(int x, int y, int yF) {
		if(y>yF)
			for(int i = 0; i <= (y-yF); i++)drawPixel(x, y-i);
		else
			for(int i = 0; i <= (yF-y); i++)drawPixel(x, y+i);
	}
	
	public void drawVerticalLine(Point2D start, int endY) {
		drawVerticalLine(start.x, start.y, endY);
	}
	
	public void drawVerticalLine(int x, int y, int yF, Color[] c) {
		if(y>yF)
			for(int i = 0; i <= (y-yF); i++)drawPixel(x, y-i, c[Utils.getRandom(0, c.length -1 )]);
		else
			for(int i = 0; i <= (yF-y); i++)drawPixel(x, y+i, c[Utils.getRandom(0, c.length -1 )]);
	}
	
	public void drawVerticalLine(Point2D start, int endY, Color[] c) {
		drawVerticalLine(start.x, start.y,endY,c);
	}
	
	public void drawHorizontalLine(int x, int xF, int y) {
		if(x>xF) 
			for(int i = 0; i <= (x-xF); i++)  drawPixel(x-i, y);	
		else
			for(int i = 0; i <= (xF-x); i++)  drawPixel(x+i, y);			
	}
	
	public void drawHorizontalLine(Point2D start, int endX) {
		drawHorizontalLine(start.x, endX, start.y);
	}
	
	public void drawHorizontalLine(int x, int xF, int y, Color[] c) {
		if(x>xF) 
			for(int i = 0; i <= (x-xF); i++)  drawPixel(x-i, y, c[Utils.getRandom(0,  c.length-1)]);	
		else
			for(int i = 0; i <= (xF-x); i++)  drawPixel(x+i, y, c[Utils.getRandom(0,  c.length-1)]);			
	}
	
	public void drawHorizontalLine(Point2D start, int endX, Color[] c) {
		drawHorizontalLine(start.x, endX, start.y ,c);
	}
	
	public void drawLine(int x0, int y0, int x1, int y1) {
		int dy = y1-y0;
		int dx = x1-x0;
		if(dx==0) {
			drawVerticalLine(x1 ,y0, y1);
			return;
		}
		
		if(dy==0) {
			drawHorizontalLine(x0, x1, y0);
			return;
		}
		
		int incYi = 1, incYr, incXr, incXi=1, k;
		if(dy<=0) {
			dy= -dy;
			incYi=-1;
		}
		if(dx<0) {
			dx= -dx;
			incXi=-1;
		}
		if(dx>=dy) {
			incYr = 0;
			incXr = incXi;
		}
		else {
			incXr=0;
			incYr=incYi;
			
			k = dx;
			dx = dy;
			dy = k;
		}
		int x=x0;
		int y=y0;
		int avR = (2*dy);
		int av = (avR - dx);
		int avI = (av-dx);
		do {
				drawPixel(x, y);
			if(av >=0) {
				x = (x+incXi);
				y = (y+incYi);
				av = (av+avI);
			}
			else {
				x = (x+incXr);
				y = (y+incYr);
				av = (av + avR);
			}
		}while(x!=x1);
		drawPixel(x, y);
	}
	
	public void drawLine(Point2D start, Point2D end) {
		drawLine(start.x,  start.y, end.x, end.y);
	}
	
	public void drawRectangle(int x0, int y0, int x1, int y1) {
		drawVerticalLine(x0,y0,y1);
		drawHorizontalLine(x0,x1,y1);
		drawVerticalLine(x1,y0,y1);
		drawHorizontalLine(x0,x1,y0);
	}
	
	public void drawRectangle(Point2D topLeftCorner,Point2D bottomRightCorner ) {
		drawRectangle(topLeftCorner.x, topLeftCorner.y, bottomRightCorner.x, bottomRightCorner.y);
	}
	
	public void drawCircle(Point2D center, int R) {
		drawCircle(center.x, center.y, R);
	}
	
	public void drawCircle(int x0, int y0, int R) {
		double pk = 3-2*R;
		int y = R;
		int x = 0;
		drawOctants(x,y, x0, y0);
		while(x<=y) {
			if(pk<=0) {
				pk = pk + 4*x + 6;
			}
			else {
				pk= pk + 4*(x-y) + 10;
				y--;
			}
			x++;
			drawOctants(x, y, x0, y0);
		}
	}
	
	private void drawOctants(int x, int y, int x0, int y0) {
		drawPixel(x0+x,y0+y);
		drawPixel(x0+y,y0-x);
		drawPixel(x0+x,y0-y);
		drawPixel(x0-y,y0-x);
		drawPixel(x0-x,y0-y);
		drawPixel(x0+y,y0+x);
		drawPixel(x0-y,y0+x);
		drawPixel(x0-x,y0+y);
	}

	public void drawParametricCircle(int x0, int y0, int R) {
		drawParametricCircle(x0, y0, R, SMOOTHNESSFACTOR);
	}
	
	public void drawParametricCircle(int x0, int y0, int R, double smoothnessFactor) {
		drawParametricCircleArc(x0, y0, R, 0, 360, smoothnessFactor);	
	}
	
	public void drawParametricCircleArc(int x0, int y0, int R,int startDegrees, int endDegrees) {
		drawParametricCircleArc(x0, y0, R, startDegrees, endDegrees, SMOOTHNESSFACTOR);
	}
	
	public void drawParametricCircleArc(int x0, int y0, int R,int startDegrees, int endDegrees, double smoothnessFactor) {
		int x=0, y=0;
		double increase = (double)smoothnessFactor/(double)R;
		for(double t = startDegrees; t <endDegrees; t+=increase) {
			x = (int) Math.round(x0+(R*Math.sin(Math.toRadians(t))));
			y = (int) Math.round(y0+(R*Math.cos(Math.toRadians(t))));
			drawPixel(x, y);
		}		
	}
	
	
	
	public void paintFlood(BufferedImage bf, Point2D center, Color[] nColors) {
		paintFlood(bf, center.x, center.y, nColors);
	}
	
	public void paintFlood(BufferedImage bf, int x, int y, Color[] nColors) {
		paintFlood(bf,x,y, getColorAt(bf, x, y) ,nColors);
	}
	
	public void paintFlood(BufferedImage bf, int x, int y, Color oColor, Color[] nColors) {
		
		int random = Utils.getRandom(0, nColors.length-1);
		
	    drawPixel(x, y, nColors[random]);
	    int upColor 	= bf.getRGB(x,y+1);
	    int downColor 	= bf.getRGB(x,y-1);
	    int leftColor 	= bf.getRGB(x-1,y);
	    int rightColor 	= bf.getRGB(x+1,y);
	     
	    int oColorRGB = oColor.getRGB();
	    	    
	    if (rightColor 	== oColorRGB ) paintFlood(bf,x+1,y, oColor, nColors);
	    if (leftColor 	== oColorRGB ) paintFlood(bf,x-1,y, oColor, nColors);
	    if (upColor 	== oColorRGB ) paintFlood(bf,x,y+1, oColor, nColors);
	    if (downColor 	== oColorRGB ) paintFlood(bf,x,y-1, oColor, nColors);
	}
	
	public void paintFlood(BufferedImage bf, Point2D center) {
		paintFlood(bf, center, c);
	}
	
	public void paintFlood(BufferedImage bf, Point2D center, Color nColor) {
		paintFlood(bf, center.x, center.y, nColor);
	}
	
	public void paintFlood(BufferedImage bf, int x, int y, Color nColor) {
		paintFlood(bf,x,y, getColorAt(bf, x, y) ,nColor);
	}
		
	public void paintFlood(BufferedImage bf, int x, int y, Color oColor, Color nColor) {
	    drawPixel(x, y, nColor);
	    int upColor 	= bf.getRGB(x,y+1);
	    int downColor 	= bf.getRGB(x,y-1);
	    int leftColor 	= bf.getRGB(x-1,y);
	    int rightColor 	= bf.getRGB(x+1,y);
	    
	    int oColorRGB = oColor.getRGB();
	    
	    if (rightColor 	== oColorRGB ) paintFlood(bf,x+1,y, oColor, nColor);
	    if (leftColor 	== oColorRGB ) paintFlood(bf,x-1,y, oColor, nColor);
	    if (upColor 	== oColorRGB ) paintFlood(bf,x,y+1, oColor, nColor);
	    if (downColor 	== oColorRGB ) paintFlood(bf,x,y-1, oColor, nColor);
	}
	
	public void paintFloodDifferentColor(BufferedImage bf, int x, int y, Color differentColor, Color nColor) {
		drawPixel(x, y, nColor);
		
		int upColor 	= bf.getRGB(x,y+1);
	    int downColor 	= bf.getRGB(x,y-1);
	    int leftColor 	= bf.getRGB(x-1,y);
	    int rightColor 	= bf.getRGB(x+1,y);
	    
	    int dColorRGB = differentColor.getRGB();
	    
	    if (rightColor 	!= dColorRGB ) paintFloodDifferentColor(bf,x+1,y, differentColor, nColor);
	    if (leftColor 	!= dColorRGB ) paintFloodDifferentColor(bf,x-1,y, differentColor, nColor);
	    if (upColor 	!= dColorRGB ) paintFloodDifferentColor(bf,x,y+1, differentColor, nColor);
	    if (downColor 	!= dColorRGB ) paintFloodDifferentColor(bf,x,y-1, differentColor, nColor);
	}
	
	public void paintFloodWithGradient(MyGradient2D gradient, BufferedImage bf, Point2D p) {
		paintFloodWithGradient(gradient, bf, p.x, p.y);
	}
	
	public void paintFloodWithGradient(MyGradient2D gradient, BufferedImage bf, int x, int y) {
		paintFloodWithGradient(gradient, bf, x, y, getColorAt(bf, x, y));
	}
	
	public void paintFloodWithGradient(MyGradient2D gradient, BufferedImage bf, int x, int y, Color oColor) {
		drawPixel(x, y, gradient.getColorAt(new Point2D(x,y)));
	    int upColor 	= bf.getRGB(x,y+1);
	    int downColor 	= bf.getRGB(x,y-1);
	    int leftColor 	= bf.getRGB(x-1,y);
	    int rightColor 	= bf.getRGB(x+1,y);
	    
	    
	    int oColorRGB = oColor.getRGB();
	    
	    if (rightColor 	== oColorRGB ) paintFloodWithGradient(gradient, bf,x+1,y, oColor);
	    if (leftColor 	== oColorRGB ) paintFloodWithGradient(gradient, bf,x-1,y, oColor);
	    if (upColor 	== oColorRGB ) paintFloodWithGradient(gradient, bf,x,y+1, oColor);
	    if (downColor 	== oColorRGB ) paintFloodWithGradient(gradient, bf,x,y-1, oColor);
	}
	
	public void paintSL(BufferedImage bf, Point2D center, Color[] nColor) {
		paintSL(bf, center.x, center.y, nColor);
	}
	
	public void paintSL(BufferedImage bf, Point2D center, Color oColor, Color[] nColor) {
		paintSL(bf, center.x, center.y, oColor, nColor);
	}
	
	public void paintSL(BufferedImage bf, int x, int y, Color[] nColor) {
		paintSL(bf, x, y, getColorAt(bf, x, y), nColor);
	}
	
	public void paintSL(BufferedImage bf, int x, int y, Color oColor, Color[] nColor) {
		int x0 = x, y0 = y;
		int x1 = x0, y1 = y0;
		
		int oColorRGB = oColor.getRGB();

		while(bf.getRGB(x1+1, y0)==oColorRGB) x1++;
		while(bf.getRGB(x0-1, y0)==oColorRGB) x0--;
		

		while(x0 <= x1) {
			while(bf.getRGB(x0, y1+1)==oColorRGB) y1++;
			while(bf.getRGB(x0, y0-1)==oColorRGB) y0--;
			drawVerticalLine(x0, y0,y1, nColor);
			x0++;
		}
	}
	
	public void paintSL(BufferedImage bf, Point2D center, Color oldColor) {
		paintSL(bf, center.x, center.y, oldColor);
	}
	
	public void paintSL(BufferedImage bf, int x, int y, Color oColor) {
		int x0 = x, y0 = y;
		int x1 = x0, y1 = y0;
		
		int oColorRGB = oColor.getRGB();
		
		while(bf.getRGB(x1+1, y0)==oColorRGB) x1++;
		while(bf.getRGB(x0-1, y0)==oColorRGB) x0--;
		
		while(x0 <= x1) {
			while(bf.getRGB(x0, y0+1)==oColorRGB) y1++;
			while(bf.getRGB(x1, y0-1)==oColorRGB) y0--;
			drawVerticalLine(x0, y0,y1);
			x0++;
		}

	}
	
	public void setThickness(int thickness) {
		if(thickness < DEFAULT_THICKNESS) throw new IllegalArgumentException("Thickness must be at least 1");
		if(thickness == currentThickness) return;
		currentThickness = thickness;
		thickAuxBuffer = new BufferedImage(thickness, thickness, BufferedImage.TYPE_INT_ARGB);
		thickBufferReady = false;
	}
	
	public void drawPixel(Point2D p) {
		drawPixel(p.x,p.y);
	}
	
	public void drawPixel(int x, int y) {
		drawPixel(x, y, c);
	}
	
	public void drawPixel(Point2D p, Color color) {
		drawPixel(p.x, p.y, color);
	}
	
	public void drawPixel(int x, int y, Color color) {
		if(currentThickness != DEFAULT_THICKNESS) drawThickPixel(x,y,color);
		else {
			bufferAux.setRGB(0, 0, color.getRGB());
			g.drawImage(bufferAux, x, y,null);
		}
		
	}
	
	private void drawThickPixel(int x, int y, Color color) {
		if(!thickBufferReady) {
			for(int i = 0; i < currentThickness; i++) {
				for(int j = 0; j < currentThickness; j++) {
					thickAuxBuffer.setRGB(i, j, color.getRGB());
				}
			}
			thickBufferReady = true;
		}
		g.drawImage(thickAuxBuffer, x, y,null);
	}
	
	
	private Color getColorAt(BufferedImage bf ,int x, int y) {
		return new Color(bf.getRGB(x,y), true);
	}


}
