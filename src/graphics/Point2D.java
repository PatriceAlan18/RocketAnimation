package graphics;


public class Point2D {

	
	private int[][] translateMatrix = {{1,0,0},{0,1,0},{0,0,1}};
	private double[][] scaleMatrix = {{0,0,0},{0,0,0},{0,0,1}};
	private double[][] rotateMatrix = {{-1,-1,0},{-1,-1,0},{0,0,1}};
	
	public int x;
	public int y;
	
	public Point2D(Point2D point) {
		this.x = point.x;
		this.y = point.y;
	}
	
	public Point2D(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
	
	public void movePoint(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public void movePoint(Point2D dP) {
		movePoint(dP.x, dP.y);
	}
	
	public int getXDistance(Point2D to) {
		return Math.abs(this.x - to.x);
	}
	
	public int getYDistance(Point2D to) {
		return Math.abs(this.y - to.y);
	}
	
	public double getDistance(Point2D to) {
		double dx = this.x - to.x;
		double dy = this.y - to.y;
		return Math.sqrt((dx * dx)+(dy * dy));
	}
	
	@Override
	public String toString() {
		return "x: "+x+", y: "+y;
	}
	
	private void arrayToPoint2D(int[] array) {
		this.x = array[0];
		this.y = array[1];
	}
	
	public void scale(double sx, double sy) {
		scaleMatrix[0][0] = sx/100;
		scaleMatrix[1][1] = sy/100;
		int [] point = {this.x, this.y, 1};
		point = Matrix.multiplyMatrices(point, scaleMatrix);
		arrayToPoint2D(point);
	}
	
	public void rotar(int angulo) {
		double radians = Math.toRadians(angulo);
		double sin = Math.sin(radians);
		double cos = Math.cos(radians);
		rotateMatrix[0][0] = cos;
		rotateMatrix[0][1] = -sin;
		rotateMatrix[1][0] = sin;
		rotateMatrix[1][1] = cos;
		int [] point = {this.x, this.y, 1};
		point = Matrix.multiplyMatrices(point, rotateMatrix);
		arrayToPoint2D(point);
	}
	
	public void translate(int dx, int dy) {
		translateMatrix[0][2] = dx;
		translateMatrix[1][2] = dy;
		int [] point = {this.x,this.y,1};
		point = Matrix.multiplyMatrices(point, translateMatrix);
		arrayToPoint2D(point);
	}
	
}
