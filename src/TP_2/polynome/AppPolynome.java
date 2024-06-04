package TP_2.polynome;


import java.sql.SQLOutput;

public class AppPolynome {

	public static void main(String[] args) {
		double[] coeff1 = {1.0, -2.0, 3.0};
		double[] coeff2 = {1.2, 0, 3};


		// Create Polynomials
		Polynome p1 = new Polynome(coeff1);
		Polynome p2 = new Polynome(1);
		Polynome p3 = new Polynome(4);
		Polynome p4 = new Polynome(coeff2);

		// Let's check our print methods
		System.out.println(p1);
		System.out.println(p3);
		System.out.println(p4);

		// Test getting a non-existent coefficient
		System.out.println("Despite the non-existence of the coefficient we get: " + p4.getCoeff(5));

		// Let's use our setters to change some of our polynomial coeffs
		System.out.println("Before changes:" + p2);
		p2.setCoeff(0, 5.0);
		p2.setCoeff(1, -1.0);

		// Try and set an undefined Coeff
		p2.setCoeff(4, 3);

		System.out.println("After changes:" + p2);


		// Compute polynomial 1 for x=4
		double x=4.0;
		System.out.println("Polynomial:" + p1 + " solved for x =" + x + " is : " + p1.resultat(x));


		//Basic approach to add polynomials together
		System.out.println(Polynome.add(p1, p2));

		// Why have it as a method even when it's not using 'this'
		// might as well just be a function

		//Better suited approach more suited to using classes
		p1.addPoly(p2);
		System.out.println(p1);

		//Get the roots of a Polynomial
		p2.getRoots(-1000,450);
		//Double check
		System.out.println(p2.resultat(5));

		// This concludes our exercise
	}
}
