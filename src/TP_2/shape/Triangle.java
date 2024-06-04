package TP_2.shape;

public abstract class Triangle implements GeometricalShape {
	
	private double base;
	
	private double height;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	public double getBase() {
		return base;
	}
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Triangle{" +
				       "base=" + base +
				       ", height=" + height +
				       '}';
	}

	// It is not possible to compute the Perimeter of a triangle
	// with only the base and height.
	@Override
	public abstract double getPerimeter();
	
	@Override
	public double getSurfaceArea() {

		return (this.base * this.height) * 0.5;
	}
}
