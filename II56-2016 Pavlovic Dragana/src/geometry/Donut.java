package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;
	private Color innerBorderColor = Color.BLACK;
	private Color innerCircleColor;
	
	public Donut(Point center, int radius, int innerRadius) {
		super(radius,center);
		this.innerRadius = innerRadius;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public Color getInnerBorderColor() {
		return innerBorderColor;
	}
	
	public void setInnerBorderColor(Color innerBorderColor) {
		this.innerBorderColor = innerBorderColor;
	}
	
	public Color getInnerCircleColor() {
		return innerCircleColor;
	}
	
	public void setInnerCircleColor(Color innerCircleColor) {
		this.innerCircleColor = innerCircleColor;
	}
	
	public double area() {
		return  super.area() - Math.PI * innerRadius * innerRadius;
	}
	
	@Override
	public void draw(Graphics g) {
		if (getInnerColor() != null) {
			g.setColor(getInnerColor());
			g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius() * 2, this.getRadius() * 2);
		}
		
		g.setColor(getColor());
		super.draw(g);
		
		if (innerCircleColor != null) {
			g.setColor(innerCircleColor);
			g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		}
		
		g.setColor(innerBorderColor);
		g.drawOval(this.getCenter().getX() - this.innerRadius,
				this.getCenter().getY() - this.innerRadius,
				this.innerRadius * 2,
				this.innerRadius * 2);
		
		if(this.isSelected()) {
			g.drawRect(this.getCenter().getX() - this.innerRadius - 3,
					this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.innerRadius - 3,
					this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3,
					this.getCenter().getY() - 3 - this.innerRadius, 6, 6);
			g.drawRect(this.getCenter().getX() - 3,
					this.getCenter().getY() - 3 + this.innerRadius, 6, 6);
		}
	}
	
	@Override
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(new Point(x, y));
		return super.contains(x, y) && dFromCenter > this.innerRadius;
	}
}
