package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	private int radius;
	private Point center;
	private Color color = Color.BLACK;
	private Color innerColor;
	
	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle(int radius, Point center, boolean selected) {
		this.radius = radius;
		this.center = center;
		this.setSelected(selected);
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
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
	
    public double area() {
    	return radius * radius * Math.PI;
    }
    
    @Override
	public void draw(Graphics g) {
		if (innerColor != null) {
			g.setColor(innerColor);
			g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius() * 2, this.getRadius() * 2);
		}
		
		g.setColor(color);
		g.drawOval(this.getCenter().getX() - this.radius,
				this.getCenter().getY() - this.radius,
				this.radius * 2,
				this.radius * 2);
		
		if(this.isSelected()) {
			g.drawRect(this.getCenter().getX() - this.radius - 3,
					this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.radius - 3,
					this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3,
					this.getCenter().getY() - 3 - this.radius, 6, 6);
			g.drawRect(this.getCenter().getX() - 3,
					this.getCenter().getY() - 3 + this.radius, 6, 6);
		}
	}
	
    @Override
	public boolean contains(int x, int y) {
		return this.center.distance(new Point(x, y)) <= this.radius;
	}
	
	@Override
	public void moveBy(int dx, int dy) {
		this.center.moveBy(dx, dy);
	}

	@Override
	public void moveOn(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
