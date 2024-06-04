package TP_3.ferry;
import java.util.List;
import java.util.ArrayList;



/*
Class ParkingExterieur
 */
public class ParkingExterieur extends Parking {

    /*
    immutable -> String
    mutable
     */

    /*
    Propriétés
     */
    private final Vehicule[] places;

    /*
    Constructeur
     */
    public ParkingExterieur(int cap) {
        super(cap);
        this.places = new Vehicule[cap];
    }

    /*
    Méthodes
     */
    /*
    On ajoute un véhicule à la première place trouvée
     */
    @Override
    public boolean ajouterVehicule(Vehicule v) {
        int pos = 0;
        while (pos < this.getCapacite() && this.places[pos] != null) {
            pos++;
        }
        if (pos == this.getCapacite()) {
            return false;
        } else {
            this.places[pos] = v;
            return true;
        }
    }

    /*
    Par défaut on enlève le véhicule le plus proche de la sortie.
    Sortie est à l'indice 0.
     */
    @Override
    public Vehicule enleverVehicule() {
        for (int i = 0; i < this.getCapacite(); i++) {
            if (this.places[i] != null) {
                Vehicule vehiculeSupprime = this.places[i];
                this.places[i] = null;
                return vehiculeSupprime;
            }
        }
        return null;
    }

    // Removes Vehicule at a given index
    public Vehicule enleverVehicule(int indice) {
        if (indice > this.places.length - 1) {
            return null;
        }
        Vehicule vehiculeDeleted = this.places[indice];
        this.places[indice] = null;
        return vehiculeDeleted;
    }

    @Override
    public int nbPlacesLibres() {
        int nbPlaces = 0;
        for (int i = 0; i < this.getCapacite(); i++) {
            if (this.places[i] == null) {
                nbPlaces++;
            }
        }
        return nbPlaces;
    }

    public double chargeTotale() {
        double charge = 0.0;
        for (int i = 0; i < this.places.length; i++) {
            if (this.places[i] != null) {
                charge += this.places[i].chargeTotale();
            }
        }
        return charge;
    }

    @Override
    public int nbPassagersTotal() {
        int nbTotal = 0;
        for (int i = 0; i < this.places.length; i++) {
            if (this.places[i] != null) {
                nbTotal += this.places[i].nbPassagers();
            }
        }
        return nbTotal;
    }


    //WILCARD
    @Override
    public List<Vehicule> getVehicules() {
        List<Vehicule> vehicules = new ArrayList<>();
        for (int i = 0; i < this.getCapacite(); i++) {
            if (this.places[i] != null) {
                vehicules.add(this.places[i]);
            }

        }
        return vehicules;
    }

    @Override
    public String toString() {
        String ch = "{";
        for (int i = 0; i < this.getCapacite(); i++) {
            if (this.places[i] != null) {
                ch += " " + this.places[i].getImmat();
            } else {
                ch += " ---";
            }
        }
        ch += " }";
        return ch;
    }
}
