package TP_3.ferry;

import java.util.List;

/**
 * Classe abstraite Parking.
 */
public abstract class Parking {
    /*----- Propriétés-----*/
    private int capacite; // Setter - Getter, est-ce utile ?

    /*----- Constructeurs-----*/
    public Parking(int cap) {
        this.capacite = cap;
    }

    /*----- Setters / Getters -----*/
    public int getCapacite() {
        return this.capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    /*----- Méthodes abstraites -----*/
    public abstract Vehicule enleverVehicule();

    public abstract boolean ajouterVehicule(Vehicule v);

    public abstract int nbPlacesLibres();

    public abstract double chargeTotale();

    public abstract int nbPassagersTotal();

    //WILCARD
    public abstract List<Vehicule> getVehicules();

} /*----- Fin de la classe Parking -----*/
