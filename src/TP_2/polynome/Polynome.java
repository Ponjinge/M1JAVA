package TP_2.polynome;

import java.util.Arrays;

public class Polynome {
	/*
	Propriétés
	 */
	private double[] coeffs;
	
	/*
	Constructeur
	 */
	public Polynome(int degres) {
		this.coeffs = new double[degres + 1];
	}
	
	public Polynome(double[] tableau) {
		// Copie défensive
		this.coeffs = new double[tableau.length];
		System.arraycopy(tableau, 0, this.coeffs, 0, tableau.length);
	}
	
	/*
	Méthodes
	 */
	public void setCoeff(int pos, double d) {
		try{
		this.coeffs[pos] = d;}
		catch (Exception e){
			System.out.println("This coefficient is too big for the set degrees of this polynomial");
		}
	}

	//Returns the coefficient of a polynomial.
	// Try-catch for a non-defined coefficient
	public double getCoeff(int pos) {
		try{
			return this.coeffs[pos];
		}catch (Exception e) {
			System.out.println("Erreur : " + pos + " est plus grand que le degré du polynome");
		}
		// Return 0 in this case because if it doesn't exist it means that it's 0.
		return 0;
	}

	//Get the degree of a polynomial (a)
	public int degrees() {
		return this.coeffs.length - 1;
	}

	//Get if two polynomials are equal (b)
	public boolean equals(Object obj) {
		return (obj instanceof Polynome p) && Arrays.equals(this.coeffs, p.coeffs);
	}

	//Solve polynomial for x (c)
	public double resultat(double x) {
		double somme = 0.0;
		for (int i = 0; i < this.coeffs.length; i++) {
			somme += this.coeffs[i] * Math.pow(x, i);
		}
		return somme;
	}
	// Add two polynomials using a new one (d)
	public static Polynome add(Polynome p1, Polynome p2) {
		Polynome p;
		if (p1.degrees() >= p2.degrees()) {
			p = new Polynome(p1.degrees());
			for (int i = 0; i < p2.coeffs.length; i++) {
				p.setCoeff(i, p1.getCoeff(i) + p2.getCoeff(i));
			}
			for (int i = p2.coeffs.length; i < p1.coeffs.length; i++) {
				p.setCoeff(i, p1.getCoeff(i));
			}
		} else {
			p = new Polynome(p2.degrees());
			for (int i = 0; i < p1.coeffs.length; i++) {
				p.setCoeff(i, p1.getCoeff(i) + p2.getCoeff(i));
			}
			for (int i = p1.coeffs.length; i < p2.coeffs.length; i++) {
				p.setCoeff(i, p2.getCoeff(i));
			}
		}
		return p;
	}
	// Add a polynomial to the one being used, using .this (e)
	public void addPoly(Polynome p) {
		double[] coeffs;
		if (this.degrees() >= p.degrees()) {
			coeffs = new double[this.coeffs.length];
			for (int i = 0; i < p.coeffs.length; i++) {
				coeffs[i] = this.coeffs[i] + p.coeffs[i];
			}
			if (this.coeffs.length - p.coeffs.length >= 0)
				// Code recommended to replace a manual array copy by my IDE, thank you Idea
				System.arraycopy(this.coeffs, p.coeffs.length, coeffs, p.coeffs.length, this.coeffs.length - p.coeffs.length);
		} else {
			coeffs = new double[p.coeffs.length];
			for (int i = 0; i < this.coeffs.length; i++) {
				coeffs[i] = this.coeffs[i] + p.coeffs[i];
			}
			if (p.coeffs.length - this.coeffs.length >= 0)
				// Code recommended to replace a manual array copy by my IDE
				System.arraycopy(p.coeffs, this.coeffs.length, coeffs, this.coeffs.length, p.coeffs.length - this.coeffs.length);
		}
		this.coeffs = coeffs;
	}

	// Get the roots of a polynomial for a given interval (f)
	public void getRoots(int borneInf, int borneSup) {
		for (int i = borneInf; i <= borneSup; i++) {
			if (this.resultat(i) == 0) {
				System.out.println(i + " is a root of this polynomial.");
			}
		}
	}

	
	@Override
	public String toString() {
		return Arrays.toString(this.coeffs);
	}
}
