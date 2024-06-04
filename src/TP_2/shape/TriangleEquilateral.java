package TP_2.shape;

public class TriangleEquilateral extends Triangle {
	// This specific class of triangle is constructed using the length of its sides which are all the same length

	public TriangleEquilateral(double side) {
		super( side, (Math.sqrt(3) / 2) * side);
	}

	// With this Equilateral triangle we can compute the Perimeter
	@Override
	public double getPerimeter() {
		return 3 * this.getBase();
	}
	
	@Override
	public String toString() {
		return "TriangleEquilateral{" +
				       "cote=" + this.getBase() +
				       '}';
	}
}
