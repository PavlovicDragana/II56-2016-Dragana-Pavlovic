package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;
	private Color color = Color.BLACK;
	
   public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
        this.endPoint = endPoint;
	}
	
	public double length() {
		return this.startPoint.distance(this.endPoint);
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line l = (Line)obj;
			if (l.getStartPoint().equals(this.getStartPoint()) && l.getEndPoint().equals(this.getEndPoint())) {
				return true;
			} else {
				return false;
			}
		 } else {
			 return false;
		 }
	 }

	public String toString() {
		return this.getStartPoint() + "->" + this.getEndPoint();
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.drawLine(this.getStartPoint().getX(),
				this.getStartPoint().getY(),
				this.getEndPoint().getX(),
				this.getEndPoint().getY());
		
		if(selected) {
			g.drawLine(this.getStartPoint().getX() - 3,
					this.getStartPoint().getY() - 3, 6, 6);
			g.drawLine(this.getEndPoint().getX() - 3,
					this.getEndPoint().getY() - 3, 6, 6);
		}
	}
	
	public double distance(Point p) {
		double distAB = Math.sqrt(
				(this.getStartPoint().getX() - this.getEndPoint().getX()) * 
				(this.getStartPoint().getX() - this.getEndPoint().getX()) +
				(this.getStartPoint().getY() - this.getEndPoint().getY()) * 
				(this.getStartPoint().getY() - this.getEndPoint().getY()));
		double distAC = Math.sqrt(
				(this.getStartPoint().getX() - p.getX()) *
				(this.getStartPoint().getX() - p.getX()) +
				(this.getStartPoint().getY() - p.getY()) *
				(this.getStartPoint().getY() - p.getY()));
		double distBC = Math.sqrt(
				(this.getEndPoint().getX() - p.getX()) *
				(this.getEndPoint().getX() - p.getX()) +
				(this.getEndPoint().getY() - p.getY()) *
				(this.getEndPoint().getY() - p.getY()));
		double s = (distAB + distAC + distBC) / 2;
		return 2 * (Math.sqrt(s * (s-distAB) * s * (s-distAC) * s * (s-distBC))) / distAB;
	}
	
	@Override
	public boolean contains(int x, int y) {
		Point point = new Point(x, y);
		double distFromLineToPoint = this.distance(point);
		double distFromStartToPoint = this.startPoint.distance(point);
		double distFromEndToPoint = this.endPoint.distance(point);
		
		return (distFromLineToPoint < 5 && 
				distFromStartToPoint < this.length() && 
				distFromEndToPoint < length());
	}
	
	@Override
	public void moveBy(int dx, int dy) {
		this.startPoint.moveBy(dx, dy);
		this.endPoint.moveBy(dx, dy);
	}

	@Override
	public void moveOn(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
