package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	private int x;
	private int y;
	private Color color = Color.BLACK;
	
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x, y);
		this.setSelected(selected);
	}
	
	public Point(Point p) {
		this(p.x, p.y);
		this.setSelected(p.selected);
	}
	
	public double distance(Point p) {
		int dx = this.x - p.x;
		int dy = this.y - p.y;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point)obj;
			if (p.x == this.x && p.y == this.y) {
				return true; 
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "(" + this.x + "," + this.y + "), selected=" + this.selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.drawLine(this.x - 1, this.y, this.x + 1, this.y);
		g.drawLine(this.x, this.y - 1, this.x, this.y + 1);
		
		if(selected) {
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
	}
	
	@Override
	public boolean contains(int x, int y) {
		Point clickPosition = new Point(x, y);
		return this.distance(clickPosition) < 5;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y = this.y + byY;
	}
	
	@Override
	public void moveOn(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
