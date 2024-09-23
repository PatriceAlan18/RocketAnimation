package graphics;

import java.awt.Color;

public class MyGradient2D {

	//Point 1
	private Point2D p2D0;
	private int x0, y0;
	//Color 1
	private Color c0;
	private int red0, green0, blue0, alpha0;
	//Point 2
	private Point2D p2D1;
	private int x1, y1;
	//Color 2
	private Color c1;
	private int red1, green1, blue1, alpha1;
	
	public MyGradient2D(Point2D p0, Color _c0, Point2D p1, Color _c1) {
		this(p0.x, p0.y, _c0, p1.x, p1.y, _c1);
	}
	
	public MyGradient2D(int _x0, int _y0, Color _c0, int _x1, int _y1, Color _c1) {
		//Point 1
		this.x0 = _x0;
		this.y0 = _y0;
		//Color 1
		this.c0 = _c0;
		
		//Point 1
		this.x1 = _x1;
		this.y1 = _y1;
		//Color 1
		this.c1 = _c1;
		
		createPoints2D();
		setColorValues();
	}
	
	public Color getColorAt(Point2D position) {
		double dP0P1 = p2D0.getDistance(p2D1);
		double dP1P = p2D0.getDistance(position);
		
		double t = dP1P / dP0P1;
		
		int r = (int) (red0 + t * (red1 - red0));
	    int g = (int) (green0 + t * (green1 - green0));
	    int b = (int) (blue0 + t * (blue1 - blue0));
	    int a = (int) (alpha0 + t * (alpha1 - alpha0)); 
	    
	    return new Color(r, g, b, a);
	}
	

	
	private void setColorValues() {
		red0 = c0.getRed();
		green0 = c0.getGreen();
		blue0 = c0.getBlue();
		alpha0 = c0.getAlpha();
		
		red1 = c1.getRed();
		green1 = c1.getGreen();
		blue1 = c1.getBlue();
		alpha1 = c1.getAlpha();
	}
	
	private void createPoints2D() {
		p2D0 = new Point2D(x0, y0);
		p2D1 = new Point2D(x1, y1);
	}
	
}
