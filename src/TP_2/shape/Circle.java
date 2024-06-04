package TP_2.shape;

public class Circle implements GeometricalShape {
	
	private Point centre;
	
	private double radius;
	
	public Circle(Point centre, double radius) {
		this.centre = centre;
		this.radius = radius;
	}
	
	public Point getCentre() {
		return centre;
	}
	
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "Circle{" +
				       "centre=" + centre +
				       ", radius=" + radius +
				       '}';
	}
	
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}
	
	@Override
	public double getSurfaceArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}
}
