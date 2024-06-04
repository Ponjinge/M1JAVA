package TP_3.ferry;

public class Garage extends Couloir { //Instead of using Parking we can inherit Couloir,
    // They both have a height limit and this way Garage inherits all the overloads/surcharges of Couloir

    public Garage(int cap, double limitationHauteur) {
        super(cap, limitationHauteur);
    }


    // In a garage, it is the first car that enters that leaves last,
    // Last one in leaves first
    @Override
    public Vehicule enleverVehicule() {
        if (this.places.size() != 0) {
            return this.places.removeLast();
        }
        return null;
    }
}
