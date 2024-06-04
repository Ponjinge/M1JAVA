package TP_2.shape;

// Let's make an interface for all our shapes.
// This will be used for all of our geometrical shapes

public interface GeometricalShape {
	// Every shape has a perimeter and surface area, but they are calculated in various ways depending on the shape
	// Therefor the methods shall be defined in each use of this interface and remain abstract here
	public double getPerimeter();
	
	public double getSurfaceArea();
}
