package TP_3.triplet;

import TP_3.ferry.Bus;
import TP_3.ferry.Vehicule;
import TP_3.ferry.Voiture;

import java.util.ArrayList;

public class TripletTypesDifferents<E extends Comparable<E>, F extends Comparable<F>, G extends Comparable<G>> {

    // Props
    private E firstObject; private F secondObjet; private G thirdObject;

    // Constructors
    public TripletTypesDifferents(E firstObject, F secondObjet, G thirdObject) {
        this.firstObject = firstObject;
        this.secondObjet = secondObjet;
        this.thirdObject = thirdObject;
    }

    // Methods
    public E getFirstObject() {
        return firstObject;
    }

    public void setFirstObject(E firstObject) {
        this.firstObject = firstObject;
    }

    public F getSecondObjet() {
        return secondObjet;
    }

    public void setSecondObjet(F secondObjet) {
        this.secondObjet = secondObjet;
    }

    public G getThirdObject() {
        return thirdObject;
    }

    public void setThirdObject(G thirdObject) {
        this.thirdObject = thirdObject;
    }

    // toString()
    @Override
    public String toString() {
        return "Triplet{" + "firstObject=" + this.firstObject + ", secondObjet=" + this.secondObjet + ", thirdObject=" + this.thirdObject + '}';
    }

    public static void main(String[] args) {

        // Create a list of Triplets
        ArrayList<TripletTypesDifferents<String, Integer, Double>> tripletList = new ArrayList<>();


        // Create triplets
        TripletTypesDifferents<String, Integer, Double> triplet1 = new TripletTypesDifferents<>("A", 12, 60000000.9);
        TripletTypesDifferents<String, Integer, Double> triplet2 = new TripletTypesDifferents<>("B", 1, 1.546);
        TripletTypesDifferents<String, Integer, Double> triplet3 = new TripletTypesDifferents<>("C", 4209, 11.02);


        // Add the triplets to the list
        tripletList.add(triplet1);
        tripletList.add(triplet2);
        tripletList.add(triplet3);

        // Sort the list using different Comparators
        tripletList.sort(new FirstComparator<>());
        System.out.println("Sort using the first element : " + tripletList);
        tripletList.sort(new SecondComparator<>());
        System.out.println("Sort using the second element : " + tripletList);
        tripletList.sort(new ThirdComparator<>());
        System.out.println("Sort using the third element : " + tripletList);

        // Test it out with Vehicles

        //Cars
        Voiture v2 = new Voiture("Voiture 2",2.2,2.54,1,1100,1);
        Voiture v4 = new Voiture("Voiture 4",2.2,2.54,1,1100,4);

        // Buses
        Bus b3 =  new Bus("B3",1500,2.30,15.0,3,23);


        // Create a list of Triplets
        ArrayList<TripletTypesDifferents<Vehicule, Integer, Double>> vtripletList = new ArrayList<>();

        // We have two cars and a bus
        TripletTypesDifferents<Vehicule, Integer, Double> vtriplet1 = new TripletTypesDifferents<>(v2, 12, 6.9);
        TripletTypesDifferents<Vehicule, Integer, Double> vtriplet2 = new TripletTypesDifferents<>(b3, 230, 11.546);
        TripletTypesDifferents<Vehicule, Integer, Double> vtriplet3 = new TripletTypesDifferents<>(v4, 4209, 11.02);

        // Add the triplets to the list
        vtripletList.add(vtriplet1);
        vtripletList.add(vtriplet2);
        vtripletList.add(vtriplet3);

        // Sort the list using different Comparators
        vtripletList.sort(new FirstComparator<>());
        System.out.println("Sort using the first element : " + vtripletList);
        vtripletList.sort(new SecondComparator<>());
        System.out.println("Sort using the second element : " + vtripletList);
        vtripletList.sort(new ThirdComparator<>());
        System.out.println("Sort using the third element : " + vtripletList);
    }
}
