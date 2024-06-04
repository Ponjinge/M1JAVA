package TP_3.ferry;

import java.util.List;

/**
 * Classe Ferry.
 */
public class Ferry {
    /*----- Propiétés -----*/
    private Parking[] parkings;

    private double tonnageLimite;

    private int nbMaximalPassagers;

    /*----- Constructeurs -----*/
    public Ferry(int nbParking, double tonnageLimite, int nbMaximalPassagers) {
        this.parkings = new Parking[nbParking];
        this.tonnageLimite = tonnageLimite;
        this.nbMaximalPassagers = nbMaximalPassagers;
    }

    /*----- Ajoute un parking en position 'pos' -----*/
    public void addParking(int pos, Parking p) {
        this.parkings[pos] = p;
    }

    private double chargeTotale() {
        double charge = 0.0;
        for (Parking parking : this.parkings) {
            charge += parking.chargeTotale();
        }
        return charge;
    }

    private int nbPassagersTotal() {
        int nbTotal = 0;
        for (Parking parking : this.parkings) {
            nbTotal += parking.nbPassagersTotal();
        }
        return nbTotal;
    }

    // WILCARD
    // get the number of passagers for a category of vehicles
    public <T extends Vehicule> int getNombrePassagersParType(Class<T> type) {
        int somme = 0;
        for (Parking parking : this.parkings) {
            List<Vehicule> vehicules = parking.getVehicules();
            for (Vehicule v : vehicules) {
                if (type.isInstance(v)) {
                    somme += v.nbPassagers();
                }
            }
        }
        return somme;
    }





    /*----- Ajoute un véhicule dans le ferry -----*/
    public boolean ajouterVehicule(Vehicule v) {
        // Vérifier si la charge totale et le nombre de passagers dépassent la limite
        if (this.chargeTotale() + v.chargeTotale() > this.tonnageLimite || this.nbPassagersTotal() + v.nbPassagers() > this.nbMaximalPassagers) {
            return false;
        }
        // Trouver le parking où on peut mettre ce véhicule
        for (Parking parking : this.parkings) {
            if (parking.ajouterVehicule(v)) {
                return true;
            }
        }
        return false;
    }

    /*----- Déchargement du ferry -----*/
    public void dechargement() {
        // Parcourir le tableau de parkings
        for (Parking parking : this.parkings) {
            // Tant qu'il reste des véhicules dans ce parking, on supprime un véhicule
            while (parking.nbPlacesLibres() != parking.getCapacite()) {
                parking.enleverVehicule();
            }
        }
    }

    /*----- Méthodes redéfinies -----*/
    @Override
    public String toString() {
        String ch = "----- Ferry\n";

        ch += "Charge maximale       : " + this.tonnageLimite + "\n";
        ch += "Charge en cours       : " + this.chargeTotale() + "\n";
        ch += "Capacité en passagers : " + this.nbMaximalPassagers + "\n";
        ch += "Nombre de passagers   : " + this.nbPassagersTotal() + "\n";

        for (int i = 0; i < this.parkings.length; i++)
            ch += i + " : " + this.parkings[i].toString() + "\n";

        ch += "----------";

        return ch;
    }

} /*----- Fin de la classe Ferry -----*/
