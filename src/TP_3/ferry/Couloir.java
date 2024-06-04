package TP_3.ferry;

import java.util.ArrayList;
import java.util.List;

public class Couloir extends Parking {


    protected final ArrayList<Vehicule> places;

    private final double limitationHauteur;

    public Couloir(int cap, double limitationHauteur) {
        super(cap);
        this.places = new ArrayList<>(cap);
        this.limitationHauteur = limitationHauteur;
    }

    @Override
    public boolean ajouterVehicule(Vehicule v) {
        if (this.places.size() < this.getCapacite() && v.getHauteur() < this.limitationHauteur) {
            return this.places.add(v);
        }
        return false;
    }

    // In a couloir, it is the first car that enters that leaves first

    @Override
    public Vehicule enleverVehicule() {
        if (this.places.size() != 0) {
            return this.places.removeFirst();
        }
        return null;
    }

    @Override
    public int nbPlacesLibres() {
        return this.getCapacite() - this.places.size();
    }

    @Override
    public double chargeTotale() {
        double charge = 0.0;
        for (Vehicule place : this.places) {
            charge += place.chargeTotale();
        }
        return charge;
    }

    @Override
    public int nbPassagersTotal() {
        int nbTotal = 0;
        for (Vehicule place : this.places) {
            nbTotal += place.nbPassagers();
        }
        return nbTotal;
    }

    //WILCARD
    @Override
    public List<Vehicule> getVehicules() {
        List<Vehicule> vehicules = new ArrayList<>();
        for (Vehicule place : this.places) {
            if (place != null) {
                vehicules.add(place);
            }

        }
        return vehicules;
    }


    // DOUBLE CHECK THIS
    @Override
    public String toString() {
        StringBuilder ch = new StringBuilder("{");
        for (int i = 0; i < this.places.size(); i++) {
            //if (this.places != null) {
                ch.append(" ").append(this.places.get(i).getImmat());
            //}
        }
        ch.append(" }");
        return ch.toString();
    }
}
