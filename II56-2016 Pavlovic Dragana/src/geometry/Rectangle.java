package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	private Point upperLeft;
	private int height;
	private int width;
	private Color color = Color.BLACK;
	private Color innerColor;
	
	public Rectangle(Point upperLeft, int height, int width) {
		this.upperLeft = upperLeft;
		this.height = height;
		this.width = width;
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getInnerColor() {
		return innerColor;
	}
	
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	public Point getCenter() {
		int centerX = upperLeft.getX() + width/2;
		int centerY = upperLeft.getY() + height/2;
		Point p = new Point(centerX, centerY);
		return p;			
	}
	
	public int area() {
		return width * height;
	}
	
	@Override
	public void draw(Graphics g) {
		if (innerColor != null) {
			g.setColor(innerColor);
			g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.getWidth(), this.getHeight());
		}
		
		g.setColor(color);
		g.drawRect(this.getUpperLeft().getX(),
				this.getUpperLeft().getY(),
				this.width,
				this.height);
		
		if(selected) {
			g.drawRect(this.getUpperLeft().getX() - 3,
					this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3 + this.width,
					this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3,
					this.getUpperLeft().getY() - 3 + this.height, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3 + this.width,
					this.getUpperLeft().getY() - 3 + this.height, 6, 6);
		}
	}
	
	@Override
	public boolean contains(int x, int y) {
		boolean containsX = false;
		boolean containsY = false;
		if(x >= this.upperLeft.getX() && x <= (this.upperLeft.getX() + width)) {
			containsX = true;
		}
		if(y >= this.upperLeft.getY() && y <= (this.upperLeft.getY() + width)) {
			containsY = true;
		}
		return containsX && containsY;
	}
	
	@Override
	public void moveBy(int dx, int dy) {
		this.upperLeft.moveBy(dx, dy);
		
	}

	@Override
	public void moveOn(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return this.area() - ((Rectangle) o).area();
		}
		
		return 0;
	}
	
	public String toString() {
		return "Upper left point = " + this.getUpperLeft() + ", height = " + height + ", width = " + width + ";";
	}
}
