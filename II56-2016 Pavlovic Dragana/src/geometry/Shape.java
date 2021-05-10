package geometry;

import java.awt.Graphics;

public abstract class Shape implements Movable {
	protected boolean selected;
	
	public Shape() {}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
}
