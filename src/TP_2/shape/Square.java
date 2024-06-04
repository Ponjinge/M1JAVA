package TP_2.shape;

public class Square extends Rectangle {
	
	public Square(double side) {
		// We call back to the Rectangle class of which this class inherits
		super(side, side);
	}

	// We don't need to redefine the methods because the length and width of the rectangle that is a square are both 'side',
	// the methods for Rectangle work for this Class
	@Override
	public String toString() {
		return "Square{" +
				       "side :" + this.getWidth() +
				       '}';
	}
}
