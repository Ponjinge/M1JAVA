package TP_2.shape;

public class Rectangle implements GeometricalShape {
	
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (this.length + this.width);
	}
	
	@Override
	public double getSurfaceArea() {
		return this.length * this.width;
	}
	
	@Override
	public String toString() {
		return "Rectangle{" +
				       "length=" + length +
				       ", width=" + width +
				       '}';
	}
}
