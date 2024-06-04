package TP_2.shape;

import java.sql.SQLOutput;

public class AppShape {

	// We get the shape with the largest perimeter and return it,
	public static GeometricalShape largestPerimeter(GeometricalShape[] listOfShapes){
		int largerPerimIndex = 0;
		double largestPerim = 0.0;
		for(int i=0; i<listOfShapes.length;i++){
			if (listOfShapes[i].getPerimeter()>= largestPerim){
				largestPerim = listOfShapes[i].getPerimeter();
				largerPerimIndex = i ;
			}
		}
		//System.out.println("The largest perimeter is: "+ largestPerim);
		return listOfShapes[largerPerimIndex];
	}

	// We get the sum of all surface areas of a list of shapes
	public static double sumOfSurfaces(GeometricalShape[] listOfShapes){
		double runningSum = 0.0;
		for (GeometricalShape shape : listOfShapes) {
			runningSum += shape.getSurfaceArea();
		}

		return runningSum;
	}

	public static void main(String[] args) {
		GeometricalShape[] shapes = new GeometricalShape[4];

		Circle circle = new Circle(new Point(3.5, 4.1), 1.5);
		Rectangle rectangle = new Rectangle(7, 32);
		Square square = new Square(122.0);
		TriangleEquilateral triangleEquilateral = new TriangleEquilateral(15.5345);

		// We cannot initiate a standard triangle because it has abstract methods
		//Triangle normalTriangle = new Triangle(4,5);

		shapes[0] = circle;
		shapes[1] = rectangle;
		shapes[2] = square;
		shapes[3] = triangleEquilateral;

		// Largest perimeter (a)
		System.out.println("The shape with the largest perimeter in our list is : "
				+ largestPerimeter(shapes)
				+ "  , with a perimeter of: "
				+ largestPerimeter(shapes).getPerimeter()

		);

		// For checking
		//for (GeometricalShape shape : shapes) {
		//	System.out.println(shape.getSurfaceArea());
		//}

		// Sum of surfaces (b)
		System.out.println("The sum of the areas of our shapes is: "+ sumOfSurfaces(shapes));

		// This concludes the exercise
	}
}
